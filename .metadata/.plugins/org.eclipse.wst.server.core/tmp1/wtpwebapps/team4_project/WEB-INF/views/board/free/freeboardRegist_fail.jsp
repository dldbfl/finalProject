<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script>
	alert("게시글 등록이 실패했습니다. /n 관리자에게 문의 바람니다.");
	location.href="<%=request.getContextPath()%>/board/free";
</script>