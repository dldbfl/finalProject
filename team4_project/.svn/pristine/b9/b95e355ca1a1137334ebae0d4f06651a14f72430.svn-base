<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<%=request.getContextPath() %>/resources/css/qna/detail.css" rel="stylesheet">
<!-- JQuery 3.4.1 -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<!--  JQuery 1.12.1 UI -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!-- JQuery 2.2.0 Color -->
<script src="https://code.jquery.com/color/jquery.color-2.2.0.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<link href="<%=request.getContextPath() %>/resources/css/lecture/lecture.css" rel="stylesheet">

<!-- 하단 슬라이더 -->
<!-- <link rel="stylesheet" href="https://unpkg.com/swiper/css/swiper.min.css"> -->

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/css/swiper.min.css">
<link href="<%=request.getContextPath() %>/resources/css/lecture/video.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js"></script>
 
<script src="<%=request.getContextPath() %>/resources/scripts/common.js"></script>
	
	<link href="<%=request.getContextPath() %>/resources/css/qna/dist/switchery.css" rel="stylesheet">
	<script src="<%=request.getContextPath() %>/resources/css/qna/dist/switchery.js"></script>

<style>
body{
		/* width: 345px;
    	height: 607px; */
    	padding: 5px 10px 70px 10px;
	}
	
#detaildiv{
	font-size: 13px;
    height: 354px;
}
    
#answerTable,#answerdiv{
	font-size: 13px;
}
.btns{
    background-color: #6D6AB7;
    text-decoration: blink;

}
.note-toolbar panel-heading{
	height: 39px;
}
.note-fontname, .note-style, .note-insert, .note-table, .note-para{
	display: none;
} 
.writerPwd{	
    height: 8%;
    font-size: 14px;	
}
#password{
	font-size: 13px;
}
#buttons{
	float: right;
}
.titlecover{
    height: 35px;
}
.note-editor note-frame panel panel-default{
	margin-top: 15px;
}
#qnaRegist_content{
	margin-top: 15px;
}
.titletext{
	margin: 1%;
}
</style>

<head>

    <title>등록</title>


<body>
  <div class="FormController">

    <section id="section-timesheet" style="background-color: white; width: 100%;">
      <div class="clearfix" style="width: 100%; background-color: white; /* border-top: 2px solid steelblue */ height: 500px;">

        <form enctype="multipart/form-data" name="regist" method="post" action="/lecture/regist?member_id=${member_id}&professor_id=${professor_id}" style="height: 130%;" >
			<div class="clearfix">	   
				 
				<div class="writerPwd">
		  	       <div class="name">
			  	       <label style="display:none; float: left; margin-left: 1%;">작성자</label>
			  	       <input type="hidden" class="col-xs-2" style="heig	ht: 30px; font-size: 15px; " id="qna_writer" name="qna_writer" type="text" value="${member_id }"  required readonly="readonly">
		  	       </div>
		  	       <div class="professor">
			  	       <label style="display:none; float: left; margin-left: 1%;">교수</label>
			  	       <input type="hidden" class="col-xs-2" style="heig	ht: 30px; font-size: 15px; " id="professor_id" name="professor_id" value="${professor_id }"  required readonly="readonly">
		  	       </div>
		  	       <div class="titlecover">
			            <label class="titlename" >제목</label>
			           	<input class="titletext" id="title" name="qna_title" type="text" placeholder="제목을 입력하세요" required  >
			           	 <div id="buttons">
						  	<a href="#this" class="btns" id="regist">등록</a>
					  		<a href="#this" class="btns" id="close">닫기</a>
				          </div> 
					</div>
				   <div class="btn-group pwd">	
					   <label id="pass" style="display: none;"  >비밀번호 </label>
					   <input id="password" name="qna_password" type="text" value="" placeholder="비밀번호를 입력하세요" style=" display: none; " >
					   <span >비밀글 </span>
					   <input id="secret" name="qna_type" type="checkbox" class="js-switch" value="일반글"/>	
		  	       </div>
	  	        </div>
			</div>
         	
  	       <br/>
          <textarea id="qnaRegist_content" name="qna_content"></textarea>
          
          
          
        </form>      
      </div>
    </section>

  </div>
</body>
	<script>
	var elem = document.querySelector('.js-switch');

	var init =new Switchery(elem,{
		    // primary color
		    color             :'#FF0033',
		    secondaryColor    :'#66FF00',
		    className         :'switchery',
		    disabled          :false,
		    disabledOpacity   : 0.5,
		    speed             :'0.4s',
		    // 'small', 'large'
		    size              :'default'
	    
	});

	elem.onchange =function(){
		if($("input:checkbox[name=qna_type]").is(":checked") == true) {
			$('#secret').attr('value', "비밀글");
			$('#pass').attr('style', "display: '';")
			$('#password').attr('style', "display:'';")

		}
		else{
			$('#secret').attr("value","일반글");
			$('#pass').attr('style', "display:none;")
			$('#password').attr('style', "display:none;")

		}

	}
	
	
	// 등록 버튼
	$('#regist').on('click', function(e){

		var form = document.regist;
		if(form.title.value==""){
			alert("제목은 필수 입니다.");
			return;
		}
		if(form.qnaRegist_content.value.length>1000){
			alert("글자수가 1000자를 초과할 수 없습니다.");
			return;
		}

		form.submit();
	});
	//닫기 버튼
	$('#close').on('click', function(){
		history.go(-2);

	 	});

	</script>
	
	
</html>
<%@ include file="videonote_js.jsp" %> 
<%@ include file="/WEB-INF/views/board/qna/qna.js.jsp" %> 

</body>


