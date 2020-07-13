<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<title>찾아오는 길</title>
<style type="text/css" id="fontFamilyStyleSheet">
body { 
	font-family: 'Malgun Gothic', sans-serif !important; 
}
.fileDrop{
	width:90%;
	height:100px;
	margin:auto;
}

input:read-only, 
textarea:read-only{
  cursor: not-allowed;
}

div#picturePreView{
	height:500px;
	width:1050px;
	margin:0 auto;
	margin-top : 15px;	  		
	background-image:url("<%=request.getContextPath()%>/manager/picture/enterprise_coming/${manager_board.manager_board_no}");
	background-repeat:no-repeat;
	background-position:center;
	background-size:cover;
}

.enterprise_coming{
	border: none;
	overflow:hidden; 
	font-size : 15px; 
	width :400px;
	height: 200px; 
}
#commingDiv{
	padding: 20px;
}

</style>

<body >

<form role="form" id= "modifyform" name='modifyform' method=post enctype="multipart/form-data">
	<div id="commingDiv">
		<div class="textComing" style="margin-left: 35px;">
		</div>
		 <div role="manager_data_filename">
			<div id="picturePreView">
				<div id = "buttonset2">
					<input type="file" id="manager_data_filename" name="manager_data_filename" style="display:none;"/>
			 		<input type="hidden" id="old_manager_data_filename" name="old_manager_data_filename" value="${manager_board.manager_data_filename }"/>		
		 		</div>
			</div>		
		 </div>
		 <input type="hidden" readonly name="enterprise_introduce_no" class="col-sm-12 enterprise_modifyset" value="${manager_board.manager_board_no}">
		<br>
		  <div class="col-sm-8" >
			<div  style="
								      font-size:1.4em;
								      margin: 18px 0px 0px 14.1875px;
								      width: 700px;
								      height: 100px;
								      " class="col-sm-12 enterprise_modifyset" name ="enterprise_coming">${manager_board.enterprise_coming}</div>     
		 </div>
	</div>
		 
</form>

