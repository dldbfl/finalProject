<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link href="<%=request.getContextPath() %>/resources/css/lecture/lecture.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/lecture/video.css" rel="stylesheet">
<title>Insert title here</title>
<style>
div#lecturedataimage{
	height:200px;
	width:320px;
	margin:0 auto;
	margin-top : 15px;	  		
	border : 1px solid lightgray;  		
	background-repeat:no-repeat;
	background-position:center;
	background-size:cover;
}
#star{
    width: 40px;
}
#isimp{
	display:none;
}
</style>
<body>
	<c:if test="${empty lectureDataList}">
		<h1> 등록된 동영상이 없습니다. </h1>
	</c:if>
	<c:if test="${not empty lectureDataList}">
	<div class="container">
    <div>
		<h3 style="margin-top: 20px;"><a href="<%=request.getContextPath()%>/myPage/professorMain" style="color:black;">마이페이지</a>><a id="head1" href="javascript:location.reload()" style="color:#308fe2;" >강의실</a></h3>
	</div>
    <div class="well well-sm">
        <strong>Display</strong>
        <div class="btn-group">
            <a href="#" id="list" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-th-list">
            </span>List</a> <a href="#" id="grid" class="btn btn-default btn-sm"><span
                class="glyphicon glyphicon-th"></span>Grid</a>
        </div>
    </div>
    <div id="products" class="row list-group">
      <c:forEach items="${lectureDataList}" var="lecture" >
        <div class="item  col-xs-4 col-lg-4">
            <div class="thumbnail">
            	<c:choose>
	            	<c:when test="${not empty lecture.lecture_data_image}">
		            	<div class="thumbnail-wrapper">
		            		<div id = "lecturedataimage" ></div>
						</div>
					</c:when>
	                <c:otherwise>
						<img class="group list-group-image imagecover" src="/resources/images/videoimage/example.png" alt="" />
					</c:otherwise>
                </c:choose>                
                <div class="caption">    
                    <h3 class="group inner list-group-item-heading" id="lecture_data_filenamecut" >${lecture.lecture_data_filename}</h3>
                    <p class="group inner list-group-item-text">등록일&nbsp;:&nbsp;<fmt:formatDate value="${lecture.lecture_data_regdate}" pattern="yyyy-MM-dd"/></p>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <p class="lead">${lecture.professor_id} 교수님</p>
                        </div>
                        <div class="col-xs-12 col-md-6" align="right">
                            <a class="btn btn-success" onclick="OpenWindow('/professor/video/view?lecture_data_no=${lecture.lecture_data_no }&lecture_lastview_time=${lecture.lecture_lastview_time }&lecture_no=${lecture_no}&professor_id=${lecture.professor_id}','','1450','750');">영상 보기</a>
						</div>
                    </div>
                    <input type="hidden" value="${lecture.lecture_data_filename}" id ="lecture_data_filename">
                    <input type="hidden" value="${lecture.lecture_data_image}" id ="lecture_data_image">
					<input type="hidden" value="${lecture.lecture_data_no}" id ="lecture_data_no">
                </div>
            </div><!-- thumbnail -->
        </div><!-- item -->
       </c:forEach> 
   
    </div><!-- products -->
</div>

</c:if>
</body>

<script>
 $(document).ready(function() {
	
	var lecture_data_filename = $('#lecture_data_filename').val();
	var lecture_data_image = $('#lecture_data_image').val();
	var lecture_data_no = $('#lecture_data_no').val();
	 
    $('#list').click(function(event){event.preventDefault();$('#products .item').addClass('list-group-item');});
    $('#grid').click(function(event){event.preventDefault();$('#products .item').removeClass('list-group-item');$('#products .item').addClass('grid-group-item');});
	
    $('div#lecturedataimage'). css({'background-image':'url("<%=request.getContextPath()%>/lecture/picture/'+lecture_data_no+'")'}); 
    
    /* var lecture_data_filenamecut = lecture_data_filename.split('$$')[1];    
    
    $('#lecture_data_filenamecut').text(lecture_data_filenamecut.split('.jpg')[0]); 
    
    $('#lecture_data_filenamecut').text(lecture_data_filenamecut.slice(0,-4)); */
    
    
    // 추가할 태그
    var starcheck = "<img id='star' src='/resources/images/star.png'>";
    var starnocheck  = "<img id='star' src='/resources/images/star2.png'>";
    
    $("#isimp").on('click', function() {
    	if ($(this).prop('checked')) {
		   	    $('#star').remove();
	   		 	$('#starlabel').append(starcheck);
		   		$.ajax({
		 			type: "POST",
		 			url: "/lecture/favorite",	
		 			async: false ,
		 			data : {"lecture_data_no" : lecture_data_no,
		 					"lecture_data_favorites" : 1},
		 			dataType: 'text'
		 		}); 
    		 
    		 alert('즐겨찾기에 등록되었습니다.')
   		 	}else{
    			$('#star').remove();
	   		 	$('#starlabel').append(starnocheck);
		   		$.ajax({
		   			type: "POST",
		 			url: "/lecture/favorite",	
		 			async: false ,
		 			data : {"lecture_data_no" : lecture_data_no,
		 					"lecture_data_favorites" : 0},
		 			dataType: 'text'
	 			}); 
		   		
   			 alert('즐겨찾기가 해제되었습니다')
		 	} 
    	}); 	
    });	    
</script>