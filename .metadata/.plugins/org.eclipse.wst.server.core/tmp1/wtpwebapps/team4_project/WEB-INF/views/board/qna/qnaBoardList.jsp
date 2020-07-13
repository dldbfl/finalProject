<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
	<title>Q&A</title>
</head>

<style>
	table{
		border-collapse:separate ;
		
	}

	#writeBtn{
		width: 100px; 
	}
	
	.form-group{
		margin-top : 20px;	
	
	}
</style>



<body class="blur-theme data-container-body">
			
			<div class="container-dashboard" style="background-color: white;">
				<div class="container-dashboard-inner">
				<input type="hidden" id="member_id" value="${member.member_id }">
				<form id="infoForm"  method="post" class="form-inline" onkeydown="return captureReturnKey(event)" >
						<input name="page" type="hidden" value="${pageMaker.cri.page}">
						<input name="perPageNum" type="hidden" value="${pageMaker.cri.perPageNum }">
				<div class="clearfix">
					<div class="pull-left">
						<h2>&nbsp;Q&A</h2>
					</div>	
					 <div class="pull-right" id="keyword">
						<div class="form-group">
							<input type="hidden" name="xxxx" id="xxxx" value="xxxx" />
						<select class="form-control" name="searchType" id="searchType">
							<option value="tcw" ${pageMaker.cri.searchType eq 'tcw' ? 'selected':'' }>전체</option>
							<option value="t" ${pageMaker.cri.searchType eq 't' ? 'selected':'' }>제 목</option>
							<option value="w" ${pageMaker.cri.searchType eq 'w' ? 'selected':'' }>작성자</option>
							<option value="tc" ${pageMaker.cri.searchType eq 'tc' ? 'selected':'' }>제목+내용</option>
						</select>	
						
							<input type="hidden" name="xxxx" id="xxxx" value="xxxx" />
							<input onkeyup="enterkey(${pageMaker.cri.page},'${flag}')" type="text" class="form-control" placeholder="검색어를 입력해주세요" id="keyword" name="keyword" value="">
							 <input type="hidden" name="xxxx" id="xxxx" value="xxxx" />
							<i  class="fa fa-search search-box" aria-hidden="true" onclick="searchList_go(${pageMaker.cri.page},'${flag }')"  style="cursor:pointer;"></i>
						</div>
					</div>
				</div>
				<div class="btn-group">
						<a data-toggle="dropdown" id="drop" href="#" class="btn mini all"><span id="drop">답변 등록 여부</span><i class="fa fa-angle-down "></i>
						</a>
						<ul class="dropdown-menu">
							<li><a href="#" onclick="registAnswer()"  id="reg">등록</a></li>
							<li><a href="#" onclick="nonRegistAnswer()"  id="nonReg">미등록</a></li>
							<li><a href="#" onclick="allList()"  id="nonReg">전체</a></li>
						</ul>
				</div>
					<c:set var="member" value="${member.member_id }"/>
					<c:if test="${not empty member }">
					<div class="pull-right">
					<label id="noRule" style="color: red; display: none;">대상자가 아닙니다.</label>
						<button id="write" class="form-control" type="button"
							style="color: white; background-color: black;">&nbsp;&nbsp;&nbsp;작성</button>
							<input type="hidden" id="authority" value="${loginUser.member_authority }">
					</div>
					</c:if>
					<input type='hidden' name="page" value="${pageMaker.cri.page}" />
					<input type='hidden' name="perPageNum" value="${pageMaker.cri.perPageNum}"/>
					<input type='hidden' name="searchType" value="${pageMaker.cri.searchType }" />
					<input type='hidden' name="keyword" value="${pageMaker.cri.keyword }" />
			</form>				
				<div class="table-responsive">
					<table class="table table-striped">
						<tbody>
						<c:if test="${not empty qna }" >
						 <c:forEach items="${qna}" var="qna">
							<tr>
								<td class="text-center" style="width: 7%;">${qna.qna_no }</td>
								<td class="text-center" style="width: 50%;"><a style="color: black; cursor: pointer" href="#" onclick="promp('${qna.qna_no}','${qna.qna_type }','${qna.qna_writer }','${loginUser.member_authority }')">${qna.qna_title}</a>
								<td class="text-center" style="width: 15%;">${qna.qna_writer}</td>
								<td style="width: 10%;">
									<i class="glyphicon glyphicon-time" aria-hidden="true"><fmt:formatDate value="${qna.qna_regdate}" pattern="yyyy-MM-dd"/></i>
								</td>
								<td class="text-center" style="width: 4%;">${qna.qna_viewcnt}</td>
								<c:set var="answer" value="${qna.qna_status }" />
								<c:if test="${answer eq 1 }">
								<td class="text-center" style="width: 4%;"><span style="color:blue;">답변완료</span></td>
								</c:if>
								<c:if test="${answer eq 0 }">
								<td class="text-center" style="width: 4%;"><span style="color:red;">답변대기</span></td>
								</c:if>		
								<c:set var="lock" value="${qna.qna_type }" />
								<c:if test="${lock eq '일반글' }">
								<td class="text-center" style="width: 4%;"><img src="<%=request.getContextPath() %>/resources/images/unlock.png"></td>
								</c:if>
								<c:if test="${lock eq '비밀글' }">
								<td class="text-center" style="width: 4%;"><img src="<%=request.getContextPath() %>/resources/images/lock.png"></td>
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
<%@ include file="/WEB-INF/views/board/qna/qna.js.jsp" %>
     







