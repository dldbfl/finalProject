<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
	.wrap{
		padding: 80px 0px 0px;
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
	.successText{
		display: none;
		text-align: center;
	}
	.goMainBtn{
		display: none;
	}
</style>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/loading/loading.css" />
<div class="wrap">
		<div class="registFormChoose">
			<h2>
				<a href="<%=request.getContextPath() %>/main" class="logoImage"></a>
				<span>회원가입</span>
			</h2>
		</div>
		<div class="row idOpen">
			<ul class="col-sm-12 breadcrumb">
				<li class="breadcrumb-item completed " id="step1"><a href="javascript:void(0);">1.회원선택</a></li>
				<li class="breadcrumb-item completed active" id="step2"><a href="javascript:void(0);">2.약관동의</a></li>
				<li class="breadcrumb-item active" id="step3"><a href="javascript:void(0); ">3.정보입력</a></li>
				<li id="step4"><a href="javascript:void(0);">4.가입완료</a></li>
			</ul>
			<h3 class='col-xs-12 successText'>가입 성공!!</h3>
			<button type="button" class="btn btn-primary btn-lg btn-block goMainBtn" onclick="goMain();">홈으로</button>
		</div>
</div>
<div class="loadingio-spinner-spin-7iwzmidmo6b loadingImage"><div class="ldio-romrehr7hof">
<div><div></div></div><div><div></div></div><div><div></div></div><div><div></div></div><div><div></div></div><div><div></div></div><div><div></div></div><div><div></div></div>
</div></div>
<script>
	setTimeout(function() {
		$('#step3').addClass("breadcrumb-item completed");
		$('#step4').addClass("breadcrumb-item active");
		setTimeout(function() {
			$('#step4').addClass("breadcrumb-item completed");
			$(".loadingImage").remove();
			$(".successText").css("display","inline");
			$(".goMainBtn").css("display","inline");
			}, 1000);
		}, 1000);

	function goMain(){
		location.href="<%=request.getContextPath()%>/main";
	}
</script>
