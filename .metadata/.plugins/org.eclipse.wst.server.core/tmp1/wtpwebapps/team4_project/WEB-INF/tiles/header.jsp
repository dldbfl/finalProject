<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

<html>
<head>

<style>
	.headersWarp{
background: #FF512F;  /* fallback for old browsers */
background: -webkit-linear-gradient(to right, #F09819, #FF512F);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right, #4267f1, #cc86e8); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */

	}
	.header_logo{
		cursor: pointer;
    	
	}
	.headerInWrap{
		margin-bottom: 0px;
	}
	.mainMenubar {
	    margin-bottom: 10px;
  	  	margin-top: -12px;
    	float: left;
    	color: white;
	}
	.mainMenubar li {
    display: inline;
    font-size: 1.5em;
    padding: 0px 34.8px 0px 45px;
}

	.mainMenubar li:hover{
		cursor: pointer;
		color: #00a7c1;
	}
	a{
		text-decoration:none;
	}
	li{
		list-style: none;
	}	
	
	#modelMenubar>li {
    position: fixed;
    background: #0009;
    width: 110%;
    height: 24.8%;
    z-index: -1;
    left: 0;
    top: -21%;
    padding: 0px 17.5% 0px 19.7%;
}
    .subMenuForm{
    	width: -webkit-calc(89%-30px);
    }
    .buildingIcon{
		width: 120px;
	    height: 130px;
	    text-align: center;
	    padding-top: 22px;
	    border-right: 3px solid;
	    float: left;
    }
    .iconWrap{
    	margin-top: 35px;
    	height: 200px;
    	float: left;
    	margin-right: 10px;
    }
    .companyInfoSubMenu, .courseReviewSubMenu,.studentRecruitSubMenu, .MyclassRoomSubMenu, .communitySubMenu{
    	float: left;
    	color: beige;
    	width: 177.6px;
    	text-align: center;
    }
   .menuUl li {
    padding: 5px;
    font-size: 18px;
    border: 3px solid;
    border-radius: 10px;
    margin-top: 5px;
    margin-right: 0px;
    width: 160px;
}
	.menuUl li:hover{
		background: buttonface;
		cursor: pointer;
    }
    .menuUl li a{
    	color: white;
    	text-decoration:none;
    }
    .menuUl li a:hover{
		color: black;
    }
    .fa-5x{
    	color: greenyellow;
    }
    .moveSubMenu{
    	
    }
    .adminPage:hover{
    	cursor: pointer;
    	color: white;
    }
    .manager-modal-content {
    		    background-image: url(/resources/images/book.png);
			    background-size: 116%;
			    background-repeat: no-repeat;
			    background-color: unset;
			    background-position: center;
			    margin: 2% auto;
			    padding: 20px;
			    padding-top: 66px;
			    width: 22%;
			    height: 68%;
			    border-radius: 3%;
			    left: 19%;
			    position: relative;
			    font-family: sans-serif;
			    top: -6%;
	}
	.header_menu{
	font-size: 1.4em;
	}
	
	.joinKeepingLabel{
	    position: absolute;
	    top: 140px;
	    left: 190px;
	    border: 3px solid green;
	    width: 150px;
	    height: 100px;
	    padding: 17px;
	    text-align: center;
	    color: red;
	    border-radius: 44px;
	}
	.joinKeepingLabel:hover{
		color: blue;
	}
	.link{
		font-size: 23px;
	    padding-left: 41px;
	    height: 13px;
	    margin-top: 7%;
	}
	.manager-modal-close{
		float: right;
	    font-size: 45px;
	    margin-top: 1%;
	    font-weight: 700;
	    line-height: 1;
	    color: #000;
	    text-shadow: 0 1px 0 #fff;
	    filter: alpha(opacity=20);
	    opacity: .2;
        cursor: pointer;
	}
	#resetpopup{
		float: right;
	    font-size: 19px;
	    font-weight: bold;
	    border-radius: 8px;
	    background-color: lavenderblush;
	    width: 108px;
	    height: 32px;
	    margin-top: 1px;
	}
</style>
 <script>
		$(function() {
		    $(".mainMenubar li").click(function(e) {
		    	e.stopPropagation();
		    	$("#modelMenubar>li").css("transform","translate(0px,339.4px");
		    	$("#modelMenubar>li").css("transition-property","all");
		    	$("#modelMenubar>li").css("transition-duration","0.5s");
		    });
		
		
			$(document).click(function() {
		    	$("#modelMenubar>li").css("transform","translate(0px,-300px");
		    	$("#modelMenubar>li").css("transition-property","all");
		    	$("#modelMenubar>li").css("transition-duration","0.5s");			
			});
		})
    </script>
