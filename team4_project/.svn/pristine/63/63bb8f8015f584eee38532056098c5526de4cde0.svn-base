<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<style type="text/css" id="fontFamilyStyleSheet">
body { 
	font-family: 'Malgun Gothic', sans-serif !important; 
}
.fileDrop{
	width:90%;
	height:100px;
	margin:auto;
}
select:disabled {
	background: lightgray;
}
input:read-only, 
textarea:read-only{
  cursor: not-allowed;
}
div#picturePreView{
	height:1100px;
	width:100%;
	margin:0 auto;
	background-image:url("<%=request.getContextPath()%>/manager/picture/education_curriculum/${manager_board.manager_board_no}");
	background-position: center;
	background-repeat: no-repeat;
}
.butDiv{
	clear: both;
	padding-left: 300px;
	margin-bottom: 20px;
}

#goLecture{
	border: 2px solid #F15F5F;
	background: none;
	padding: 3px;
}
#goLecture:hover {
	background: #F15F5F;
}
div#curBox{
	padding-top: 30px;
	padding-left: 70px;
}
</style>

<body >

<form role="form" id= "modifyform" name='modifyform' method=post enctype="multipart/form-data">
	<div id="curBox">
		<br>
		<div style="font-size : 18px;" class="col-sm-12 enterprise_modifyset">${manager_board.education_curriculum}</div>               					  
	</div>
			<div id="picturePreView">			
				<div id = "buttonset2">	
					<input type="file" id="manager_data_filename" name="manager_data_filename" style="display:none;"/>
			 		<input type="hidden" id="old_manager_data_filename" name="old_manager_data_filename" value="${manager_board.manager_data_filename }"/>		
				</div>
		 	</div> 
		 <input type="hidden" readonly name="manager_board_no" class="col-sm-12 enterprise_modifyset" value="${manager_board.manager_board_no}">
		
		<div class="butDiv">
			<!-- <button type="button" id="goLecture">수강신청하러가기</button> -->
		</div>
</form>

</body>

<script>
$('#goLecture').on('click',function(){
	location.href="<%=request.getContextPath()%>/lecture/list";
})
</script>



