<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
	<link rel='stylesheet' href="<%=request.getContextPath()%>/resources/css/professor/student.css">
	
<style>
table{
		border-collapse:separate ;
		
	}
.container-dashboard {
    padding-top: 15px;
    
   
}

.meminfo {
	cursor: pointer;
}

.popupLayer {
	position: absolute;
	display: none;
	background-color: #ffffff;
	border: solid 2px #d0d0d0;
	width: 500px;
	height: 150px;
	padding: 10px;
}
.popupLayer div {
	position: absolute;
	top: 5px;
	right: 15px;
}

div#picturePreView{
	height:100%;
	width:100%;
	border : 1px solid lightgray;  		
	background-position: center;
	background-repeat: no-repeat;
	background-size: 100% 100%;
}

</style>
	<!-- FAVIICON -->
	<link rel="shortcut icon" href="favicon.ico">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<!-- Le fav and touch icons -->
	<link rel="apple-touch-icon" sizes="114x114" href="apple-touch-icon-114x114.png" />
	<link rel="icon" type="images/svg+xml" href="images/logo.svg" />
<script>
		$('.meminfo').each(function(){}).click(function(event) {
			event.preventDefault(); 
			consol.log($('.meminfo'));
			});	
</script>	

<body class="blur-theme data-container-body">
	<div id="projectmaster" class="content">

			<div class="container-dashboard">
				<div class="container-dashboard-inner">
					<h3>커뮤니티  > 자유게시판</h3>
					<form class="form-inline">
						<div class="clearfix">
							<div class="pull-left">
							</div>
							<div class="pull-right">
								<div class="form-group">
									<button id="writeBtn" class="form-control" type="button" onclick="goSubmit('post','');">작성</button>
								</div>
							</div>
							<div class="pull-right" id="keyword">
								<div class="form-group">
								
								<select class="form-control" name="searchType" id="searchType">
									<option value="tcw" ${pageMaker.cri.searchType eq 'tcw' ? 'selected':'' }>전 체</option>
									<option value="t" ${pageMaker.cri.searchType eq 't' ? 'selected':'' }>제 목</option>
									<option value="w" ${pageMaker.cri.searchType eq 'w' ? 'selected':'' }>작성자</option>
									<option value="c" ${pageMaker.cri.searchType eq 'c' ? 'selected':'' }>내 용</option>
									<option value="tc" ${pageMaker.cri.searchType eq 'tc' ? 'selected':'' }>제목+내용</option>
									<option value="cw" ${pageMaker.cri.searchType eq 'cw' ? 'selected':'' }>작성자+내용</option>
								</select>	
								
									<input type="text" class="form-control" placeholder="검색어를 입력해주세요" id="keyword" name="keyword" value="${pageMaker.cri.keyword }">
									<i class="fa fa-search search-box" aria-hidden="true" id="searchBtn" style="cursor:pointer;"></i>
								</div>
							</div>
						</div>
					</form>
								
								
				<div class="table-responsive">
					<table class="table table-striped" style="font-size: 1.4em;">
						<thead id="trtr">
							<tr >
								<th class="text-center">번호</th>
								<th class="text-center">제목</th>
								<th class="text-center">작성자</th>
								<th class="text-center">날짜</th>
								<th class="text-center">조회수</th>
							</tr>
						</thead>
						<tbody>
						
					<c:forEach items="${point}" var="point">
							<tr>
								<td class="text-center" style="color:red;"><img src="<%=request.getContextPath() %>/resources/images/important.png"></td>
								<td class="text-center" >
								<a style="font-weight: bold; color: blue;" href="<%=request.getContextPath() %>/board/notice/detail?notice_no=${point.notice_no }">${point.notice_title}</a>
								</td>
								<td class="table-text-status" align="center">
									<a href="#">
									<span class="issue-text" ></span>
									${point.notice_writer}
									</a>
								</td>
								<td style="color:red;" align="center">
									<a href="#"><i class="fa"><fmt:formatDate value="${point.notice_regdate}" pattern="yyyy-MM-dd"/></i></a>
								</td>
								<td class="text-center" style="color:red;" align="center">
									<a href="#"><i class="text-center" aria-hidden="true">${point.notice_viewcnt}</i></a>
								</td>
							</tr>
							</c:forEach>	
							
						 <c:forEach items="${freeboardList}" var="freeboard">
							<tr>
								<td class="text-center">${freeboard.freeboard_no }</td>
								<td class="text-center">
								<a href="<%=request.getContextPath()%>/board/free/detail?freeboard_no=${freeboard.freeboard_no }">${freeboard.freeboard_title}
								<c:if test="${freeboard.freeReplycnt > 0 }"><span style="color:blue;font-weight:bold;"> [${freeboard.freeReplycnt}]</span> </c:if>
								</a>
								
								</td>
								<td class="table-text-status" align="center">
								<%-- 	<a class="meminfo" rel="${freeboard.member_id}" href="#" data-hasqtip="21">
									<span class="issue-text"></span>
									${freeboard.member_id}
									</a> --%>
									<a class="meminfo" rel="${freeboard.member_id}" href="#" data-hasqtip="21">
										<i class="issue-text" title="작성자"></i>															
										${freeboard.member_id}
									</a>
								</td>
								<td align="center">
									<i class="fa text-center" aria-hidden="true"><fmt:formatDate value="${freeboard.freeboard_regdate}" pattern="yyyy-MM-dd"/></i>
								</td>
								<td align="center" class="text-center">
									<i class="fa text-center" aria-hidden="true">${freeboard.freeboard_viewcnt}</i>
								</td>
							</tr>
							</c:forEach>
							
						</tbody>
					</table>
				</div>
				
				
				<div>
					
				</div>
			</div>
		</div>
	</div>
	
	<div class="popupLayer" id="meminfo" style="z-index: 100">
	<div style="z-index: 100">
		<span onClick="closeLayer(this)" style="cursor:pointer;font-size:1.5em" title="닫기">X</span>
	</div>
	<%-- <c:set value="${member.member_infoopen }" var="infoopen" /> --%>
	<%-- <c:if test="${infoopen eq 'Y' }"> --%>
	<table border="0" style="font-size:9pt; width:100%; font-size: 1.4em;" cellspacing=0 cellpadding=0>
	<tr>
		<div id="picutreDiv" role="picture" align="left" style="width: 100px; height: 120px;">
			<div id="picturePreView"></div>						 
		</div> 
		
		<td valign="center">
			<table id=Info border=0 cellpadding=0 cellspacing=0>
				<tr height=22>
					<td id="InfoMemtext">&nbsp;<img src="<%=request.getContextPath()%>/resources/images/info/etc_infor_dot.gif" border=0>아이디 : </td>
					<td id="InfoMemId"></td>
				</tr>
				<tr height=22>
					<td id="InfoEmail">&nbsp;<img src="<%=request.getContextPath()%>/resources/images/info/etc_infor_dot.gif" border=0>이메일 : </td>
					<br>
					<td id="InfoMemEmail"></td>
				</tr>
				
			</table>
		</td>
	</tr>
	</table>
	<%-- </c:if > --%>
	
	</div>
	
	<div id="sendMail" class="overlay light" style="z-index: 100">
		<div class="popup2">
			<h4>■ 메일 전송  &nbsp;<button class="mailBtn" id="mailCancel">취소</button>
			<button class="mailBtn" id="sendBtn">전송</button></h4>
			
			<div>
				<label class="title-label">제목</label><br/>
				<input class="mail-title" type="text" id="title" placeholder="제목을 입력해 주세요">
				<label class="content-label">내용</label><br/>
				<textarea id="mail-content"></textarea>
			</div>
			
		</div>
	</div>
	
