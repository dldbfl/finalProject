  var mySwiper = new Swiper ('.swiper-container', {
    // Optional parameters
    direction: 'horizontal',
    loop: true,

    autoplay : { // 자동 재생
    	delay : 1500, // 딜레이 0
    },
    speed : 2000, // 슬라이드 속도 2초
    // Navigation arrows
    navigation: {
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    },
	pagination : { // 페이징 설정
		el : '.swiper-pagination',
		clickable : true, // 페이징을 클릭하면 해당 영역으로 이동, 필요시 지정해 줘야 기능 작동
	},
  })
  
  function searchList_go(page,url){
	$('#memId').attr('value','')  
	var jobForm=$('#jobForm');
	jobForm.find("[name='page']").val(page);
	jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
	jobForm.find("[name='keyword']").val($('div.input-group>input[name="keyword"]').val());
	jobForm.attr("method","post");
	if(url){
		jobForm.attr("action",url)
	}else{
		jobForm.attr("action","list")
		
		if($("input:checkbox[id=chk]").is(":checked") == true) {
			jobForm.attr("action","photolist")
		}
	}
	
	jobForm.submit();
}
  function myList(member_id){
	  $('#memId').attr('value',member_id)
	  
	  if(member_id == ''){
		 $('#noLogin').attr('style','display:block');
		  return;
	  }
	  
	  var jobForm=$('#jobForm');
		jobForm.find("[name='page']").val();
		jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
		jobForm.find("[name='keyword']").val($('#keyword').val());
		jobForm.attr("method","post");
		jobForm.attr("action","myList")
		
		if($("input:checkbox[id=chk]").is(":checked") == true) {
			jobForm.attr("action","photolist")
		}
		jobForm.submit();
  }

  function like(rno,id){
	  if(id == ''){
		  $('#noLogin').attr('style','display:block');
		  return false;
	  }
	  $.ajax({
		 url:"likecount",
		 data:{"lecture_review_no":rno,"like_id":id},
		 type:"post",
		 success:function(res){
			 if(res == 'up'){
				 alert('좋아요를 눌렀습니다')
				 location.reload();
			 }
			 if(res == 'down'){
				 alert('좋아요를 취소했습니다')
				 location.reload();
			 }
		 }
	  });
  }
  
  function detail(rno){
	 $('#review_no').attr('value',rno);
	 
	 var jobForm=$('#jobForm');
		jobForm.find("[name='page']").val();
		jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
		jobForm.find("[name='keyword']").val($('#keyword').val());
		jobForm.attr("method","post");
		jobForm.attr("action","detail");
		jobForm.submit();
  }