<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
	<link href="<%=request.getContextPath() %>/resources/css/qna/detail.css" rel="stylesheet">

	<!-- JQuery 3.4.1 -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style>
.btn-default{
	color:black;
}
body{
		width: 345px;
    	height: 607px;
    	padding: 5px 10px 70px 10px;
	}
	
#detaildiv{
	font-size: 13px;
    height: 354px;
}
    
#answerTable,#answerdiv{
	font-size: 13px;
}
.btns{
    background-color: #6D6AB7;
    text-decoration: blink;

}




</style>	
</head>

<body>
	<form id="infoForm" action="qnalist" method="post">
	<c:set var="check" value="${qna.answer_content }"/>
	<div id="detaildiv" style=";">
	<div>
		<h2 style="float:left;">&nbsp;Q&A</h2>
		<label style="float:right; margin-top: 18px;">
			<c:if test="${member_id eq qna.qna_writer }">
				<a href="#this" class="btns" id="delete">삭제</a>
			</c:if>		
			<a href="#this" class="btns" id="list">목록으로</a>
		</label>
	</div>
	<table class="board_view">
		<colgroup>
			<col width="15%"/>
			<col width="35%"/>
			<col width="15%"/>
			<col width="35%"/>
		</colgroup>		
		<tbody>
			<tr>
				<th scope="row">제목</th>
				<td colspan="3">${qna.qna_title }</td>
			</tr>
			<tr>
				<th scope="row">작성자</th>
				<td>${qna.qna_writer }</td>
				<th scope="row">작성시간</th>
				<td><fmt:formatDate value="${qna.qna_regdate}" pattern="yyyy-MM-dd - hh:mm:ss"/></td>
			</tr>
			<tr>
				<td colspan="4">
					<div class="form-group">
						<div class="col-xs-12  g_value" style="min-height: 200px; padding: 8px 3px 3px; margin: 0px; overflow: auto;">
					  		<p>${qna.qna_content}<br></p>
						</div>
					</div>
				</td>
			</tr>
		</tbody>
	</table>
	</div>		
		
        <c:if test="${not empty check}">
		<table id="answerTable" class="board_view">
			<colgroup>
			<col width="15%"/>
			<col width="35%"/>
			<col width="15%"/>
			<col width="35%"/>
		</colgroup>
		<tr>
			<th scope="row">답변자</th>
			<td>${qna.qna_answer }</td>
			<th scope="row">답변시간</th>
			<td><fmt:formatDate value="${qna.qna_regdate}" pattern="yyyy-MM-dd - hh:mm:ss"/></td>
		</tr>
		</table>
			<div id="answerdiv" class="form-group">
				<div class="col-xs-12  g_value" style="min-height: 180px; padding: 8px 3px 3px; margin: 0px; overflow: auto;">
			  		<p>${qna.answer_content}<br></p>
				</div>
			</div>
		</c:if>
	<input type='hidden' name="qna_answer" value="${loginUser.member_id }" />
	<input type='hidden' name="qna_no" value="${qna.qna_no}" />
	<input type='hidden' name="page" value="${pageMaker.page}" />
	<input type='hidden' name="perPageNum" value="${pageMaker.perPageNum}"/>
	<input type='hidden' name="searchType" value="${pageMaker.searchType }" />
	<input type='hidden' name="keyword" value="${pageMaker.keyword }" />
	<input type='hidden' name="member_id" value="${member_id }"/>
	<input type='hidden' name="professor_id" value="${professor_id}" />
	</form>
	
	<script type="text/javascript">
	
	var qna_no = $('[name="qna_no"]').val();
	var member_id = $('[name="member_id"]').val();
	var professor_id = $('[name="professor_id"]').val();
	
	// 삭제 버튼
	$('#delete').on('click', function(e){
		location.href="delete?qna_no="+qna_no+"&member_id="+member_id+"&professor_id"+professor_id;
				
	});
	
	
	
	
	window.onload = function() {

	    setTimeout (function () {

	    scrollTo(0,0);

	    }, 100);

	}
		$(document).ready(function(){
			$("#list").on("click", function(e){ //목록으로 버튼
				e.preventDefault();
				var form = $('#infoForm');
				form.submit();
			});
			
			$('#saveBtn').on('click', function(e) {
				e.preventDefault();
				var form = $('#infoForm').attr('action','answer');
				form.submit();
			})
					
		});
		
	</script>
</body>
</html>
<%@ include file="videonote_js.jsp" %>