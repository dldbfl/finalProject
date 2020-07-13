<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<head>
	<title>Admin</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Le fav and touch icons -->
<link rel="apple-touch-icon" sizes="114x114" href="apple-touch-icon-114x114.png" />
<link rel="icon" type="images/svg+xml" href="images/logo.svg" />
<style>
.lecture-modal-content {
	background-color: #fefefe;
	margin: 2% auto;
	padding: 20px;
	padding-top: 30px;
	border: 1px solid #888;
	width: 40%;
	box-shadow: 0 5px 15px rgba(0,0,0,.5);
	height: 90%;
	border-radius: 1%;       
}
.modal_head{
	 border: 1px solid black; 
	height: 45%;
}
.modal_body{
	/* border: 1px solid silver; */
	height: 48%;
}
.modal_footer{
	/* border: 1px solid yellow; */
	height: 7%;
}
.head_top{
	text-align: center;
	margin-left: 10%;
}
.head_top button{
	float: right;
	/* border-color: 1px solid black; */
    margin-top: -1%;
    margin-right: 3%;
}
.head_left{
	border: 1px solid black; 
	float: left;
	width: 45%;
    height: 300px;
}
#pictureView{
	height: 100%;
}
#pictureView2{
	height: 100%;
}
.head_left_btn{
	position: relative;
	float: right;
}
.head_right{
	border: 1px solid black; 
	float: right;
	width: 55%;
    height: 300px;
}
.head_right label{
	margin-left: 3%;
    margin-top: 5%;
	width: 30%;
}
.head_right input{
	width: 60%;
    PADDING: 1%;
    MARGIN: 3%;
}
.head_right select{	
	MARGIN: 3%;
    HEIGHT: 12%;
    WIDTH: 60%; 
}
.body_top{
	/* border: 1px solid pink; */
	border: 1px solid black; 
	
}
.body_top label{
	margin: 1%;
    margin-left: 6%;
    margin-top: 10px;
    width: 20%;
}
}
.body_main{
	/* border: 1px solid green; */
}
.modal_footer{
	text-align : center;
	/* border: 1px solid purple; */
	width: 100%;
	height: 50px;
}
.footer_left{
	float: left;
    margin-left: 30%;
    margin-top: 1%;
}
.footer_right{
	float: right;
    margin-right: 30%;
    margin-top: 1%;
	
}
table{
	border-collapse:separate ;
}

.writeBtn{
	width : 100px; 
	background: #C7C4FF;
	font-weight: bold;
	font-size: 15px;
				
}

.form-group{
	margin-top : 20px;	

}
.table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th {
    padding: 15px 0px 10px 0px;
    line-height: 1.42857143;
    vertical-align: top;
    border-top: 1px solid #ddd;
    font-size: 18px;
}

</style>
</head>