<form id="jobForm">
		  <input type='hidden' name="page" value="${pageMaker.cri.page}" />
		  <input type='hidden' name="perPageNum" 
		  		 value="${pageMaker.cri.perPageNum}"/>
		  <input type='hidden' name="searchType" 
		         value="${pageMaker.cri.searchType }" />
		  <input type='hidden' name="keyword" 
		         value="${pageMaker.cri.keyword }" />
</form>

</body>
<%@ include file="mail_js.jsp" %>
 <script>
$('#searchBtn').on('click',function(e){
	
	var jobForm=$('#jobForm');
	jobForm.find("[name='page']").val(1);
	jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
	jobForm.find("[name='keyword']").val($('input[name="keyword"]').val());
	
	
	jobForm.attr("action","free.do").attr("method","get");
	jobForm.submit(); 
});

function searchList_go(page,url){
	
	var jobForm=$('#jobForm');
	jobForm.find("[name='page']").val(page);
	jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
	jobForm.find("[name='keyword']").val($('div.input-group>input[name="keyword"]').val());
	jobForm.attr("method","post");
	if(url){
		jobForm.attr("action",url)
	}else{
		jobForm.attr("action","free.do")
	}
	
	jobForm.submit();
}

/*아이디 클릭시 팝업 생성*/
function closeLayer( obj ) {
		$(obj).parent().parent().hide();
	};

