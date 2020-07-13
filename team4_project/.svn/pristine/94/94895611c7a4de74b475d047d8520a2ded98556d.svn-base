<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	.loginGoBtn{
		display: none;
		margin: 100px 20px;                                                          
	}
	.cntTitle{
		display: none;
	}
	.cntbycnt{
		color: red;
	}
 </style>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/loading/loading.css" />
<div class="wrap">
<span class="glyphicon glyphicon-search" aria-hidden="true">아이디찾기</span>
	<div class="row idOpen">
		<ul class="col-sm-6 breadcrumb">
			<li class="breadcrumb-item active" id="step1"><a href="javascript:void(0);">1.찾기방식 선택</a></li>
					<li id="step2"><a href="javascript:void(0);">2.인증 확인</a></li>
			<li id="step3"><a href="javascript:void(0);">3.인증완료</a></li>
		</ul>
	</div>
	
	<div class="cntTitle">
		<span>정보와 일치하는 아이디가 <span class="cntbycnt">${fn:length(memberList)}개</span> 있습니다.</span>
	</div>
	<div class="col-sm-12">
		<button type="button" onclick="location.href='<%=request.getContextPath() %>/commons/login'" class=" btn btn-info loginGoBtn col-sm-5">로그인하러가기</button>
		<button type="button" onclick="location.href='<%=request.getContextPath() %>/commons/pwdFoget'" class="btn btn-success loginGoBtn col-sm-5">비밀번호찾기</button>
	</div>
</div>
<input type="hidden" name="member_id" value="${member.member_id}" />
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
			<c:forEach items="${memberList}" var="member">
			var text="${member.member_id}";
			var lengthNum= text.length;
			var helf2=text.substr(0,lengthNum/2)
			var helfNum= lengthNum/2;
			var star="";
			for(var i=0; i<helfNum; i++){
				star=star+"*";
			}
			console.log(helf2+star);
				$(".cntTitle").after($("<h3 class='col-xs-offset-1 col-xs-5'>"+helf2+star+"</h3>"));
			</c:forEach>
			$(".loginGoBtn").css("display","block");
			$(".cntTitle").css("display","block");
			}, 1000);
		}, 1000);
	}, 1000);

</script>
