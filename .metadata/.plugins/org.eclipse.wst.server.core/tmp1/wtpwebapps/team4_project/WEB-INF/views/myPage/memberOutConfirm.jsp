<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
h3{
font-weight: bold;
}
.passBox{
border: 2px solid #d2d2d2;
background-color: #efefef;
height: 90px;
}
p{
font-weight: bold;

margin-top: 5px;
}
section#main-container {
    height: auto;
    margin-top: 19px;
    min-height: 663px;
    font-size: 1.4em;
}
</style>

<body>
<br>
<h2>본인 확인</h2>
<br>
	<p>회원님의 개인정보 보호를 위해 비밀번호를 확인해주세요.</p>
	<form id="memberOutConfirm" name="memberOutConfirm" action="memberOutConfirm" method="post">
	<div class="passBox"><br>
		<label style="margin-left: 30%">비밀번호확인</label><input id="member_pwd_check" name="member_pwd_check" type="password" style="margin-left: 50px;width: 300px;"><br><br>
	</div>
	</form>
	<br>
	<div id="buttons" style="margin-bottom: 50px;">
	            <button id="next" class="btn btn-primary flex-item btn-primary active" type="button" style="width: auto; font-size: larger; float: right;background-color: #e83636;border-color: #e83636;">다 음</button>
	            <button id="backBtn" class="btn btn-danger flex-item btn-primary active" type="button" style="width: auto; font-size: larger; float: right;margin-right: 5px;background-color: #b5b5b5;border-color: #b5b5b5;">뒤로가기</button>
         	</div>
</body>



<script>
	$('#backBtn').on('click', function() {
		history.go(-1);
	});
	
	$('#next').on('click', function(){
		var memberOutConfirm = document.memberOutConfirm;
		var member_pwd_chek = $('[name="member_pwd_check"]').val();
		var member_pwd = "${loginUser.member_pwd}";
		
		
		if(member_pwd == member_pwd_chek){
			location.href="<%=request.getContextPath() %>/myPage/memberOut" 
		}else{
		alert("비밀번호가 틀렸습니다. 다시 확인해 주세요.");
			
		}
		
	});
</script>















