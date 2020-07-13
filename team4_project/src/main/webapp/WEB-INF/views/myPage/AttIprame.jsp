<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">
html{
height: 100%;
width: 100%;
}
body{
height: 100%;
width: 100%;
margin: 0px;
margin-top: -35px;
}
td {
	height: 100%;
	text-align: center;
	font-size: 20px;
	font-weight: bold;
	border: none;
	border-radius: 50px; /*모서리 둥글게*/
	/* background-color: #f5f5f5; */
}
table{
	width:100%;
	border: none;
}

aside{
display: none;
}
#wrap{
height: 265px;
margin-top: 0px;
margin-bottom: 0px;
}
footer{
display: none;
}
/* section{
width: 100%;
height: 100%;
min-height: 202px;
} */
section#main-container{
min-height: 0px;
margin: 0px;
width: 100%;
height: 100%;

}
img {
display: block; 
margin-left: 20px;

}

.hover3:hover{ 
box-shadow: 0 80px 0 0 rgba(0,0,0,0.25) inset, 0 -80px 0 0 rgba(0,0,0,0.25) inset; 
}

header {
    width: 100%;
    position: fixed;
    z-index: 100;
    display: none;
}
</style>
<script type="text/javascript">
	
	
	var today = new Date();//오늘 날짜//내 컴퓨터 로컬을 기준으로 today에 Date 객체를 넣어줌
	var date = new Date();//today의 Date를 세어주는 역할
	
	
	
	function prevCalendar() {//이전 달
		// 이전 달을 today에 값을 저장하고 달력에 today를 넣어줌
		//today.getFullYear() 현재 년도//today.getMonth() 월  //today.getDate() 일 
		//getMonth()는 현재 달을 받아 오므로 이전달을 출력하려면 -1을 해줘야함
		today = new Date(today.getFullYear(), today.getMonth() - 1, today
				.getDate());
		buildCalendar(); //달력 cell 만들어 출력 
	}

	function nextCalendar() {//다음 달
		// 다음 달을 today에 값을 저장하고 달력에 today 넣어줌
		//today.getFullYear() 현재 년도//today.getMonth() 월  //today.getDate() 일 
		//getMonth()는 현재 달을 받아 오므로 다음달을 출력하려면 +1을 해줘야함
		today = new Date(today.getFullYear(), today.getMonth() + 1, today.getDate());
		buildCalendar();//달력 cell 만들어 출력
	}
	
	
	
	
	function buildCalendar() {//현재 달 달력 만들기
		var doMonth = new Date(today.getFullYear(), today.getMonth(), 1);
		//이번 달의 첫째 날,
		//new를 쓰는 이유 : new를 쓰면 이번달의 로컬 월을 정확하게 받아온다.     
		//new를 쓰지 않았을때 이번달을 받아오려면 +1을 해줘야한다. 
		//왜냐면 getMonth()는 0~11을 반환하기 때문
		var lastDate = new Date(today.getFullYear(), today.getMonth() + 1, 0);
		//이번 달의 마지막 날
		//new를 써주면 정확한 월을 가져옴, getMonth()+1을 해주면 다음달로 넘어가는데
		//day를 1부터 시작하는게 아니라 0부터 시작하기 때문에 
		//대로 된 다음달 시작일(1일)은 못가져오고 1 전인 0, 즉 전달 마지막일 을 가져오게 된다
		var tbCalendar = document.getElementById("calendar");
		//날짜를 찍을 테이블 변수 만듬, 일 까지 다 찍힘
		var tbCalendarYM = document.getElementById("tbCalendarYM");
		//테이블에 정확한 날짜 찍는 변수
		//innerHTML : js 언어를 HTML의 권장 표준 언어로 바꾼다
		//new를 찍지 않아서 month는 +1을 더해줘야 한다. 
		tbCalendarYM.innerHTML = today.getFullYear() + "년 "
				+ (today.getMonth() + 1) + "월";

		/*while은 이번달이 끝나면 다음달로 넘겨주는 역할*/
		while (tbCalendar.rows.length > 2) {
			//열을 지워줌
			//기본 열 크기는 body 부분에서 2로 고정되어 있다.
			tbCalendar.deleteRow(tbCalendar.rows.length - 1);
			//테이블의 tr 갯수 만큼의 열 묶음은 -1칸 해줘야지 
			//30일 이후로 담을달에 순서대로 열이 계속 이어진다.
		}
		var row = null;
		row = tbCalendar.insertRow();
		//테이블에 새로운 열 삽입//즉, 초기화
		var cnt = 0;// count, 셀의 갯수를 세어주는 역할
		// 1일이 시작되는 칸을 맞추어 줌
		for (i = 0; i < doMonth.getDay(); i++) {
			/*이번달의 day만큼 돌림*/
			cell = row.insertCell();//열 한칸한칸 계속 만들어주는 역할
			cnt = cnt + 1;//열의 갯수를 계속 다음으로 위치하게 해주는 역할
		}
		/*달력 출력*/
		for (i = 1; i <= lastDate.getDate(); i++) {
			//1일부터 마지막 일까지 돌림
			cell = row.insertCell();//열 한칸한칸 계속 만들어주는 역할
			cell.setAttribute("class", "days"+i);
			cell.innerHTML = i;//셀을 1부터 마지막 day까지 HTML 문법에 넣어줌
			cnt = cnt + 1;//열의 갯수를 계속 다음으로 위치하게 해주는 역할
			if (cnt % 7 == 1) {/*일요일 계산*/
				//1주일이 7일 이므로 일요일 구하기
				//월화수목금토일을 7로 나눴을때 나머지가 1이면 cnt가 1번째에 위치함을 의미한다
				cell.innerHTML = "<font color=#F79DC2>" + i
				//1번째의 cell에만 색칠
			}
			if (cnt % 7 == 0) {/* 1주일이 7일 이므로 토요일 구하기*/
				//월화수목금토일을 7로 나눴을때 나머지가 0이면 cnt가 7번째에 위치함을 의미한다
				cell.innerHTML = "<font color=skyblue>" + i
				//7번째의 cell에만 색칠
				row = calendar.insertRow();
				//토요일 다음에 올 셀을 추가
			}
			/*오늘의 날짜에 노란색 칠하기*/
			if (today.getFullYear() == date.getFullYear()
					&& today.getMonth() == date.getMonth()
					&& i == date.getDate()) {
				//달력에 있는 년,달과 내 컴퓨터의 로컬 년,달이 같고, 일이 오늘의 일과 같으면
				cell.bgColor = "#add1ff";//셀의 배경색
			}
		}
		
	 // DB에 날짜 비교해서 값 넣어주는 부분		
	 var lastDate = new Date(today.getFullYear(), today.getMonth() + 1, 0);
    	 
    	 $(function(){
    		<c:forEach var="lecture_attend" items="${lecture_attend}">
    		
    		var lecture_attend1 = "${lecture_attend.lecture_attend_date}";
   		    var lecture_attend2 = lecture_attend1.split(' ');
   		    var day = lecture_attend2[2];
   		    
   			day = (day < 10 ? day.substr(1) : day);
    	 
   		 	var month = lecture_attend2[1];
   		 	
   		 	var Jan = 'Jan';
   		 	var Feb = 'Feb';
   		 	var Mar = 'Mar';
   		 	var Apr = 'Apr';
   		 	var May = 'May';
   		 	var Jun = 'Jun';
   		 	var Jul = 'Jul';
   		 	var Aug = 'Aug';
   		 	var Sep = 'Sep';
   		 	var Oct = 'Oct';
   		 	var Nov = 'Nov';
   		 	var Dec = 'Dec';
   		 	
   		 	if (month == Jan) {
   			month = '1';
			}else if(month == Feb){
			month = '2';
			}else if(month == Mar){
				month = '3';				
			}else if(month == Apr){
				month = '4';		
			}else if(month == May){
				month = '5';		
			}else if(month == Jun){
				month = '6';		
			}else if(month == Jul){
				month = '7';		
			}else if(month == Aug){
				month = '8';		
			}else if(month == Sep){
				month = '9';		
			}else if(month == Oct){
				month = '10';			
			}else if(month == Nov){
				month = '11';		
			}else if(month == Dec){
				month = '12';		
			}
				
   		 	var year = lecture_attend2[5];
   		 	
   		 	var ymd = year+"-"+month+"-"+day;
   		 	
   		 	var staus = "${lecture_attend.lecture_attend_status}"
    		 	
    		var check = "출석";
    		var noCheck = "미출석"; 
   		 	
		    	 for(var j = 1; j < lastDate.getDate()+1; j++) {
		    		
		    		 	var yearMonths = $("#tbCalendarYM").text().split(/[년월]/);
		    	     	var month = yearMonths[1].trim();
		    	     	
		    	     	var calDate = $('[class="days' + j + '"]').text();
			    		var cal = $('[class="days' + j + '"]');
			   		   
		    	     	var selectDate = yearMonths[0] + "-" + month + "-"  + calDate;
		    		
		    	    
		    	     	
	    	     	if (selectDate == ymd && staus == check) {
		    			cal.css('background-image','url("<%=request.getContextPath() %>/resources/uploadImg/출첵표시.jpg")');
		    			cal.css('background-repeat','no-repeat');
		    			cal.css('background-position','center');
		    			
					}else if(selectDate == ymd && staus == noCheck){
						cal.css('background-image','url("<%=request.getContextPath() %>/resources/uploadImg/엑스표시.png")');
		    			cal.css('background-repeat','no-repeat');
		    			cal.css('background-position','center');
					}
	    	     	
	    	     
	    	     	
	    	     	
		    	}
	</c:forEach>
		});

	}
</script>
<body>




	<div style="width: 100%;border: none;margin-top: 40px;">
		<table class="" id="calendar" calendarr="3" align="center"
			style="border-color: #3333FF; height: 100%">
			<tr>
				<!-- label은 마우스로 클릭을 편하게 해줌 -->
				<td><label><i onclick="prevCalendar()" class="glyphicon glyphicon-triangle-left hover3"></i></label></td>
				<td align="center" id="tbCalendarYM" colspan="5">yyyy년 m월</td>
				<td><label><i onclick="nextCalendar()" class="glyphicon glyphicon-triangle-right hover3"></i> </label></td>
			</tr>
			<tr>
				<td align="center"><font color="red">일</td>
				<td align="center">월</td>
				<td align="center">화</td>
				<td align="center">수</td>
				<td align="center">목</td>
				<td align="center">금</td>
				<td align="center"><font color="blue">토</td>
			</tr>
			
		</table><br>
	</div>
	<br>
	
	<script language="javascript" type="text/javascript">
		buildCalendar();
	</script>
</body>

