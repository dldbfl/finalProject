<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
	.header_logo{
		cursor: pointer;
	}
</style>
</head>
    <header id="header">
        <div class="container">
            <div class="row">
                <div class="header">
                <div class="header_logo" onclick="location.href='/main'"></div>
                    <div class="header_menu">
                    	<c:choose>
	                    	<c:when test="${empty loginUser.member_id }">
		                        <a href="/commons/login">로그인</a>
		                    </c:when>
		                    <c:otherwise>
		                    	<a href="#">${loginUser.member_id }님 환영합니다.</a>
		                     	<a href="/commons/logout">로그아웃</a>
	                     	</c:otherwise>
                     	</c:choose>
                    	<a href="/main">홈</a>
                        <a href="<%=request.getContextPath()%>/board/notice/list">고객센터</a>
                    </div>
                </div>
            </div>
        </div>
    </header>