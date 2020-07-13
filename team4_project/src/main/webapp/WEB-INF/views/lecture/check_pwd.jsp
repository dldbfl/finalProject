<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<link href="<%=request.getContextPath() %>/resources/css/qna/password.css" rel='stylesheet' type='text/css'>	
		
		<!-- JQuery 3.4.1 -->
		<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>	
		<style type="text/css">
			.cover{
				margin-top: 40%;
			    text-align: center;
			}
		</style>		
	</head>
	
	<body>
		<div style="background-color: white; width: 100%; height: 100%;">
			<h2 style="float:left;font-size: 40px;width: 100%;">&nbsp;Q&A</h2>
			<br>
			<div class="cover">
				<h2 style="font-weight: bold;">비밀번호 확인</h2>
				<input name="password" id="password" type="password" style="width: 350px;height: 25px;font-size: 20px;"/>
				<div style="text-align: center;margin-top: 20px;">
					<button type="button" id ="btn1" style=",border-radius:15%; width:75px; height:38px; ; color:white; background-color: #555555;">전송</button>
						&nbsp;
					<button onclick="history.go(-1); return false;" type="button" id ="btn2" style="border-color:white; border-radius:15%; width:75px; height:38px;">취소</button>
				</div>		
				
			</div>
			<form id="infoForm" method="post" action="detail">
				<input id="qno" type="hidden" name="qna_no" value="${qno }">
				<input type='hidden' name="page" value="${pageMaker.page}" />
				<input type='hidden' name="perPageNum" value="${pageMaker.perPageNum}"/>
				<input type='hidden' name="searchType" value="${pageMaker.searchType }" />
				<input type='hidden' name="keyword" value="${pageMaker.keyword }" />
				<input type='hidden' name="member_id" value="${member_id }"/>
				<input type='hidden' name="professor_id" value="${professor_id}" />	
				<span id="result"></span>
			</form>
		</div>	
			
	</body>
<script>
	$('#btn1').on('click',function(){
		var password = $('#password').val();
		var qno = $('#qno').val();

		var check = {"password":password,"qno":qno};
		$.ajax({
			url:"checkPwd",
			type:"post",
			data:check,
			success:function(res){
				var form = $('#infoForm');
				form.submit();
			},
			error:function(er){
				alert('비밀번호가 일치하지 않습니다.')
			}
		});
	});
	
</script>
</html>