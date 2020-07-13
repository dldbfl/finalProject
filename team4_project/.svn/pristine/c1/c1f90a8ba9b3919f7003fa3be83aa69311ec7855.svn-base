<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
body{

}

.profileImg {
	border-radius: 50%;
	background-repeat: no-repeat;
	background-size: cover;
	width: 120px;
	height: 120px;
	margin-left: 15px;
	margin-top: 12px;
	float: left;
}

.profileDiv {
	border: 1px solid #b6b6ff;
	border-radius: 5px;
	width: 49.5%;
	height: 260px;
	background-color: white;
	float: left;
}

.profileDiv1 {
	width: 75%;
	height: 60%;
	float: right;
}

.profileDiv2 {
	width: 100%;
	height: 30%;
	margin-top: 155px;
}

.calendar {
	border: 1px solid #b6b6ff;
	border-radius: 5px;
	width: 49.5%;
	height: 260px;
	background-color: white;
	float: left;
	margin-left: 10px;
}

#myInfoBtn {
    background-color: #5371e4;
    border: 1px solid #1b00ff;
    width: 84px;
    height: 25px;
    border-radius: 5px;
    color: #ffffff;
    position: relative;
    left: -110px;
    top: -19px;
    font-size: x-small;
}

.progress {
	position: relative;
	left: 23px;
	top: 9px;
}

.btns {
    width: 22%;
    height: 39px;
    margin-left: 4px;
    border: 2px solid #5c7fff;
    background-color: #ffffff;
    border-radius: 5px;
    font-weight: bold;
    color: #5c7fff;
    font-size: 17px;
}

.profileLabel {
	font-size: medium;
	margin: 0px;
	margin-left: 20px;
}

input {
	border: none;
	font-size: small;
	padding-bottom: 5px;
}

.myBoardList {
	border: 1px solid #b6b6ff;
	border-radius: 5px;
	width: 100%;
	height: 475px;
	background-color: white;
	margin-top: 265px;
	margin-bottom: 30px;
}

.listDiv {
	height: 200px;
	width: 48.6%;
	margin-left: 10px;
	margin-top: 8px;
	float: left;
	border-radius: 5px;
}

.listDiv1 {
	height: 200px;
	width: 48.6%;
	margin-top: 8px;
	margin-left: 10px;
	float: left;
	border-radius: 5px;
}

.listDiv2 {
	height: 200px;
	width: 48.6%;
	margin-top: 20px;
	margin-left: 10px;
	float: left;
	border-radius: 5px;
}

.listDiv3 {
	height: 200px;
	width: 48.6%;
	margin-top: 20px;
	margin-left: 10px;
	float: left;
	border-radius: 5px;
}

.tableList {
	border: 1px solid black;
}

.listInDiv {
	border: 1px solid #b6b6ff;
	border-radius: 5px;
	height: 90%;
}

.hover3:hover {
	box-shadow: 0 80px 0 0 rgba(0, 0, 0, 0.25) inset, 0 -80px 0 0
		rgba(0, 0, 0, 0.25) inset;
}

section#main-container {
    height: auto;
    margin-top: 19px;
    min-height: 663px;
    font-size: 20px;
}
</style>
<body><br>


<div class="profileDiv">
<div style="width: 100%; background-color: #4636cc;height: 23px;border-radius: 5px 5px 0px 0px;font-size: medium;font-weight: bold;color: white;text-align: center;">&nbsp;나의 정보
</div>


	<div>
		<img class="profileImg" >
	</div>
	
	<div class="profileDiv1" >
		<div style="height: 25px;"></div>
		<label class="profileLabel" >아이디</label><input style="margin-left: 59px;width: 68%;" value="${loginUser.member_id }"><br>
		<label class="profileLabel">이름</label><input style="margin-left: 75px;width: 68%;" value="${loginUser.member_name }"><br>
		<label class="profileLabel">주소</label><input style="margin-left: 75px;width: 68%;" value="${loginUser.member_address1 }${loginUser.member_address2 }"><br>
		<label class="profileLabel">이메일 주소</label><input style="margin-left: 24px;width: 68%;" value="${loginUser.member_email }">
		<button class="btns hover3" type="button" id="myInfoBtn" onclick='location.href="<%=request.getContextPath() %>/myPage/myInfoModify"'>&nbsp;&nbsp;내정보 수정 &nbsp;&nbsp;<i class="glyphicon glyphicon-pencil"></i></button>
	</div>


	<div class="profileDiv2"><br>
		
		<button class="btns hover3" type="button" style="margin-left: 22px;" onclick='location.href="<%=request.getContextPath() %>/myPage/favoriteLecture"'>즐겨찾는 강의</button>
		<button class="btns hover3" type="button" onclick='location.href="<%=request.getContextPath() %>/myPage/proposal/list"'>창업계획서</button>
		<button class="btns hover3" type="button" onclick='location.href="<%=request.getContextPath() %>/myPage/pay/list"'>수강신청내역</button>
		<button class="btns hover3" type="button" onclick='location.href="<%=request.getContextPath() %>/myPage/memberOutConfirm"'>회원탈퇴</button>
	</div>
	
