<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
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

<title></title>
 <style>
        * {margin: 0; padding: 0;}
        header {width: 100%; height: 100%; background: #2089ef;}
        section {float: inherit; width:  76.6%; height: 800px; }
		
		.header_menu{
			float: right;
			text-align: right;
			margin-top: 1%;
		}
		.header_menu a{
			margin-right: 30px;
			font-size: 17px;
    		color: snow;
		}
		.header_logo{
			float: left;
			   background-image:
  			   url('<%=request.getContextPath()%>/resources/images/loginLogo.png');
			   background-position: center;
			   background-repeat: no-repeat;
			   background-size: contain;
			   width: 125px;
    		   height: 46px;
		}
		/* .header_container{
			padding-left: 15px;
 			padding-right: 60px;
		} */
		.nav_menu{
			margin-top: 43px;
			
		}
		.navigation{
			 width: 50px;
			 height: 20px;
		}
		
        /* 화면 너비 0 ~ 1200px */
        @media (max-width: 1220px){
            #wrap {width: 95%;}
        }

        /* 화면 너비 0 ~ 768px */
        @media (max-width: 768px){
            #wrap {width: 100%;}
        }

        /* 화면 너비 0 ~ 480px */
        @media (max-width: 480px){
            #wrap {width: 100%;}
            header {height: 300px;}
            aside {float: none; width: 100%; height: 300px;}
            section {float: none; width: 100%; height: 300px;}
        }
    </style>
</head>
<body>
	<header><tiles:insertAttribute name="login_header" ignore="true"/></header>
	<section class="container"><tiles:insertAttribute name="body" ignore="true"/></section>
</body>
</html>