<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="<%=request.getContextPath() %>/resources/css/professor/mainPage.css" rel="stylesheet">
<body>
	<div style="padding: 30px;">
	<div class="img-div">
	<a href="<%=request.getContextPath()%>/professor/mypage"><img class="main-Img" src="<%=request.getContextPath()%>/resources/images/profileImg.png"></a>
	<h4 class="main-h3">개인 정보</h4>
	</div>
	<div class="img-div">
	<a href="<%=request.getContextPath()%>/professor/myLecture"><img class="main-Img" src="<%=request.getContextPath()%>/resources/images/lecture.png"></a>
	<h4 class="main-h3">나의 강의</h4>
	</div>
	<div class="img-div">
	<a href="<%=request.getContextPath()%>/professor/video"><img class="main-Img" src="<%=request.getContextPath()%>/resources/images/lectureVideo.png"></a>
	<h4 class="main-h3">강의실</h4>
	</div>
	<div class="img-div">
	<a href="<%=request.getContextPath()%>/professor/pds/main"><img class="main-Img" src="<%=request.getContextPath()%>/resources/images/pdsImg.png"></a>
	<h4 class="main-h3">자료실</h4>
	</div>
	<div class="img-div">
	<a href="<%=request.getContextPath()%>/message/receiver_list"><img class="main-Img" src="<%=request.getContextPath()%>/resources/images/messageImg.png"></a>
	<h4 class="main-h3">쪽지함</h4>
	</div>
	<div class="img-div">
	<a href="<%=request.getContextPath()%>/professor/student/list"><img class="main-Img" src="<%=request.getContextPath()%>/resources/images/StudentImg.png"></a>
	<h4 class="main-h3">수강생 관리</h4>
	</div>
	<div class="img-div">
	<a href="<%=request.getContextPath()%>/professor/qna/list"><img class="main-Img" src="<%=request.getContextPath()%>/resources/images/qnaImg.png"></a>
	<h4 class="main-h3">질의 문답</h4>
	</div>
	</div>
</body>