</div>

<div class="calendar">
<div style="width: 100%; background-color: #4636cc;height: 23px;border-radius: 5px 5px 0px 0px;font-size: medium;font-weight: bold;color: white;text-align: center;">&nbsp;출석</div>
	<iframe style="float: left;" frameborder="0" scrolling="no" height="230px" width="50%" src="http://localhost/myPage/AttIprame"></iframe>
	
	
	
<div style="float: left;width:50%;height: 230px;margin-top: 15px;">

<input id="qwe" style="width: 100%; background-color: white; font-weight: bold;" disabled="disabled" >
<div id="circle3" class="circleChart" style="height: 50%;width: 50%;float: left;"></div>
<div id="circle4" class="circleChart" style="height: 50%;width: 50%;float: left;"></div>



<div style="margin-top: 114px; width: 95%; height: 31%; background-color: #edf6fb; margin-left: 8px; border-radius: 5px; border: 1px solid #5c7fff">
	<input id="qwe1" style="width: 90%; background-color: white; background-color: #edf6fb;margin-top: 5px; margin-left: 15px; font-size: small; padding: 0px" disabled="disabled">
	<input id="qwe2" style="width: 90%; background-color: white; background-color: #edf6fb;margin-left: 15px; font-size: medium; padding: 0px" disabled="disabled">
	<input id="qwe3" style="width: 90%; background-color: white; background-color: #edf6fb;margin-left: 15px; font-size: small; padding: 0px;" disabled="disabled">
</div>

</div>
</div>


