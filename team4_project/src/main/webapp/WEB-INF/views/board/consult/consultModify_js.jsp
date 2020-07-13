<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
    


<script>

//등록 버튼
$('#modifyBtn').on('click', function(e){
	
	var form = document.modify;
	if(form.title.value==""){
		alert("제목은 필수 입니다.");
		return;
	}
	if(form.content.value.length>1000){
		alert("글자수가 1000자를 초과할 수 없습니다.");
		return;
	}

	form.submit();
});
//닫기 버튼
$('#close').on('click', function(){
	history.go(-1);

 	});


var elem = document.querySelector('.js-switch');

var init =new Switchery(elem,{
	    // primary color
	    color             :'#FF0033',
	    secondaryColor    :'#66FF00',
	    className         :'switchery',
	    disabled          :false,
	    disabledOpacity   : 0.5,
	    speed             :'0.4s',
	    // 'small', 'large'
	    size              :'default'
    
});

elem.onchange =function(){
	if($("input:checkbox[name=consult_type]").is(":checked") == true) {

		$('#secret').attr('value', "비밀글");
		$('#pass').attr('style', "display: ''; height:35px;")
		$('#password').attr('style', "display:'';")
	}
	else{
		$('#secret').attr("value","일반글");
		$('#pass').attr('style', "display:none;")
		$('#password').attr('style', "display:none;")
		
	}

}



</script>