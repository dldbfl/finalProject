<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


	<title>Student List</title>
	<!-- FAVIICON -->
	<link rel="shortcut icon" href="favicon.ico">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<!-- Le fav and touch icons -->
	<link rel="apple-touch-icon" sizes="114x114" href="apple-touch-icon-114x114.png" />
	<link rel="icon" type="images/svg+xml" href="images/logo.svg" />
	
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
						<h2>&nbsp;관리자 - 수강생 목록</h2>
					</div>	
					 <div class="pull-right" id="keyword">
						<div class="form-group">
						
						<select class="form-control" name="searchType" id="searchType">
							<option value="c" ${pageMaker.cri.searchType eq 'c' ? 'selected':'' }>강좌명</option>
							<option value="n" ${pageMaker.cri.searchType eq 'n' ? 'selected':'' }>이 름</option>
						</select>	
						
							<input onkeyup="enterkey(${pageMaker.cri.page});" type="text" class="form-control" placeholder="검색어를 입력해주세요" id="keyword" name="keyword" value="${pageMaker.cri.keyword }">
							<i  class="fa fa-search search-box" aria-hidden="true" onclick="searchList_go(${pageMaker.cri.page})"  style="cursor:pointer;"></i>
						</div>
					</div>
				</div>				
					<!-- <div class="pull-right"> 
						<button id="write" class="form-control" type="button"
							style="color: white; background-color: black;">&nbsp;&nbsp;&nbsp;작성</button>
					</div> -->
			</form>				
				<div class="table-responsive">
					<table class="table table-striped">
						<tbody class="tableA">
						<c:if test="${not empty studentList }" >
							<tr>
								<td class="text-center" style="width:8%;">아이디</td>  
								<td class="text-center" style="width:12%;">이름</td>   
								<td class="text-center" style="width:12%;">등록일자</td> 
								<td class="text-center" style="width:12%;">휴대폰 번호</td>  
								<td class="text-center" style="width:12%;">강좌명</td>   
								<td class="text-center" style="width:15%;">현재 출석률</td>
								<td class="text-center" style="width:15%;">총 출석률</td>
								<td class="text-center" style="width:10%;">상태</td>		
							</tr>    
						 <c:forEach var="studentList" items="${studentList }" varStatus="status">
							<tr>
									
								<td class="text-center" style="width: 5%;">
									<a href="#" onclick="OpenWindow('student_detail?student_id=${studentList.member_id }','','720','500');">${studentList.member_id }</a>
								</td>
								<td class="text-center" style="width: 7%;">${studentList.member_name }</td>
								
								<td style="width: 10%; text-align: center;">
									<fmt:formatDate value="${studentList.member_regdate}" pattern="yyyy-MM-dd"/>
								</td>
								
								<td class="text-center" style="width: 15%;">
									<a href="tel:${studentList.member_phone }">${studentList.member_phone }</a>
								</td>
								
								<td class="text-center" style="width: 4%;">${studentList.class_name }</td>
								
								<td class="text-center" style="width: 4%; padding-left: 1%; padding-right: 1%;">
									<div class="progress">
									  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${studentList.lecture_attend_percent }"
									  aria-valuemin="0" aria-valuemax="100" style="color:black; width:${studentList.lecture_attend_percent }%">
									    ${studentList.lecture_attend_percent }%
									  </div>
									</div>									
								</td>
								
								<td class="text-center" style="width: 4%; padding-left: 1%; padding-right: 1%;">
									<div class="progress">
									  <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="${studentList.lecture_attend_all_percent }"
									  aria-valuemin="0" aria-valuemax="100" style="color:black; width:${studentList.lecture_attend_all_percent }%">
									    ${studentList.lecture_attend_all_percent }%
									  </div>
									</div>	
								</td>
								
								
								
								<c:set var="status" value="${studentList.member_status }" />																
								<c:choose> 
								    <c:when test="${status eq '1'}">
								        <td class="text-center" style="width: 4%;"><span style="color:blue;">활성</span></td>
								    </c:when>								  
								    <c:otherwise>
								        <td class="text-center" style="width: 4%;"><span style="color:red;">탈퇴</span></td>
								    </c:otherwise>
								</c:choose>
									
							</tr>			
							</c:forEach>	
							</c:if>
						</tbody>
					</table>
				</div>
				  <nav id="pageO" aria-label="member list Navigation" class="col-xs-offset-5 col-xs-7" style="position: relative;">
					<ul class="pagination justify-content-center m-0">
						<li class="page-item">
							<a class="page-link" href="javascript:searchList_go(1);">
							<i class="glyphicon glyphicon-step-backward"></i>
							</a>
						</li>
						<li class="page-item">
							<a class="page-link" href="javascript:searchList_go(
							${pageMaker.prev ? pageMaker.startPage-1 : 1}				
							);"><i class="glyphicon glyphicon-chevron-left"></i></a>
						</li>
						<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="pageNum">						
						<li class="page-item 
							<c:out value="${pageMaker.cri.page == pageNum?'active':''}"/>">
							<a class="page-link" href="javascript:searchList_go(${pageNum});" >${pageNum }
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
								${pageMaker.realEndPage} );">
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
     
<script>
//버튼 클릭 및 페이지 이동 버튼
function searchList_go(page){
	var jobForm=$('#jobForm');
	jobForm.find("[name='page']").val(page);
	jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
	jobForm.find("[name='keyword']").val($('input[name="keyword"]').val());	
	jobForm.attr("method","get");
	jobForm.attr("action","student_list?page="+page+"&perPageNum="+perPageNum+"&searchType="+searchType+"&keyword="+keyword)
	
	jobForm.submit();
	
}

//검색란에서 입력시
function enterkey(page){
	if (window.event.keyCode == 13) {
		 
		var jobForm=$('#jobForm');
		jobForm.find("[name='page']").val(page);
		jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
		jobForm.find("[name='keyword']").val($('input[name="keyword"]').val());	
		jobForm.attr("method","get");
		
		jobForm.attr("action","student_list?page="+page+"&?perPageNum="+perPageNum+"&?searchType="+searchType+"&?keyword="+keyword)
		
		jobForm.submit();
		
   }

}
</script>







 