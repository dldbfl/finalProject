<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
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

<!-- 웹 폰트 -->
    <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Nanum+Brush+Script" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Abel&display=swap" rel="stylesheet">
<!-- 아이콘 포트 및 파비콘 -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- JQuery 1.9.0 datepick -->
	<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js">
</head>
<style>
	.accessImgeWrap{
		text-align: center;		
	}
	.moveMenus{
		position: absolute;
	    top: 60%;
	    left: 39%;
	    width: 22%;
	}
	.mainBtn{
		float: right;
	}
</style>
<body>
	<div class="accessImgeWrap">
		<img src="<%=request.getContextPath() %>/resources/images/accessDenied.png">
		<div class="moveMenus col-sm-12">
			<button class="col-sm-5 btn btn-info" onclick="javascript:history.back();">이전화면</button>
			<button class="mainBtn col-sm-5 btn btn-success" onclick="javascript:location.href='<%=request.getContextPath() %>/main'">홈으로</button>
		</div>
	</div>
</body>

