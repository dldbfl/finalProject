<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    


<title>Insert title here</title>
<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/lecture/review.css">
<body>
	<c:set value="${best}" var="best" />
   	<c:if test="${not empty best}">
	<div id="head-line">
		<h1>베스트 수강후기</h1>
	</div>
	<div class="swiper-container" style="position: relative;">
   		 <div class="swiper-wrapper">
   		 	<c:forEach var="best" items="${best }" begin="0" end="5" >
        	<div class="swiper-slide">
        		<div class="img-line">
					<c:forEach var="img" items="${best.lecture_img_list }" begin="0" end="0">
        			<p><img onclick="detail('${best.lecture_review_no }')" class="slide-img" src="${img }"></p>
        			</c:forEach>
        			<p class="img-writer">${best.member_name }</p>
        		</div>
        		<div class="review-line" >
        			<p class="review-con">${best.lecture_review_title }</p>
        		</div>
        	</div>
        	</c:forEach>
   		 </div>
      <!-- If we need navigation buttons -->
      <div class="swiper-button-prev"></div>
      <div class="swiper-button-next"></div>
       <div class="swiper-pagination"></div>
      <div class="swiper-scrollbar"></div>
	</div>
	</c:if>
	<div style="text-align: center;">
		<h3>실시간 수강후기</h3>
	</div>
	<div style="height: 50px;">
	  	<select class="sel-box" id ="keyword" name="keyword" >
		    <option value="0"
		    ${pageMaker.cri.keyword eq '0' ? 'selected':'0' }>전체</option>
			<c:forEach var="lecture" items="${lecture}">
		    <option value="${lecture.lecture_no }"
		    ${pageMaker.cri.keyword eq '${lecture.lecture_no }' ? 'selected':'0' }>${lecture.lecture_title }</option>
		   	</c:forEach>
	  	</select>
	    <select id="viewMethod" class="sel-box" name="searchType" >
		    <option value="none"> 조회 방법</option>
		    <option value="many"
		    ${pageMaker.cri.searchType eq 'many' ? 'selected':'none' }>조회 수가 많은 것부터</option>
		    <option value="low"
		    ${pageMaker.cri.searchType eq 'low' ? 'selected':'none' }>조회 수가 적은 것부터</option>
		    <option value="desc"
		    ${pageMaker.cri.searchType eq 'desc' ? 'selected':'none' }>최근 등록된 것부터</option>
		    <option value="asc"
		    ${pageMaker.cri.searchType eq 'asc' ? 'selected':'none' }>이전에 등록된 것부터 </option>
	  	</select>
	  	<input id="chk" type="checkbox" value="asdas">
	  	<label for="chk">포토 리뷰 모아보기</label>
	  	<button class="review-btn" id="write">후기 작성</button>
	  	<button class="review-btn" onclick="myList('${loginUser.member_id}')">내 후기보기</button>
	  	<label class="message" id="noRule">이미 후기를 작성 하셨거나 대상자가 아닙니다.</label>
	  	<label class="message" id="noLogin">로그인 후 이용해 주세요</label>
	  	<br/>
	</div>
		<hr class="review-hr">
		<c:set value="${lecture_review }" var="review" />
		<c:if test="${not empty review }">
		<c:forEach var="review" items="${lecture_review }">
		<div>
			<div>
				<p class="review-one-info">${review.member_name } || <fmt:formatDate value="${review.lecture_review_regdate}" pattern="yyyy-MM-dd"/> || 조회 수 ${review.lecture_review_viewcnt }</p>
				<button class="like-btn" onclick="like('${review.lecture_review_no}','${loginUser.member_id }')">
					<img
						src="<%=request.getContextPath()%>/resources/images/thumbs.png">${review.lecture_review_likecnt }
				</button>
				<br />
				<p class="review-one-lecture">${review.lecture_title }</p>
				<p onclick="detail('${review.lecture_review_no}')"  class="review-one">${review.lecture_review_title }</p>
				<br />
			</div>
			<hr class="review-hr">
		</div>
		</c:forEach>
		</c:if>
		
		<c:set value="${lecture_review }" var="review" />
		<c:if test="${empty review  }">
			<h3 style="text-align: center;">등록된 후기가 없습니다</h3>
			<hr class="review-hr">
		</c:if>
	 <%@include file="../commons/pagination.jsp" %> 
	<form id="jobForm">
	<input type='hidden' name="page" value="${pageMaker.cri.page}" />
	<input type='hidden' name="perPageNum" value="${pageMaker.cri.perPageNum}"/>
	<input type='hidden' name="searchType" value="${pageMaker.cri.searchType }" />
	<input type='hidden' name="keyword" value="${pageMaker.cri.keyword }" />
	<input type="hidden" id="memId" name="member_id" value="">
	<input type="hidden" id="review_no" name="lecture_review_no" value="">
	</form>
	<script src="https://unpkg.com/swiper/swiper-bundle.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/lecture/review.js"></script>

</body>
<script>
	$('#write').on('click',function(){
		  var member_id = '${loginUser.member_id}';
		  if(member_id == ''){
			  $('#noLogin').attr('style','display:block');
			  return;
		  }
		  
		 $.ajax({
			 url:"review_overlap_check",
			 data:{"student_id": member_id},
			 type:'post',
			 success:function(res){
				 if(res =='existence'){
					 $('#noRule').attr('style','display:block');
				 }
				 if(res =='non_existence'){
					var jobForm=$('#jobForm');
					jobForm.find("[name='page']").val();
					jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
					jobForm.find("[name='keyword']").val($('#keyword').val());
					jobForm.attr("method","post");
					jobForm.attr("action","registForm")			
					jobForm.submit();
				 } 
			 },
			 error:function(res){
				 
			 }
			 
		 }) ;
	});
	  
	  $('#viewMethod').on('change',function(){
		  $('#memId').attr('value','')
		  var jobForm=$('#jobForm');
			jobForm.find("[name='page']").val();
			jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
			jobForm.find("[name='keyword']").val($('#keyword').val());
			jobForm.attr("method","post");
			jobForm.attr("action","list")
			
			if($("input:checkbox[id=chk]").is(":checked") == true) {
				jobForm.attr("action","photolist")
			}
			jobForm.submit();
			
	  })
</script>

