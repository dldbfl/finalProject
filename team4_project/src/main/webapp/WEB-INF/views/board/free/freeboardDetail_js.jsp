<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<script type="text/javascript">
var freeboard_no="${freeboard.freeboard_no}";
	var formObj = $("form[role='form']")
	
	/*자유게시판 게시글 삭제 버튼 이벤트*/
<%-- 	$('button#removeBtn').on('click',function(event){
	 	var ans=confirm("게시글을 삭제하시겠습니까?");
		if(ans){
			var contactForm = $("#contact");
			contactForm.attr("action", "<%=request.getContextPath()%>/board/free/remove");
			contactForm.submit();
			location.href="<%=request.getContextPath()%>/board/free/remove/"+freeboard_no;
		}
	}); --%>
	
	
	
	
	
	/*자유게시판 게시글 닫기버튼 이벤트*/
	$("#listBtn").on('click',function(){
		location.href="<%=request.getContextPath()%>/board/free";
	});
	
	
	/*자유게시판 게시글 수정버튼 이벤트*/
	var url = 'modifyForm';
	$('#freeModifyBtn').on('click',function(){
		  location.href="<%=request.getContextPath()%>/board/modifyForm?freeboard_no=${freeboard.freeboard_no}";
	  });	
	
	/*게시글 상세내역 다음글 버튼*/
	$('#next').on('click', function(){
  		var nextNo = ${freeboard.nextNo};
  		if(nextNo==0){
  			nextNo = ${freeboard.freeboard_no}; 
  		}
  		location.href="detail?freeboard_no=" + nextNo;
  	});
  	
	/*게시글 상세내역 이전글 버튼*/
  	$('#prev').on('click', function(){
  		var prevNo = ${freeboard.prevNo};
  		
  		location.href="detail?freeboard_no=" + prevNo;
  	});
  	

</script>
<script type="text/javascript">
/*댓글 입력 글 제한 */
	function TextCount(obj){
		var strsubject = obj.value;
		strlength = 0;
		document.getElementById("tmptext").innerHTML = strsubject.length;
		for (cntchar = 0; cntchar < strsubject.length; cntchar++) {
			if (strsubject.charCodeAt(cntchar) > 255){
				strlength += 2;
			}else{
				strlength++;
			}
			if (strlength >= 1000){
				alert("입력 문자는 최대 1000byte이므로 더이상 입력 할 수 없습니다");
				obj.value = obj.value.substring(0, cntchar);
				break;
			}
		}
	}


</script>










