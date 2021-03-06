<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<style>
#ptag{
color: red;
font-weight: bold;
padding-top: 10px;
}
h3{
font-weight: bold;
}
h4{
font-weight: bold;
}
.notice1{
border: 2px solid #d2d2d2;
background-color: #f9e9e9;
height: 305px;
}
.notice2{
border: 2px solid #d2d2d2;
background-color: #efefef;
height: 220px;
}
#notiInfo{
color: red;

}

.reasonBox{


}
.reasonText{
width: 100%;
height: 100px;
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
	<h2>회원탈퇴안내(탈퇴사유)</h2>
	<br>
	<h3>회원탈퇴</h3>	
		 	<div class="notice1">
			<p id="ptag">&nbsp;&nbsp;&nbsp;회원탈퇴 시 개인정보 및 D-LMS에서 만들어진 모든 데이터는 삭제됩니다.<br>&nbsp;&nbsp;&nbsp;(단,아래 항목은 표기된 법률에 따라 특정 기간 동안 보관됩니다.)</p>			
			&nbsp;&nbsp;&nbsp;1. 계약 또는 청약철회 등에 관한 기록 보존 이유 : 전자상거래 등에서의 소비자보호에 관한 법률 / 보존 기간 : 5년<br>
			&nbsp;&nbsp;&nbsp;2. 대금결제 및 재화 등의 공급에 관한 기록 보존 이유 : 전자상거래 등에서의 소비자보호에 관한 법률 / 보존기간 : 5년<br>
			&nbsp;&nbsp;&nbsp;3. 전자금융 거래에 관한 기록 보존 이유 : 전자금융거래법 보존 기간 / 5년<br>
			&nbsp;&nbsp;&nbsp;4. 소비자의 불만 또는 분쟁처리에 관한 기록 보존 이유 : 전자금융거래 등에서의 소비자보호에 관한 법률 보존 기간 / 3년 <br>
			&nbsp;&nbsp;&nbsp;5. 신용정보의 수집/처리 및 이용 등에 관한 기록 보존 이유 : 저자상거래 등에서의 소비자보호에 관한 법률 보존 기간 / 3년<br>
			&nbsp;&nbsp;&nbsp;6. 전자(세금)계산서 시스템 구축 운영하는 사업자가 지켜야 할 사항 고시(국세청 고시 제 2016-3호)(전자세금계산서 사용자에 한함) : 5년<br>
			&nbsp;&nbsp;&nbsp;(단, (세금)계산서 내 개인식별번호는 3년 경과 후 파기)
		 	</div>
			<br>
			
			
			<h4>- 유의 사항</h4>
			<div class="notice2">
			<p id="ptag">&nbsp;&nbsp;&nbsp;회원탈퇴를 신청하기 전에 아래 사항을 꼭 확인해주세요.</p>
			&nbsp;&nbsp;&nbsp;- 탈퇴 신청시 즉시 탈퇴 처리됩니다.<br>
			&nbsp;&nbsp;&nbsp;- 탈퇴 후 60일 동안 회원가입이 불가능합니다.<br>
			&nbsp;&nbsp;&nbsp;- 사용하고 계신 아이디와 닉네임은 탈퇴 후 재사용할 수 없습니다.<br>
			&nbsp;&nbsp;&nbsp;- 재가입에 60일의 시간이 걸리는 만큼, 아이디변경을 목적으로 하는 경우 신중히 판단해주세요.<br>
			&nbsp;&nbsp;&nbsp;- 탈퇴 전 작성된 게시물이나 댓글 등은 탈퇴 후에도 유지됩니다.<br>
			<p id="notiInfo">&nbsp;&nbsp;&nbsp;- 게시물 삭제 등을 원하는 경우 반드시 삭제 처리 후 탈퇴를 신청해주세요.</p><br>
			</div>
			<br>
			<h4>- 탈퇴 사유</h4>
			<div class="reasonBox">
			<form name="out" action="out" method="get">
			<textarea id="member_memberOutReason" name="member_memberOutReason" class="reasonText" rows="" cols=""></textarea>			
			</form>
			</div>



 		  	<div id="buttons" style="margin-bottom: 50px;">
	            <button id="byebye" class="btn btn-primary flex-item btn-primary active" type="button" style="width:100px; float: right;background-color: #e83636;border-color: #e83636;width: auto; font-size: larger;">회원탈퇴</button>
	            <button id="backBtn" class="btn btn-danger flex-item btn-primary active" type="button" style="width:100px; float: right;margin-right: 5px;background-color: #b5b5b5;border-color: #b5b5b5;width: auto; font-size: larger;">뒤로가기</button>
         	</div>
</body>
<script>
	$('#backBtn').on('click', function(){
		history.go(-1);
	});
	
	
	$('#byebye').on('click', function(){

		var member_memberOutReason = document.out;
		
		out.submit();
		
	});
	
	
	
	
	
	
	
</script>