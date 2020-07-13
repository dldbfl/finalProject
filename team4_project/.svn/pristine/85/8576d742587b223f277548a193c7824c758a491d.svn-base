<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<!-- include summernote css/js-->



<script>
/**
 * 작성 버튼 클릭시 화면 전환
 */
 function goSubmit(){ 
	 if("${loginUser.member_id}" == ""){
			alert("로그인 후 작성 가능합니다.");
			return;
		}
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
 

 /*검색 기능*/

 $('#searchBtn').on('click',function(e){
		
		var jobForm=$('#jobForm');
		jobForm.find("[name='page']").val(1);
		jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
		jobForm.find("[name='keyword']").val($('input[name="keyword"]').val());
		
		
		jobForm.attr("action","free.do").attr("method","get");
		jobForm.submit(); 
	});


</script>