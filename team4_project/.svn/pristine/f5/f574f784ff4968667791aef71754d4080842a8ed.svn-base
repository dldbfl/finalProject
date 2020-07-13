<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<style>
.hover3:hover {
	box-shadow: 0 80px 0 0 rgba(0, 0, 0, 0.25) inset, 0 -80px 0 0
		rgba(0, 0, 0, 0.25) inset;
}

section#main-container {
	height: auto;
	margin-top: 19px;
	min-height: 663px;
	font-size: 1.4em;
}
</style>
<body>
							
				<!-- form start-->
				<div id="register">
					<h3 style="font-weight: bold;margin-top: 50px;">비밀번호 확인</h3>
					<hr>
					<label for="consult_pwd" style="margin-left: 342px;">비밀번호  </label>
					<input name="consult_pwd" id="consult_pwd" type="password" style="width: 350px;"/>
				<form id="infoForm" method="post" action="detail">
					<input id="consult_no" type="hidden" name="consult_no" value="${consult_no }">
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
		
				<div style="text-align: center;">
					<button class="hover3" type="button" id ="btn1" style="border-radius:15%; width:auto; height:auto; color:white; background-color: #555555;font-size: 1.4em;">전송</button>
					&nbsp;<button class="hover3" onclick="history.go(-1); return false;" type="button" id ="btn2" style="border-color:white; border-radius:15%; width:auto; height:auto;font-size: 1.4em;">취소</button>
				</div>
			<div id="content" style="margin-top: 20%;">	
					
				<!-- form start-->
				<div id="register">
				</div>		
				<!-- form end-->
			</div>
	</body>
<script>
	$('#btn1').on('click',function(){
		var consult_pwd = $('#consult_pwd').val();
		var consult_no = $('#consult_no').val();

		var check = {"consult_no":consult_no, "consult_pwd":consult_pwd};
		
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
