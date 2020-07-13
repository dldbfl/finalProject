<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>아이디찾기</title>
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
	.foundbox{
		margin: 30px;
	    padding: 30px 330px 30px 49px;
	}
	input[name="member_name"],input[name="member_email"],input[name="member_hp"],button[name="checkBtn"]{
		width:  100%;
		margin-bottom: 10px;
	    font-size: 23px;
	}
	button[name='idOpenBtn']{
		width: 60px;
	}
	.writeNum{
		font-size: 23px;
    	margin-right: 27px;
	}
</style>
<body>
<div class="wrap">
<span class="glyphicon glyphicon-search" aria-hidden="true">아이디찾기</span>
	<div class="row">
	<ul class="col-sm-6 breadcrumb">
			<li class="breadcrumb-item active"><a href="javascript:void(0);">1.찾기방식 선택</a></li>
					<li><a href="javascript:void(0);">2.인증 확인</a></li>
			<li><a href="javascript:void(0);">3.인증완료</a></li>
		</ul>
	</div>
	<div class="comfirm_area first">
		<div class="tit_box">
			<h3 class="tit">회원 정보</h3>
			<div class="form-check emailRadioCheck">
			  <input class="form-check-input" type="radio" name="check" id="emailCheck" value="" >
			  <label class="form-check-label" for="emailCheck">
			   	이메일 주소로 찾기
			  </label>
			</div>
			<div class="form-check hpRadioCheck">
			  <input class="form-check-input" type="radio" name="check" id="hpCheck" value="">
			  <label class="form-check-label" for="hpCheck">
			    휴대폰 인증으로 찾기
			  </label>
			</div>
		</div>
	</div>
	<form action="<%=request.getContextPath() %>/commons/idCheck_HpCertify" method="post" class="numberCheckForm">
		<input type="hidden" name="CheckNum" value="" />
	</form>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.1.2/handlebars.min.js"></script>
<script id="templateEmailInfo" type="text/x-handlebars-template">
	<form method="post" action="${pageContext.request.contextPath}/commons/idCheck_EmailCertify" name="idCheckForm" class="joinEmail_write foundbox">
		<fieldset >
			<ul>
				<li>
					<input type="text" name="member_name" id="memberName" class="inp" placeholder="이름" maxlength="50"
					 onkeyup="this.value=this.value.replace(/[0-9~!@#$%^&*()_+|<>?:{}\- ]/g,'');">
				</li>
				<li>
					<input type="text" name="member_email" id="memberEmailAddr" class="inp" placeholder="이메일" maxlength="80">
				</li>
				<li>
					<button class="btn btn-danger" name="checkBtn"><span>찾기</span></button>
				</li>
			</ul>
		</fieldset>
	</form>
</script>

<script id="templatehpInfo" type="text/x-handlebars-template">
	<div class="joinHp_write foundbox">
		<fieldset>
		<ul>
			<li>
				<input type="text" name="member_name" id="memberName" class="inp" placeholder="이름"  maxlength="50"
										onkeyup="this.value=this.value.replace(/[0-9~!@#$%^&*()_+|<>?:{}\- ]/g,'');">
				<p class="warningNameMsg"></p>
			</li>
			<li>
				<input type="text" name="member_hp" id="memberhp" class="inp" placeholder="'-'을 생략"" maxlength="11"
										onkeyup="this.value=this.value.replace(/[ㄱ-ㅎㅏ-ㅣ가-힣 a-z A-Z~!@#$%^&*()_+|<>?:{}\- ]/g,'');">
				<p class="warningHpMsg"></p>
			</li>
			<li class="liParent">
				<button type="button" class="btn btn-danger certifyNum" onclick="doSns();" name="checkBtn"><span>인증하기</span></button>
				<button class="btn btn-danger col-xs-2" name="idOpenBtn" onclick="idOpenBtn()">찾기</button>
				<button class="btn btn-danger col-xs-2" name="idCancelBtn" onclick="idCancelBtn()">취소</button>		
			</li>
				<input type="hidden"  name='saveWriteNum' />	
		</ul>
		</fieldset>
	</div>
</script>
<script>

	//체크박스에 의한 이메일인증 작업선택
	$("input[id='emailCheck']").on("click",function(){
			var certify =$("input:radio[id='emailCheck']").is(':checked');
			if(certify){
				if($("div.emailRadioCheck > form").length == 0){
					var template=Handlebars.compile($('#templateEmailInfo').html());
					$(".emailRadioCheck").append(template);
					$(".joinHp_write").remove();
					
				}
			}
			
	})

	//체크박스에 의한 휴대폰인증 작업선택
	$("input[id='hpCheck']").on("click",function(){
			var certify =$("input:radio[id='hpCheck']").is(':checked');
			if(certify){
	 			if($("div.hpRadioCheck > div.foundbox").length == 0){ 
					var template=Handlebars.compile($('#templatehpInfo').html());
					$(".hpRadioCheck").append(template);
					$(".joinEmail_write").remove();
					$("button[name='idOpenBtn']").hide();
					$("button[name='idCancelBtn']").hide();
	 			} 
			}
	})
	
	function doSns(){
		//입력한 이름 및 휴대폰 번호
		var searchName = $("input[name='member_name']").val();
		var searchHp   = $("input[name='member_hp']").val();
		
		if(searchName==""){
			$(".warningNameMsg").text("입력 필수").css("color" , "red");
			return;
		}
			$(".warningNameMsg").empty();
		
		if(searchHp==""){
			$(".warningHpMsg").text("입력 필수").css("color" , "red");
			return;
		}
			$(".warningHpMsg").empty();
		
		var data={ 
					"name" : searchName,
					"hp"   : searchHp
				 }
		$('.certifyNum').after($("<input type='text' placeholder='인증번호' name='writeNum' class='col-xs-5' />"));
		
		
	   $.ajax({
			url:"<%=request.getContextPath()%>/commons/idCheck_Send",
			type:"post",
			data : JSON.stringify(data),
			contentType:"application/json; charset=UTF-8" , //보내는 data 형식 지정
			success:function(suc){
				
				alert("인증문자가 발송 되었습니다.");
				$("button[name='checkBtn']").text('다시보내기');
				$("input[name='member_name']").prop('readonly', true).css('background','#dedbdb');
				$("input[name='member_hp']").prop('readonly', true).css('background','#dedbdb');
				$("input[name='saveWriteNum']").val(suc);
				$("button[name='idOpenBtn']").show();
				$("button[name='idCancelBtn']").show();
			},
			error:function(err){
				alert(err);
			}
			
		}) 
	}
	
	function idOpenBtn(){
		//입력한 이름 및 휴대폰 번호
		var searchName = $("input[name='member_name']").val();
		var searchHp   = $("input[name='member_hp']").val();
		
		var data={ 
				"member_name" : searchName,
				"member_phone"   : searchHp
			 }
		
		var writeNum= $("input[name='writeNum']").val();
		var saveWriteNum= $("input[name='saveWriteNum']").val();
		if(writeNum == saveWriteNum){
			$.ajax({
				url:"<%=request.getContextPath()%>/commons/idcheckLoading",
				type:"post",
				data: JSON.stringify(data),
				contentType :"application/json; charset=UTF-8" , //보내는 data 형식 지정
				success:function(suc){
					location.href="<%=request.getContextPath()%>/commons/idcheckPage?member_name="+searchName+"&member_phone="+searchHp;
				}
			})
		}else{
			alert("인증문자 불일치");
		}
	}
	
	function idCancelBtn(){
		alert("CancelTest");
	}
	
</script>
</body>
