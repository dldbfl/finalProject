<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
	<link href="<%=request.getContextPath() %>/resources/css/qna/detail.css" rel="stylesheet">
<style>
.btn-default{
	color:black;
}
</style>	
</head>

<body>
	<form id="infoForm" method="post" enctype="multipart/form-data">
	<div style="width: 100%;">
	<table class="board_view">
		<colgroup>
			<col width="15%"/>
			<col width="35%"/>
			<col width="15%"/>
			<col width="35%"/>
		</colgroup>
		<caption style="font-size: 3.0em;">문서자료수정</caption>

		<caption style="text-align:right;">
			<a href="#" class="btns" id="saveBtn">등록</a>
			<a href="#" onclick="history.go(-1)" class="btns" >취소</a>
		</caption>
		<tbody>
			<tr>
				<th scope="row">제목</th>
				<td colspan="3" ><input name="document_title" style="border: none; width: 100%;" value="${document.document_title }">
								 <input type="hidden" name="document_writer" value="${loginUser_member_id }">
				</td>
			</tr>
			<tr>
				<th scope="row">파일 첨부</th>
					<td colspan="3">
						 <div class="custom-file-upload">	 		
   								<input name ="originalName" id="originalName"style="border: none; width: 70%;" value="${document.originalName }" readonly="readonly"/>
   								<button id="delete" style="background-color: #6b9ab8; color: white; border: 2px solid #6b9ab8; float: left;" >첨부파일 삭제</button>
								<input style="width: 100%;" type="file" id="file" name="documentFile" accept=".hwp,.doc,.docx,.ppt,.pptx,.xls,.xlsx,.pdf" />
						 </div>
					</td>		
				</tr>
			</tbody>
		</table>
		</div>	
			<div style="color:black;">
				<textarea id="content" name="document_content">${document.document_content }</textarea>
			</div>
				<input type="hidden" name="document_no" value="${document.document_no }">
				
	</form>
	
	<script type="text/javascript">
	
	window.onload = function() {

	    setTimeout (function () {

	    scrollTo(0,0);

	    }, 100);

	}			
			$('#saveBtn').on('click', function(e) {
				e.preventDefault();
				var flag = $('#file').val();
				var title = $('input[name=document_title]').val();
				var form = $('#infoForm');
				form.attr('action','modify');
				
				if(title.length<=0){
					alert('제목을 적어주세요');
					return;
				}
				
				if(title.length>30){
					alert('제목은 30자 미만으로 해주세요');
					return;
				}
				
				if(flag==''){
				if($('#originalName').val().length <=0){
					alert('첨부파일은 필수 입니다.')
					return;
				}
				}
				
				form.submit();
			});

		
		$('#delete').on('click',function(){
			event.preventDefault();
			var bool = confirm('첨부파일을 삭제 하시겠습니까?');
			if(bool){
			var dno = ${document.document_no}
			
				$.ajax({
					url:"attachDelete",
					type : "post",
					data: JSON.stringify(dno),
					contentType: "application/json; charset=utf-8;",
		            dataType: "json",
				
				})
				alert('첨부파일을 삭제했습니다.')
				$('#originalName').attr('value','');
				$('#originalName').attr('style','display:none;');
				$('#delete').attr('style','display:none;');
			}	
		});
		
	</script>
</body>
</html>
<%@ include file="documentNote_js.jsp" %>