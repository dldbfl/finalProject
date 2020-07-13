<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<head>
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

input:read-only, 
textarea:read-only{
  cursor: not-allowed;
}
div#picturePreView{
	padding:5px;
	height: 2170px;
	width:100%;
	margin:0 auto;
	background-image:url("<%=request.getContextPath()%>/manager/picture/education_purpose/${manager_board.manager_board_no}");
	background-position: center;
	background-repeat: no-repeat;
	
}

</style>
<script src="<%=request.getContextPath()%>/resources/scripts/common.js"></script>
<link href="<%=request.getContextPath() %>/resources/css/manager/manager_board.css" rel="stylesheet">
</head>
<body >

<form role="form" id= "modifyform" name='modifyform' method=post enctype="multipart/form-data">
	 <div>
		<div id="picturePreView" >
				<input type="file" id="manager_data_filename" name="manager_data_filename" style="display:none;"/>
		 		<input type="hidden" id="old_manager_data_filename" name="old_manager_data_filename" value="${manager_board.manager_data_filename }"/>		
		</div>		

	 <input type="hidden" readonly name="manager_board_no" class="col-sm-12 enterprise_modifyset" value="${manager_board.manager_board_no}">
	</div>
</form>

</body>

