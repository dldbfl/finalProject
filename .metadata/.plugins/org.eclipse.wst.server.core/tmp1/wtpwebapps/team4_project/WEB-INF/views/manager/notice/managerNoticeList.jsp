<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
		table{
		border-collapse:separate ;
		
		}
	
		#writeBtn{
			width : 90px; 
			background: #C7C4FF;
			font-weight: bold;
			font-size: 15px;
			
			
		}
		
		.form-group{
			margin-top : 20px;	
			padding: 3px;
		
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
			
				<div class="container-dashboard-inner">
				
					<form class="form-inline" id="searchForm">
						<div class="clearfix">
							<div class="pull-left">
								<div class="titlecover">
									<div class="titleimage1"></div>
									<div class="titlemessage">
										<h3>&nbsp;공지사항 관리</h3>
									</div>
								</div>
							</div>	
							
							<div class="pull-right" id="keyword">
								<div class="form-group">
								
								<select class="form-control" name="searchType" id="searchType">
									<option value="tcw" ${pageMaker.cri.searchType eq 'tcw' ? 'selected':'' }>전 체</option>
									<option value="t" ${pageMaker.cri.searchType eq 't' ? 'selected':'' }>제 목</option>
									<option value="w" ${pageMaker.cri.searchType eq 'w' ? 'selected':'' }>작성자</option>
									<option value="c" ${pageMaker.cri.searchType eq 'c' ? 'selected':'' }>내 용</option>
									<option value="tc" ${pageMaker.cri.searchType eq 'tc' ? 'selected':'' }>제목+내용</option>
									<option value="cw" ${pageMaker.cri.searchType eq 'cw' ? 'selected':'' }>작성자+내용</option>
								</select>	
								
									<input type="text" class="form-control" placeholder="검색어를 입력해주세요" id="keyword" name="keyword" value="${pageMaker.cri.keyword }">
									<i class="fa fa-search search-box" aria-hidden="true" id="searchBtn" style="cursor:pointer;"></i>
								</div>
							</div>
							
							
							<div class="pull-right">
								<div class="form-group">
								<c:if test="${loginUser.member_authority=='ADMIN'}">
								<button id="writeBtn" class="btn btn-block" type="button" onclick="goSubmit()">작성</button>
								</c:if>
								</div>
							</div>
						</div>
					</form>
								
								
				<div class="table-responsive">
					<table class="table table-striped">
						<thead id="trtr">
							<tr >
								<th class="text-center">번호</th>
								<th class="text-center">제목</th>
								<th class="text-center">작성자</th>
								<th class="text-center">날짜</th>
								<th class="text-center">조회수</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${point}" var="point" varStatus="status" begin="0" end="4">
							<tr>
								<td class="text-center" style="color:red;"><img src="<%=request.getContextPath() %>/resources/images/important1.png"></td>
								<td class="text-center" >
								<a style="font-weight: bold; color: blue; " href="<%=request.getContextPath() %>/manager/detail?notice_no=${point.notice_no }">${point.notice_title}</a>
								</td>
								<td class="text-center"  >
									<a href="#">
									<strong>
									${point.notice_writer}
									</strong>
									</a>
								</td>
								<td style="color:red;text-align: center;">
									<a href="#"><fmt:formatDate value="${point.notice_regdate}" pattern="yy-MM-dd"/></a>
								</td>
								<td class="text-center" style="color:red;">
									<a href="#"><i class="text-center" aria-hidden="true">${point.notice_viewcnt}</i></a>
								</td>
							</tr>
							</c:forEach>					
						
						 <c:forEach items="${noticeList}" var="notice">
						   
							<tr>
								<td class="text-center">${notice.notice_no }</td>
								<td class="text-center">
								<a  style="color: black;"href="<%=request.getContextPath() %>/manager/detail?notice_no=${notice.notice_no }">${notice.notice_title}</a>
								</td>
								<td class="text-center">
									<a href="#">
									<strong>
									${notice.notice_writer}
									</strong>
									</a>
								</td>
								<td class="text-center">
									<a href="#"><fmt:formatDate value="${notice.notice_regdate}" pattern="yy-MM-dd"/></a>
								</td>
								<td class="text-center">
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

<%@ include file="/WEB-INF/views/manager/notice/noticeBoardList_js.jsp" %>

</body>

     
<!-- <script>

$("#searchBtn").on("click", function(){
	var searchForm = $('#searchForm');
	searchForm.find("[name=keyword]").val($('input[name="keyword"]').val());
	
	
	searchForm.attr("action","list").attr("method", "get");
	searchForm.submit();
	
	
	
});

</script> -->





