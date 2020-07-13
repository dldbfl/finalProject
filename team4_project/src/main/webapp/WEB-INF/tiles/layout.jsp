<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- JQuery 3.4.1 -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<!--  JQuery 1.12.1 UI -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<!-- JQuery 2.2.0 Color -->
<script src="https://code.jquery.com/color/jquery.color-2.2.0.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!-- 웹 폰트 -->
    <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Nanum+Brush+Script" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Abel&display=swap" rel="stylesheet">

<!-- 파비콘 -->
	<link rel="icon" type="image/png" sizes="32x32" href="<%=request.getContextPath() %>resources/images/favicon-32x32.png">
<!-- 아이콘 모음 -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/message/messenger_bootstrap.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="<%=request.getContextPath()%>/resources/js/message/message.js"></script>
<title>D-LMS 창업 교육 센터</title>
  <style>
        * {margin: 0; padding: 0;}
        header {
        	width: 100%;
        	position: fixed;
  			z-index: 100;
        }
        aside {width: 100%; height: 115px; background: #0000;}
        section {float: inherit; width:  76.6%;height: auto;background: white; }
        footer {clear: both; width: 100%; height: 180px; background: olive;}
		
		
		.header_menu{
			float: right;
			text-align: right;
			margin-top:;
		}
		.header_menu a{
			margin-right:;
    		color: black;
    		color: #292fd6;
    		font-weight: bold;
		}
		.header_logo{
			float: left;
			   background-image:
  			   url('<%=request.getContextPath()%>/resources/images/logo.png');
			   background-position: center;
			   background-repeat: no-repeat;
			   background-size: contain;
			   width: 125px;
    		   height: 94px;
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
        section#main-container{
        	height: auto;
        	margin-top: 19px;
        	min-height: 663px;
        }
        #wrap{
        background: white;
        }
        
    </style>
</head>
<body>
	<div id="wrap">
        <header><tiles:insertAttribute name="header" ignore="true"/></header>
        <aside><tiles:insertAttribute name="aside" ignore="true"/></aside>
        <section class="container" id="main-container"><tiles:insertAttribute name="body" ignore="true"/></section>
        <footer style="height: 140px;"><tiles:insertAttribute name="footer" ignore="true"/></footer>
	</div>
</body>
</html>