<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
alert("수정에 실패했습니다. 관리자에 문의 바랍니다.");
location.href="<%=request.getContextPath()%>/board/free/detail?freeboard_no=${param.freeboard_no}";
</script>