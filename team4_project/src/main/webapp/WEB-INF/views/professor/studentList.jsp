<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
	<link href="<%=request.getContextPath() %>/resources/css/list/listCSS.css" rel="stylesheet">
	<link rel='stylesheet' href="<%=request.getContextPath()%>/resources/css/professor/student.css">
	<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
	<title>수강생리스트</title>
	
</head>

<style>

	#writeBtn{
		width : 100px; 
	}
	
	.form-group{
		margin-top : 20px;	
	
	}
</style>



<body class="blur-theme data-container-body">
			
			<div class="container-dashboard" style="background-color: white;">
				<div class="container-dashboard-inner">
				<form id="infoForm" class="form-inline" action="list">
				<div class="clearfix">
						<h4 style="font-size: 25px;"><a href="<%=request.getContextPath()%>/myPage/professorMain" style="color: black;">마이페이지</a>><a href="javascript:location.reload()"style="color:#308fe2;">수강생리스트</a></h4>
					 <div class="pull-right" id="keyword">
						<div class="form-group">	
							<h4>총 ${count }명 수강중</h4>
						</div>
					</div>
				</div>
			</form>				
				<div class="table-responsive" style="width: 100%;">
					<table class="table table-striped">
						<tbody>
							<tr>
								<td class="text-center" style="width:25%;"><label style="font-size: 18px;">아이디</label></td>								
								<td class="text-center" style="width:25%;"><label style="font-size: 18px;">이름</label></td>
								<td class="text-center" style="width:15%;"><label style="font-size: 18px;">현재 출석률</label></td>
								<td class="text-center" style="width:15%;"><label style="font-size: 18px;">총 출석률</label></td>
								<td class="text-center" style="width:10%;"><label style="font-size: 18px;">상태</label></td>
							</tr>	
						 <c:forEach items="${student}" var="student" varStatus="i">
							<tr>
								<td class="text-center" style="width:25%;"><label style="font-size: 18px;">${student.student_id}</label></td>
								<td class="text-center" style="width:25%;"><a href="#profile" onclick="profile('${student.student_id}')" style="cursor: pointer;"><label style="font-size: 18px; cursor: pointer;">${student.student_name}</label></a></td>
								<td class="text-center" style="width:15%;">
								<label style="font-size: 18px;">${student.attend_rate}%</label>
								</td>
								<td class="text-center" style="width:15%;"><label style="font-size: 18px;">${student.lecture_attend_all_percent}%</label></td>
								<c:set value="${student.student_status }" var="status" />
								<c:if test="${status eq 1 }" >
								<td class="text-center" style="width:10%;"><label style="font-size: 18px;">이용중</label></td>
								</c:if>
								<c:if test="${status eq 0 }" >
								<td class="text-center" style="width:10%;"><label style="font-size: 18px;">탈퇴</label></td>
								</c:if>
							</tr>			
								<input type="hidden" id="index"value="${i.index }">
								<input type="hidden" id="rate${i.index }" value="${student.lecture_attend_all_percent}">
							</c:forEach>	
						</tbody>
					</table>
					 <c:if test="${empty student }">
					 	<h2 style="text-align: center;">현재 등록중인 수강생이 없습니다.</h2>
					 </c:if>
				</div>		 
				<div>
				</div>
			</div>
		</div>
		
		<div id="profile" class="overlay light">
		<div class="popup1">
			<h4 style="color:#a2a5f6; width:260px;">■ 수강생 프로필 </h4>
					 <button style="float: right; margin-right: 25px; margin-bottom: 15px; width: 55px;" id="btn">확인</button>
				<div id="image">
					<img id="profileImg"/>
				</div>
			<table id="table-o">
				
				<tbody>
					<tr class="tr-o">
						<th scope="row" class="th-o" style="border-radius:14px 0px 0px 0px;"><label style="font-size: 15px;">이름</label></th>
						<td colspan="4" class="td-o" id="name"><label style="font-size: 15px;">이름</label></td>
					</tr>
					<tr class="tr-o">
						<th scope="row" class="th-o"><label style="font-size: 15px;">성별</label></th>
						<td colspan="4" class="td-o" id="gender"><label style="font-size: 15px;">성별</label></td>
					</tr>
					<tr class="tr-o">
						<th scope="row" class="th-o"><label style="font-size: 15px;">생년월일</label></th>
						<td colspan="4" class="td-o" id="birth"><label style="font-size: 18px;">생일</label></td>
					</tr>
					<tr class="tr-o">
						<th scope="row" class="th-o"><label style="font-size: 15px;">이메일</label></th>
						<td colspan="4" class="td-o"id="mail"><label style="font-size: 15px;">이메일</label></td>
					</tr>
					<tr class="tr-o">
						<th scope="row" class="th-o"><label style="font-size: 15px;">연락처</label></th>
						<td colspan="4" class="td-o" id="phone"><label style="font-size: 15px;">연락처</label></td>
					</tr>
					<tr class="tr-o">
						<th scope="row" class="th-o"><label style="font-size: 15px;">희망업종</label></th>
						<td colspan="4" class="td-o" id="purpose"><label style="font-size: 15px;">희망업종</label></td>
					</tr>
				</tbody>
			</table>
			  <label style="margin-left: 20px; font-size: 18px;">비고</label>
			  <div id="remark" style="margin-left: 20px; border: 1px solid #cab9b9e0; width:510px; height: 180px;">
			  	
			  </div>
			<br/> <br/>
		</div>
	</div>
	<div id="sendMail" class="overlay light">
		<div class="popup2">
			<h4>■ 메일 전송  &nbsp;<button class="mailBtn" id="mailCancel">취소</button><button class="mailBtn" id="sendBtn">전송</button></h4>
			
			<div>
				<label class="title-label">제목</label><br/>
				<input class="mail-title" type="text" id="title" placeholder="제목을 입력해 주세요">
				<label class="content-label">내용</label><br/>
				<textarea id="mail-content"></textarea>
				<input type="hidden" id="receive_id">
			</div>
			
		</div>
	</div>
