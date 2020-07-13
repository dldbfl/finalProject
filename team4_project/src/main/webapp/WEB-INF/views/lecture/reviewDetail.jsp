<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    


<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/css/swiper.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/lecture/reviewDetail.css">
<body>
	<div>
   		<c:if test="${review.lecture_review_likecnt >= 50 }">
		<div class="head-line">
			<h1 class="head">베스트 수강후기</h1>
		</div>
	</c:if>
	<c:if test="${review.lecture_review_likecnt < 50 }">
		<div class="head-line">
			<h1 class="head">수강후기</h1>
		</div>
	</c:if>
		<div id="detail">
		<div class="review-detail-header">
			<p class="review-detail"><span class="detial-point">${review.member_name }</span> || <fmt:formatDate value="${review.lecture_review_regdate}" pattern="yyyy년 MM 월 dd일 hh시mm분"/> || 조회 수 
				<c:if test="${review.lecture_review_viewcnt >= 50}"><span class="detial-point"> ${review.lecture_review_viewcnt }</span></c:if>
				<c:if test="${review.lecture_review_viewcnt < 50}">${review.lecture_review_viewcnt }</c:if>
			</p>
			<button class="detail-btn" id="listBack" name="listBack" type="button">목록으로</button>
			<button class="detail-btn" id="delete" name="delete" type="button" onclick="deleteReview(${review.lecture_review_no})">삭제</button>
			<button class="detail-btn" id="modify" name="modify" type="button" onclick="modifyReview(${review.lecture_review_no})">수정</button>	
		</div>	
		<div id="pre">
		<div class="swiper-container">
   			 <div class="swiper-wrapper">
				<c:forEach var="img" items="${review.lecture_img_list }" begin="0" end="5">
        				<div class="swiper-slide">  			
    						<img class="slide-img" src="${img }">
						</div>
    			</c:forEach>
	    	 </div>
			 <div class="swiper-button-prev"></div>
		     <div class="swiper-button-next"></div>
		     <div class="swiper-pagination"></div>
		     <div class="swiper-scrollbar"></div>
	    </div> 
	    </div>
	    <div id="detail-content">
	    	<p>${review.lecture_review_content }</p>
	    </div>
	   </div>
	   
	<form id="modifyForm" action="modifyReview" method="post" style="display:none;">

	<div>
  		<input id="modify_review_title" type="text" name="lecture_review_title" value="${review.lecture_review_title }">
	</div><br><br>
		
		 <textarea id="content" name="lecture_review_content">${review.lecture_review_content }</textarea>
	
	<button class="detail-btn" onclick="history.go(-1)" type="button" style="margin:0px 5px 20px 5px;">취 소</button>	
	<button class="detail-btn" id="modifyBtn" type="button"style="margin-right:15px;">수 정</button>
	
	<input type="hidden" name="lecture_review_writer" value="${loginUser.member_id }">
	<input type="hidden" id="modifyNo" name="lecture_review_no" value="">
	<input type='hidden' name="page" value="${pageMaker.page}" />
	<input type='hidden' name="perPageNum" value="${pageMaker.perPageNum}"/>
	<input type='hidden' name="searchType" value="${pageMaker.searchType }" />
	<input type='hidden' name="keyword" value="${pageMaker.keyword }" />
	</form>
	   
	</div>
	
	<form id="jobForm">
	<input type='hidden' name="page" value="${pageMaker.page}" />
	<input type='hidden' name="perPageNum" value="${pageMaker.perPageNum}"/>
	<input type='hidden' name="searchType" value="${pageMaker.searchType }" />
	<input type='hidden' name="keyword" value="${pageMaker.keyword }" />
	<input type="hidden" id="memId" name="member_id" value="${loginUser.member_id }">
	<input type="hidden" id="review_no" name="rno" value="">
	</form>	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/lecture/reviewDetail.js"></script>	
</body>
<%@ include file="reviewnote_js.jsp" %>