<div class="myBoardList">
<div style="width: 100%; background-color: #4636cc;height: 23px;border-radius: 5px 5px 0px 0px;font-size: medium;font-weight: bold;color: white;text-align: center;">&nbsp;나의 게시글</div>



	<div class="listDiv">
		<label>자유게시판</label>&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/board/free" style="color: #6f6de0;float: right;font-weight: bold;font-size: medium;">+&nbsp;전체보기</a><br>
			<div class="listInDiv">
				<div style="margin: 10px;height: 158px;overflow-y: scroll;">
				
				  <c:set var="free" value="${free}"/>
					 <c:if test="${empty free}" >
					  	<p style="margin-top: 70px;margin-left: 165px;font-weight: bold;color: gray;">작성한 게시물이 없습니다.</p>
					 </c:if>
				
					 <c:forEach items="${free}" var="freeboard">
					    -&nbsp;<a href="<%=request.getContextPath()%>/board/free/detail?freeboard_no=${freeboard.freeboard_no }" style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${freeboard.freeboard_title }</a><br>
					 </c:forEach>
					 
				</div> 
			</div>
	</div>
	
	<div class="listDiv1">
		<label>QnA</label>&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/board/qna/list" style="color: #6f6de0;float: right;font-weight: bold;font-size: medium;">+&nbsp;전체보기</a><br>
			<div class="listInDiv">
				<div style="margin: 10px;height: 158px;overflow-y: scroll;">
			    <c:set var="qna" value="${qna}"/>
					 <c:if test="${empty qna}" >
					 	<p style="margin-top: 70px;margin-left: 165px;font-weight: bold;color: gray;">작성한 게시물이 없습니다.</p>
					 </c:if>
				
					 <c:forEach items="${qna}" var="qna">
					    -&nbsp;<a href="<%=request.getContextPath()%>/board/qna/detail?qna_no=${qna.qna_no }" style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${qna.qna_title }</a><br>
					 </c:forEach>
			  	</div>
		 	</div>
	</div>
		
	<div class="listDiv2">
		<label>창업후기</label>&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/board/foundReviewList" style="color: #6f6de0;float: right;font-weight: bold;font-size: medium;">+&nbsp;전체보기</a><br>
			<div class="listInDiv">
				 <div style="margin: 10px;height: 158px;overflow-y: scroll;">
				 
				 <c:set var="founded_review" value="${founded_review}"/>
					 <c:if test="${empty founded_review}" >
					 	<p style="margin-top: 70px;margin-left: 165px;font-weight: bold;color: gray;">작성한 게시물이 없습니다.</p>
					 </c:if>
				 
					 <c:forEach items="${founded_review}" var="founded_review">
				          -&nbsp;<a href="<%=request.getContextPath()%>/board/foundedReview/detail?founded_review_no=${founded_review.founded_review_no }" style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${founded_review.founded_review_title }</a><br>
				     </c:forEach>
				     
			     </div>
		     </div>
	</div>
	
	<div class="listDiv3">
		<label>상담문의</label>&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/board/consult/list"style="color: #6f6de0;float: right;font-weight: bold;font-size: medium;">+&nbsp;전체보기</a><br>
			<div class="listInDiv">
				 <div style="margin: 10px;height: 158px;overflow-y: scroll;">
				 
				  <c:set var="consult" value="${consult}"/>
					 <c:if test="${empty consult}" >
					 	<p style="margin-top: 70px;margin-left: 165px;font-weight: bold;color: gray;">작성한 게시물이 없습니다.</p>
					 </c:if>
					 
					 <c:forEach items="${consult}" var="consult" >
				        -&nbsp;<a href="<%=request.getContextPath()%>/board/consult/detail?consult_no=${consult.consult_no }" style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${consult.consult_title }</a><br>
					 </c:forEach>
				 </div>
		    </div>
	</div>

</div>
<%-- <c:forEach items="${lecture}" var="lecture">
var asd = "${lecture.lecture_progress}";
</c:forEach>
alert(asd); --%>

<script>
$(".profileImg").attr("src", "<%=request.getContextPath()%>/myPage/profile")
.css("background-position", "center")
.css("background-size", "100% 100%"); 


<c:forEach items="${lecture}" var="lecture">
var lectureStart = "${lecture.lecture_progress }";
var lectureFinish = "${lecture.lecture_end }";
</c:forEach>

<c:set var="lecture_attend" value="${lecture_attend}"/>
	<c:if test="${not empty lecture_attend}" >
	

var lectureIndex = lectureFinish.split(' ');
var year = lectureIndex[5];
var month = lectureIndex[1];
var day = lectureIndex[2];

var lectureIndex1 = lectureStart.split(' ');
var year1 = lectureIndex1[5];
var month1 = lectureIndex1[1];
var day1 = lectureIndex1[2];

var now = new Date();    // 현재일

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
	
	if (month1 == Jan) {
	month1 = '1';
}else if(month1 == Feb){
	month1 = '2';
}else if(month1 == Mar){
	month1 = '3';				
}else if(month1 == Apr){
	month1 = '4';		
}else if(month1 == May){
	month1 = '5';		
}else if(month1 == Jun){
	month1 = '6';		
}else if(month1 == Jul){
	month1 = '7';		
}else if(month1 == Aug){
	month1 = '8';		
}else if(month1 == Sep){
	month1 = '9';		
}else if(month1 == Oct){
	month1 = '10';			
}else if(month1 == Nov){
	month1 = '11';		
}else if(month1 == Dec){
	month1 = '12';		
}


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
	

var finishDay = new Date(year, month-1, day); // 강의 종료일 
var D_day = now.getTime() - finishDay.getTime();    
var result = Math.floor(D_day / (1000 * 60 * 60 * 24)) * -1;    




 
 
 
var startDay = new Date(year1, month1-1, day1); // 강의 시작일
var finishDay1 = new Date(year, month-1, day); // 강의 종료일 

var D_day1 = startDay.getTime() - finishDay1.getTime();    
 
var result1 = Math.floor(D_day1 / (1000 * 60 * 60 * 24)) * -1;    
 
