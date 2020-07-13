	function CheerUpload(){
		
		var cheerText = $("input[name='cheerUpText']").val();
			textOnly=$.trim(cheerText);
		if(userId==""){
			alert("로그인 후 이용가능합니다.");
			return;
		}
		
		
		if(!textOnly){
			alert("글을 작성해주세요");
			return;
		}
		var idCheck=$("input[name='"+userId+"']").val();
		if(userId==idCheck){
			alert("응원글 하루 한번만 등록 가능합니다.");	
			return;
		}
		textOnly='textOnly='+textOnly;
		$.ajax({
			url:"/registCheerUp",
			type:"post",
			data: textOnly,
			dataType:"text",
			success:function(suc){
				alert("작성 성공");
				location.reload();
			},
			error:function(err){
				alert("글작성 실패");
			}
		})
		
	}
	