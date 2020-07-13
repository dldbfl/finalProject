<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
 </style>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/loading/loading.css" />
<div class="wrap">
<span class="glyphicon glyphicon-search" aria-hidden="true">비밀번호찾기</span>
	<div class="row idOpen">
	<ul class="col-sm-6 breadcrumb">
			<li class="breadcrumb-item active" id="step1"><a href="javascript:void(0);">1.찾기방식 선택</a></li>
					<li id="step2"><a href="javascript:void(0);">2.인증 확인</a></li>
			<li id="step3"><a href="javascript:void(0);">3.인증완료</a></li>
		</ul>
	</div>
</div>
<input type="hidden" name="member_id" value="${member_pwd}" />
<div class="loadingio-spinner-spin-7iwzmidmo6b loadingImage"><div class="ldio-romrehr7hof">
<div><div></div></div><div><div></div></div><div><div></div></div><div><div></div></div><div><div></div></div><div><div></div></div><div><div></div></div><div><div></div></div>
</div></div>
<script>
	var memberid = $("input[name='member_id']").val();
	setTimeout(function() {
		$('#step1').addClass("breadcrumb-item completed");
		$('#step2').addClass("breadcrumb-item active");
		setTimeout(function() {
			$('#step2').addClass("breadcrumb-item completed");
			$('#step3').addClass("breadcrumb-item active");
			setTimeout(function() {
				$('#step3').addClass("breadcrumb-item completed");
				$(".loadingImage").remove();
				$(".idOpen").after($("<h3 class='col-xs-offset-3 col-xs-5'>"+memberid+"</h3>"));
				}, 1000);
			}, 1000);
		}, 1000);
</script>