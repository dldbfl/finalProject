<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel='stylesheet' href="<%=request.getContextPath()%>/resources/css/professor/myLecture.css">
<body>
<c:if test="${not empty lecture }">
 <h3 style="margin-top: 20px;"><a href="<%=request.getContextPath()%>/myPage/professorMain" style="color:black;">마이페이지</a>><a id="head1" href="javascript:location.reload()" style="color:#308fe2;" >나의 강의</a></h3><label style="font-size: 15px; color:#2f70a9;">${count}개 영상 등록 중</label><a href="<%=request.getContextPath()%>/pds/lecture/list" id="registBtn"><label style="margin-left:80px; font-size: 20px; color:#0c963d; cursor: pointer;">영상 등록하러 가기</label></a>
 </c:if>
	<c:if test="${empty lecture }">
	<h3 style="margin-top: 20px;"><a href="<%=request.getContextPath()%>/myPage/professorMain" style="color:black;">마이페이지</a>><a id="head1" href="javascript:location.reload()" style="color:#308fe2;" >나의 강의</a></h3>
		<h1 style="padding: 20% 0% 0% 30%;">배정된 강의가 없습니다</h1>
	</c:if>
	<c:if test="${not empty lecture }">
	<div>
      <div class="lecture-content">

       	<br/>
        	<div class="head_top">   	     
        	<div class="head_left">
				<img style="width: 300px; height: 230px;" src="<%=request.getContextPath()%>/resources/images/qnaImg.png">
        	</div> 	
       		<div class="head_right">				
				<label class="label1">담당교수 ID</label>
				<input class="con1" type="text" id="lecture_no2" name="lecture_no" maxlength="50"  readonly="readonly" value="${lecture.professor_id }">
				<label class="label1">강의제목</label>
				<input class="con1" type="text" name="lecture_title" id="lecture_title2" maxlength="50" readonly="readonly" style="" value="${lecture.lecture_title }" >
				<label class="label1">교과목 구분</label>
				<input class="con1" type="text" name="lecture_distinction" id="lecture_distinction2" maxlength="50" readonly="readonly" value="${lecture.lecture_distinction }">				
       			<label class="label1">강의 가격</label>
				<input class="con1" type="text" name="lecture_price" id="lecture_price2" readonly="readonly" value="${lecture.lecture_price }원" >
			</div>
       	</div>
       	<div class="modal_body">
       		<div class="body_top">
				<label class="label2" style="margin-top: 40px;">모집 시작일</label>
				<input class="con1" type="text" name="lecture_recruit_date" id="lecture_recruit_date2" readonly="readonly" value="&nbsp;&nbsp;&nbsp;<fmt:formatDate value="${lecture.lecture_recruit_date}" pattern="yyyy년 MM월 dd일"/>">
				<label class="label2">모집 마감일</label>
				<input class="con1" type="text" name="lecture_recruit_status" id="lecture_recruit_status2" readonly="readonly" value="&nbsp;&nbsp;&nbsp;<fmt:formatDate value="${lecture.lecture_recruit_status}" pattern="yyyy년 MM월 dd일"/>">
       			<label class="label2">강의 시작일</label>
       			<input class="con1" type="text" name="lecture_progress" id="lecture_progress2" readonly="readonly" value="&nbsp;&nbsp;&nbsp;<fmt:formatDate value="${lecture.lecture_progress}" pattern="yyyy년 MM월 dd일"/>">
       			<label class="label2">강의 마감일</label>
       			<input class="con1" type="text" name="lecture_end" id="lecture_end2" readonly="readonly" value="&nbsp;&nbsp;&nbsp;<fmt:formatDate value="${lecture.lecture_end}" pattern="yyyy년 MM월 dd일"/>">  
       		</div>
       		<div class="span">
       			<hr>
       			${lecture.lecture_content } 			
       		</div>
       	</div>
   	  </div> 
    </div>
    </c:if>	
</body>
