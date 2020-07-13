<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
	
	
	<%-- <link href="<%=request.getContextPath() %>/resources/css/list/listCSS.css" rel="stylesheet">
	 --%>
	
	<title>consult</title>
	<!-- FAVIICON -->
	<!-- <link rel="shortcut icon" href="favicon.ico">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	Le fav and touch icons
	<link rel="apple-touch-icon" sizes="114x114" href="apple-touch-icon-114x114.png" />
	<link rel="icon" type="images/svg+xml" href="images/logo.svg" />
 -->	
</head>

<style>
	table{
		border-collapse:separate ;
		
	}

	#writeBtn{
		width : 100px; 
	}
	
	.form-group{
		margin-top : 20px;	
	
	}
	.table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th {
		    padding: 15px 0px 10px 0px;
		    line-height: 1.42857143;
		    vertical-align: top;
		    border-top: 1px solid #ddd;
		    font-size: 18px;
		}
</style>



<body class="blur-theme data-container-body">
			
			<div class="container-dashboard" style="background-color: white;">
				<div class="container-dashboard-inner">
				<form id="infoForm" class="form-inline">
						<input name="page" type="hidden" value="${pageMaker.cri.page }">
						<input name="perPageNum" type="hidden" value="${pageMaker.cri.perPageNum }">
				<div class="clearfix">
					<div class="pull-left">
						<h2>&nbsp;관리자 - 상담문의 관리</h2>
					</div>	
					 <div class="pull-right" id="keyword">
						<div class="form-group">
						
						<select class="form-control" name="searchType" id="searchType">
							<option value="tcw" ${pageMaker.cri.searchType eq 'tcw' ? 'selected':'' }>전체</option>
							<option value="t" ${pageMaker.cri.searchType eq 't' ? 'selected':'' }>제 목</option>
							<option value="w" ${pageMaker.cri.searchType eq 'w' ? 'selected':'' }>작성자</option>
							<option value="tc" ${pageMaker.cri.searchType eq 'tc' ? 'selected':'' }>제목+내용</option>
						</select>	
						
							<input onkeyup="enterkey(${pageMaker.cri.page},'${flag}');" type="text" class="form-control" placeholder="검색어를 입력해주세요" id="keyword" name="keyword" value="${pageMaker.cri.keyword }">
							<i  class="fa fa-search search-box" aria-hidden="true" onclick="searchList_go(${pageMaker.cri.page},'${flag }')"  style="cursor:pointer;"></i>
						</div>
					</div>
				</div>
				<div class="btn-group">
						<a style="font-size: 20px" data-toggle="dropdown" href="#" class="btn mini all" aria-expanded="false">답변 등록 여부<i class="fa fa-angle-down "></i>
						</a>
						<ul class="dropdown-menu">
							<li><a href="#" onclick="allList()"  id="nonReg">전체</a></li>
							<li><a href="#" onclick="registAnswer()"  id="reg">답변완료</a></li>
							<li><a href="#" onclick="nonRegistAnswer()"  id="nonReg">답변대기</a></li>
						</ul>
				</div>
					<!-- <div class="pull-right"> 
						<button id="write" class="form-control" type="button"
							style="color: white; background-color: black;">&nbsp;&nbsp;&nbsp;작성</button>
					</div> -->
			</form>				
				<div class="table-responsive">
					<table class="table table-striped">
						<tbody>
						<c:if test="${not empty consult }" >
						 <c:forEach items="${consult}" var="consult">
							<tr>
								<td class="text-center" style="width: 7%;">${consult.consult_no }</td>
								<td class="text-center" style="width: 45%;"><a style="color: black; cursor: pointer" onclick="promp('${consult.consult_no}','${consult.consult_type }','${consult.consult_pwd }')">${consult.consult_title}</a></td>
								<td class="text-center" style="width: 15%;">${consult.consult_writer}</td>
								<td style="width: 10%;">
									<i class="glyphicon glyphicon-time" aria-hidden="true"><fmt:formatDate value="${consult.consult_regdate}" pattern="yyyy-MM-dd"/></i>
								</td>
								<td class="text-center" style="width: 4%;">${consult.consult_viewcnt}</td>
								<c:set var="answer" value="${consult.consult_status }" />
								<c:if test="${answer eq 1 }">
								<td class="text-center" style="width: 8%;"><span style="color:blue;">답변완료</span></td>
								</c:if>
								<c:if test="${answer eq 2}">
								<td class="text-center" style="width: 8%;"><span style="color:green;">답변읽음</span></td>
								</c:if>
								<c:if test="${answer eq 0 }">
								<td class="text-center" style="width: 8%;"><span style="color:red;">답변대기</span></td>
								</c:if>		
								<c:set var="lock" value="${consult.consult_type }" />
								<c:if test="${lock eq '일반글' }">
								<td class="text-center" style="width: 4%;    margin-top: -10px;"><img style="margin-top: -10px;" src="<%=request.getContextPath() %>/resources/images/unlock.png"></td>
								</c:if>
								<c:if test="${lock eq '비밀글' }">
								<td class="text-center" style="width: 4%;    margin-top: -10px;"><img style="margin-top: -10px;" src="<%=request.getContextPath() %>/resources/images/lock.png"></td>
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
<%@ include file="/WEB-INF/views/manager/consult/consultManagerList_js.jsp" %>
     







