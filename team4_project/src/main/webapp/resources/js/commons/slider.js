	//	메인화면  이미지 슬라이드 작업
	//	https://slidesjs.com  옵션 기능 추가시 참조  
	$(function() {
	  $('#slides').slidesjs({
	    width: 900,
	    height: 140,
	    play: {
	      active: true,
	      auto: true,
	      interval: 4000,
	      swap: true
	    }
	  });
	});
