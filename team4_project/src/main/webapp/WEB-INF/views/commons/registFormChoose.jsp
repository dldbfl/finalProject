<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<style>
	.registFormChoose{
		position: relative;
	    padding-bottom: 28px;
	    margin-bottom: 20%;
	    border-bottom: 5px solid #333;
	    margin-top: 4%;
	
	}
	
	.registFormChoose .steps li{
		float: left;
	    margin-left: 18px;
	    font-size: 15px;
	    letter-spacing: -0.5px;
	    color: #999;
	    list-style: none;
	}
	.registFormChoose .steps li.on{
		color: #111;
	    font-weight: bold;
	}
	
	.steps{
		float: right;
	}
	.memberMenu{
		text-align: center;
	}
	
	.memberMenu button,.memberMenu span{
		font-size: 20px;
		font-weight: bold;
		
	}
	.student{
		float: left;
		border: 2px solid;
		width: 50%;
		height: 300px;
    	padding: 10%;
	}
	.professor{
		float: right;
		border: 2px solid;
		width: 50%;
		height: 300px;
    	padding: 10%;
	}
	.memberImgeBox i{
		display: block;
	}
	.wrap-content{
		border-bottom: 1px solid gray;
	}
	.student:hover, .professor:hover{
		background-color: #b0fff8;
	}
	.step1,.step2,.step3,.step4{
	    font-size: 22px;
	}
</style>
<body>
<div class="wrap">
			<div class="registFormChoose">
				<h1>
					<a href="<%=request.getContextPath() %>/main" class="logoImage"></a>
					<span>회원가입</span>
				</h1>
				<ol class="steps">
					<li class="step1 on">1.회원선택</li>
					<li class="step2">2.약관동의</li>
					<li class="step3">3.정보입력</li>
					<li class="step4">4.가입완료</li>
					
					
				</ol>
			</div>
			<div class="memberMenu col-xs-offset-1 col-xs-10">
				<div class="memberGroup">
					<div class="student">
						<span class="member_student">수강생 회원</span>
						<div class="memberImgeBox">
							<i class="fa fa-user fa-4x" aria-hidden="true"></i>
							<br>
							<button class="btn btn-info" onclick="location.href='<%=request.getContextPath() %>/commons/termsOfService?member=student'">가입하기</button>
						</div>
					</div>
					<div class="professor">
						<span class="member_professor">교수 회원</span>
						<div class="memberImgeBox">
							<i class="fa fa-user fa-4x" aria-hidden="true"></i>
							<br>
							<button class="btn btn-info" onclick="location.href='<%=request.getContextPath() %>/commons/termsOfService?member=professor'" >가입하기</button>
						</div>
					</div>
				</div>
			</div>
			<!-- Iframe 보류 -->
			<!-- <div id="if_list_div" style="position:relative;padding:0;" class="hide">
			<iframe id="if_list" name="if_list" frameborder="0" scrolling="0" src="" style="position: absolute; top: 0px; left: 0px; bottom: 0px; height: 830px; width: 100%; border: 0px;"></iframe>
		</div>	 -->
	</div>	
	
</body>
<script>

</script>
