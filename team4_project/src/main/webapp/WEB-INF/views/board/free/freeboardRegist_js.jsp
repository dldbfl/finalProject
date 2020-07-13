<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script>
/**
 * 취소 버튼 클릭시 이전화면으로 
 */
function godelete(){ 
	/* alert("클릭"); */
	history.go(-1);
	
} 

/* function docSubmit(){
	var form=$('form[name="registForm"]');
	alert("클릭");
	// setEditorForm(); // 에디터의 데이터를 폼에 삽입
    if (!validCheck()) return false;
	if (!confirm("저장 하시겠습니까?")) return false;

	//alert("regist click");
	if(form.title.value==""){
		alert("제목은 필수입니다.");
		return;
	}
	
	if(form.content.value.length>1000){
		alert("글자수가 1000자를 초과할 수 없습니다.");
		return;
	}
	form.submit();
		
} */

/**
 * 게시글 작성
 */
/*  
 function goSubmit(cmd,docId){ 
 	var frm = document.getElementById("registForm");
 	switch(cmd) {
 		case "post":				 
 			//if (!docSubmit()) return;
 			docSubmit();
 			//frm.submit();
 			break;
 		case "close":
 			if(confirm("편집중인 문서는 저장되지 않습니다 !\n창을 닫으시겠습니까 ?")){
 				window.close();
 			}
 			return;
 			break;
 		default:
 			return;
 			break;
 	}
 } */
<%-- 
 $('#registBtn').on('click',function(e){
	alert("클릭");
	//alert("regist click");
	var form=$('form[name="registForm"]');
	
	if(form.title.value==""){
		alert("제목은 필수입니다.");
		return;
	}
	
	if(form.content.value.length>1000){
		alert("글자수가 1000자를 초과할 수 없습니다.");
		return;
	}
	form.submit();
	
	location.href="<%=request.getContextPath()%>/board/free/regist"; 
	
});
 --%>
 $('#regist').on('click', function(e){
		
		var form = document.regist;
		
		if(form.title.value==""){
			alert("제목은 필수 입니다.");
			return;
		}

		form.submit();
	});

</script>