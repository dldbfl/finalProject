	
	//메인화면 시계
	var clockStart = setInterval(function() {

	var today = new Date();
	
	var dayList = ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'];//일요일0 ~ 토요일 6

	var hh = addZero(today.getHours());				// 시간
	var mm = addZero(today.getMinutes()); 			// 분
	var ss = addZero(today.getSeconds());			// 초
	
	var YY = today.getFullYear(); 					// 연도
	var MM = today.getMonth()+1;					// 월	년도는 0부터시작
	var DD = today.getDate();	 					// 일


	document.getElementById('hours').innerText = hh
	document.getElementById('min').innerText = mm
	document.getElementById('sec').innerText = ss
	document.getElementById('month').innerText = MM
	document.getElementById('date').innerText = DD
	document.getElementById('year').innerText = YY
	
	//숫자가 10보다 작으면 앞에 '0'을 붙이고 10보다 크면 ''를 붙여서 string 타입으로 return
	function addZero(num) {
		return (num < 10 ? '0'+num : ''+num);
		}
}, 1000)