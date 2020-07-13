<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	

<style>

section#main-container {
    height: auto;
    margin-top: 19px;
    min-height: 663px;
    font-size: 1.4em;
}
table {
	border-collapse: separate;
}

#writeBtn {
	width: 100px;
}

.form-group {
	margin-top: 20px;
}

.container-dashboard {
    padding: 20px;
}
.table-responsive{
	margin-top: 5px;
}
td,th{
text-align: center;
}
.table>tbody>tr>td{
    padding: 10px;
}
.table>thead>tr>th{
	padding: 10px;
	background-color: #add1ff;
} 

.hover3:hover {
	box-shadow: 0 80px 0 0 rgba(0, 0, 0, 0.25) inset, 0 -80px 0 0
		rgba(0, 0, 0, 0.25) inset;
}
.col-xs-offset-5 {
    margin-left: 380px;
}
.btn{
font-size: 1.4em;
}
#searchType{
font-size: 1.4em;
height: 53px;
}
</style>



<body class="blur-theme data-container-body">
			
			<div class="container-dashboard" style="background-color: white;">
				<div class="container-dashboard-inner">
				<form id="infoForm" class="form-inline">
						<input name="page" type="hidden" value="${pageMaker.cri.page }">
						<input name="perPageNum" type="hidden" value="${pageMaker.cri.perPageNum }">
				 <h2>상담문의</h2><br>
				
				
				
				<div class="btn-group">
				
						<button id="" name="" class="btn btn-default hover3" type="button" onclick="allList()">전체</button>
						<button id="" name="" class="btn btn-default hover3" type="button" onclick="registAnswer()">답글</button>
						<button id="" name="" class="btn btn-default hover3" type="button" onclick="nonRegistAnswer()">미답글</button>
						
				</div>
				
					<div class="pull-right">
						<select class="form-control" name="searchType" id="searchType">
							<option value="tcw" ${pageMaker.cri.searchType eq 'tcw' ? 'selected':'' }>전체</option>
							<option value="t" ${pageMaker.cri.searchType eq 't' ? 'selected':'' }>제 목</option>
							<option value="w" ${pageMaker.cri.searchType eq 'w' ? 'selected':'' }>작성자</option>
							<option value="tc" ${pageMaker.cri.searchType eq 'tc' ? 'selected':'' }>제목+내용</option>
						</select>	
						<input style="font-size: 1.4em;height: 53px;" onkeyup="enterkey(${pageMaker.cri.page},'${flag}');" type="text" class="form-control" placeholder="검색어를 입력해주세요" id="keyword" name="keyword" value="${pageMaker.cri.keyword }"> 
						
						<button id="" class="form-control hover3" type="button"
							style="color: white; background-color: #6b6b6b; border: #6b6b6b; font-size: 1.4em; height: 53px;" onclick="searchList_go(${pageMaker.cri.page},'${flag }')">검 색</button>
						<button id="write" class="form-control pull-right hover3" type="button"
							style="color: white; background-color: #69a7fd; border: #69a7fd; margin-left: 5px;font-size: 1.4em; height: 53px;">작 성</button>
					</div>
					
			</form>				
				<div class="table-responsive">
					<table class="table table-striped">
					<thead id="trtr">
							<tr >
								<th style="width: auto;" class="">번호</th>
								<th style="width: auto;" class="">제목</th>
								<th style="width: auto;" class="">작성자</th>
								<th style="width: auto;" class="">날짜</th>
								<th style="width: auto;" class="">조회수</th>
								<th style="width: auto;" class="">답변상태</th>
								<th style="width: auto;" class="">비밀여부</th>
							</tr>
						</thead>
						<tbody>
						
							<c:forEach items="${point}" var="point" varStatus="status" begin="0" end="2">
							<tr>
								<td class="text-center" style="color:red;width: auto;"><img src="<%=request.getContextPath() %>/resources/images/important1.png"></td>
								
								<td class="text-center" style="width: auto;">
								<a style="width: 400px;text-overflow: ellipsis;overflow: hidden; display: inline-block;white-space: nowrap;font-weight: bold; color: blue; " href="<%=request.getContextPath() %>/board/notice/detail?notice_no=${point.notice_no }">${point.notice_title}</a>
								</td>
								
								<td class="text-center" style="width: auto;" >
									<a href="#">
									<strong>
									${point.notice_writer}
									</strong>
									</a>
								</td>
								
								<td style="color:black;text-align: center;width: auto;">
									<fmt:formatDate value="${point.notice_regdate}" pattern="yyyy-MM-dd"/>
								</td>
								
								<td class="text-center" style="color:red;width: auto;">
									<a href="#"><i class="text-center" aria-hidden="true">${point.notice_viewcnt}</i></a>
								</td>
								
								<td style="width: auto;">-</td>
								
								<td style="width: auto;">-</td>
								
							</tr>
							</c:forEach>	
						<c:if test="${not empty consult }" >
						 <c:forEach items="${consult}" var="consult">
							<tr>
								<td class="" style="width: auto">${consult.consult_no }</td>
								<td class="" style="width: auto"><a style="width: 400px;text-overflow: ellipsis; overflow: hidden; display: inline-block;white-space: nowrap;color: black; cursor: pointer" onclick="promp('${consult.consult_no}','${consult.consult_type }','${consult.consult_pwd }')">${consult.consult_title}</a></td>
								<td class="" style="width: auto">${consult.consult_writer}</td>
								<td class="" style="width: autofont-size: large;">
									<fmt:formatDate value="${consult.consult_regdate}" pattern="yyyy-MM-dd"/>
								</td>
								<td class="" style="width: auto">${consult.consult_viewcnt}</td>
								<c:set var="answer" value="${consult.consult_status }" />
								
								<c:if test="${answer eq 2 }">
								<td class="" style="width: auto"><span style="color:green;">답변읽음</span></td>
								</c:if>

								<c:if test="${answer eq 1 }">
								<td class="" style="width: auto"><span style="color:blue;">답변완료</span></td>
								</c:if>
								
								<c:if test="${answer eq 0 }">
								<td class="" style="width: auto"><span style="color:red;">답변대기</span></td>
								</c:if>	
								
									
								<c:set var="lock" value="${consult.consult_type }" />
								
								<c:if test="${lock eq '일반글' }">
								<td class="text-center" style="width: auto"><img src="<%=request.getContextPath() %>/resources/images/unlock1.png" style="background-repeat: no-repeat;background-position: center;width: 25px;"></td>
								</c:if>
								
								<c:if test="${lock eq '비밀글' }">
								<td class="text-center" style="width: auto"><img src="<%=request.getContextPath() %>/resources/images/lock1.png" style="background-repeat: no-repeat;background-position: center;width: 25px;"></td>
								</c:if>		
																
							</tr>			
							</c:forEach>	
							</c:if>
						</tbody>
					</table>
				</div>
				  <nav id="pageO" aria-label="member list Navigation" class="col-xs-offset-5 col-xs-7" style="position: relative;">
					<ul class="pagination justify-content-center m-0">
						<li class="page-item">
							<a class="page-link" href="javascript:searchList_go(1,'${flag }');">
							<i class="glyphicon glyphicon-step-backward"></i>
							</a>
						</li>
						<li class="page-item">
							<a class="page-link" href="javascript:searchList_go(
							${pageMaker.prev ? pageMaker.startPage-1 : 1}				
							,'${flag }');"><i class="glyphicon glyphicon-chevron-left"></i></a>
						</li>
						<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="pageNum">						
						<li class="page-item 
							<c:out value="${pageMaker.cri.page == pageNum?'active':''}"/>">
							<a class="page-link" href="javascript:searchList_go(${pageNum},'${flag }');" >${pageNum }
							</a>
						</li>
						</c:forEach>
						<li class="page-item">
							<a class="page-link" href="javascript:searchList_go(
							${pageMaker.next ? pageMaker.endPage+1 : pageMaker.cri.page},'${flag }'			
							);"><i class="glyphicon glyphicon-chevron-right" ></i></a>
						</li>
						<li class="page-item">
							<a class="page-link" href="javascript:searchList_go(
								${pageMaker.realEndPage},'${flag }' );">
								<i class="glyphicon glyphicon-step-forward"></i></a>
						</li>	
					</ul>
				</nav>
				<div>
				</div>
			</div>
		</div>
	<form id="jobForm">
	<input type='hidden' name="page" value="${pageMaker.cri.page}" />
	<input type='hidden' name="perPageNum" value="${pageMaker.cri.perPageNum}"/>
	<input type='hidden' name="searchType" value="${pageMaker.cri.searchType }" />
	<input type='hidden' name="keyword" value="${pageMaker.cri.keyword }" />
	</form>
</body>
<%@ include file="/WEB-INF/views/board/consult/consultBoardList_js.jsp" %>
     







