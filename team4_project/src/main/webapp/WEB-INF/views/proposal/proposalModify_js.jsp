<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>



<script>
		$('#close').on('click', function(){
			history.go(-1);
		});
		
		$('#modify').on('click', function(){

			var form = document.modify;
			 
			alert(form);
			
			form.submit();
		});
		</script>