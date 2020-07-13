<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<span class="breadcrumb-Info">
				<img src="<%=request.getContextPath()%>/resources/common/images/pi.png" border="0" align="absmiddle">
				<a href="#" rel="${loginUser.member_id }" class="maninfo" data-hasqtip="0" aria-describedby="qtip-0">				
					${loginUser.member_id } / 정보시스템</a> <fmt:formatDate value="<%=new Date() %>" pattern="( yyyy-MM-dd HH:mm:ss)"/>
		</span>