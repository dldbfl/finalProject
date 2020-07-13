<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/slider/sliderDisplay.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/slider/sliderOption.css" />
 <script src="<%=request.getContextPath() %>/resources/js/slider/jquery.slides.min.js"></script>
<style>
	.tableIntheText{
		font-size: 1.4em;
		
	}
	.tableIntheText a{
		text-decoration: none;
		
	}
	.tableIntheText a:hover{
		text-decoration: none;
		color: #ff434396;
	}
/* 	.tableIntheText:hover{
		background: #afffaf3b;
	}
 */	.thText{
		font-size: 1.6em;
	}
	.imageReview{
		width: 437px;
	    height: 224px;
	    float: left;
	    margin-left: 133px;
	    padding-right: 163px;
	    border-right: 4px ridge;
	}
	.contentText{
		overflow: auto;
   		padding: 0px 30px;
   		width: 50%;
   		height: 239px;
	}
	::-webkit-scrollbar{width: 16px;}
	::-webkit-scrollbar-track{background-color: #f7ffe9;}
	::-webkit-scrollbar-thumb{background-color: #555; border-radius: 10px;}
	::-webkit-scrollbar-button:start:decrement, ::webkit-scrollber-button:end:increment{width: 16px;height: 16px;background: #f1ef79;}
	
	.ReviewWrap{
		margin-top: 20px;
		background: #f7ffe9;
	}
	.noticeTr{
		background: orange;
	}
	.noticeTr td img{
		width: 30px;
	}
	.slidesjs-previous{
		position: absolute;
	    top: 339px;
	    z-index: 20;
	    
	}
	.slidesjs-next{
	    position: absolute;
	    top: 338px;
	    right: 294px;
	    z-index: 20;
	}
	.imageReview img {
		width: 114%;
	}
	.review_title{
		text-align: center;
	}
	
	
	
	
	.tooltipbox {
		position: relative;
		background: #208dd5;
		border: 4px solid #d3f4f5;
	}
	.tooltipbox:after, .tooltipbox:before {
		right: 100%;
		top: 50%;
		border: solid transparent;
		content: " ";
		height: 0;
		width: 0;
		position: absolute;
		pointer-events: none;
	}
	
	.tooltipbox:after {
		border-color: rgba(32, 141, 213, 0);
		border-right-color: #208dd5;
		border-width: 52px;
		margin-top: -52px;
	}
	.tooltipbox:before {
		border-color: rgba(211, 244, 245, 0);
		border-right-color: #d3f4f5;
		border-width: 58px;
		margin-top: -58px;
	}
	.h3Title{
		padding-left: 24px;
	}
	.hrLine{
		margin-left: 24px;
	    margin-right: 24px;
	}
	.worText{
		display: none;
		color: red;
	}
	.notLoginUserworText,.notAttendStatusText{
		display: none;
		color: red;
	}
	#slides img{
		cursor: pointer;
	}
</style>

<body class="blur-theme data-container-body">
	<div class="wrapBody">
		<div class="ReviewWrap">
		  <div id="slides">
			<div class="ReviewTtitle">
				<h3 class="h3Title">베스트 창업  후기</h3>
				<hr class="hrLine">
				<div class="imageReview bestImage1" onclick="ImageClickdetail(this)">
					<img src="#"/>
				</div>
				<input type="hidden" class="image1"> 
				<div class="contentText contentText1 scrollbars">
				</div>
			</div>
			<div class="ReviewTtitle ">
				<h3 class="h3Title">베스트 창업  후기</h3>
				<hr class="hrLine">
				<div class="imageReview bestImage2"  onclick="ImageClickdetail(this)">
					<img src="#"/>
				</div>
				<input type="hidden" class="image2">
				<div class="contentText contentText2 scrollbars">
				</div>
			</div>
			<div class="ReviewTtitle ">
				<h3 class="h3Title">베스트 창업  후기</h3>
				<hr class="hrLine">
				<div class="imageReview bestImage3"  onclick="ImageClickdetail(this)">
					<img src="#"/>
				</div>
				<input type="hidden" class="image3">
				<div class="contentText contentText3 scrollbars">
				</div>
			</div>
			<div class="ReviewTtitle ">
				<h3 class="h3Title">베스트 창업  후기</h3>
				<hr class="hrLine">
				<div class="imageReview bestImage4"  onclick="ImageClickdetail(this)">
					<img src="#"/>
				</div>
				<input type="hidden" class="image4">
				<div class="contentText contentText4 scrollbars">
				</div>
			</div>
			<div class="ReviewTtitle ">
				<h3 class="h3Title">베스트 창업  후기</h3>
				<hr class="hrLine">
				<div class="imageReview bestImage5"  onclick="ImageClickdetail(this)">
					<img src="#"/>
				</div>
				<input type="hidden" class="image5">
				<div class="contentText contentText5 scrollbars">
				</div>
			</div>
		  </div>
		</div>
		<div id="projectmaster" class="content">
			<div class="menu-search-block">
				<div class="clearfix">
					<div class="pull-left foundedListTitle">
						<h3>창업 후기</h3>
						<span>전체 게시글 수: ${pageMaker.totalCount} 건</span>
					</div>
				</div>
			</div>
			<div class="container-dashboard">
				<div class="container-dashboard-inner">
					<div class="">
						<form class="form-inline">
							<div class="clearfix">
								<div class="pull-left" id="keyword">
									<div class="form-group">
										<select class="form-control" name="searchType" id="searchType">
											<option value="tcw" ${pageMaker.cri.searchType eq 'tcw' ? 'selected':'' }>전 체</option>
											<option value="t" ${pageMaker.cri.searchType eq 't' ? 'selected':'' }>제 목</option>
											<option value="w" ${pageMaker.cri.searchType eq 'w' ? 'selected':'' }>작성자</option>
											<option value="c" ${pageMaker.cri.searchType eq 'c' ? 'selected':'' }>내 용</option>
											<option value="tc" ${pageMaker.cri.searchType eq 'tc' ? 'selected':'' }>제목+내용</option>
											<option value="cw" ${pageMaker.cri.searchType eq 'cw' ? 'selected':'' }>작성자+내용</option>
										</select>	
										<input type="text" class="form-control" data-toggle="tooltip" data-placement="top" title="검색어를 입력해주세요" id="keyword" name="keyword" value="${pageMaker.cri.keyword }">
										<i class="fa fa-search search-box fa-2x" aria-hidden="true" id="searchBtn" style="cursor:pointer;"></i>
									</div>
								</div>
								<div class="pull-right" id="regist">
									<span class="worText">수강생만 등록 가능합니다.</span>
									<span class="notLoginUserworText">로그인 후 사용 가능합니다.</span>
									<span class="notAttendStatusText">수강수료 후 작성 가능합니다.</span>
									<button type="button" class="btn btn-sm btn-primary"  onclick="foundedWrite();">
									<i class=""></i><b>작성</b>
									</button>
								</div>
							</div>
						</form>
						<div class="table-responsive">
						<table class="table table-striped">
							<thead>
								<tr class="thText">
									<th class="text-center">번호</th>
									<th class="text-center">제목</th>
									<th class="text-center">작성자</th>
									<th class="text-center">날짜</th>
									<th class="text-center">조회수</th>
								</tr>
								 <c:forEach items="${pointList }" var="noticePoint">
									<tr class="noticeTr">
										<td class="text-center" style="color:red;"><img src="<%=request.getContextPath() %>/resources/images/pointImg.png"></td>
										<td class="text-center">
										<a style="font-weight: bold; color: blue;" href="<%=request.getContextPath() %>/board/notice/detail?notice_no=${noticePoint.notice_no }">${noticePoint.notice_title}</a>
										</td>
										<td class="text-center table-text-status" >
											<a href="#"><span class="issue-text"></span>${noticePoint.notice_writer}</a>
										</td>
										<td class="text-center"  style="color:red;">
											<i class="fa fa-calendar" aria-hidden="true"></i>&nbsp;<fmt:formatDate value="${noticePoint.notice_regdate}" pattern="yyyy-MM-dd"/>
										</td>
										<td class="text-center" style="color:red;">
											<a href="#"><i class="text-center" aria-hidden="true">${noticePoint.notice_viewcnt}</i></a>
										</td>
									</tr>
								</c:forEach> 
								<c:forEach items="${foundedList}" var="foundedList">
									<tr class="tableIntheText">
										<td class="text-center">${foundedList.founded_review_no }</td>
										<td class="text-center"><a href="/board/foundedReview/detail?founded_review_no=${foundedList.founded_review_no }">${foundedList.founded_review_title }</a></td>
										<td class="text-center"><p class="profileTooltip" onclick="openTheProfile(this);" >${foundedList.founded_review_writer }</p></td>
										<td class="text-center"><i class="fa fa-calendar" aria-hidden="true">&nbsp;</i><fmt:formatDate  value="${foundedList.founded_review_regdate }"  pattern = "yyyy-MM-dd"/></td>
										<td class="text-center">${foundedList.founded_review_viewcnt }</td>
									</tr>
								</c:forEach>
							</thead>
							<tbody>
							</tbody>
						</table>
						</div>
						<div class="paginationWrap">
							<%@ include file="/WEB-INF/views/commons/pagination.jsp" %>
						</div>
						<form id="searchForm">
							<input type='hidden' name="page" value="${pageMaker.cri.page}" />
							<input type='hidden' name="perPageNum" 
								   value="${pageMaker.cri.perPageNum}"/>
							<input type='hidden' name="searchType" 
								   value="${pageMaker.cri.searchType }" />
							<input type='hidden' name="keyword" 
								   value="${pageMaker.cri.keyword }" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

<script>
	
	$(".foundedListTitle").val();

$(function () {
	  $('[data-toggle="tooltip"]').tooltip()
	})

//메인화면  이미지 슬라이드 작업
//https://slidesjs.com  옵션 기능 추가시 참조  
$(function() {
  $('#slides').slidesjs({
    width: 700,
    height: 200
    /* play: {
      active: true,
      auto: true,
      interval: 4000,
      swap: true
    } */
  });
});

function openTheProfile(obj){
	
	var writter =$(obj).text();

	var data ={"writter" : writter}
	
	$.ajax({
		url:"<%=request.getContextPath()%>/board/foundedReview/profile?writter="+writter,
		type:"post",
		data:JSON.stringify(data),
		success:function(suc){
			
		},
		error:function(err){
			alert("실패");
		}
	})
	
}

//창업후기 작성 버튼
function foundedWrite(){
	
	//수강생만 작성가능 기능
	if("${loginUser.member_authority}" == "PROFESSOR" || "${loginUser.member_authority}" == "ADMIN" ){
		$(".worText").show();
		setTimeout(function(){
			$(".worText").hide();
		},1000)
		return;
	}
	
	//로그인상태 여부 확인
	if("${loginUser.member_id}" == ""){
		$(".notLoginUserworText").show();
		setTimeout(function(){
			$(".notLoginUserworText").hide();
		},1000)
		return;
	}
	
	//출석률 80%이상일때 창업후기 작성 가능
<%-- 	var statusCnt='${attendStatusCnt}';
			
	var membe_id='${loginUser.member_id}';
	
	$.ajax({
		url:"<%=request.getContextPath()%>/board/foundedReview/attendCnt?member_id="+membe_id,
		type:"get",
		success:function(suc){
			if(suc<16){
				$(".notAttendStatusText").show();
				setTimeout(function(){
					$(".notAttendStatusText").hide();
				},2000)
				return;
			} 
			location.href='<%=request.getContextPath() %>/board/foundedReview/registForm'
		},
		error:function(err){
			alert("접근실패");
			return;
		}
	}) --%>
	location.href='<%=request.getContextPath() %>/board/foundedReview/registForm'
			 
}

 
$('#searchBtn').on('click',function(e){
	if($("#keyword").val() ==""){
			
		return;
	}
	var searchForm=$('#searchForm');
	searchForm.find("[name='page']").val(1);
	searchForm.find("[name='searchType']").val($('select[name="searchType"]').val());
	searchForm.find("[name='keyword']").val($('input[name="keyword"]').val());
	
	
	searchForm.attr("action","foundReviewList").attr("method","get");
	searchForm.submit(); 
});

function searchList_go(page){
	
	var searchForm=$('#searchForm');
	searchForm.find("[name='page']").val(page);
	searchForm.find("[name='searchType']").val($('select[name="searchType"]').val());
	searchForm.find("[name='keyword']").val($('input[name="keyword"]').val());
	searchForm.attr("action","foundReviewList").attr("method","get");
	
	searchForm.submit();
}



 $.ajax({
	url:"<%=request.getContextPath()%>/board/foundedReview/bestFoundedReview",
	type: "get",
	success:function(suc){
		console.log(suc);
		var imgeName1=suc.foundedImgList0[0].founded_review_img_name;
 		var imgeName2=suc.foundedImgList1[0].founded_review_img_name;
		var imgeName3=suc.foundedImgList2[0].founded_review_img_name;
		var imgeName4=suc.foundedImgList3[0].founded_review_img_name;
		var imgeName5=suc.foundedImgList4[0].founded_review_img_name; 
		$(".contentText1").append("<p class='review_title'>"+suc.foundedList[0].founded_review_title+"</p>")
		$(".contentText1").append(suc.foundedList[0].founded_review_content);
		
		$(".contentText2").append("<p class='review_title'>"+suc.foundedList[1].founded_review_title+"</p>")
		$(".contentText2").append(suc.foundedList[1].founded_review_content);
		
		$(".contentText3").append("<p class='review_title'>"+suc.foundedList[2].founded_review_title+"</p>")
		$(".contentText3").append(suc.foundedList[2].founded_review_content);
		
		$(".contentText4").append("<p class='review_title'>"+suc.foundedList[3].founded_review_title+"</p>")
		$(".contentText4").append(suc.foundedList[3].founded_review_content);
		
		$(".contentText5").append("<p class='review_title'>"+suc.foundedList[4].founded_review_title+"</p>")
		$(".contentText5").append(suc.foundedList[4].founded_review_content);
		
		$(".bestImage1 img").attr("src","<%=request.getContextPath()%>/board/foundedImge?fileName="+imgeName1)
 		$(".bestImage2 img").attr("src","<%=request.getContextPath()%>/board/foundedImge?fileName="+imgeName2)
		$(".bestImage3 img").attr("src","<%=request.getContextPath()%>/board/foundedImge?fileName="+imgeName3)
		$(".bestImage4 img").attr("src","<%=request.getContextPath()%>/board/foundedImge?fileName="+imgeName4)
		$(".bestImage5 img").attr("src","<%=request.getContextPath()%>/board/foundedImge?fileName="+imgeName5)
		$("input.image1").val(suc.foundedImgList0[0].founded_review_no);
		$(".image2").val(suc.foundedImgList1[0].founded_review_no);
		$(".image3").val(suc.foundedImgList2[0].founded_review_no);
		$(".image4").val(suc.foundedImgList3[0].founded_review_no);
		$(".image5").val(suc.foundedImgList4[0].founded_review_no);
	},
	error:function(err){
		alert("에러");
	}
 })
 
 function ImageClickdetail(obj){
	 	
	 var detailNum=$(obj).next().val();
		 	location.href="/board/foundedReview/detail?founded_review_no="+detailNum; 
 }
 

 
</script>
</body>









