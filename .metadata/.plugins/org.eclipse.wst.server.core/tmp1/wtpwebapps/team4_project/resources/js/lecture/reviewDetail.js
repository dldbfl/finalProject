new Swiper('.swiper-container', {

	slidesPerView : 2, // 동시에 보여줄 슬라이드 갯수
	spaceBetween : 10, // 슬라이드간 간격
	slidesPerGroup : 2, // 그룹으로 묶을 수, slidesPerView 와 같은 값을 지정하는게 좋음

	// 그룹수가 맞지 않을 경우 빈칸으로 메우기
	// 3개가 나와야 되는데 1개만 있다면 2개는 빈칸으로 채워서 3개를 만듬
	loopFillGroupWithBlank : true,

	loop : true, // 무한 반복

	pagination : { // 페이징
		el : '.swiper-pagination',
		clickable : true, // 페이징을 클릭하면 해당 영역으로 이동, 필요시 지정해 줘야 기능 작동
	},
	navigation : { // 네비게이션
		nextEl : '.swiper-button-next', // 다음 버튼 클래스명
		prevEl : '.swiper-button-prev', // 이번 버튼 클래스명
	},
});

$('#listBack').on('click', function(){
  	var form = $('#jobForm');
	form.attr("action","list")
	
	form.submit();
});


 
 function deleteReview(rno){
	 	
	 	var res = confirm('정말 후기를 삭제하시겠습니까?')
	 	
	 	if(res){
	 	$('#review_no').attr('value',rno);
	 	alert($('#review_no').val())
		var form = $('#jobForm');
		form.attr("action","delete")
		alert('후기를 삭제했습니다.')
		form.submit();
	 	}else {
			return false;
		}
 }
 
 function modifyReview(rno){
	 	$('#modifyNo').attr('value',rno);
	 	$('#detail').attr('style','display:none;')
		$('.head').text('수정하기')
		$('#modifyForm').attr('style','""')
		// 새로고침 금지
		function noRefresh()
		{
		    if (event.keyCode == 116) 
		    {
		        alert("새로고침을 할 수 없습니다.");
		        event.keyCode = 2;
		        return false;
		    } 
		    else if(event.ctrlKey && (event.keyCode == 78 || event.keyCode == 82)) 
		    {
		        return false;
		    }
		}
		document.onkeydown = noRefresh;
	 		 	
}
 
$('#modifyBtn').on('click',function(){
	var form = $('#modifyForm');
//	var content = $('content').val();
//	var title =$('#modify_review_title').val();
//	if(title.length < 0){
//		alert('제목을 입력해주세요')
//		return false;
//	}
//	
//	if(title.length > 50){
//		alert('제목은 50자 미만으로 입력해주세요')
//		return false;
//	}
//	
//	if(content.length < 0){
//		alert('내용을 입력해주세요')
//		return false;
//	}
//	
//	if(content.length > 1000){
//		alert('내용은 1000자 미만으로 입력해주세요')
//		return false;
//	}
	alert('후기를 수정했습니다.')
	form.submit();
});
 