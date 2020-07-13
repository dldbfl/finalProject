<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
    
    
<script>
var paging = $('[name=page]').val();
var perPageNum = $('[name="perPageNum"]').val();
var searchType = $('[name="searchType"]').val();
var keyword = $('[name=keyword]').val();

function captureReturnKey(e) { 
    if(e.keyCode==13) 
    return false; 
} 

//검색란에서 입력시
function enterkey(page,flag){
	if (window.event.keyCode == 13) {
		var jobForm=$('#jobForm');
		jobForm.find("[name='page']").val(page);
		jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
		jobForm.find("[name='keyword']").val($('input[name="keyword"]').val());	
		jobForm.attr("method","post");
		if(flag ==''){
			jobForm.attr("action","list")
		}
		
		if(flag == '등록'){
			jobForm.attr("action","registList")
			
		}
		if(flag =='미완'){
			jobForm.attr("action","noRegistList")
		}	
		jobForm.submit();
		flag==''
   }

}
//버튼 클릭 및 페이지 이동 버튼
function searchList_go(page,flag){
	var jobForm=$('#jobForm');
	jobForm.find("[name='page']").val(page);
	jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
	jobForm.find("[name='keyword']").val($('input[name="keyword"]').val());	
	jobForm.attr("method","post");
	if(flag ==''){
		jobForm.attr("action","list")
	}
	
	if(flag == '등록'){
		jobForm.attr("action","registList")
		
	}
	if(flag =='미완'){
		jobForm.attr("action","noRegistList")
	}	
	jobForm.submit();
	flag==''
}

//비밀글 설정
var secret = function(){
	    $('#secret').attr('style',"color:red;")
		$('#secret').attr('value', "비밀글");
		$('#pass').attr('style', "display:''; height:35px;")
		$('#password').attr('style', "display:'';")
	}
//비밀글 해제
var nonsecret = function(){
	$('#secret').attr('style',"color:blue;")
	$('#secret').attr("value","일반글");
	$('#pass').attr('style', "display:none;")
	$('#password').attr('style', "display:none;")
}
//답변 등록글 조회
var registAnswer = function() {
	    $('#status').attr('')
		var jobForm=$('#jobForm');
		jobForm.find("[name='page']").val(paging);
		jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
		jobForm.find("[name='keyword']").val($('input[name="keyword"]').val());	
		jobForm.attr("method","post");
		jobForm.attr("action","registList")
		jobForm.submit();
		flag==''
}
//답변 미등록 글 조회
var nonRegistAnswer = function () {
	
	var jobForm=$('#jobForm');
	jobForm.find("[name='page']").val(paging);
	jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
	jobForm.find("[name='keyword']").val($('input[name="keyword"]').val());	
	jobForm.attr("method","post");
	jobForm.attr("action","noRegistList")

	jobForm.submit();
	flag==''
	
}
//전체조회
var allList = function () {
	var jobForm=$('#jobForm');
	jobForm.find("[name='page']").val(paging);
	jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
	jobForm.find("[name='keyword']").val($('input[name="keyword"]').val());	
	jobForm.attr("method","post");
	jobForm.attr("action","list")

	jobForm.submit();
	flag==''


}
//등록 폼 여는 버튼
$('#write').on('click', function() {
	var rule = $('#authority').val();
	if(rule == 'PROFESSOR' || rule == 'ADMIN'){
		$('#noRule').css('display','inline')
	}
	else{
	var form = $('#infoForm');
	form.attr("action","registForm");
	form.submit();
	}
})
// 등록 버튼
$('#regist').on('click', function(e){
	
	var form = document.regist;
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

function promp(qno,type,writer,authority){
	var id = $('#member_id').val();
	if(id == writer){
		var form = $('#infoForm');
		form.attr("action","detail");
		form.attr("method", "Post");
		form.append($('<input/>', {type: 'hidden', name: 'qna_no', value:qno }));
		form.submit();
		
	}else if(authority == 'PROFESSOR'){
		var form = $('#infoForm');
		form.attr("action","detail");
		form.attr("method", "Post");
		form.append($('<input/>', {type: 'hidden', name: 'qna_no', value:qno }));
		form.submit();
		
		
	}else if(type == '비밀글'){
		
		var form = $('#infoForm');
		form.attr("action","checkForm");
		form.attr("method", "Post");
		form.append($('<input/>', {type: 'hidden', name: 'qna_no', value:qno }));
		form.submit();
			
	}else{
		var form = $('#infoForm');
		form.attr("action","detail");
		form.attr("method", "Post");
		form.append($('<input/>', {type: 'hidden', name: 'qna_no', value:qno }));
		form.submit();
	}
}

$('#modifyBtn').on('click',function(){

	var form = $('#modify');
	var title = $('#title').val();
	var content = $('#content').val();
	
	if(title.length > 50){
		alert('제목은 50자를 넘을 수 없습니다')
		return false
	}
	
	if(content.length > 1000){
		alert('내용은은 1000자를 넘을 수 없습니다')
		return false
	}
	form.submit();
});

</script>