</body>
<%@ include file="mail_js.jsp" %>
<script>

 var flag =0;
 function profile(id) {	 
		$("#profileImg").attr("src", "<%=request.getContextPath()%>/professor/student/profile/img?id="+id)
		.css("background-position", "center")
		.css("width","200px")
		.css("height","230px");
		$.ajax({
			url:"<%=request.getContextPath()%>/professor/student/profile",
			data: {"id":id},
			type:"post",
			success:function(res){
					flag=1;
					$('#name').text(res.name);
					$('#gender').text(res.gender);
					$('#birth').text(res.birth);
					$('#mail').text(res.mail);
					$('#student_id').val(res.id)
					$('#mail').append('<a href="#sendMail" onclick="sendMailForm(\'' + res.id + '\')"><img src="<%=request.getContextPath() %>/resources/images/mail.png" style="width:25px; margin-left:10px;"/></a>');
					$('#phone').text(res.phone)
					$('#purpose').text(res.purpose)
					$('#remark').append(res.remark)
					
					if(flag ==1){
					function doNotReload(){
					    if( (event.ctrlKey == true && (event.keyCode == 78 || event.keyCode == 82)) || (event.keyCode == 116) ) {
					        event.keyCode = 0;
					        event.cancelBubble = true;
					        event.returnValue = false;
					    } 
					}
					document.onkeydown = doNotReload;
					}	
			},
			error:function(){
				
			}
			
		});
	}
 	$('#btn').on('click',function(){
 		flag=0;
 		location.href="#";
 		location.reload();
 	});
 	
 	function sendMailForm(id){
 		$('#receive_id').val(id);
 	}
 	
 	$('#mailCancel').on('click',function(){
 		var id = $('#receive_id').val;
 		location.href="#profile"
 		profile(id);
 	});
 	
 	$('#sendBtn').on('click',function(){

 		var id = $('#receive_id').val();
 		var title = $('#title').val();
 		var content = $('#mail-content').val();
 		$.ajax({
 			url:"<%=request.getContextPath()%>/professor/student/sendMail",
 			data:{"id": id,"title":title,"content":content},
 			type:"post",
 			success:function(){
 				alert('메일을 성공적으로 보냈습니다.')
 				location.href="#profile"
 			 	profile(id);
 			},
 			error:function(exception){
 				alert(exception);
 			}
 		});
 	});
 	
</script>

     







