<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
/**
 * 작성 버튼 클릭시 화면 전환
 */
 function goSubmit(){ 
	/* 	alert("클릭"); */
		location.href="<%=request.getContextPath()%>/board/free/regist";
		
	}
 
 /*
 	detail화면 전환
 */
 function doDetail(){
	 alert("클릭");

 }
 
 function OpenWindow(UrlStr, WinTitle, WinWidth,WinHeight) {
		winleft = (screen.width - WinWidth) / 2;
		wintop = (screen.height - WinHeight) / 2;
		var win = window.open(UrlStr, WinTitle, "scrollbars=yes, width="+ WinWidth + "," 
						+ "height=" + WinHeight + ", top=" + wintop + ", left="
						+ winleft + ",resizable=yes, status=yes");
		
		win.focus();
		
	}
</script>