<body class="blur-theme data-container-body">

			
			<div class="container-dashboard" style="background-color: white;">
				<div class="container-dashboard-inner">
				<form id="infoForm" class="form-inline">
						<input name="page" type="hidden" value="${pageMaker.cri.page }">
						<input name="perPageNum" type="hidden" value="${pageMaker.cri.perPageNum }">
				<div class="clearfix">
					<div class="pull-left">
						<h2>&nbsp;관리자 - 강의 관리</h2>
					</div>	
					
					 <div class="pull-right" id="keyword">
						<div class="form-group">						
				        <button type="button" class="btn btn-sm btn-white btn-bold writeBtn" onclick="registLec();">
							<i class="grey ace-icon fa bigger-120"></i><b>등록</b>
						</button>
						<select class="form-control" name="searchType" id="searchType">
							<option value="t" ${pageMaker.cri.searchType eq 't' ? 'selected':'' }>강의명</option>
							<option value="l" ${pageMaker.cri.searchType eq 'l' ? 'selected':'' }>교과구분</option>
						</select>	
						
							<input onkeyup="enterkey(${pageMaker.cri.page});" type="text" class="form-control" placeholder="검색어를 입력해주세요" id="keyword" name="keyword" value="${pageMaker.cri.keyword }">
							<i  class="fa fa-search search-box" aria-hidden="true" onclick="searchList_go(${pageMaker.cri.page})"  style="cursor:pointer;"></i>
						</div>
					</div>
				</div>				
					<!-- <div class="pull-right"> 
						<button id="write" class="form-control" type="button"
							style="color: white; background-color: black;">&nbsp;&nbsp;&nbsp;작성</button>
					</div> -->
			</form>				
				<div class="table-responsive">
					<table class="table table-striped">
						<tbody class="tableA">
						<c:if test="${not empty lectureList }" >
							<tr>
								<td class="text-center" style="width:1%;">번호</td>  
								<td class="text-center" style="width:5%;">강의명</td>   
								<td class="text-center" style="width:15%;">강의구분</td> 
								<td class="text-center" style="width:10%;">담당 교수 ID</td>  
								<td class="text-center" style="width:12%;">모집 시작일</td>   
								<td class="text-center" style="width:12%;">모집 마감일</td>
								<td class="text-center" style="width:12%;">강의 시작일</td>
								<td class="text-center" style="width:12%;">강의 마감일</td>								
								<td class="text-center" style="width:15%;">강의 가격</td>		
							</tr>    
						 <c:forEach var="lectureList" items="${lectureList }" varStatus="status">
							<tr>
									
								<td class="text-center" style="width: 10%;">${lectureList.lecture_no }</td>
								<td class="text-center" style="width: 7%;">
									<a href="#" onclick="lecDetail('${lectureList.lecture_no}')">${lectureList.lecture_title }</a>
								</td>
								<td class="text-center" style="width: 10%;">${lectureList.lecture_distinction }</td>
								<td class="text-center" style="width: 10%;">${lectureList.professor_id }</td>
								
								<td style="width: 10%; text-align: center;">
									<fmt:formatDate value="${lectureList.lecture_recruit_date}" pattern="yyyy-MM-dd"/>
								</td>
								<td style="width: 10%; text-align: center;">
									<fmt:formatDate value="${lectureList.lecture_recruit_status}" pattern="yyyy-MM-dd"/>
								</td>
								<td style="width: 10%; text-align: center;">
									<fmt:formatDate value="${lectureList.lecture_progress}" pattern="yyyy-MM-dd"/>
								</td>
								<td style="width: 10%; text-align: center;">
									<fmt:formatDate value="${lectureList.lecture_end}" pattern="yyyy-MM-dd"/>
								</td>
																
								<td class="text-center" style="width: 10%;">${lectureList.lecture_price }</td>
											
							</tr>			
							</c:forEach>	
							</c:if>
						</tbody>
					</table>
				</div>
				
				
				  <nav id="pageO" aria-label="member list Navigation" class="col-xs-offset-5 col-xs-7" style="position: relative;">
					<ul class="pagination justify-content-center m-0">
						<li class="page-item">
							<a class="page-link" href="javascript:searchList_go(1);">
							<i class="glyphicon glyphicon-step-backward"></i>
							</a>
						</li>
						<li class="page-item">
							<a class="page-link" href="javascript:searchList_go(
							${pageMaker.prev ? pageMaker.startPage-1 : 1}				
							);"><i class="glyphicon glyphicon-chevron-left"></i></a>
						</li>
						<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="pageNum">						
						<li class="page-item 
							<c:out value="${pageMaker.cri.page == pageNum?'active':''}"/>">
							<a class="page-link" href="javascript:searchList_go(${pageNum});" >${pageNum }
							</a>
						</li>
						</c:forEach>
						<li class="page-item">
							<a class="page-link" href="javascript:searchList_go(
							${pageMaker.next ? pageMaker.endPage+1 : pageMaker.cri.page},'${flag }'			
							);"><i class="glyphicon glyphicon-chevron-right" ></i></a>
						</li>
						<li class="page-item">
							<a class="page-link" href="javascript:searchList_go(
								${pageMaker.realEndPage} );">
								<i class="glyphicon glyphicon-step-forward"></i></a>
						</li>	
					</ul>
				</nav>
			</div>
		</div>
	<form id="jobForm">
		<input type='hidden' name="page" value="${pageMaker.cri.page}" />
		<input type='hidden' name="perPageNum" value="${pageMaker.cri.perPageNum}"/>
		<input type='hidden' name="searchType" value="${pageMaker.cri.searchType }" />
		<input type='hidden' name="keyword" value="${pageMaker.cri.keyword }" />
	</form>
	
	
	
	
	
	
	
	
	
	<!-- The Modal -->
    <div id="lectureModal" class="modal">
 	<form enctype="multipart/form-data" name="regist" method="post" action="/manager/lecture_management" >
      <!-- Modal content -->
      <div class="lecture-modal-content">
        <span class="close">&times;</span>
       	<div class="modal_head">
        	<h2 style="text-align: center;">강의 모집글 등록</h2>     
        	<div class="head_left">
        		<div class="" id="pictureView" class="profileImgeLabel">
	        		<div class="head_left_btn" >
						<label for="picture" class=" btn btn-info btn-sm btn-flat">파일선택</label>
						<input type="file" id="picture" name="picture" style="display:none;" />
						<input id="inputFileName" class="form-control" type="hidden" name="lecture_img" />
	        		</div>
        		</div>
        	</div> 	
       		<div class="head_right">
				<label>강의번호</label>
				<input type="text" name="lecture_no" maxlength="50" value="${nextLecture_no }" readonly="readonly" style="background-color: lightgray">
				<label>담당교수 ID</label>
				<select name="professor_id">
					<c:forEach var="professorList" items="${professorList }" varStatus="status">
						<option value="${professorList.professor_id }">${professorList.professor_id }</option>
					</c:forEach>
				</select>
				
				<input type="hidden" name="manager_id" value="admin">
				<label>강의제목</label>
				<input type="text" name="lecture_title" maxlength="50">
				<label>교과목 구분</label>
				<input type="text" name="lecture_distinction" maxlength="50">				
       			<label>강의 가격</label>
				<input type="text" name="lecture_price">
			</div>
       	</div>
       	<div class="modal_body">
       		<div class="body_top">
				<label>모집 시작일</label>
				<input type="date" name="lecture_recruit_date" >
				<label>모집 마감일</label>
				<input type="date" name="lecture_recruit_status"  >
       			<label>강의 시작일</label>
       			<input type="date" name="lecture_progress" >  
       			<label>강의 마감일</label>
       			<input type="date" name="lecture_end" >  
       		</div>
       		<div class="body_main">
       			<textarea id="lecture_content" name="lecture_content"></textarea>
       		</div>
       	</div>
       	<div class="modal_footer">
       		<div class="footer_left">
	      		<button id="regist" class="btn btn-primary flex-item btn-primary active" type="button" >등록</button>
     		</div>     		
     		<div class="footer_right">
	            <button id="close" class="btn btn-danger flex-item btn-primary active" type="button" >닫기</button>       		
     		</div>
       	</div>
   	  </div>
   	  </form> 
    </div>	
    
    <!-- The Modal -->
    <div id="lectureModal2" class="modal">
 	<form enctype="multipart/form-data" name="update" id="updateform" method="post" action="/manager/lecture_management" >
      <!-- Modal content -->
      <div class="lecture-modal-content">
        <span class="close"></span>
       	<div class="modal_head">
        	<div class="head_top">
	            <button id="deletebtn" class="btn btn-secondary flex-item btn-secondary active writeBtn" type="button" >삭제</button>       		
        		<h2>강의 변경</h2>
     		</div>        	     
        	<div class="head_left">
        		<div class="" id="pictureView2" class="profileImgeLabel">
	        		<div class="head_left_btn" >
						<label for="picture2" class=" btn btn-info btn-sm btn-flat">파일선택</label>
						<input type="file" id="picture2" name="picture" style="display:none;" />
						<input id="inputFileName2" class="form-control" type="hidden" name="lecture_img" />
	        		</div>
        		</div>
        	</div> 	
       		<div class="head_right">
				<label>강의번호</label>
				<input type="text" id="lecture_no2" name="lecture_no" maxlength="50"  readonly="readonly" style="background-color: lightgray">
				<label>담당교수 ID</label>
				<select name="professor_id" id="professor_id2" >
					<c:forEach var="professorList" items="${professorList }" varStatus="status">
						<option value="${professorList.professor_id }">${professorList.professor_id }</option>
					</c:forEach>
				</select>
				
				<input type="hidden" name="manager_id" id="manager_id2" value="admin">
				<label>강의제목</label>
				<input type="text" name="lecture_title" id="lecture_title2" maxlength="50" >
				<label>교과목 구분</label>
				<input type="text" name="lecture_distinction" id="lecture_distinction2" maxlength="50" >				
       			<label>강의 가격</label>
				<input type="text" name="lecture_price" id="lecture_price2" >
			</div>
       	</div>
       	<div class="modal_body">
       		<div class="body_top">
				<label>모집 시작일</label>
				<input type="date" name="lecture_recruit_date" id="lecture_recruit_date2"  >
				<label>모집 마감일</label>
				<input type="date" name="lecture_recruit_status" id="lecture_recruit_status2" >
       			<label>강의 시작일</label>
       			<input type="date" name="lecture_progress" id="lecture_progress2" >
       			<label>강의 마감일</label>
       			<input type="date" name="lecture_end" id="lecture_end2"  >  
       		</div>
       		<div class="body_main">
       			<textarea id="lecture_content2" name="lecture_content" ></textarea>
       		</div>
       	</div>
       	<div class="modal_footer">
       		<div class="footer_left">
	      		<button id="update" class="btn btn-primary flex-item btn-primary active" type="button" >수정</button>
     		</div>     		
     		<div class="footer_right">
	            <button id="close2" class="btn btn-danger flex-item btn-primary active" type="button" >닫기</button>       		
     		</div>
       	</div>
   	  </div>
   	  </form> 
    </div>	
