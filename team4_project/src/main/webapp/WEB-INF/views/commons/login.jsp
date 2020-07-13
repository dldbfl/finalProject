<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- 메인 로그인 CSS -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/login/loginMain.css">
<style>
	.loginFailText{
	    font-size: 18px;
	    color: red;
	}
	.logo2Imge{
    	width: inherit;
	}
</style>
<title>로그인</title>
</head>
<script>
</script>
<body>
	<div class='wrap'>
	<img class="logo2Imge" src="<%=request.getContextPath() %>/resources/images/loginLogo2.png" />
	<form name="loginForm" action="/commons/loginCheck" method="post">
		<input type='text' id='member_id' name="member_id" placeholder='아이디' value="${member_id}">
		<input type='password' id='member_pwd' name="member_pwd" placeholder='비밀번호'> 	<br>
		<button class='login' onclick="SubmitLogin();">로그인</button>
	</form>
	<button class='forgot' onclick="location.href='idForgot'">아이디 찾기 </button>
	<button class='forgot' onclick="location.href='pwdFoget'">비밀번호 찾기 </button>
	<button class='signUp' onclick="location.href='registFormChoose'">회원가입</button>
	<span class="loginFailText">${msg }</span>
	<div><br>
		<h3>불편사항 문의</h3>
		<h4>1577-3525</h4>
	</div>
</div>
</body>

<script>
	//아이디 또는 비밀번호가 틀렸을때 해당 비밀번호 지우고 포커스이동
	if("${msg}"){
		$("#member_pwd").val("");
		$("#member_pwd").focus();
	}
	
	//login submit!
	function SubmitLogin(){
		var form= $("form[name='loginForm']");
		form.submit();
	}
</script>
</html>