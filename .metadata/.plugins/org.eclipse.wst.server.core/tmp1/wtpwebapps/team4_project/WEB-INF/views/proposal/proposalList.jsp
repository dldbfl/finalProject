<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
#writeBtn {
    width: 120px;
    margin-right: 15px;
}

th {
	background-color: #8ca2ff;
	padding: 0px;
	font-size: medium;
}

.table>thead>tr>th {
	padding: 10px 10px 10px 10px;
}

.table>tbody>tr>td {
	padding: 0px;
	padding-top: 50px;
}
section#main-container {
    height: auto;
    margin-top: 19px;
    min-height: 663px;
    font-size: 1.4em;
}

</style>



<body class="">
			<br>
			<h2>창업계획서</h2>
					
						<div class="clearfix">
							
								
								
								<div class="pull-right">
									<button id="writeBtn" class="btn btn-success flex-item btn-primary active btn-block" type="button" onclick="goSubmit()"style="font-size: 1.1em;">작성</button>
								</div>
					
						</div>
					<br>
			<div class="container-dashboard" style="background-color: white;">
				<div class="container-dashboard-inner">
				
				
					
								
							
				<div class="">
					<table class="propsoalTable table table-striped">
						<thead id="trtr">
							<tr >
								<th class="text-center">번호</th>
								<th class="text-center">창업명</th>
								<th class="text-center">날짜</th>
								<th class="text-center">변경</th>
							</tr>
						</thead>
						<c:forEach items="${proposal}" var="pro">
						<tbody>
							<tr height="120px">
								<td id="proposal_num" class="text-center" width="100px">${pro.proposal_num }</td>
								<td class="text-center" >
								<a  style="color: black;"href="<%=request.getContextPath() %>/myPage/proposal/detail?proposal_num=${pro.proposal_num }">${pro.proposal_title }</a>
								</td>
								<td class="table-text-status" width="150px">
									<a href="#"><i class="fa fa-pencil-square-o" aria-hidden="true"><fmt:formatDate value="${pro.proposal_regdate}" pattern="yyyy-MM-dd"/></i></a>
								</td>
								<td align="center" width="150px" style="padding: 15px;">
								<button id="modify" name="modify" type="button" class="btn btn-info flex-item btn-primary active btn-block" style="font-size: 1.1em;">수정</button><br>
								<button id="delete" name="delete" type="button" class="btn btn-danger flex-item btn-primary active btn-block"style="font-size: 1.1em;">삭제</button>
								</td>
							</tr>
						</tbody>
						</c:forEach>
					</table>
				</div>
				
				
				
			
			</div>
		</div>


<%@ include file="/WEB-INF/views/proposal/proposalList_js.jsp" %>
</body>

 