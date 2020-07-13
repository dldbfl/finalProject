<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<head>
<title>기업소개 관리</title>
<style type="text/css" id="fontFamilyStyleSheet">
body { 
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
div#picturePreView{
    margin-left: 240px;
    height: 460px;
    width: 620px;
    margin-top: 30px;
	background-image:url("<%=request.getContextPath()%>/manager/picture/enterprise_introduce/${enterprise_introduce.enterprise_introduce_no}");
	background-repeat: no-repeat;
    background-position: center;
    background-size: cover;	
}
.enterprise_modifyset{
	font-size: 20px;
    height: 60px;
    border: 2px solid saddlebrown;
    background-color: unset;
}
.enterprise_modifyset2{
	font-size: 20px;
    height: 60px;
    border: 2px solid saddlebrown;
    background-color: unset;
}


</style>
<script src="<%=request.getContextPath()%>/resources/scripts/common.js"></script>
</head>
<body >
<div class="bookcover">
<h1>기업소개</h1>
<div id = "buttonset">
<button id = "modify" type="button" class="btn btn-sm btn-white btn-bold" onclick="Modfiy_go();">
	<i class="red ace-icon fa fa-check bigger-120"></i><b>수정</b>
</button>
<button id = "submit" disabled type="button" class="btn btn-sm btn-white btn-bold" onclick="goSubmit('post');">
	<i class="red ace-icon fa fa-check bigger-120"></i><b>확인</b>
</button>
<button id = "cansel" disabled type="reset" class="btn btn-sm btn-white btn-bold" onclick="Cansel_go();">
	<i class="grey ace-icon fa fa-times bigger-120"></i><b>취소</b>
</button>
</div>

<form role="form" id= "modifyform" name='modifyform' method=post enctype="multipart/form-data">
	<div class="col-sm-12" style="HEIGHT: 0PX;" >
		<div  class="col-sm-12" role="manager_data_filename">
			<div id="picturePreView">		
				<div id = "buttonset2">	
					<label for="manager_data_filename"  id = "data_change" class="btn btn-xs btn-info" style="width:110px;margin-bottom:2px;visibility: hidden;">사진변경</label>
					<input type="file" id="manager_data_filename" name="manager_data_filename" style="display:none;"/>
			 		<input type="hidden" id="old_manager_data_filename" name="old_manager_data_filename" value="${enterprise_introduce.manager_data_filename }"/>		
			 	</div>
		 	</div>
		 </div>	
		 <div class="col-sm-12 memocover" style="margin: 40px;" > 
			<input readonly class="col-sm-4 enterprise_modifyset" value="기업명">
			<input readonly class="col-sm-8 enterprise_modifyset2" name 	="enterprise_name"    value="${enterprise_introduce.enterprise_name}">                		
			<input readonly class="col-sm-4 enterprise_modifyset" value="설립일자">
			<input readonly class="col-sm-8 enterprise_modifyset2" name ="enterprise_regdate" value="${enterprise_introduce.enterprise_regdate}">               		
			<input readonly class="col-sm-4 enterprise_modifyset" value="대표이사">
			<input readonly class="col-sm-8 enterprise_modifyset2" name ="enterprise_manager" value="${enterprise_introduce.enterprise_manager}">              		
			<input readonly class="col-sm-4 enterprise_modifyset" value="위치">
			<input readonly class="col-sm-8 enterprise_modifyset2" name ="enterprise_location"value="${enterprise_introduce.enterprise_location}">           			
			<input readonly class="col-sm-4 enterprise_modifyset" value="사업자 등록번호">
			<input readonly class="col-sm-8 enterprise_modifyset2" name ="enterprise_regno"   value="${enterprise_introduce.enterprise_regno}">          					
			<input readonly class="col-sm-4 enterprise_modifyset" value="전화번호">
			<input readonly class="col-sm-8 enterprise_modifyset2" name ="enterprise_phone"   value="${enterprise_introduce.enterprise_phone}">  
			<input readonly class="col-sm-4 enterprise_modifyset" value="이메일">
			<input readonly class="col-sm-8 enterprise_modifyset2" name ="enterprise_email"   value="${enterprise_introduce.enterprise_email}">  
			
			<input type="hidden" readonly class="col-sm-12 enterprise_modifyset" value="${enterprise_introduce.enterprise_introduce_writer}">                		  
			<input type="hidden" readonly name="enterprise_introduce_no" class="col-sm-12 enterprise_modifyset" value="${enterprise_introduce.enterprise_introduce_no}">
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
	$('.enterprise_modifyset2').removeAttr("readonly");
	$('#data_change').css({'visibility':'visible'});
}

function Cansel_go(){
	$('#modify').removeAttr("disabled");
	$('#cansel').attr('disabled', true);
	$('#submit').attr('disabled', true);
	$('.enterprise_modifyset2').attr('readonly', true);	
	$('#data_change').css({'visibility':'hidden'});
	$('#modifyform').each(function(){
        this.reset();
    });
	$('#picturePreView').css({'background-image':'url("<%=request.getContextPath()%>/manager/picture/enterprise_introduce/${enterprise_introduce.enterprise_introduce_no}"'});
	alert('취소된 이미지는 저장되지 않습니다.')
}

/* 사진업로드 */
$('input[name="manager_data_filename"]').on('change',function(){
	console.log('테스트')
  //$('#picturePreView').on('click',function(){
	$('input[name="checkUpload"]').val(0);
	console.log('작동확인');
	//이미지 확장자 jpg 확인
	var fileFormat=this.value.substr(this.value.lastIndexOf(".")+1).toUpperCase();
	/* if(fileFormat!="JPG" && fileFormat!="JPEG"){
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
        	$('div#picturePreView')
        	.css({'background-image':'url('+e.target.result+')',
				  'background-position':'center',
				  'background-size':'cover',
				  'background-repeat':'no-repeat'
        		});
        }
        
        reader.readAsDataURL(this.files[0]);
	}
 });	
  
/* //form submit (사진 업로드 확인 alert 메서드때문에 공통사항은 아니라 regist.jsp에서 작성해도 무방
  function SubmitMemberRegist(formRole){
  	var uploadCheck = $('input[name="checkUpload"]').val();
  	if(!(uploadCheck>0)){
  		alert("사진 업로드는 필수입니다.");
  		//$('input[name="pictureFile"]').click();
  		return;
  	}
  	var form = $('form[role="' + formRole + '"]');
  	form.submit();
  } */
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


