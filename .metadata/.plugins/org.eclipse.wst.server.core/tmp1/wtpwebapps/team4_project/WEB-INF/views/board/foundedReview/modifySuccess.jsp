<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	alert("수정 성공");
	location.href="<%=request.getContextPath()%>/board/foundedReview/detail?modifyText=success&founded_review_no="+${founded_review_no};
</script>