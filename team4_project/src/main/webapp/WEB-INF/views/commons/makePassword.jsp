<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <style>
	.wrap{
		padding: 303px 0px 0px;
	    font-size: 32px;
	    width: 70%;
	    font-family: 'Karla';
	    margin: 0 auto;
	    text-align: left;
	}
	 .breadcrumb {
	    padding: 0px;
		background: #D4D4D4;
		list-style: none; 
		overflow: hidden;
		float: right;
		width: 47%;
	}
	.breadcrumb>li+li:before {
		padding: 0;
	}
	.breadcrumb li { 
		float: left; 
	}
	.breadcrumb li.active a {
		background: brown;                  
		background: #ffc107 ; 
	}
	.breadcrumb li.completed a {
		background: brown;                   
		background: hsla(153, 57%, 51%, 1); 
	}
	.breadcrumb li.active a:after {
		border-left: 30px solid #ffc107 ;
	}
	.breadcrumb li.completed a:after {
		border-left: 30px solid hsla(153, 57%, 51%, 1);
	} 

	.breadcrumb li a {
		color: white;
		text-decoration: none; 
		padding: 10px 0 10px 45px;
		position: relative; 
		display: block;
		float: left;
	}
	.breadcrumb li a:after { 
		content: " "; 
		display: block; 
		width: 0; 
		height: 0;
		border-top: 50px solid transparent;          
		border-bottom: 50px solid transparent;
		border-left: 30px solid hsla(0, 0%, 83%, 1);
		position: absolute;
		top: 50%;
		margin-top: -50px; 
		left: 100%;
		z-index: 2; 
	}	
	.breadcrumb li a:before { 
		content: " "; 
		display: block; 
		width: 0; 
		height: 0;
		border-top: 50px solid transparent;          
		border-bottom: 50px solid transparent;
		border-left: 30px solid white;
		position: absolute;
		top: 50%;
		margin-top: -50px; 
		margin-left: 1px;
		left: 100%;
		z-index: 1; 
	}	
	.breadcrumb li:first-child a {
		padding-left: 15px;
	}
	.wrap .row{
		border-bottom: 1px solid black;
		margin-bottom: 10%; 
	}
	span.glyphicon{
		float: left;
	}
	ul{
	   list-style:none;
	   font-size: 15px;
   }
   li>button{
		width: 50%;
   }
   .tit{
		font-size: 32px;
   }
   div label{
		font-size: 20px;
	}
	.checkPoint{
		display: none;
	}
	.h3Resurlt{
		text-align: center;
		margin-top: 400px;
	}
 </style>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/loading/loading.css" />
<div class="wrap">
	<span class="glyphicon glyphicon-pencil" aria-hidden="true">비밀번호 변경하기</span>
<br>
	<form name="updatePwd" class="updatePwd">
		<fieldset >
			<input type="hidden" name="member_id" value="${member_id}" />
			<ul>
				<li>
				<h3>새로운 비밀번호</h3>
				
					<input type="password" name="member_pwd" id="member_pwd" class="inp" placeholder="비밀번호 입력" maxlength="50"/>
				</li>
				<li>
				<h3>새로운 비밀번호 확인</h3>
					<input type="password" name="member_pwdCheck" id="member_pwdCheck" class="inp" placeholder="비밀번호 확인 입력" maxlength="80"/>
					<span class="checkPoint">비밀번호가 일치하지 않습니다.</span>
				</li>
				<br>
				<li>
					<button  type="button" class=" btn btn-danger" name="checkBtn" onclick="SubmitChangPwd();"><span>확인</span></button>
				</li>
			</ul>
		</fieldset>
	</form>
</div>
<script>
	function SubmitChangPwd(){
		var form = $("form[name='updatePwd']");
		
		form.attr("action","<%=request.getContextPath()%>/commons/insertPwd");
		form.attr("method","post");

		var pwd=$("input[name='member_pwd']").val()
		var pwdCheck=$("input[name='member_pwdCheck']").val()
		if(pwd==""){
			$("input[name='member_pwd']").css("border","4px solid pink");
			$("input[name='member_pwd']").focus();
			return;
		}
		if(pwdCheck==""){
			$("input[name='member_pwdCheck']").css("border","4px solid red");
			$("input[name='member_pwdCheck']").focus();
			return;
		}
		if(pwd != pwdCheck){
			$("input[name='member_pwdCheck']").focus();
			$("input[name='member_pwdCheck']").val("");
			$(".checkPoint").show();
			$(".checkPoint").css("color","red");
			
			return
		}
		
		setTimeout(function() {
			$(".wrap").hide();
			$(".h3Resurlt").show();
			$(".wrap").after("<h3 class='h3Resurlt'>비밀번호가 변경되었습니다.</h3>");
            //카운트 시작 숫자
            var count = 3;
            //카운트다운함수
            var countdown = setInterval(function(){
            //해당 태그에 아래 내용을 출력
            $(".h3Resurlt").html("<div class='logoImge'></div><b><font color='blue' size='66pt'>"
            + count + "</font><b><p>초 후  로그인화면으로 이동 합니다.</p>");
                //0초면 초기화 후 이동되는 사이트
                if (count == 0) {
                    clearInterval(countdown);
            		form.submit();
                    }
                count--;//카운트 감소
            }, 1000);
		},500)
		

	}
</script>