$(function(){

	/* 클릭 클릭시 클릭을 클릭한 위치 근처에 레이어가 나타난다. */
	$('.meminfo').click(function(e){
		
		var sWidth = window.innerWidth;
		var sHeight = window.innerHeight;

		var oWidth = $('.popupLayer').width();
		var oHeight = $('.popupLayer').height();
		
		// 레이어가 나타날 위치를 셋팅한다.
		var divLeft = e.clientX + 10;
		var divTop = e.clientY + 5;

		// 레이어가 화면 크기를 벗어나면 위치를 바꾸어 배치한다.
		if( divLeft + oWidth > sWidth ) divLeft -= oWidth;
		if( divTop + oHeight > sHeight ) divTop -= oHeight;

		// 레이어 위치를 바꾸었더니 상단기준점(0,0) 밖으로 벗어난다면 상단기준점(0,0)에 배치한다
		if( divLeft < 0 ) divLeft = 0;
		if( divTop < 0 ) divTop = 0;
		
		$('.popupLayer').css({
			"top": divTop,
			"left": divLeft,
			"position": "absolute"
		}).show();
		var memId = $(this).attr("rel");
		$.ajax({
			type: "get",
 			data:{
 				//member_id:'${member.member_id}'
 				member_id:memId,
 			},
			url : "<%=request.getContextPath()%>/board/free/memInfo/" + memId,
			success:function(suc){
				console.log(suc);
		<%-- 		if(suc =='Y' ){
					
				$("#InfoMemId").empty();
				$("#InfoMemId").append(suc.member_id);

				$("#InfoMemEmail").empty();
 				$("#InfoMemEmail").append(suc.member_email);
				
				$("#picturePreView").empty();
				$("#picturePreView").css("background-image","url('<%=request.getContextPath()%>/board/free/picture/" + suc.memId + "')" );
				}
				else{
					
					$("#InfoMemId").empty();
					$("#InfoMemOpenY").append( suc.member_infoOpen);
				}
				
				 --%>
				 
				if(suc.infoOpen == "Y"){
					
				$("#InfoMemId").empty();
				$("#InfoMemId").append( suc.id);
				
				$("#InfoMemEmail").empty();
				$("#InfoMemEmail").html("<a href='#sendMail' class='infoEmail'>"+suc.email+"</a>");
				
				$("#picturePreView").empty();
				$("#picturePreView").css("background-image","url('<%=request.getContextPath()%>/board/free/picture/" + suc.id + "')" );

				}
				else{
					$("#InfoMemId").empty();
					$("#InfoMemId").append( "비공개");
					$("#InfoMemEmail").empty();
					$("#InfoMemEmail").append("비공개");
					$("#picturePreView").empty();
					$("#picturePreView").css("background-image","url('<%=request.getContextPath()%>/resources/images/info/사용자.png')");
					
				}

				
				/* $("#InfoMemId").remove();
				$("#InfoMemEmail").remove();
				$("#picturePreView").remove();
				 */
			},
			error:function(err){
				alert("에러");
				
			},
			dataType : "json"
		});
		
	});
	
});

/*이메일*/

	$('.popupLayer').on('click','.infoEmail',function(){
		var id = $('#InfoMemEmail').text(); 
	});
	/* function sendMailForm(id){
		$('#InfoMemId').val(id);
	} 
	 */
	$('#mailCancel').on('click',function(){
		var id = $('#InfoMemId').text(); 
 		location.href="#meminfo";
 		
 	});
	
	
	$('#sendBtn').on('click',function(){

		var id = $('#InfoMemId').text();
		var title = $('#title').val();
		var content = $('#mail-content').val();
		$.ajax({
			url:"<%=request.getContextPath()%>/board/free/infoMail",
			data:{"id": id,"title":title,"content":content},
			type:"post",
			success:function(){
				alert('메일을 성공적으로 보냈습니다.')
				location.href="#meminfo";
			},
			error:function(exception){
				alert(exception);
			}
		});
	});
	


</script>

<%@ include file="/WEB-INF/views/commons/pagination.jsp" %>
<%@ include file="/WEB-INF/views/board/free/freeboardList_js.jsp" %>







