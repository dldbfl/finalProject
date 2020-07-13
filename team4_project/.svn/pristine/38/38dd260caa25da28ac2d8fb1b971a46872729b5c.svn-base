<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>

<script>

$(function(){
	$('#content').summernote({
		placeholder: '내용을 작성하세요.',
        tabsize: 0,
		height: 250,
		fontNames : [ '맑은고딕', 'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New', ],
		fontNamesIgnoreCheck : [ '맑은고딕' ],
		focus: true,
		
		callbacks: {
			onImageUpload : function(files, editor, welEditable) {
	            for (var i = files.length - 1; i >= 0; i--) {
	            	if(files[i].size > 1024*1024*5){
	            		alert("!!!");
	            		alert("이미지는 5MB 미만입니다.");
	            	}
	            }
	            for (var i = files.length - 1; i >= 0; i--) {
	            	sendFile(files[i], this);
	            }
	        },
	        onMediaDelete : function(target) {
               // deleteFile(target[0].src);                
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
    	success: function(img_url) {
      		$(el).summernote('editor.insertImage', img_url);
    	}
  	});
}

function deleteFile(src) {
	
	var splitSrc= src.split("/");
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

