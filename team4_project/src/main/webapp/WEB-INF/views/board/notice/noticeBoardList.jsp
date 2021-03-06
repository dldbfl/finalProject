<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
table {
	border-collapse: separate;
}

#writeBtn {
	width: 100px;1
}

.form-group {
	margin-top: 20px;
}

section#main-container {
	margin-top: 100px;
}

.table>tbody>tr>td {
	padding: 15px;
}


.hover3:hover {
	box-shadow: 0 80px 0 0 rgba(0, 0, 0, 0.25) inset, 0 -80px 0 0
		rgba(0, 0, 0, 0.25) inset;
}

section#main-container {
    height: auto;
    margin-top: 19px;
    min-height: 663px;
    font-size: 1.4em;
}
</style>

<body class="blur-theme data-container-body">
<br>
			 <h2>공지사항</h2>
				<div class="container-dashboard-inner">
				
				
					<form class="form-inline" id="searchForm">
					
						<div class="clearfix">
							<div class="pull-right">
								<div class="form-group">
								<c:if test="${loginUser.member_authority=='ADMIN'}">
								<button style="font-size: 1.4em;height: 53px;margin-left: 5px;" id="writeBtn" class="btn btn-success flex-item btn-primary active btn-block hover3" type="button" onclick="goSubmit()">작성</button>
								</c:if>
								</div>
							</div>
							
							<div class="pull-right" id="keyword">
								<div class="form-group">
								
								<select class="form-control" name="searchType" id="searchType" style="font-size: 1.4em;height: 53px;">
									<option value="tcw" ${pageMaker.cri.searchType eq 'tcw' ? 'selected':'' }>전 체</option>
									<option value="t" ${pageMaker.cri.searchType eq 't' ? 'selected':'' }>제 목</option>
									<option value="w" ${pageMaker.cri.searchType eq 'w' ? 'selected':'' }>작성자</option>
									<option value="c" ${pageMaker.cri.searchType eq 'c' ? 'selected':'' }>내 용</option>
									<option value="tc" ${pageMaker.cri.searchType eq 'tc' ? 'selected':'' }>제목+내용</option>
									<option value="cw" ${pageMaker.cri.searchType eq 'cw' ? 'selected':'' }>작성자+내용</option>
								</select>	
								
									<input style="font-size: 1.4em;height: 53px;" type="text" class="form-control" placeholder="검색어를 입력해주세요" id="keyword" name="keyword" value="${pageMaker.cri.keyword }">
									<button id="searchBtn" class="form-control hover3" type="button"
							style="font-size: 1.4em;height: 53px;color: white; background-color: #6b6b6b; border: #6b6b6b" onclick="searchList_go(${pageMaker.cri.page},'${flag }')">검 색</button>
								</div>
							</div>
						</div>
					</form>
								
								
				<div class="table-responsive">
					<table class="table table-striped" style="margin-bottom: 0px;">
						<thead id="trtr">
							<tr >
								<th class="text-center" style="width: 100px; height: 56px; padding: 0px;">번호</th>
								<th class="text-center" style="width: 640px; height: 56px; padding: 0px;">제목</th>
								<th class="text-center" style="width: 135px; height: 56px; padding: 0px;">작성자</th>
								<th class="text-center" style="width: 200px; height: 56px; padding: 0px;">날짜</th>
								<th class="text-center" style="width: auto; height: 56px; padding: 0px;">조회수</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${point}" var="point" varStatus="status" begin="0" end="2">
							<tr>
								<td class="text-center" style="color:red;width: auto;"><img src="<%=request.getContextPath() %>/resources/images/important1.png"></td>
								<td class="text-center" style="width: auto;" >
								<a style="width: 400px;text-overflow: ellipsis;overflow: hidden; display: inline-block;white-space: nowrap;font-weight: bold; color: blue; " href="<%=request.getContextPath() %>/board/notice/detail?notice_no=${point.notice_no }">${point.notice_title}</a>
								</td>
								<td class="text-center" style="width: 135px;" >
									<a href="#">
									<strong>
									${point.notice_writer}
									</strong>
									</a>
								</td>
								<td style="color:black;text-align: center;width: 200px;">
									<fmt:formatDate value="${point.notice_regdate}" pattern="yyyy-MM-dd"/>
								</td>
								<td class="text-center" style="color:red;width: auto;">
									<a href="#"><i class="text-center" aria-hidden="true">${point.notice_viewcnt}</i></a>
								</td>
							</tr>
							</c:forEach>					
							</tbody>
					</table>
						
						
						
						
						
						
							<table class="table table-striped">
							
							<tbody>
						 <c:forEach items="${noticeList}" var="notice">
						   
							<tr>
								<td class="text-center" style="width: 100px; height: 56px;">${notice.notice_no }</td>
								<td class="text-center" style="width: 640px; height: 56px;">
								<a  style="width: 400px;text-overflow: ellipsis;overflow: hidden; display: inline-block;white-space: nowrap;color: black;"href="<%=request.getContextPath() %>/board/notice/detail?notice_no=${notice.notice_no }">${notice.notice_title}</a>
								</td>
								<td class="text-center" style="width: 135px; height: 56px;">
									<a href="#">
									<strong>
									${notice.notice_writer}
									</strong>
									</a>
								</td>
								<td class="text-center" style="width: 200px; height: 56px;">
									<a href="#"><fmt:formatDate value="${notice.notice_regdate}" pattern="yyyy-MM-dd"/></a>
								</td>
								<td class="text-center" style="width: auto;">
									<a href="#"><i class="text-center" aria-hidden="true">${notice.notice_viewcnt}</i></a>
								</td>
							</tr>
							</c:forEach>
							
						</tbody>
					</table>
				</div>
				
				
				<div>
					<%@ include file="/WEB-INF/views/commons/pagination.jsp" %>
				</div>
			</div>
			
	<form id="jobForm">
		  <input type='hidden' name="page" value="${pageMaker.cri.page}" />
		  <input type='hidden' name="perPageNum" value="${pageMaker.cri.perPageNum}"/>
		  <input type='hidden' name="searchType" value="${pageMaker.cri.searchType }" />
		  <input type='hidden' name="keyword" value="${pageMaker.cri.keyword }" />
	</form>

<%@ include file="/WEB-INF/views/board/notice/noticeBoardList_js.jsp" %>

</body>

     
<!-- <script>

$("#searchBtn").on("click", function(){
	var searchForm = $('#searchForm');
	searchForm.find("[name=keyword]").val($('input[name="keyword"]').val());
	
	
	searchForm.attr("action","list").attr("method", "get");
	searchForm.submit();
	
	
	
});

</script> -->





