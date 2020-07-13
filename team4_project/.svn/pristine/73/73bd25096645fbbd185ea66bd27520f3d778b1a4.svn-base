<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<script>
$('#addFileBtn').on('click',function(event){
	var attachedFile=$('a[name="attachedFile"]').length;
	var inputFile=$('input[name="uploadFile"]').length;	
	var attachCount=attachedFile+inputFile;
	
	if(attachCount >=5){
		alert("파일추가는 5개까지만 가능합니다.");
		return;
	}
	
	var input=$('<input>').attr({"type":"file","name":"uploadFile"})
	  					  .css("display","inline"); 

	var div=$('<div>').addClass("inputRow");
	div.append(input).append("<button style='border:0;outline:0;' class='badge bg-red' type='button'>X</button");
	div.appendTo('.fileInput');
});


$('div.fileInput').on('click','div.inputRow > button',function(event){  		
	//alert("X btn click;");
	$(this).parent('div.inputRow').remove();	
});
$('.fileInput').on('change','input[type="file"]',function(event){
	if(this.files[0].size>1024*1024*40){
	alert("파일 용량이 40MB를 초과하였습니다.");
	this.value="";
	$(this).focus();
	return false;
} 
});  

$('div.fileInput').on('click','a[name="attachedFile"] > button',function(event){	
	var parent = $(this).parent('a[name="attachedFile"]');
	alert(parent.attr("attach-fileName")+"파일을 삭제합니다.");
	
	var notice_data_no=parent.attr("attach-no");
	var delElement = $(this);
	//$(this).parents('li.attach-item').remove();
	
/* 	var input=$('<input>').attr({"type":"hidden",
	     "name":"deleteFile",
	     "value":notice_data_no
		 }); 
	$('form[name="modifyForm"]').prepend(input); */
	
 	$.ajax({
		url:"<%=request.getContextPath()%>/manager/attachdelete",
		type:"post",
		data:{"notice_data_no": notice_data_no},
		dataType:"text",
		success:function(data){
			delElement.parents('li.attach-item').remove();
			alert(data);
		},
		error:function(dd){
			alert('error');
		}
	});
	
	return false;
});


$('#notice_backBtn').on('click', function(){
		history.go(-1);
	});

$('#notice_close').on('click', function(){
	location.href="notice_list";
});

</script>

<script>




$('#notice_modify').on('click',function(e){
	var form=document.modifyForm;
	var finishDate = $('input[name="notice_finishdate"]');
	
	
	if(finishDate.val()==""){
		alert("마감일을 입력해주세요.");
		return;
	}
	
	if($("input[name='notice_title']").val()==""){
		alert(input.name+"은 필수입니다.");
		$("input[name='notice_title']").focus();
		return;
	}

	
	form.submit();
	
});
</script>