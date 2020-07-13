<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<link href="<%=request.getContextPath() %>/resources/css/qna/password.css" rel='stylesheet' type='text/css'>				
	</head>
	
	<body>
		<div id="container" style="background-color: white; width: 100%; height: 100%;">
			<div id="header">
				<hr>
							
			</div>
			<hr>
			<div id="content" style="margin-top: 20%; margin-left:20%; ">	
				<!-- form start-->
				<div id="register">
					<h3 style="font-weight: bold;">비밀번호 확인</h3>
					<hr>
					<label for="password" style="color: blue;">비밀번호  </label>
					<input name="password" id="password" type="text" style="width: 350px;"/>
				<form id="infoForm" method="post" action="detail">
					<input id="qno" type="hidden" name="qna_no" value="${qno }">
					<input type='hidden' name="page" value="${pageMaker.page}" />
					<input type='hidden' name="perPageNum" value="${pageMaker.perPageNum}"/>
					<input type='hidden' name="searchType" value="${pageMaker.searchType }" />
					<input type='hidden' name="keyword" value="${pageMaker.keyword }" />
					<span id="result"></span>
				</form>
				</div>	
				<div style="width: 100%">
					<hr>
				</div>			
			</div>
				<div style="text-align: center;">
					<button type="button" id ="btn1" style="border-radius:15%; width:75px; height:38px; margin-left: 21%; color:white; background-color: #555555;">전송</button>
					&nbsp;<button onclick="history.go(-1); return false;" type="button" id ="btn2" style="border-color:white; border-radius:15%; width:75px; height:38px;">취소</button>
					<hr>
				<hr>
				</div>
			<div id="content" style="margin-top: 20%;">	
					
				<!-- form start-->
				<div id="register">
				</div>		
				<!-- form end-->
			</div>
			<hr>				
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