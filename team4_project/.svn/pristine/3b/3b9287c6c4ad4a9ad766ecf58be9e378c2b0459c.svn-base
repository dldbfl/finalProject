<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
.payLectBtn{
	background-color: #3162C7;
	color: #fff;
}
.payLectBtn:hover {
	background-color: #fff;
	color:#3162C7;
}
#payText{
	background-image: url('<%=request.getContextPath()%>/resources/images/결제.png');
	background-position: center;
    background-repeat: no-repeat;
    background-size: 100% 100%;
    height: 600px;
    width: 550px;
}
</style>

<body>
	
	<div>
      <div class="pay-group" id="payText" style="padding-top: 80px; padding-bottom:25px; margin: auto;">
          <div>
          <table style="margin-left:auto; margin-right:auto; ">
          	<tr style="border-bottom: 2px solid;">
          		<td colspan="2" ><h3>결제를 진행 하시겠습니까?</h3></td>
          	</tr>
          	<tr style="height: 100px;">
          		<td>
          			<h3>결제금액 :</h3>
          		</td>
          		<td style="text-align:center;">
          			<h2 style="color: #5D5D5D;">${lecture.lecture_price } 원</h2>
          		</td>
          	</tr>
          	<tr style="height: 150px; border-bottom: 2px solid;">
          		<td >
          			<h3>신청한 강의 :</h3>
          		</td>
          		<td style="text-align:center;">
          			<h2 style="color: #5D5D5D;">${lecture.lecture_title }</h2>
          		</td>
          		
          	</tr>
          </table>
              
          </div>
          <div class="lecturePayBtn" align="center" style="padding-top: 18px;">
          <button id="cansle" type="button" class="btn payLectBtn">취소</button>
          <button id="payButton" class="btn payLectBtn" type="button"> 결제 </button>
          </div>
       
      </div>
	</div>
<%@ include file="/WEB-INF/views/lecture/lecturePay_js.jsp" %>
</body>
<script>
$('#cansle').on('click',function(){
	history.go(-1);
})

$.ajax({
	url:"<%=request.getContextPath()%>/pay/lecturePay",
	type:"get",
	success:function(src){
		
	},
	error:function(err){
		alert("이미 수강내역이 있습니다")
		location.href=history.go(-1);		
	}
})
</script>