</head>
    <header id="header">
        <div class="container headersWarp" style="margin: 0px;width: 100%; padding: 21px 17% 0px 20%;margin-top:">
            <div class="header_logo col-sm-3" style="width: 130px;" onclick="location.href='<%=request.getContextPath() %>/main'"></div>
            <div class="headerInWrap col-sm-10" style="float:right; margin-right: 60px;">
                  <div class="header_menu">
                  <c:set var ="id" value="${loginUser.member_id}"  scope="session"/>
                  <c:set var ="authority" value="${loginUser.member_authority}"  scope="session"/>
                  	<c:choose>
                   	<c:when test="${empty loginUser.member_id}">
                        <a href="<%=request.getContextPath() %>/commons/login">로그인</a>&nbsp;&nbsp;&nbsp;
                     <%--    <a href="<%=request.getContextPath() %>/main">홈</a> --%>
                        <a href="<%=request.getContextPath()%>/board/notice/list">고객센터</a>&nbsp;&nbsp;&nbsp;
                        <a href="<%=request.getContextPath()%>/myPage/myPageMain">마이페이지</a>
                    </c:when>
                    <c:when test="${authority =='STUDENT' ||authority == 'USER'}">
                        <a href="<%=request.getContextPath()%>/myPage/myPageMain" style="color: #c8caff;font-weight: bold;">${loginUser.member_name }(${id })님 환영합니다.</a>&nbsp;&nbsp;&nbsp;
                        <a href="<%=request.getContextPath() %>/commons/logout">로그아웃</a>&nbsp;&nbsp;&nbsp;
                       <%--  <a href="<%=request.getContextPath() %>/main">홈</a>&nbsp;&nbsp; --%>
                        <a href="<%=request.getContextPath()%>/board/notice/list">고객센터</a>&nbsp;&nbsp;&nbsp;
                        <a href="<%=request.getContextPath()%>/myPage/myPageMain">마이페이지</a>
                    </c:when>
                    <c:when test="${authority == 'ADMIN'}">
                    	<a href="<%=request.getContextPath()%>/board/notice/list">관리자님 환영합니다</a>&nbsp;&nbsp;&nbsp;
                     	<a href="<%=request.getContextPath() %>/commons/logout">로그아웃</a>&nbsp;&nbsp;&nbsp;
	                  <%-- 	<a href="<%=request.getContextPath() %>/main">홈</a> --%>
                     	<a href="<%=request.getContextPath()%>/board/notice/list">고객센터</a>&nbsp;&nbsp;&nbsp;
                     	<span class="adminPage" onclick="openManager();" style="color: #292fd6; font-weight: bold;">관리자 탭</span>
                    </c:when>
                    <c:otherwise>
                    	<a href="<%=request.getContextPath() %>/myPage/professorMain">${loginUser.member_name }(${id }) 교수님 환영합니다.</a>&nbsp;&nbsp;&nbsp;
                     	<a href="<%=request.getContextPath() %>/commons/logout">로그아웃</a>&nbsp;&nbsp;&nbsp;
	                  	<%-- <a href="<%=request.getContextPath() %>/main">홈</a> --%>
                     	<a href="<%=request.getContextPath()%>/board/notice/list">고객센터</a>&nbsp;&nbsp;&nbsp;
                     	<a href="<%=request.getContextPath() %>/myPage/professorMain">마이페이지</a>
                    </c:otherwise>
                   	</c:choose>
                  </div> 
            </div>
            <br>
        <div class="subMenuForm col-sm-12">
		    <ul class="mainMenubar" style="float:right;margin-right:31px;">
				<li>기업소개</li>
				<li>수강생모집</li>
				<li>수강후기</li>
				<li>나의강의실</li>
				<li>커뮤니티&nbsp;&nbsp;</li>
				<li>상담문의</li>
			</ul>
			<ul id="modelMenubar">
				<li>
				<div class="iconWrap">
					<i class="fa fa-building-o fa-5x buildingIcon" aria-hidden="true"></i>
				</div>
				<div class="companyInfoSubMenu">
					<ul class="menuUl">
						<li onclick="menuUlMove(this);">기업소개</li>
						<li onclick="menuUlMove(this);">인사글</li>
						<li onclick="menuUlMove(this);">교육목표</li>
						<li onclick="menuUlMove(this);">교육과정</li>
						<li onclick="menuUlMove(this);">찾아오는길</li>
					</ul>
				</div>
				<div class="studentRecruitSubMenu">
					<ul class="menuUl">
						<li onclick="menuUlMove(this);">모집강의</li>
					</ul>
				</div>
				<div class="courseReviewSubMenu">
					<ul class="menuUl">
						<li onclick="menuUlMove(this);">수강후기</li>
					</ul>
				</div>
				<div class="MyclassRoomSubMenu">
					<ul class="menuUl">
						<li onclick="menuUlMove(this);">동영상강의</li>
					</ul>
				</div>
				<div class="communitySubMenu">
					<ul class="menuUl">
						<li onclick="menuUlMove(this);">자유게시판</li>
						<li onclick="menuUlMove(this);">창업후기</li>
						<li onclick="menuUlMove(this);">Q&A</li>
					</ul>
				</div>
				<div class="communitySubMenu">
					<ul class="menuUl">
						<li onclick="menuUlMove(this);">문의내역</li>
						<li onclick="menuUlMove(this);">문의하기</li>
					</ul>
				</div>
				</li>
			</ul>
		</div>
        </div>
   	<c:if test="${loginUser.member_status > 1 }">
	  	<div class="joinKeepingLabel">
	       <h4> 가입승인</h4>
	       <h4> 대기중</h4>
	   </div>
    </c:if>
	
	<!-- The Modal -->
    <div id="myModal" class="modal"> 	
	      <!-- Modal content -->
	      <div class="manager-modal-content">
	        <span class="manager-modal-close">&times;</span>
	       	<div class="link">
				<a href="<%=request.getContextPath()%>/manager/notice_list" >공지사항 관리</a>   
			</div>    
			<div class="link">           
				<a href="<%=request.getContextPath()%>/manager/student_list" >수강생 관리</a>
			</div>
			<div class="link">                  
				<a href="<%=request.getContextPath()%>/manager/professor_list" >교수 관리</a>                 
			</div>
			<div class="link">
				<a href="<%=request.getContextPath()%>/manager/lecture_management" >강의 관리</a>             
			</div>
			<div class="link">
				<a href="<%=request.getContextPath()%>/manager/draft/list" >기안서 관리</a>                    
			</div>
			<div class="link">
				<a href="<%=request.getContextPath()%>/manager/consult/list" >상담문의 관리</a>                 
			</div>
			<div class="link">
				<a href="<%=request.getContextPath()%>/manager/enterprise_introduce" >기업소개 관리</a>         
			</div>
			<div class="link">
				<a href="<%=request.getContextPath()%>/manager/chairman_introduce" >대표 이사 소개 관리</a>       
			</div>
			<div class="link">
				<a href="<%=request.getContextPath()%>/manager/education_curriculum" >교육과정 관리</a>         
			</div>
			<div class="link">
				<a href="<%=request.getContextPath()%>/manager/education_purpose" >교육목표 관리</a>            
			</div>
			<div class="link">
				<a href="<%=request.getContextPath()%>/manager/enterprise_coming" >찾아오는길 관리</a>           
			</div>
			<div class="link">
				<a href="<%=request.getContextPath()%>/manager/popup" >메인화면 팝업 관리</a>     
				<button id = "resetpopup" style="display: none;">
					<i class="fa">팝업 복구</i>
				</button>	                
			</div>
	    </div>
    </div>	
	
