<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
<script>

$(function(){
	$('#content').summernote({
		placeholder: '게시판의 목적과 맞지 않는 글은 예고없이 삭제/이동될 수있습니다.',
        tabsize: 1,
		height: 350,
		fontNames : [ '맑은고딕', 'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New', ],
		fontNamesIgnoreCheck : [ '맑은고딕' ],
		focus: true,
		
		callbacks: {
			onImageUpload : function(files, editor, welEditable) {
	            for (var i = files.length - 1; i >= 0; i--) {
	            	if(files[i].size > 1024*1024*5){
	            		alert("이미지는 5MB 미만입니다.");
	            	}
	            }
	            for (var i = files.length - 1; i >= 0; i--) {
	            	sendFile(files[i], this);
	            
	            }
	        },
	        onMediaDelete : function(target) {               
	        	deleteFile(target[0].src);
            }
		}
		
	});

})

function sendFile(file, el) {
	var form_data = new FormData();
  	form_data.append("file", file);
  	$.ajax({
    	data: form_data,
    	type: "POST",
    	url: '<%=request.getContextPath()%>/uploadImg',
    	cache: false,
    	contentType: false,
    	enctype: 'multipart/form-data',
    	processData: false,
    	success: function(data) {
 
    		 $(el).summernote('editor.insertImage', data);
      
    	}
  	});
}

function deleteFile(src) {
	
	var fileName = splitSrc[splitSrc.length-1];
    $.ajax({
        data: {fileName : fileName},
        type: "POST",
        url: "<%=request.getContextPath()%>/deleteImg", 
        cache: false,
        success: function(resp) {
            console.log(resp);
        }
    });
}

</script>