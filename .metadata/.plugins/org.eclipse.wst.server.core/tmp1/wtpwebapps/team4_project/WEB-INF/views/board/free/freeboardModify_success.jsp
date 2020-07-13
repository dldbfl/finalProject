<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
alert("수정작업이 완료되었습니다.");
location.href="<%=request.getContextPath()%>/board/free/detail?freeboard_no=${param.freeboard_no}";
</script>