$("#qwe").attr("value", "          진행율 " + "                    출석율"); // d-day
var complateDay = startDay.getTime() - now.getTime();  
var result2 = Math.floor(complateDay / (1000 * 60 * 60 * 24)) * -1;   //지금까지일수
 
var per = result2/result1*100;

/* $("#qwe1").attr("value", "전체기간 " + result1 + "일 중 " + result2 + "일째 되는 날입니다."); // d-day */

 


var attenSuc = 0;
var attenFail = 0;
var lectCnt = 0;
var totalLecture =20;

<c:forEach var="lecture_attend" items="${lecture_attend}">

	var lecture_attend = "${lecture_attend.lecture_attend_status}";
	var lectAtt = "${lecture_attend.student_id}";
	var member_id = "${loginUser.member_id}";
	
	if(lectAtt == member_id){
		lectCnt++
	}
	
	if(lecture_attend == "출석"){
		attenSuc++
	}
	if(lecture_attend == "미출석"){
		attenFail++
	}

</c:forEach>

var attenPer = attenSuc/result2*100;
$("#qwe3").attr("value", " " + (lectCnt + 1) + "번째 강의가 준비중입니다.") // d-day 
		  .css("position", "relative")
		  .css("left", "1px")
	   	  .css("top", "-17px")
		  .css("font-size", "small");



/* $("#qwe1").attr("value", "전체기간 " + result1 + "일 중 " + result2 + "일째 되는 날입니다."); */
$("#qwe1").attr("value", " 전체 강의수 : " + totalLecture + "   남은 강의 : " + (totalLecture - lectCnt));
		 
				
$("#qwe2").attr("value", " 출석  : " + attenSuc + "일   결석 : " + attenFail + "일")
		  .css("position", "relative")
		  .css("left", "0px")
		  .css("top", "-9px")
		  .css("font-size", "small");

var lecPer = lectCnt/totalLecture*100;
var attPer = attenSuc/lectCnt*100;
var lPer = lectCnt/totalLecture*100;
var aPer = attenSuc/lectCnt*100;
</c:if>


<c:set var="lecture_attend" value="${lecture_attend}"/>
<c:if test="${empty lecture_attend}" >
	var lecPer = 0;
	var attPer = 0;
	var lPer = 1;
	var aPer = 1;
	$("#qwe2").attr("value", " 현재 진행중인 강의가 없습니다.")
			  .css("margin-left", "15px")	
			  .css("margin-top", "27px")	
			  .css("width", "90%");	
	$("#qwe").attr("value", "          진행율 " + "                    출석율") // d-day
			 .css("font-size", "medium");	
	$("#qwe3").css("display", "none");
	$("#qwe1").css("display", "none");
</c:if>

