<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
    
    
<script>
$('#regist').on('click', function(e){
	var form = document.regist;
	var jobForm=$('#jobForm');
	
	
	
	jobForm.find("[name='notice_point']").val($('select[name="notice_point"]').val());
	
	if(form.title.value==""){
		alert("제목은 필수 입니다.");
		return;
	}
	
	
	
	
	form.submit();
	
	
	
});

$('#close').on('click', function(){
	location.href="list";
});



</script>