<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<script>
$('#searchBtn').on('click',function(e){
	
	var jobForm=$('#jobForm');
	jobForm.find("[name='page']").val(1);
	jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
	jobForm.find("[name='keyword']").val($('input[name="keyword"]').val());
	
	/* alert(jobForm.serialize()); */
	
	
	jobForm.attr("action","notice_list").attr("method","get");
	jobForm.submit(); 
});


function goSubmit(){ 
	/* 	alert("클릭"); */
		location.href="<%=request.getContextPath()%>/manager/registForm";
		
	}
 
</script>

<script>
function searchList_go(page,url){
	
	var jobForm=$('#jobForm');
	jobForm.find("[name='page']").val(page);
	jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
	jobForm.find("[name='keyword']").val($('div.input-group>input[name="keyword"]').val());
	jobForm.attr("method","post");
	if(url){
		jobForm.attr("action",url)
	}else{
		jobForm.attr("action","notice_list")
	}
	
	jobForm.submit();
}
</script>