<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
    
    
<script>
var paging = $('#page').val();
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

//답변 등록글 조회
var registAnswer = function() {
	    $('#status').attr('')
	    var jobForm=$('#infoForm');
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

	var jobForm=$('#infoForm');
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

	var jobForm=$('#infoForm');
	jobForm.find("[name='page']").val(paging);
	jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
	jobForm.find("[name='keyword']").val($('input[name="keyword"]').val());	
	jobForm.attr("method","post");
	jobForm.attr("action","list")
	jobForm.submit();
	flag==''


}

//닫기 버튼
$('#close').on('click', function(){
	history.go(-1);

 	});

function detail(qno){
	
		var form = $('#infoForm');
		form.attr("action","detail");
		form.attr("method", "Post");
		form.append($('<input/>', {type: 'hidden', name: 'qna_no', value:qno }));
		form.submit();
	}

</script>