<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

  <script>
  
  var url = 'modifyForm?notice_no='+ ${notice.notice_no};
  var formObj = $("form[role='form']");
  
  
  	$('#modify').on('click', function(){
  		
  		formObj.attr({
  			'action' : url,
  			'method' : 'post'
  		});
  		formObj.submit();
  		
  	});
  
  	
  	$('#delete').on('click', function(){
  		var answer = confirm("정말 삭제하시겠습니까?");
  		if(answer){
  		formObj.attr("action", "delete");
  		formObj.attr("method", "post");
  		formObj.submit();
  		}
  	});
  	
  	$('#close').on('click', function(){
  		location.href="list";
  	});

  	
  	$('#next').on('click', function(){
  		var nextNo = ${notice.nextNo};
  		if(nextNo==0){
  			nextNo = ${notice.notice_no}; 
  		}
  		
  		
  		location.href="detail?notice_no=" + nextNo;
  	});
  	
  	$('#prev').on('click', function(){
 
  		var prevNo = ${notice.prevNo};
  		
  		location.href="detail?notice_no=" + prevNo;
  	});
  	
  	
  </script>
  
  
  <script>
var getFile = function(){
	var notice_data_no = $("#attachNo").val();
	
	$.ajax({
		url:"<%=request.getContextPath()%>/board/notice/getFile",
		data:{"notice_data_no": notice_data_no},
		type:'post',
		success:function(data){
			var jsonString1 = JSON.stringify(data);
			var jsonObject1 = JSON.parse(jsonString1);
			var filePath = jsonObject1.filePath;
			var fileName = jsonObject1.fileName;
			var originalName = jsonObject1.originalName;
			
			var file = {"fileName" : fileName, "filePath" : filePath, "originalName": originalName};
			
			$.fileDownload("<%=request.getContextPath()%>/board/notice/getDown", {
				httpMethod: "POST",
			    data: file,
				successCallback: function(){
		   			
				},
				failCallback: function(){
				
				}
			});
		},
		error:function(dd){
			alert('error');
		}
	});
	
}
</script>
  