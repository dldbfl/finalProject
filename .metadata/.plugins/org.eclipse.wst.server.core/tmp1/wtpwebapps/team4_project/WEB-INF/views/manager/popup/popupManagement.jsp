<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<head>
<title>메인화면 이미지 팝업 관리</title>

<style type="text/css" id="fontFamilyStyleSheet">

body { 
	background-color:white;
	font-family: 'Malgun Gothic', sans-serif !important; 
}
.fileDrop{
	width:90%;
	height:100px;
	border:1px dotted gray;
	margin:auto;
}
select:disabled {
	background: lightgray;
  	border:1px solid gray; 
}
input:read-only, 
textarea:read-only{
  cursor: not-allowed;
}
div#picturePreView1{
	height:200px;
	width:200px;
	margin:0 auto;
	margin-top : 15px;	  		
	border : 1px solid lightgray;  		
	background-image:url("<%=request.getContextPath()%>/manager/popup/1");
	background-repeat:no-repeat;
	background-position:center;
	background-size:cover;
}
div#picturePreView2{
	height:200px;
	width:200px;
	margin:0 auto;
	margin-top : 15px;	  		
	border : 1px solid lightgray;  		
	background-image:url("<%=request.getContextPath()%>/manager/popup/2");
	background-repeat:no-repeat;
	background-position:center;
	background-size:cover;
}
div#picturePreView3{
	height:200px;
	width:200px;
	margin:0 auto;
	margin-top : 15px;	  		
	border : 1px solid lightgray;  		
	background-image:url("<%=request.getContextPath()%>/manager/popup/3");
	background-repeat:no-repeat;
	background-position:center;
	background-size:cover;
}

</style>
<script src="<%=request.getContextPath()%>/resources/scripts/common.js"></script>


</head>
<body >
	<div class="bookcover">
		<h1>메인화면 PopUP 관리</h1>
		<div id = "buttonset">				
			<button id = "modify" type="button" class="btn btn-sm btn-white btn-bold " onclick="Modfiy_go();">
				<i class="red ace-icon fa fa-check bigger-120"></i><b>수정</b>
			</button>
			<button id = "submit" disabled type="button" class="btn btn-sm btn-white btn-bold " onclick="goSubmit('post');">
				<i class="red ace-icon fa fa-check bigger-120"></i><b>확인</b>
			</button>
			<button id = "cansel" disabled type="reset" class="btn btn-sm btn-white btn-bold " onclick="Cansel_go();">
				<i class="grey ace-icon fa fa-times bigger-120"></i><b>취소</b>
			</button>
		</div>
	

<form role="form" id= "modifyform" name='modifyform' method=post enctype="multipart/form-data">
	
	 <div  role="manager_data_filename">
		 <div class="container">
			<!--header start-->
			<div class="row">
				<div class="col-sm-12" style="margin-top: 10%;">
					<div class="col-sm-1" style="margin-left: 5%;">
					</div>
					<div class="col-sm-3">
						<h3 style="text-align: center; font-weight: bold;">1번 PopUP</h3>
						<div id="picturePreView1"></div>	
						<div class="col-sm-4">
							
						</div>
						<div class="col-sm-4">							
				 			<label class="btn btn-xs btn-info data_change" style="width:130px;margin-bottom:2px;visibility: hidden;">
							사진변경
								<input type="file" class="manager_data_filename" name="manager_data_filename1" style="display: none;" />
						 		<input type="hidden" class="old_manager_data_filename" name="old_manager_data_filename1" value="${popup1 }"/>	
					 		</label>
			 			</div>
			 			<div class="col-sm-4">
			 				<label class="btn btn-xs btn-info " for="popup1close" style="margin-left: 1px;width: 24px;margin-bottom: 2px;visibility: hidden;background-color: snow;">
								<input id="popup1close" value="비활성화" type="image" src="/resources/images/x2.png" style="width: 12px;visibility: visible;">
							</label>
	 		 			</div>
			 		</div>
			 		<div class="col-sm-3">
			 			<h3 style="text-align: center; font-weight: bold;">2번 PopUP</h3>
				 		<div id="picturePreView2"></div>
				 		<div class="col-sm-4">
							
						</div>
						<div class="col-sm-4">							
				 			<label class="btn btn-xs btn-info data_change" style="width:130px;margin-bottom:2px;visibility: hidden;">
							사진변경
								<input type="file" class="manager_data_filename" name="manager_data_filename2" style="display: none;" />
						 		<input type="hidden" class="old_manager_data_filename" name="old_manager_data_filename2" value="${popup2 }"/>	
					 		</label>
			 			</div>
			 			<div class="col-sm-4">
			 				<label class="btn btn-xs btn-info " for="popup2close" style="margin-left: 1px;width: 24px;margin-bottom: 2px;visibility: hidden;background-color: snow;">
								<input id="popup2close" value="비활성화" type="image" src="/resources/images/x2.png" style="width: 12px ;visibility: visible;">
							</label>			 			
	 		 			</div>
			 		</div>
			 		<div class="col-sm-3">
			 			<h3 style="text-align: center; font-weight: bold;">3번 PopUP</h3>
				 		<div id="picturePreView3"></div>		
			 			<div class="col-sm-4">
							
						</div>
						<div class="col-sm-4">							
				 			<label class="btn btn-xs btn-info data_change" style="width:130px;margin-bottom:2px;visibility: hidden;">
							사진변경
								<input type="file" class="manager_data_filename" name="manager_data_filename3" style="display: none;" />
						 		<input type="hidden" class="old_manager_data_filename" name="old_manager_data_filename3" value="${popup3 }"/>	
					 		</label>
			 			</div>
			 			<div class="col-sm-4">
			 				<label class="btn btn-xs btn-info " for="popup3close" style="margin-left: 1px;width: 24px;margin-bottom: 2px;visibility: hidden;background-color: snow;">
								<input id="popup3close" value="비활성화" type="image" src="/resources/images/x2.png" style="width: 12px;visibility: visible;">
							</label>
	 		 			</div>
		 			</div>
		 			<div class="col-sm-1">
		 			</div>
		  		</div>
			  </div>
		</div>
	</div>
	 
	
	
