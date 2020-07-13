<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<title>요청 페이지 오류</title>
<meta charset="UTF-8">

<!-- JQuery 3.4.1 -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<!--  JQuery 1.12.1 UI -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!-- JQuery 2.2.0 Color -->
<script src="https://code.jquery.com/color/jquery.color-2.2.0.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<style>
	.error_wrap{
		text-align: center;
	    margin-top: 200px;
	    border: 18px solid whitesmoke;
	    padding: 43px;
	}
	.errorLogo{
		width: 300px;

	}
	.errorImge{
	    position: absolute;
	    z-index: 9999;
	    top: 36%;
	    left: 23%;
	    width: 249px;
	}
	@font-face {
		font-family: font;
		src: url('<%=request.getContextPath() %>/resources/css/font/Cafe24Dongdong.ttf');
	}

	body{
		font-family: font;
		
	}
	.
	.bottom_wrap{
	    font-size: 19px;
	    text-decoration: none;
	}
	p{
		font-size: 26px;
		
	}
	.btn_prev_page,.btn_go_home{
	    font-size: 28px;
	}
	a{
		
	}
	a:hover{
		color: red;
		text-decoration: none;
	}	
</style>
<body>
	<img class="errorImge" src="<%=request.getContextPath() %>/resources/images/pointImg.png">
<div class="error_wrap container">
	<div><img class="errorLogo" src="<%=request.getContextPath() %>/resources/images/errorLogo.png" /></div>
	<h2>이용에 불편을 드려 죄송합니다.</h2>
	<p>
		잠시 후 다시한번 시도해 주시길 바랍니다. 	<br>지속적인 오류가 있을시
		<a class="cs_center" href="<%=request.getContextPath()%>/board/consult/registForm">문의하기</a>
		로 요청바랍니다.
	</p>

	<a class="btn_prev_page"  href="javascript:history.back();">이전 페이지로 가기</a> &nbsp;&nbsp;&nbsp;&nbsp;
	<a class="btn_go_home" href="<%=request.getContextPath() %>/main">홈으로 가기</a>
	<div class="bottom_wrap">
		
		<div class="footer">
		<a href="<%=request.getContextPath() %>/main" target="_blank"><strong><span class="D">Dispatch</span>-Leaning Management System .</strong></a> All rights reserved.
		</div>
	</div>
</div>

</body>
