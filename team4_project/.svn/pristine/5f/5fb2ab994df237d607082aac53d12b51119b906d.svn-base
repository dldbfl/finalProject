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

	<div id="payBox" align="center" >
		<div id="paySucce" 
		style="width: 500px; height: 500px;
          		background-position: center;
          		background-repeat: no-repeat;
				background-size: 100% 100%;
			background-image: url('<%=request.getContextPath()%>/resources/images/lectureimg/결제성공.png');">
		</div>
		 
		<button type="button" id="btnOk"> 확인 </button>
	</div>
	
</body>

<script>
$('#btnOk').on('click',function(){
	location.href="<%=request.getContextPath()%>/main";
})
</script>
