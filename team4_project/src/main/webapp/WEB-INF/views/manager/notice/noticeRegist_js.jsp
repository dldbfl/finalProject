<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
    
    
<script>
$('#notice_regist').on('click', function(e){
	var form = document.regist;
	var jobForm=$('#jobForm');
	
	
	
	jobForm.find("[name='notice_point']").val($('select[name="notice_point"]').val());
	
	if(form.title.value==""){
		alert("제목은 필수 입니다.");
		return;
	}
	if(form.content.value.length>1000){
		alert("글자수가 1000자를 초과할 수 없습니다.");
		return;
	}
	
	
	form.submit();
	
});

$('#notice_char').on('click', function(){
	location.href="notice_list";
});



</script>