//circleCharts.js
!function(a){"use strict";a.fn.circleChart=function(b){const c={color:"#3459eb",backgroundColor:"#e6e6e6",background:!0,speed:2e3,widthRatio:.2,value:66,unit:"percent",counterclockwise:!1,size:110,startAngle:0,animate:!0,backgroundFix:!0,lineCap:"round",animation:"easeInOutCubic",text:!1,redraw:!1,cAngle:0,textCenter:!0,textSize:!1,textWeight:"normal",textFamily:"sans-serif",relativeTextSize:1/7,autoCss:!0,onDraw:!1};Math.linearTween=((a,b,c,d)=>c*a/d+b),Math.easeInQuad=((a,b,c,d)=>{a/=d;return c*a*a+b}),Math.easeOutQuad=((a,b,c,d)=>{a/=d;return-c*a*(a-2)+b}),Math.easeInOutQuad=((a,b,c,d)=>{a/=d/2;if(a<1)return c/2*a*a+b;a--;return-c/2*(a*(a-2)-1)+b}),Math.easeInCubic=((a,b,c,d)=>{a/=d;return c*a*a*a+b}),Math.easeOutCubic=((a,b,c,d)=>{a/=d;a--;return c*(a*a*a+1)+b}),Math.easeInOutCubic=((a,b,c,d)=>{a/=d/2;if(a<1)return c/2*a*a*a+b;a-=2;return c/2*(a*a*a+2)+b}),Math.easeInQuart=((a,b,c,d)=>{a/=d;return c*a*a*a*a+b}),Math.easeOutQuart=((a,b,c,d)=>{a/=d;a--;return-c*(a*a*a*a-1)+b}),Math.easeInOutQuart=((a,b,c,d)=>{a/=d/2;if(a<1)return c/2*a*a*a*a+b;a-=2;return-c/2*(a*a*a*a-2)+b}),Math.easeInQuint=((a,b,c,d)=>{a/=d;return c*a*a*a*a*a+b}),Math.easeOutQuint=((a,b,c,d)=>{a/=d;a--;return c*(a*a*a*a*a+1)+b}),Math.easeInOutQuint=((a,b,c,d)=>{a/=d/2;if(a<1)return c/2*a*a*a*a*a+b;a-=2;return c/2*(a*a*a*a*a+2)+b}),Math.easeInSine=((a,b,c,d)=>-c*Math.cos(a/d*(Math.PI/2))+c+b),Math.easeOutSine=((a,b,c,d)=>c*Math.sin(a/d*(Math.PI/2))+b),Math.easeInOutSine=((a,b,c,d)=>-c/2*(Math.cos(Math.PI*a/d)-1)+b),Math.easeInExpo=((a,b,c,d)=>c*Math.pow(2,10*(a/d-1))+b),Math.easeOutExpo=((a,b,c,d)=>c*(1-Math.pow(2,-10*a/d))+b),Math.easeInOutExpo=((a,b,c,d)=>{a/=d/2;if(a<1)return c/2*Math.pow(2,10*(a-1))+b;a--;return c/2*(2-Math.pow(2,-10*a))+b}),Math.easeInCirc=((a,b,c,d)=>{a/=d;return-c*(Math.sqrt(1-a*a)-1)+b}),Math.easeOutCubic=((a,b,c,d)=>{a/=d;a--;return c*(a*a*a+1)+b}),Math.easeInOutCubic=((a,b,c,d)=>{a/=d/2;if(a<1)return c/2*a*a*a+b;a-=2;return c/2*(a*a*a+2)+b}),Math.easeOutCirc=((a,b,c,d)=>{a/=d;a--;return c*Math.sqrt(1-a*a)+b}),Math.easeInOutCirc=((a,b,c,d)=>{a/=d/2;if(a<1)return-c/2*(Math.sqrt(1-a*a)-1)+b;a-=2;return c/2*(Math.sqrt(1-a*a)+1)+b});let d=(a,b,c,e,f,g,h,i)=>{let j=Object.create(d.prototype);j.pos=a;j.bAngle=b;j.eAngle=c;j.cAngle=e;j.radius=f;j.lineWidth=g;j.sAngle=h;j.settings=i;return j};d.prototype={onDraw(a){if(!1!==this.settings.onDraw){let c=Object.assign({},this);var b={percent:i,rad:a=>a,default:f};c.value=(b[this.settings.unit]||b.default)(c.cAngle),c.text=(b=>e(a,b)),c.settings.onDraw(a,c)}},drawBackground(a){a.beginPath(),a.arc(this.pos,this.pos,this.settings.backgroundFix?.9999*this.radius:this.radius,0,2*Math.PI),a.lineWidth=this.settings.backgroundFix?.95*this.lineWidth:this.lineWidth,a.strokeStyle=this.settings.backgroundColor,a.stroke()},draw(a){if(a.beginPath(),this.settings.counterclockwise){let b=2*Math.PI;a.arc(this.pos,this.pos,this.radius,b-this.bAngle,b-(this.bAngle+this.cAngle),this.settings.counterclockwise)}else a.arc(this.pos,this.pos,this.radius,this.bAngle,this.bAngle+this.cAngle,this.settings.counterclockwise);a.lineWidth=this.lineWidth,a.lineCap=this.settings.lineCap,a.strokeStyle=this.settings.color,a.stroke()},animate(a,b,c,d,e){let f=(new Date).getTime()-c;f<1&&(f=1),c-d<1.05*this.settings.speed&&(!e&&1e3*this.cAngle<=Math.floor(1e3*this.eAngle)||e&&1e3*this.cAngle>=Math.floor(1e3*this.eAngle))?(this.cAngle=Math[this.settings.animation]((c-d)/f,this.sAngle,this.eAngle-this.sAngle,this.settings.speed/f),b.clearRect(0,0,this.settings.size,this.settings.size),this.settings.background&&this.drawBackground(b),this.draw(b),this.onDraw(a),c=(new Date).getTime(),j(()=>this.animate(a,b,c,d,e))):(this.cAngle=this.eAngle,b.clearRect(0,0,this.settings.size,this.settings.size),this.settings.background&&this.drawBackground(b),this.draw(b),this.setCurrentAnglesData(a))},setCurrentAnglesData(a){var b={percent:i,rad:a=>a,default:f};let c=b[this.settings.unit]||b.default;a.data("current-c-angle",c(this.cAngle)),a.data("current-start-angle",c(this.bAngle))}};let e=(b,c)=>{b.data("text",c);a(".circleChart_text",b).html(c)},f=a=>a/Math.PI*180,g=a=>a/180*Math.PI,h=a=>g(a/100*360),i=a=>f(a)/360*100,j=(a=>window.requestAnimationFrame||window.webkitRequestAnimationFrame||window.mozRequestAnimationFrame||window.oRequestAnimationFrame||window.msRequestAnimationFrame||function(b){window.setTimeout(a,1e3/60)})();return this.each((e,f)=>{let i=a(f);var k={};var l=i.data();for(let a in l)l.hasOwnProperty(a)&&0===a.indexOf("_cache_")&&c.hasOwnProperty(a.substring(7))&&(k[a.substring(7)]=l[a]);let m=Object.assign({},c,k,l,b);for(let a in m)0!==a.indexOf("_cache_")&&i.data("_cache_"+a,m[a]);a("canvas.circleChart_canvas",i).length||i.append(function(){return a("<canvas/>",{class:"circleChart_canvas"}).prop({width:m.size,height:m.size}).css(m.autoCss?{"margin-left":"auto","margin-right":"auto",display:"block"}:{})});a("p.circleChart_text",i).length||!1!==m.text&&(i.append("<p class='circleChart_text'>"+m.text+"</p>"),m.autoCss&&(m.textCenter?a("p.circleChart_text",i).css({position:"absolute","line-height":m.size+"px",top:0,width:"100%",margin:0,padding:0,"text-align":"center","font-size":!1!==m.textSize?m.textSize:m.size*m.relativeTextSize,"font-weight":m.textWeight,"font-family":m.textFamily}):a("p.circleChart_text",i).css({"padding-top":"5px","text-align":"center","font-weight":m.textWeight,"font-family":m.textFamily,"font-size":!1!==m.textSize?m.textSize:m.size*m.relativeTextSize})));m.autoCss&&i.css("position","relative");m.redraw||(m.cAngle=m.currentCAngle?m.currentCAngle:m.cAngle,m.startAngle=m.currentStartAngle?m.currentStartAngle:m.startAngle);var n=a("canvas",i).get(0);var o=n.getContext("2d");var p={percent:h,rad:a=>a,default:g};let q=p[m.unit]||p.default;let r=q(m.startAngle);let s=q(m.value);let t=q(m.cAngle);var u=m.size/2;var v=u*(1-m.widthRatio/2);var w=v*m.widthRatio;var x=d(u,r,s,t,v,w,t,m);i.data("size",m.size);m.animate?0!==m.value?x.animate(i,o,(new Date).getTime(),(new Date).getTime(),t>s):j(()=>{o.clearRect(0,0,this.settings.size,this.settings.size);x.settings.background&&x.drawBackground(o)}):(x.cAngle=x.eAngle,j(()=>{m.background&&x.drawBackground(o);0!==m.value?(x.draw(o),x.onDraw(i),x.setCurrentAnglesData(i)):(o.clearRect(0,0,this.settings.size,this.settings.size),x.settings.background&&x.drawBackground(o))}))})}}(jQuery);

// 전체 강의 일정
$('#circle3').circleChart({
	widthRatio: 0.5,
    value: lPer,
    unit: "percent",
    counterclockwisie: false,
    size: 100,
    startAngle: 25,
    text: Math.floor(lecPer) + "%"
   
});

// 현재 출석율
$('#circle4').circleChart({
	widthRatio: 0.5,
    value: aPer,
    unit: "percent",
    counterclockwisie: false,
    size: 100,
    startAngle: 25,
    text: Math.floor(attPer) + "%"
   
});
















   


</script>