</body>
<script>

function registLec(){
	lectureModal.style.display = "block";	
	$("div.panel-body").html("");
}	
	
	//This is Modal Setting!
	// Get the modal
	var lectureModal = document.getElementById('lectureModal');
	var lectureModal2 = document.getElementById('lectureModal2');
	
	// Get the button that opens the modal
	var btn = document.getElementById("urlModal");
	
	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[1];                                          
	
	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
		lectureModal.style.display = "none";
		lectureModal2.style.display = "none";
	}
	
	/* // When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	    if (event.target == modal) {
	        modal.style.display = "none";
	    }
	} */
	
	//강의 이미지 기능
	$('input#picture').on('change',function(event){
		
		var fileFormat= this.value.substr(this.value.lastIndexOf(".")+1).toUpperCase();
		if(fileFormat!="JPG"){
			alert("이미지는 jpg 형식만 가능합니다.");
			return;
		}
		if(this.files[0].size>1024*1024*5){
			alert("사진 용량은 5MB 이하만 가능합니다.");
			return;
		};
		
		document.getElementById('inputFileName').value=this.files[0].name;
		
		if(this.files && this.files[0]){
			var reader = new FileReader();
			
			reader.onload = function(e){
				//이미지 미리보기
				$('div#pictureView'). css({'background-image':'url('+e.target.result+')',
					'background-position' :'center',
					'background-size':'cover',
					'background-repeat':'no-repeat'
				});
			}
			reader.readAsDataURL(this.files[0]);
		}
	});
	//강의 수정 이미지 기능
	$('input#picture2').on('change',function(event){
		
		var fileFormat= this.value.substr(this.value.lastIndexOf(".")+1).toUpperCase();
		
		if(this.files[0].size>1024*1024*5){
			alert("사진 용량은 5MB 이하만 가능합니다.");
			return;
		};
		
		document.getElementById('inputFileName2').value=this.files[0].name;
		
		if(this.files && this.files[0]){
			var reader = new FileReader();
			
			reader.onload = function(e){
				//이미지 미리보기
				$('div#pictureView2'). css({'background-image':'url('+e.target.result+')',
					'background-position' :'center',
					'background-size':'cover',
					'background-repeat':'no-repeat'
				});
			}
			reader.readAsDataURL(this.files[0]);
		}
	});
	
	
	// 등록 버튼
	$('#regist').on('click', function(e){
		var form = document.regist;
		
		if(form.lecture_title.value==""){
			alert("제목은 필수 입니다.");
			return;
		}
		if(form.lecture_content.value.length>1000){
			alert("글자수가 1000자를 초과할 수 없습니다.");
			return;
		}
		lectureModal.style.display = "none";
		form.submit(); 
	});
	//닫기 버튼
	$('#close').on('click', function(){
		lectureModal.style.display = "none";
		location.reload();

 	});
	
	//닫기 버튼
	$('#close2').on('click', function(){
		lectureModal2.style.display = "none";
		location.reload();

 	});
	
	 