</form>
</div>

</body>

<!-- form submit -->
<script>

function Modfiy_go(){
	$('#modify').attr('disabled', true);
	$('#cansel').removeAttr("disabled");
	$('#submit').removeAttr("disabled");
	$('.data_change').css({'visibility':'visible'});
	$('.popupclose').css({'visibility':'visible'});
}

function Cansel_go(){
	$('#modify').removeAttr("disabled");
	$('#cansel').attr('disabled', true);
	$('#submit').attr('disabled', true);
	$('.data_change').css({'visibility':'hidden'});
	$('.popupclose').css({'visibility':'hidden'});
	$('#modifyform').each(function(){
        this.reset();
    });
	$('#picturePreView1').css({'background-image':'url("<%=request.getContextPath()%>/manager/popup/1"'});
	$('#picturePreView2').css({'background-image':'url("<%=request.getContextPath()%>/manager/popup/2"'});
	$('#picturePreView3').css({'background-image':'url("<%=request.getContextPath()%>/manager/popup/3"'});
	$('input[name = old_manager_data_filename1]').attr('name','${popup1 }');
	$('input[name = old_manager_data_filename2]').attr('name','${popup2 }');
	$('input[name = old_manager_data_filename3]').attr('name','${popup3 }');

	
	alert('취소된 이미지는 저장되지 않습니다.')
}

$('#popup3close').on('click',function(){
	$('input[name = manager_data_filename3]').attr('name','');
	$('input[name = old_manager_data_filename3]').attr('name','');
	$('div#picturePreView3').css({'background-image':''});
});
$('#popup2close').on('click',function(){
	$('input[name = manager_data_filename2]').attr('name','');
	$('input[name = old_manager_data_filename2]').attr('name',''); 
	$('div#picturePreView2').css({'background-image':''});
});
$('#popup1close').on('click',function(){
	$('input[name = manager_data_filename1]').attr('name','');
	$('input[name = old_manager_data_filename1]').attr('name',''); 
	$('div#picturePreView1').css({'background-image':''});
});

/* 사진업로드 */
$('.manager_data_filename').on('change',function(){
	var click_id = $(this).attr("name");
	console.log(click_id+'번 업로드')  
	//이미지 확장자 jpg 확인
	var fileFormat=
		this.value.substr(this.value.lastIndexOf(".")+1).toUpperCase();
/* 	if(fileFormat!="JPG" && fileFormat!="JPEG"){
		alert("이미지는 jpg 형식만 가능합니다.");			
		return false;
	} */
	
	//이미지 파일 용량 체크
	if(this.files[0].size>1024*1024*5){
		alert("사진 용량은 5MB 이하만 가능합니다.");
		return false;
	};	
	
	if (this.files && this.files[0]) {
		
        var reader = new FileReader();
        
        reader.onload = function (e) {
        	//이미지 미리보기	   
        	
        	if(click_id == 'manager_data_filename1'){
	        	$('div#picturePreView1')
	        	.css({'background-image':'url('+e.target.result+')',
					  'background-position':'center',
					  'background-size':'cover',
					  'background-repeat':'no-repeat'
        		});
	       	}else if(click_id == 'manager_data_filename2'){
	       		$('div#picturePreView2')
	        	.css({'background-image':'url('+e.target.result+')',
					  'background-position':'center',
					  'background-size':'cover',
					  'background-repeat':'no-repeat'
        		});
	       	}else{
	       		$('div#picturePreView3')
	        	.css({'background-image':'url('+e.target.result+')',
					  'background-position':'center',
					  'background-size':'cover',
					  'background-repeat':'no-repeat'
        		});
	       	}
        	
        }
        
        reader.readAsDataURL(this.files[0]);
	}
 });	
function goSubmit(cmd){ 
	var form = document.modifyform;
	switch(cmd) {
	case "post":		
		form.submit();		
		break;
	case "close":
		window.close();
		return;
		break;
	default:
		return;
		break;
	}	
}

</script>


