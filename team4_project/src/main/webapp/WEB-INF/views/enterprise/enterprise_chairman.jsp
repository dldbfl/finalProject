<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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

div#picturePreView{
	height:600px;
	width:1280px;
	margin:0 auto;
	margin-top : 15px;	  		
	background-image:url("<%=request.getContextPath()%>/manager/picture/chairman_introduce/${manager_board.manager_board_no}");
	background-repeat:no-repeat;
	background-position:center;
	background-size:cover;
}

.chaurDiv{
	padding: 20px;
}
</style>
<body >

<form role="form" id= "modifyform" name='modifyform' method=post enctype="multipart/form-data">
	 <div class="col-sm-12">
		 <div  class="col-sm-8 chaurDiv" role="manager_data_filename">
			<div id="picturePreView">	
				<div id = "buttonset2">	
					<input type="file" id="manager_data_filename" name="manager_data_filename" style="display:none;"/>
			 		<input type="hidden" id="old_manager_data_filename" name="old_manager_data_filename" value="${manager_board.manager_data_filename }"/>		
				</div>
			</div>	
	 	</div>
 	 <input type="hidden" readonly name="manager_board_no" class="col-sm-12 enterprise_modifyset" value="${manager_board.manager_board_no}">
	</div>
</form>

</body>