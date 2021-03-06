<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
	<link href="<%=request.getContextPath() %>/resources/css/qna/detail.css" rel="stylesheet">
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/filedownload/jquery.fileDownload.js"></script>
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
		<caption style="font-size: 3.0em; margin-top:10px;">문서자료</caption>

		<caption style="text-align:right;">
			<c:set value="${loginUser.member_id }" var="member"/>
			<c:if test="${document.document_writer eq member }">
			<a href="#" class="btns" id="updateBtn">수정</a>
			<a href="#" class="btns" id="deleteBtn">삭제</a>
			</c:if>
			<a href="#" onclick="toList();" class="btns" >목록으로</a>
		</caption>
		<tbody>
			<tr>
				<th scope="row">제목</th>
				<td colspan="3" ><input name="document_title" style="border: none; width: 100%;" readonly="readonly" value="${document.document_title }">
					<input type="hidden" name="document_no" value="${document.document_no }">
				</td>
			</tr>
			<tr>
				<th scope="row">첨부 파일</th>
					<td colspan="3">
						<div class="custom-file-upload">
							<input name ="originalName" id="originalName"style="border: none; width: 95%;" value="${document.originalName }" readonly="readonly"/>
							<button id="download" style="background-color: #6b9ab8; color: white; border: 2px solid #6b9ab8" >다운로드</button>
				    	</div>
			    	</td>		
				</tr>
			</tbody>
		</table>
		</div>	
			<div class="col-xs-12  g_value" style="min-height: 250px; padding: 8px 3px 3px; margin: 0px; overflow: auto;">
				<p>${document.document_content}<br></p>
			</div>
	</form>
			
	<form id="jobForm">
	<input type='hidden' name="page" value="${pageMaker.page}" />
	<input type='hidden' name="perPageNum" value="${pageMaker.perPageNum}"/>
	<input type='hidden' name="searchType" value="${pageMaker.searchType }" />
	<input type='hidden' name="keyword" value="${pageMaker.keyword }" />
	</form>
	<input type='hidden' id="fileName" value="${document.document_dataVO.document_data_filename }">
	<input type='hidden' id="filePath" value="${document.document_dataVO.document_data_path }">
	<script type="text/javascript">
	
	window.onload = function() {

	    setTimeout (function () {

	    scrollTo(0,0);

	    }, 100);

	}
	
	function toList(){
		var form = $('#infoForm');
		form.attr('action','list');
		form.submit();
	};	
	
	$('#updateBtn').on('click', function(e) {
		var form = $('#infoForm');
		form.attr('action','modifyForm');
		form.submit();
		});
		
	$('#download').on('click', function(e){
		var fileName = $('#fileName').val();
		var path = $('#filePath').val();
		var downloadName = $('#originalName').val();
		var file = { "fileName": fileName, "filePath": path, "downloadName":downloadName };

		$.fileDownload("<%=request.getContextPath()%>/pds/document/fileDownload", {
			httpMethod: "POST",
		    data: file,
			successCallback: function(res){
				console.log(res);
			},
			failCallback: function(error){
				console.log(error);
			}
		});

	})
	$('#deleteBtn').on('click',function(){
	var bool = confirm('자료를 삭제 하시겠습니까?');
	if(bool){
		var dno = $('#document_no').val();
		
	$.ajax({
		url : "<%=request.getContextPath()%>/pds/document/remove",
				 type : "post",
				 data: JSON.stringify(dno),
				 contentType: "application/json; charset=utf-8;",
           		 dataType: "json",
    			error:function(error){
    				console.log(error);
    			}
			});
   			alert("자료를  삭제했습니다");
   			location.reload();
	}
});
	
	
	</script>
</body>
</html>