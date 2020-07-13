<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
    


<script>
	

	$('#back').on('click', function(){
		location.href="list";
	});
		
		
		
			
	var url = 'modifyForm?consult_no='+ ${consult.consult_no};
    var infoForm = $("form[id='infoForm']");
			
		$('#modify').on('click', function(){
			infoForm.attr({
	  			'action' : url,
	  			'method' : 'post'
	  		});
			infoForm.submit();
	  		
	  	}); 
		
	</script>