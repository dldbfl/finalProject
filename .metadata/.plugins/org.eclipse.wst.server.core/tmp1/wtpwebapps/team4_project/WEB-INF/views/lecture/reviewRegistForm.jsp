<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    



<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/lecture/review.css">
<body>

	<br/>
	<strong style="font-size: x-large; margin-top: 50px;">수강후기 작성</strong><br/><br/>
		

	<form id="regist" name="regist" action="regist" method="post">
	<button class="detail-btn" id="listBack" name="listBack" type="button">뒤로가기</button>	
	<input type="hidden" name="lecture_review_writer" value="${loginUser.member_id }">
	
	<select id="pay_no" name="pay_no">
		<option selected="selected" value="none">후기를 작성할 강의를 선택해 주세요</option>
			<c:forEach var="pay" items="${pay}">
		    <option value="${pay.pay_no }">${pay.lecture_title }</option>
		   	</c:forEach>
	</select><br><br>


	<div>
  		<input id="lecture_review_title" type="text" name="lecture_review_title"  placeholder="제목을 입력하세요">
	</div><br><br>
		
		 <textarea id="content" name="lecture_review_content"></textarea>
	
	<button class="registForm-btn" id="registBtn" name="registBtn" type="button">등 록</button>
	
	<input type='hidden' name="page" value="${pageMaker.cri.page}" />
	<input type='hidden' name="perPageNum" value="${pageMaker.cri.perPageNum}"/>
	<input type='hidden' name="searchType" value="${pageMaker.cri.searchType }" />
	<input type='hidden' name="keyword" value="${pageMaker.cri.keyword }" />
	</form>
 
</body>
<%@ include file="reviewnote_js.jsp" %>


<script>
var registForm = document.regist;

$('#registBtn').on('click', function(){
	var title =$('#lecture_review_title').val();
	var content = $('#content').val();
	var lecture = $('#pay_no').val();
	if(lecture == 'none'){
		alert('강의를 선택해주세요')
		return false;
	}
	
	if(title.length < 0){
		alert('제목을 입력해주세요')
		return false;
	}
	
	if(title.length > 50){
		alert('제목은 50자 미만으로 입력해주세요')
		return false;
	}
	
	if(content.length < 0){
		alert('내용을 입력해주세요')
		return false;
	}
	
	if(content.length > 1000){
		alert('내용은 1000자 미만으로 입력해주세요')
		return false;
	}
	
	registForm.submit();
});


$('#listBack').on('click', function(){
	  	var form = $('#regist');
		form.attr("action","list")
		
		form.submit();
});
</script>
