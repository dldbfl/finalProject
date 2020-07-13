<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
	<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
	<link href="<%=request.getContextPath() %>/resources/css/list/listCSS.css" rel="stylesheet">
	
	
	<title>QnA</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<!-- Le fav and touch icons -->
	<link rel="apple-touch-icon" sizes="114x114" href="apple-touch-icon-114x114.png" />
	<!-- <link rel="icon" type="images/svg+xml" href="images/logo.svg" /> -->
	
	<!-- JQuery 3.4.1 -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	
	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script src="/resources/js/message/message.js"></script>
	
	<script src="/resources/scripts/common.js"></script>
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>

<style>
	body{
		width: 356px;
		height: 520px;
	}
	table{
		border-collapse:separate ;
		
	}

	#writeBtn{
		width : 100px; 
	}
	
	.form-group{
		margin-top : 20px;	
	
	}
	.container-dashboard {
		padding: 0px;	
	}
	#pageO{
		text-align: center;
	}
	.page-link{
		height: 34px;
	}
	
	
	/* .title{
		border : 1px solid red;
	}
	.menu{
		border : 1px solid blue;
	} */
	.dropbtn{
		/* float: left; */
    	margin-top: -3%;
	}
	.registbtn{
		float: right;
	    margin-top: 10px;
	}
	/* .listbody{
		border : 1px solid black;
	} */ 
	.
</style>



<body class="blur-theme data-container-body">
			
			<div class="container-dashboard" style="background-color: white;">
				<div class="container-dashboard-inner">
				<form id="infoForm" class="form-inline">
						<input name="page" type="hidden" value="${pageMaker.cri.page }">
						<input name="perPageNum" type="hidden" value="${pageMaker.cri.perPageNum }">
						<input type='hidden' name="member_id" value="${member_id }" />						
						<input type='hidden' name="professor_id" value="${professor_id }" />
				<div class="clearfix">
				
					<div class="title">
						<div class="pull-left">
							<h2>&nbsp;Q&A</h2>
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
					
				</div>
				
				<div class="menu">
					<div class="dropbtn">
						<div class="btn-group">
							<a data-toggle="dropdown" id="drop" href="#" class="btn mini all"><span id="drop">내 게시글 보기</span><i class="fa fa-angle-down "></i>
								</a>
								<ul class="dropdown-menu">
									<li><a href="#" onclick="meList()"  id="me">내 게시글</a></li>
									<li><a href="#" onclick="allList()"  id="all">전체 게시글</a></li>
								</ul>
						</div>
						<div class="registbtn">
							<div class="pull-right"> 
								<button id="write" class="form-control" type="button"
									style="padding-right: 5px; color: royalblue;">${professor_id} 교수님께 질문하기</button>
							</div>
						</div>
					</div>				
				</div>				
			</form>		
			
				<div class="listbody">	
					<div class="table-responsive">
						<table class="table table-striped">
							<tbody>
							<c:if test="${not empty qna }" >
							 <c:forEach items="${qna}" var="qna">
								<tr>
									<%-- <td class="text-center" style="width: 7%;">${qna.qna_no }</td> --%>
									<td class="text-center" style="width: 50%;"><a style="color: black; cursor: pointer" onclick="promp('${qna.qna_no}','${qna.qna_type }','${qna.qna_password }')">${qna.qna_title}</a></td>
									<td class="text-center" style="width: 15%;">${qna.qna_writer}</td>
									<%-- <td style="width: 10%;">
										<i class="glyphicon glyphicon-time" aria-hidden="true"><fmt:formatDate value="${qna.qna_regdate}" pattern="yyyy-MM-dd"/></i>
									</td> --%>
									<c:set var="lock" value="${qna.qna_type }" />
									<c:if test="${lock eq '일반글' }">
									<td class="text-center" style="width: 4%;"><span style="color:green;">공개글</span></td>
									</c:if>
									<c:if test="${lock eq '비밀글' }">
									<td class="text-center" style="width: 4%;"><span style="color:red;">비밀글</span></td>
									</c:if>	
									<c:set var="answer" value="${qna.qna_status }" />
									<c:if test="${answer eq 1 }">
									<td class="text-center" style="width: 4%;"><span style="color:blue;">답변완료</span></td>
									</c:if>
									<c:if test="${answer eq 0 }">
									<td class="text-center" style="width: 4%;"><span style="color:red;">답변대기</span></td>
									</c:if>								
								</tr>			
								</c:forEach>	
								</c:if>
							</tbody>
						</table>
					</div>
				</div>
				
					<div class="pagebtn">
					  <nav id="pageO" aria-label="member list Navigation"  style="position: relative;">
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
				</div>
				
			</div>
		</div>
	<form id="jobForm">
	<input type='hidden' name="page" value="${pageMaker.cri.page}" />
	<input type='hidden' name="perPageNum" value="${pageMaker.cri.perPageNum}"/>
	<input type='hidden' name="searchType" value="${pageMaker.cri.searchType }" />
	<input type='hidden' name="keyword" value="${pageMaker.cri.keyword }" />
	<input type='hidden' name="member_id" value="${member_id }" />			
	<input type='hidden' name="professor_id" value="${professor_id }" />
	</form>
