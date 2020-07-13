<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<head>
	<link href="<%=request.getContextPath() %>/resources/css/qna/detail.css" rel="stylesheet">

<style>
.btn-default{
	color:black;
}
section#main-container {
    height: auto;
  	margin-top: 50px;
    min-height: 663px;
    font-size: 1.4em;
}

.hover3:hover {
	box-shadow: 0 80px 0 0 rgba(0, 0, 0, 0.25) inset, 0 -80px 0 0
		rgba(0, 0, 0, 0.25) inset;
}
</style>	
</head>

<body>

	<h3>상담문의 내용</h3>

	<div align="right" style="margin-bottom: 10px;">
	<c:if test="${loginUser.member_id==consult.consult_writer}">
		<button id="modify" name="modify" class="btn btn-info hover3" style="width: 80px;">수정</button>&nbsp;&nbsp;
	</c:if>	
		<button id="back" name="back" class="btn btn-danger hover3" style="width: 80px;">목록</button>
	</div>


	<form id="infoForm" action=modify method="post">
	<c:set var="check" value="${consult.consult_answer_content }"/>
	
	<div style="width: 100%;">
	
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
		
	<%-- 	<c:if test="${empty check}">
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
			<textarea id="consult_content" name="consult_answer_content"></textarea>
		</div>
		</div>
		</c:if> --%>
		
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
			<textarea id="consult_answer_content" name="consult_answer_content"></textarea>
		</div>
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
			<td>${consult.consult_writer }</td>
			<th scope="row">답변시간</th>
			<td><fmt:formatDate value="${consult.consult_regdate}" pattern="yyyy-MM-dd - hh:mm:ss"/></td>
		</tr>
		</table>
			<div id="answerdiv" class="form-group">
				<div class="col-xs-12  g_value" style="min-height: 250px; padding: 8px 3px 3px; margin: 0px; overflow: auto;">
			  		<p>${consult.consult_answer_content}<br></p>
				</div>
			</div>
		</c:if>
	<input type='hidden' name="consult_answer" value="${consult.consult_answer}" />
	<input type='hidden' name="consult_no" value="${consult.consult_no}" />
	<input type='hidden' name="consult_pwd" value="${consult.consult_pwd}" />
	
	</form>

<%@ include file="consultDetail_js.jsp" %>
<%@ include file="consultNote_js.jsp" %>
</body>