//상세보기 
function lecDetail(src){
	
	$.ajax({
        url: "<%=request.getContextPath()%>/manager/lecture_management_detail", 
		data: {"lecture_no" : src},
		type: "POST",
        success: function(data) {
           var timestamp1 = data.lecture_progress;
           var timestamp2 = data.lecture_recruit_date;
           var timestamp3 = data.lecture_recruit_status;
           var timestamp4 = data.lecture_end;
           var date1 = new Date(timestamp1);
           var date2 = new Date(timestamp2);
           var date3 = new Date(timestamp3);
           var date4 = new Date(timestamp4);
              $("#lecture_no2").val(data.lecture_no);      
              var option = $("<option selected>"+data.professor_id+"</option>");
              $('#professor_id2').append(option);
              $("#manager_id2").val(data.manager_id);                  
              $("#lecture_distinction2").val(data.lecture_distinction);          
              $("#lecture_title2").val(data.lecture_title);               
              $("#lecture_progress2").val(getFormatDate(date1));            
              $("#lecture_recruit_date2").val(getFormatDate(date2));	    
              $("#lecture_recruit_status2").val(getFormatDate(date3));	
              $("#lecture_end2").val(getFormatDate(date4));	
              $("#inputFileName2").val(data.lecture_img);		            
              $("#lecture_price2").val(data.lecture_price);		        
              $("div.panel-body").html(data.lecture_content);
              var image = data.lecture_img;
              $('div#pictureView2'). css({'background-image':'url("<%=request.getContextPath()%>/manager/picture/'+data.lecture_img+'")',
										 'background-position' :'center',
			   							 'background-size':'cover',
										 'background-repeat':'no-repeat'
			  });         
              
              lectureModal2.style.display = "block";
        },
    	error:function(err){
    		alert('실패');
    	} 
	});
}; 

