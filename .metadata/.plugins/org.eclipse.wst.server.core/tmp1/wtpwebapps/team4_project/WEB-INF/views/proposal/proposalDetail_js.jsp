<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>


<script>
		$('#back').on('click', function(){
			location.href="list";
		});
		
				
		
		 var url = 'modifyForm?proposal_num='+ ${proposal.proposal_num};
		  var form = $('form');
		  
		  
		  	$('#modify').on('click', function(){
		  		
		  		form.attr({
		  			'action' : url,
		  			'method' : 'post'
		  		});
		  		
		  		form.submit();
		  		
		  	});
		</script>