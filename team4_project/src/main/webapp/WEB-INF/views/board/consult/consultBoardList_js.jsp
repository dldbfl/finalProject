<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
    
    
<script>
var paging = $('[name=page]').val();
var perPageNum = $('[name="perPageNum"]').val();
var searchType = $('[name="searchType"]').val();
var keyword = $('[name=keyword]').val();

//검색란에서 입력시
//검색란에서 입력시
function enterkey(page,flag){
	if (window.event.keyCode == 13) {
		 
		var jobForm=$('#infoForm');
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
		location.href="registList?page="+paging+"&perPageNum="+perPageNum+"&searchType="+searchType+"&keyword="+keyword;
		
}
//답변 미등록 글 조회
var nonRegistAnswer = function () {
	
	location.href="noRegistList?page="+paging+"&perPageNum="+perPageNum+"&searchType="+searchType+"&keyword="+keyword;
}
//전체조회
var allList = function () {
	
	location.href="list?page="+paging+"&perPageNum="+perPageNum+"&searchType="+searchType+"&keyword="+keyword;
}
//등록 폼 여는 버튼
$('#write').on('click', function() {

	var form = $('#infoForm');
	form.attr("action","registForm");
	form.submit();
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
	location.href="list";

 	});

function promp(consult_no,consult_type){
	
	if(consult_type == '비밀글'){
		var form = $('#infoForm');
		form.attr("action","checkForm");
		form.attr("method", "Post");
		form.append($('<input/>', {type: 'hidden', name: 'consult_no', value:consult_no }));
		form.submit();
		
		
				
	}else{
		var form = $('#infoForm');
		form.attr("action","detail");
		form.attr("method", "Post");
		form.append($('<input/>', {type: 'hidden', name: 'consult_no', value:consult_no }));
		form.submit();
	}
}

</script>