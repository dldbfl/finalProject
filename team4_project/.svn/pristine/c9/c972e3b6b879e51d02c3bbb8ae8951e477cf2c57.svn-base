<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
    
    
<script>
//검색란에서 입력시
function enterkey(){
	if (window.event.keyCode == 13) {
		 
		var form=$('#infoForm');
		form.submit();

   }

}
//버튼 클릭 및 페이지 이동 버튼
function searchList_go(){
	var form=$('#infoForm');
	form.submit();
}


//등록 폼 여는 버튼
$('#write').on('click', function() {
	var form = $('#infoForm');
	form.attr("action","registForm");
	form.submit();
})


//체크된 문서자료 삭제
$('#delete').on('click',function(){
	

	var bool = confirm('선택된 자료를 삭제 합니다');
	if(bool){
		$('input:checkbox[id="document_checked"]:checked').each(function(i){
			var dno = $(this).val();
		
	$.ajax({
		url : "<%=request.getContextPath()%>/pds/document/remove",
				 type : "post",
				 data: JSON.stringify(dno),
				 contentType: "application/json; charset=utf-8;",
           		 dataType: "json",
           		 success:function(res){
    		
    			},
    			error:function(error){
    			
    			}
			});
		});
   			alert("자료를  삭제했습니다");
   			location.reload();
	}
});


</script>