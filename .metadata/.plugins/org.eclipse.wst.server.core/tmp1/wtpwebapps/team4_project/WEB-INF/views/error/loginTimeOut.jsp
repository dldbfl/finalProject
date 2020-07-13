<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>로그인 시간초과</title>
<meta charset="UTF-8">
<style>
	.h3Resurlt{
	    text-align: center;
	    margin-top: 281px;
	} 	
</style>
<body>
<h3 class='h3Resurlt'></h3>
<script>

setTimeout(function() {
    //카운트 시작 숫자
    var count = 3;
    //카운트다운함수
    var countdown = setInterval(function(){
    //해당 태그에 아래 내용을 출력
    $(".h3Resurlt").html("<div class='logoImge'></div><b><p>비정상적인 작동이 감지되어</p></b><b><font color='blue' size='66pt'>"+ count + "</font><b><p>초 후  로그인화면으로 이동 합니다.</p>");
        //0초면 초기화 후 이동되는 사이트
        if (count == 0) {
            clearInterval(countdown);
    		location.href="<%=request.getContextPath()%>/main";
            }
        count--;//카운트 감소
    }, 1000);
},1)
</script>
</body>
