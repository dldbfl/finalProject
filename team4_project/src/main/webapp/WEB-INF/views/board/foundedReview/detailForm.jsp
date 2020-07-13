<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/slider/sliderDisplay.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/slider/sliderOption.css" />
<title>창업후기 상세보기</title>
<style media="print">
	header,footer,.prevNextBtn,.headerMenu, #formHeaderRayout{ display: none;} 
@page {
    size: a4;
    page-break-after: always; 
    counter-increment: page;

    @bottom-right {
        counter-increment: page;
        content: "Page " counter(page);
    }
}
</style>
<body>
	<div id="formHeaderRayout" style="font-size: 1.4em;">
		<ul class="breadcrumb quickMenu " style="margin-top: 30px;">
			<li class="breadcrumb-item">
				<a style=" color:darkgreen;" href="/main"><i class="fa fa-home fa-lg" aria-hidden="true">홈</i></a>
			</li>
			<li class="breadcrumb-item">
				<a href="/board/foundReviewList" class="list">목록</a>
			</li>
			<li class="breadcrumb-item active">
				<span>상세내용</span>
			</li>
		</ul>
	</div>
	<div>
	  <div id="slides">
	  </div>
	</div>
	<hr>
	<div class="col-sm-12" style="height:46px;">
		<c:if test="${not empty loginUser.member_id && loginUser.member_id == review.founded_review_writer }">
			<button  type="button" class="detailModify btn btn-primary col-sm-offset-1 col-sm-1" onclick="location.href='founded_review_modify?founded_review_no=${review.founded_review_no }'">수정</button>
			<button  type="button" class="detailDelete btn btn-warning col-sm-offset-1 col-sm-1" onclick="location.href='founded_review_delete?founded_review_no=${review.founded_review_no }'">삭제</button>
		</c:if>
		<button type="button"  class="btn btn-info col-sm-offset-1 col-sm-1" onclick="location.href='<%=request.getContextPath()%>/board/foundReviewList';">목록</button>
		<button type="button" class="btn btn-secondary col-sm-offset-1 col-sm-1" onclick="printDiv()">인쇄</button>
	</div>
	<div id="pageArea" class="page row"> 
	<div id="foundedWrap col-sm-12" style="height: 128px;">
		<div class="headerMenu col-sm-12">
			<span class="col-sm-2" style="font-size:1.4em;">글 번호 : ${review.founded_review_no }</span>
		</div>
		<div class="datailHeader col-sm-auto" style="height: 94px;">
			<h3 class="col-sm-12" style="font-size: 2.3em;font-weight: bold;">상세내용</h3>
			<div class="detaildate col-sm-3">
				<span style="font-size: 1.4em;font-weight: bold;">작성날짜</span>
				<span style="font-size: 1.4em;"><fmt:formatDate value="${review.founded_review_regdate}" pattern="yyyy-MM-dd"/></span>
			</div>		
			
			<div class="col-sm-2 ">
				<span style="font-size: 1.4em;font-weight: bold;">조회수</span>
				<span style="font-size: 1.4em;">${review.founded_review_viewcnt}</span>
			</div>
			<br>
			<div class="col-sm-4">
				<span style="font-size: 1.4em;font-weight: bold;">작성자</span>
				<span style="font-size: 1.4em;">${review.founded_review_writer}</span>
			</div>
		</div>
	</div>
	
			<div class="detailTitleWrap col-md-12" style=" height: 56px;margin-bottom: 30px;border-bottom: 6px solid darkgreen;     line-height: 52px;">
				<span class="col-md-1" style="font-size: 1.7em;font-weight: bold;">제목</span>
				<span class="detailTitle col-md-10" style="font-size: 1.7em;">${review.founded_review_title }</span>
			</div>
		<div class="detailContentWrap col-md-12">
			<span class="col-md-1" style="font-size: 1.7em;">내용</span>
			<div class="detailContent col-md-11" id="detailContent" style="ffont-size: 1.2em;  border: 1px solid; padding: 30px; text-align: center;" >
				<c:forEach var="img" items="${reviewImg }" varStatus="status">
					<img src="<%=request.getContextPath() %>/board/foundedReview/${img.founded_review_img_no }" style=" width: inherit;max-width: 381px;float: unset;">
					<br>
				</c:forEach>
				${review.founded_review_content }
			</div>
		</div>
	</div>
	<div class="col-md-12">
		<div class="prevNextBtn " style="margin: 50px 0px 50px 0px;font-size: 1.5em;">
		<span>이전글 : <a class="prev" href=""></a></span>
		<br>
		<span>다음글 : <a class="next" href=""></a></span>
		</div>
	</div>
	<script>
	var reviewNO = ${review.founded_review_no}
	
		$.ajax({
		url:"/board/foundedReview/detailPrevNextInfo",
		type:"get",
		data: {"detailReviewNo": reviewNO},
		success:function(suc){
			PrevNextTitleSetting(suc);
		},
		error:function(err){
			alert("실패");
		}
	})
	
	// 이전글 이전글로 이동하는 버튼 기능 
	function PrevNextTitleSetting(obj){
		if(obj.prevTitle != "이전글없음"){
			$(".prev").attr("href","<%=request.getContextPath()%>/board/foundedReview/detail?founded_review_no="+obj.prevNum);
		}else{
			$(".prev").attr("href","javascript:void(0);");
			$(".prev").css("text-decoration", "none");
		}
		$(".prev").text(obj.prevTitle);
		
		if(obj.nextTitle != "다음글없음"){
			$(".next").attr("href","<%=request.getContextPath()%>/board/foundedReview/detail?founded_review_no="+obj.nextNum);
		}else{
			$(".next").attr("href","javascript:void(0);");
			$(".next").css("text-decoration", "none");
		}
		$(".next").text(obj.nextTitle);
	}
	
	function printDiv()
	{
        var initBody = document.body.innerHTML;
        window.onbeforeprint = function(){
            document.body.innerHTML = document.getElementById('pageArea').innerHTML;
        }
        window.onafterprint = function(){
            document.body.innerHTML = initBody;
        }
	window.print();
	}
	</script>
</body>


