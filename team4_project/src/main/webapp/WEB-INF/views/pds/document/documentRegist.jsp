<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<html>
<head>
	<link href="<%=request.getContextPath() %>/resources/css/qna/detail.css" rel="stylesheet">
<style>
.btn-default{
	color:black;
}
.header_logo col-sm-3{
    width: 130px;
}	

</style>	
</head>
<body>
	<form id="infoForm" action="regist" method="post" enctype="multipart/form-data">
	<div style="width: 100%;">
	<table class="board_view">
		<colgroup>
			<col width="15%"/>
			<col width="35%"/>
			<col width="15%"/>
			<col width="35%"/>
		</colgroup>
		<caption style="font-size: 3.0em;">문서자료등록</caption>

		<caption style="text-align:right;">
			<a href="#" class="btns" id="saveBtn">등록</a>
			<a href="#" onclick="history.go(-1)" class="btns" >취소</a>
		</caption>
		<tbody>
			<tr>
				<th scope="row">제목</th>
				<td colspan="3" ><input name="document_title" style="border: none; width: 100%;" placeholder="제목을 입력하세요">
								 <input type="hidden" name="document_writer" value="${loginUser.member_id }">
				</td>
			</tr>
			<tr>
				<th scope="row">파일 첨부</th>
				<td colspan="3"><div class="custom-file-upload">
   								<input style="width: 100%;" type="file" id="file" name="documentFile" accept=".hwp,.doc,.docx,.ppt,.pptx,.xls,.xlsx,.pdf" />
							    </div></td>		
				</tr>
			</tbody>
		</table>
		</div>	
			<div style="color:black;">
				<textarea id="content" name="document_content"></textarea>
			</div>
	</form>
	<script type="text/javascript">
	
	window.onload = function() {

	    setTimeout (function () {

	    scrollTo(0,0);

	    }, 100);

	}
		$(document).ready(function(){			
			$('#saveBtn').on('click', function(e) {
				e.preventDefault();
				var title = $('input[name=document_title]').val();
				var form = $('#infoForm');
				
				if(title.length<=0){
					alert('제목을 적어주세요');
					return;
				}
				
				if(title.length>30){
					alert('제목은 30자 미만으로 해주세요');
					return;
				}
				
				if($('#file').val().length <=0){
					alert('첨부파일은 필수 입니다.')
					return;
				}
				form.submit();
			})

		});
		
	</script>
</body>
</html>
<%@ include file="documentNote_js.jsp" %>