<script src="/resources/js/cookie.js"></script>
<script>
$('#resetpopup').on('click',function() {
	deleteCookie('todayClose');
	alert("복구되었습니다.")
});

function openManager(){
	managermodal.style.display = "block";	
}	
	
	//This is Modal Setting!
	// Get the modal
	var managermodal = document.getElementById('myModal');
	
	// Get the button that opens the modal
	var btn = document.getElementById("urlModal");
	
	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("manager-modal-close")[0];                                          
	
	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
		managermodal.style.display = "none";
	}
	
	 // When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	    if (event.target == managermodal) {
	    	managermodal.style.display = "none";
	    }
	}  
	
	function menuUlMove(obj){
		var className=$(obj).text();
		if(className=='모집강의'){
			location.href="<%=request.getContextPath()%>/lecture/list";
		}else if(className=='수강후기'){
			location.href="<%=request.getContextPath()%>/lecture/review/list";
		}else if(className=='동영상강의'){
			location.href="<%=request.getContextPath()%>/lecture/video";
		}else if(className=='자유게시판'){
			location.href="<%=request.getContextPath()%>/board/free";
		}else if(className=='창업후기'){
			location.href="<%=request.getContextPath()%>/board/foundReviewList";
		}else if(className=='Q&A'){
			location.href="<%=request.getContextPath()%>/board/qna/list";
		}else if(className=='문의내역'){
			location.href="<%=request.getContextPath()%>/board/consult/list";
		}else if(className=='문의하기'){
			location.href="<%=request.getContextPath()%>/board/consult/registForm";
		}else if(className=='기업소개'){
			location.href="<%=request.getContextPath()%>/enterprise/intro";
		}else if(className=='인사글'){
			location.href="<%=request.getContextPath()%>/enterprise/chairman";
		}else if(className=='교육목표'){
			location.href="<%=request.getContextPath()%>/enterprise/purpose";
		}else if(className=='교육과정'){
			location.href="<%=request.getContextPath()%>/enterprise/curriculum";
		}else if(className=='찾아오는길'){
			location.href="<%=request.getContextPath()%>/enterprise/coming";
		}
	}
	
</script>
    </header>
    <!-- //header -->

    