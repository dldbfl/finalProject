<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>

.but{
	padding: 1.1%;
	background: #FFC19E;
	border-style: none;
	margin-top: 52px;	
}
</style>
<body>
<div id="payBox" align="center" >
<div id="payFile" 
		style="width: 500px; height: 500px;
          		background-position: center;
          		background-repeat: no-repeat;
				background-size: 100% 100%;
			background-image: url('<%=request.getContextPath()%>/resources/images/lectureimg/결제실패.png');">
		</div>
<h4>고객센터의 문의 바랍니다  불편을 드려 죄송합니다.</h4>

<button type="button" class="but" id="goMain">메인 바로가기</button>
<button type="button" class="but" id="goConsult">수강모집 바로가기</button>
</div>


</body>

<script>

$('#goMain').on('click',function(){
	location.href="<%=request.getContextPath()%>/main";
});

$('#goConsult').on('click',function(){
	location.href="<%=request.getContextPath()%>/lecture/list";
});
</script>