// 수정 버튼
$('#update').on('click', function(e){

    
	var form = $("#updateform")[0];        
    var formData = new FormData(form);
	
    console.log($("#updateform"));
    console.log(formData);
		
		/* var lecture_no        	   = $("[name= 'lecture_no2']").val();                  
		var professor_id           = $("[name= 'professor_id2']").val();	            
		var manager_id             = $("[name= 'manager_id2']").val();                  
		var lecture_distinction    = $("[name= 'lecture_distinction2']").val();          
		var lecture_title          = $("[name= 'lecture_title2']").val();               
		var lecture_progress       = $("[name= 'lecture_progress2']").val();            
		var lecture_recruit_date   = $("[name= 'lecture_recruit_date2']").val();	    
		var lecture_recruit_status = $("[name= 'lecture_recruit_status2']").val();				
		var lecture_img            = $("[name= 'lecture_img2']").val();		            
		var lecture_price          = $("[name= 'lecture_price2']").val();		        
		var lecture_content        = $("[name= 'lecture_content2']").val();	  */           
				
		
	     $.ajax({
	        data: formData,
	           /* { lecture_no             : lecture_no,
	        		professor_id           : professor_id,
	        		manager_id             : manager_id,
	        		lecture_distinction    : lecture_distinction,
	        		lecture_title          : lecture_title,
	        		lecture_progress       : lecture_progress,
	        		lecture_recruit_date   : lecture_recruit_date,
	        		lecture_recruit_status : lecture_recruit_status, 
	        		lecture_img            : lecture_img,
	        		lecture_price          : lecture_price,
	        		lecture_content        : lecture_content 
	        	  }, */
	        	  
	        url: "<%=request.getContextPath()%>/manager/lecture_management_modify", 
	        type: "POST",
	        contentType: false,
	        processData: false,
	        success: function(src) {
	           lectureModal2.style.display = "none";
	           location.reload();
	        },
        	error:function(err){
        		alert("이미 수강후기가 등록된 종료강의입니다. 수정할 수 없습니다.");
        	} 
     });  
});
	
	//삭제 버튼
	$('#deletebtn').on('click', function(){
		var lecture_no = $("#lecture_no2").val();
		$.ajax({
	        data: { "lecture_no" : lecture_no },	        	  
	        url: "<%=request.getContextPath()%>/manager/lecture_management_delete", 
	        type: "POST",
	        success: function(src) {
	           lectureModal2.style.display = "none";
	           location.reload();
	        },
        	error:function(err){
        		alert('이미 결제가 이루어진 강의입니다. 삭제할 수 없습니다.'); 
        	} 
     	});  
	});
	
	
    function getFormatDate(date){
        var year = date.getFullYear();              //yyyy
        var month = (1 + date.getMonth());          //M
        month = month >= 10 ? month : '0' + month;  //month 두자리로 저장
        var day = date.getDate();                   //d
        day = day >= 10 ? day : '0' + day;          //day 두자리로 저장
        return  year + '-' + month + '-' + day;       //'-' 추가하여 yyyy-mm-dd 형태 생성 가능
    }
	    
	//버튼 클릭 및 페이지 이동 버튼
	function searchList_go(page){
		var jobForm=$('#jobForm');
		jobForm.find("[name='page']").val(page);
		jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
		jobForm.find("[name='keyword']").val($('input[name="keyword"]').val());	
		var perPageNum=$("[name='perPageNum']").val();
		jobForm.attr("method","get");
		console.log(jobForm);
		jobForm.attr("action","lecture_management?page="+page+"&perPageNum="+perPageNum+"&searchType="+searchType+"&keyword="+keyword)
		
		jobForm.submit();
		
	}

	//검색란에서 입력시
	function enterkey(page){
		if (window.event.keyCode == 13) {
			 
			var jobForm=$('#jobForm');
			jobForm.find("[name='page']").val(page);
			jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
			jobForm.find("[name='keyword']").val($('input[name="keyword"]').val());	
			jobForm.find("[name='perPageNum']").val($('input[name="perPageNum"]').val());
			var perPageNum=$("[name='perPageNum']").val();
			jobForm.attr("method","get");
			jobForm.attr("action","lecture_management?page="+page+"&?perPageNum="+perPageNum+"&?searchType="+searchType+"&?keyword="+keyword)
			
			jobForm.submit();
			
	   }

	}
	
</script>
<%@ include file="/WEB-INF/views/lecture/videonote_js.jsp" %>