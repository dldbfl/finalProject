<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<head>
<title>교육목표 관리</title>
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
	margin-left: 100px;
    height: 467px;
    width: 930px;
    margin-top: 40px;	
	background-image:url("<%=request.getContextPath()%>/manager/picture/education_purpose/${manager_board.manager_board_no}");
	background-repeat: no-repeat;
    background-position: center;
    background-size: cover;	
}

</style>
<script src="<%=request.getContextPath()%>/resources/scripts/common.js"></script>
</head>
<body >
<div class="bookcover">
<h1>교육목표 관리</h1>
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
	<div class="col-sm-12">
	 <div  class="col-sm-8" role="manager_data_filename">
		<div id="picturePreView">
			<div id = "buttonset2">
				<label for="manager_data_filename"  id = "data_change" class="btn btn-xs btn-info" style="width:110px;margin-bottom:2px;visibility: hidden;">사진변경</label>
				<input type="file" id="manager_data_filename" name="manager_data_filename" style="display:none;"/>
		 		<input type="hidden" id="old_manager_data_filename" name="old_manager_data_filename" value="${manager_board.manager_data_filename }"/>		
			</div>
		</div>		
	 </div>
	
	 <div  > 
		 <textarea  style="display: none;font-size : 18px; height: 360px; margin-top: 80px; border: pink;" readonly class="col-sm-12 enterprise_modifyset" name ="education_purpose">${manager_board.education_purpose}</textarea>     
	 </div>
	<%--  <input type="hidden" readonly class="col-sm-12 enterprise_modifyset" value="${enterprise_introduce.enterprise_introduce_writer}"> --%>                		   
	 <input type="hidden" readonly name="manager_board_no" class="col-sm-12 enterprise_modifyset" value="${manager_board.manager_board_no}">
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
	$('.enterprise_modifyset').removeAttr("readonly");
	$('#data_change').css({'visibility':'visible'});
}

function Cansel_go(){
	$('#modify').removeAttr("disabled");
	$('#cansel').attr('disabled', true);
	$('#submit').attr('disabled', true);
	$('.enterprise_modifyset').attr('readonly', true);	
	$('#data_change').css({'visibility':'hidden'});
	$('#modifyform').each(function(){
        this.reset();
    });
	$('#picturePreView').css({'background-image':'url("<%=request.getContextPath()%>/manager/picture/education_purpose/${manager_board.manager_board_no}"'});
	alert('취소된 이미지는 저장되지 않습니다.')
}

/* 사진업로드 */
$('input[name="manager_data_filename"]').on('change',function(){
	console.log('테스트')
  //$('#picturePreView').on('click',function(){
	$('input[name="checkUpload"]').val(0);
	console.log('작동확인');
	//이미지 확장자 jpg 확인
	var fileFormat=
		this.value.substr(this.value.lastIndexOf(".")+1).toUpperCase();
	if(fileFormat!="JPG" && fileFormat!="JPEG"){
		alert("이미지는 jpg 형식만 가능합니다.");			
		return false;
	}
	
	//이미지 파일 용량 체크
	if(this.files[0].size>1024*1024*1){
		alert("사진 용량은 1MB 이하만 가능합니다.");
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


