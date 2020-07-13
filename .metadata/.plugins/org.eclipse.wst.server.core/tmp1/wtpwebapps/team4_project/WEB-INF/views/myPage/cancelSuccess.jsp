<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<style>
#payBox{
 padding: 4%;
 padding-top: 35px;
}
#paySucce{
 margin: 2px;
 width: 70%;
 height: 40px;
 font-size: 25px;
 background: #FFD3B0;
 text-align: center;
}
#btnOk{
	background: #FFC19E;
	width: 60px;
 	height: 30px;
 	border: none;
}
#btnOk:hover {
	background: #B7F0B1;
}
</style>

<body>

	<div id="payBox" align="center">
		<div id="paySucce">
		환불완료
		</div>
		<h1>${loginUser.member_id}님</h1> 
		<h2>환불 신청이 완료되었습니다.</h2>
		 
		<button type="button" id="btnOk"> 확인 </button>
	</div>
	
</body>

<script>
$('#btnOk').on('click',function(){
	location.href="<%=request.getContextPath()%>/main";
})
</script>