</body>
<%-- <%@ include file="/WEB-INF/views/board/qna/qna.js.jsp" %> --%>
     

<script>
var paging = $('[name=page]').val();
var perPageNum = 5;
var searchType = $('[name="searchType"]').val();
var keyword = $('[name=keyword]').val();
var member_id = $('[name=member_id]').val();
var professor_id = $('[name=professor_id]').val();

//검색란에서 입력시
function enterkey(page,flag){
	if (window.event.keyCode == 13) {
		 
		var jobForm=$('#infoForm');
		jobForm.attr("method","post");
		if(flag ==''){
			jobForm.attr("action","qnalist")
		}
		
		if(flag == '내글'){
			jobForm.attr("action","melist")
			
		}
		jobForm.submit();
		flag==''
   }

}
//버튼 클릭 및 페이지 이동 버튼
function searchList_go(page,flag){
	var jobForm=$('#jobForm');
	jobForm.find("[name='page']").val(page);
	jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
	jobForm.find("[name='keyword']").val($('input[name="keyword"]').val());	
	jobForm.attr("method","post");
	if(flag ==''){
		
		jobForm.attr("action","qnalist");
	}
	
	if(flag == '내글'){
		jobForm.attr("action","melist");
		
	}
	jobForm.submit();
	flag==''
}

//내 등록글 조회
var meList = function() {
	/* alert(member_id); */
	/* $('#status').attr('') */
	location.href="qnalist?page="+paging+"&perPageNum="+perPageNum+"&searchType=w&keyword="+member_id+"&member_id="+member_id+"&professor_id="+professor_id;
}

//전체조회
var allList = function () {
	location.href="qnalist?page="+paging+"&perPageNum="+perPageNum+"&searchType="+searchType+"&keyword=&member_id="+member_id+"&professor_id="+professor_id;


}
//등록 폼 여는 버튼
$('#write').on('click', function() {
	var form = $('#infoForm');
	form.attr("action","registForm");
	form.submit();
});

function promp(qno,type){
	
	if(type == '비밀글'){
		var form = $('#infoForm');
		form.attr("action","checkForm");
		form.attr("method", "Post");
		form.append($('<input/>', {type: 'hidden', name: 'qna_no', value:qno }));
		/* form.append($('<input/>', {type: 'text', name: 'professor_id', value: '${professor_id}' })); */
		form.submit();
		
		
				
	}else{
		var form = $('#infoForm');
		form.attr("action","detail");
		form.attr("method", "Post");
		form.append($('<input/>', {type: 'hidden', name: 'qna_no', value:qno }));
		/* form.append($('<input/>', {type: 'text', name: 'professor_id', value: '${professor_id}' }));*/
		form.submit();
	}
}
</script>




