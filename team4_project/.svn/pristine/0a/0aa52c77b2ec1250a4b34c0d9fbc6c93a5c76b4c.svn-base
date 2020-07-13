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
	<form id="infoForm" action="list" method="post">
	<c:set var="check" value="${consult.consult_status }"/>
	<div style="width: 100%;">
	<table class="board_view">
		<colgroup>
			<col width="15%"/>
			<col width="35%"/>
			<col width="15%"/>
			<col width="35%"/>
		</colgroup>
		<caption style="font-size: 3.0em;">질문게시판</caption>

		<caption style="text-align:right;">
			<c:if test="${check == 1 || check == 2}">
			<a href="#this" class="btns" id="updateBtn">답변 수정하기</a>
			</c:if>
			<a href="#this" class="btns" id="list">목록으로</a>
		</caption>
		<tbody>
			<tr>
				<th scope="row">제목</th>
				<td colspan="3">${consult.consult_title }</td>
			</tr>
			<tr>
				<th scope="row">작성자</th>
				<td>${consult.consult_writer }</td>
				<th scope="row">작성시간</th>
				<td><fmt:formatDate value="${consult.consult_regdate}" pattern="yyyy-MM-dd - hh:mm:ss"/></td>
			</tr>
			<tr>
				<td colspan="4">
					<div class="form-group">
						<div class="col-xs-12  g_value" style="min-height: 250px; padding: 8px 3px 3px; margin: 0px; overflow: auto;">
					  		<p>${consult.consult_content}<br></p>
						</div>
					</div>
				</td>
			</tr>
		</tbody>
	</table>
	</div>
		
		<c:if test="${check == 0 }">
		<div style="width: 100%;">
		<table class="board_view">
		<colgroup>
			<col width="15%"/>
			<col width="35%"/>
			<col width="15%"/>
			<col width="35%"/>
		</colgroup>
		<caption style="1.5em; font-weight:bold;">답글<button  id="saveBtn" class="btns" style="float: right; ">저장</button></caption>
			 <tr>
			</tr>
		</table>
		<div style="color:black;">
			<textarea id="content" name="consult_answer_content"></textarea>
		</div>
		</div>
		</c:if>
		
		<!-- 답글 수정을 위한 부분  -->
		<div id="updatediv" style="width: 100%; display:none;">
		<table class="board_view">
		<colgroup>
			<col width="15%"/>
			<col width="35%"/>
			<col width="15%"/>
			<col width="35%"/>
		</colgroup>
		<caption style="1.5em; font-weight:bold;">답글<button  id="saveBtn" class="btns" style="float: right; ">저장</button></caption>
			 <tr>
			</tr>
		</table>
		<div style="color:black;">
			<textarea id="content" name="consult_answer_content"></textarea>
		</div>
		</div>
		
        <c:if test="${check == 1 }">
		<table id="answerTable" class="board_view">
			<colgroup>
			<col width="15%"/>
			<col width="35%"/>
			<col width="15%"/>
			<col width="35%"/>
		</colgroup>
		<tr>
			<th scope="row">답변자</th>
			<td>${consult.consult_answer }</td>
			<th scope="row">답변시간</th>
			<td><fmt:formatDate value="${consult.consult_answer_date}" pattern="yyyy-MM-dd - hh:mm:ss"/></td>
		</tr>
		</table>
			<div id="answerdiv" class="form-group">
				<div class="col-xs-12  g_value" style="min-height: 250px; padding: 8px 3px 3px; margin: 0px; overflow: auto;">
			  		<p>${consult.consult_answer_content}<br></p>
				</div>
			</div>
		</c:if>
		<input type='hidden' name="consult_answer" value="admin" />
		<input type='hidden' name="consult_no" value="${consult.consult_no}" />
		<input type='hidden' name="page" value="${pageMaker.page}" />
		<input type='hidden' name="perPageNum" value="${pageMaker.perPageNum}"/>
		<input type='hidden' name="searchType" value="${pageMaker.searchType }" />
		<input type='hidden' name="keyword" value="${pageMaker.keyword }" />
	</form>
	<script type="text/javascript">
	
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
		
			$('#updateBtn').on('click',function(e){
			
				$('#answerdiv').attr('style','display:none;')
				$('#answerTable').attr('style','display:none;')
				$('#updatediv').attr('style','display:"";')
				$(this).attr('style','display:none;')
			});
			
		});
		
	</script>
</body>
</html>
<%@ include file="/WEB-INF/views/board/qna/qnanote_js.jsp" %>