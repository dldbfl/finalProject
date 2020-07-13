<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<input type="hidden" name ="member_id" value="${member.member_id}">
<input type="hidden" name ="member_pwd" value="${member.member_pwd}">
<script>
	var id = $("input[name='member_id']").val();
	var pwd= $("input[name='member_pwd']").val();
	
	var data={
			
			"member_id" : id,
			"member_pwd": pwd
	}
	$.ajax({
		url:"<%=request.getContextPath()%>/checkPwd",
		type:"post",
		data:JSON.stringify(data),
		contentType:"application/json; charset=UTF-8",
		success:function(suc){
			location.href="<%=request.getContextPath()%>/commons/makePassword?member_id="+suc;
		},
		error:function(err){
			alert("시스템 에러가 발생 했습니다 \n고객센터 담당자에게 문의 바랍니다.")
		}
	})
</script>
