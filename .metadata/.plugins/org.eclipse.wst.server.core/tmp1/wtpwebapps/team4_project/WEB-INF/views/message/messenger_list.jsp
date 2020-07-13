<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<style>
 .recycle:hover { 
  color: red; 
  transition-duration: .05s; 
  text-decoration: none; 
 }
  .boardWrap{
  	
 	
 }
 a{
 	color: black;
 	font-size: 1.1em;
 }

</style>



<head>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/filedownload/jquery.fileDownload.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/message/message.js"></script>
<link rel='stylesheet' href="<%=request.getContextPath()%>/resources/css/message/messenger.css">
<link rel='stylesheet' href="<%=request.getContextPath()%>/resources/css/message/write.css">
<!------ Include the above in your HEAD tag ---------->
</head>
<body>
	<div class="boardWrap">
	<div class="container">
		<div class="mail-box">
			<h3 style="margin-top: 20px;"><a href="<%=request.getContextPath()%>/myPage/professorMain" style="color:black;">마이페이지</a>><a id="head1" href="javascript:location.reload()" style="color:#308fe2;" >발신함</a>><a href="<%=request.getContextPath()%>/message/messenger/recycle_list" style="color:black;">발신함 휴지통</a></h3>
				<br/>
				<div class="inbox-head">
				</div>
				<div class="inbox-body">
					<div class="mail-option">
						<div class="chk-all">
							<form id="messengerSearch" method="post" action="messenger_list" >
								<input name="page" type="hidden" value="${pageMaker.cri.page }">
								<input name="perPageNum" type="hidden"
									value="${pageMaker.cri.perPageNum }">
								<div class="btn-group">
									<a data-toggle="dropdown" href="#" class="btn mini all"
										aria-expanded="false" style="font-size:16px;">쪽지함&nbsp; <i
										class="fa fa-angle-down "></i>
									</a>
									<ul class="dropdown-menu">
										<li><a
											href="<%=request.getContextPath() %>/message/receiver_list" style="font-size:16px;">수신함</a></li>
										<li><a
											href="<%=request.getContextPath() %>/message/messenger/recycle_list" style="font-size:16px;">
												휴지통</a></li>

									</ul>
								</div>
								<div class="btn-group">
									<a data-toggle="dropdown" href="#" class="btn mini all"
										aria-expanded="false" style="font-size:16px;"> 체크 <i class="fa fa-angle-down "></i>
									</a>
									<ul class="dropdown-menu" style="font-size:16px;">
										<li><a href="#" id="chkAll" style="font-size:16px;"> 모두 체크</a></li>
										<li><a href="#" id="readChk" style="font-size:16px;"> 읽은 것만</a></li>
										<li><a href="#" id="unReadChk" style="font-size:16px;"> 안 읽은 것만</a></li>
										<li><a href="#" id="unChkAll" style="font-size:16px;"> 모두체크 해제</a></li>
									</ul>
								</div>
								<a href="javascript:history.go(0)" class="btn mini tooltips">
									<i class=" fa fa-refresh" style="font-size:16px;">새로 고침</i>
								</a>
								<!-- 모달로 작성창 띄우기 -->
								<a href="#write" class="btn mini tooltips"> <i
									class=" fa fa-send-o" style="font-size:16px;">쪽지 보내기</i>
								</a>
								<a href="#" onclick="messenger_allRecycle()" class="btn mini tooltips"> <i
									class=" fa fa-trash-o" style="font-size:16px;">일괄휴지통</i>
								</a>
								
								<select id="searchType" name="searchType"
									style="width: 100px; float: right;">
									<option value="" style="font-size:16px;">검색구분</option>
									<option value="t"
										${pageMaker.cri.searchType eq 't' ? 'selected':'' } style="font-size:16px;">제목</option>
									<option value="r"
										${pageMaker.cri.searchType eq 'r' ? 'selected':'' } style="font-size:16px;">받는
										사람</option>
									<option value="c"
										${pageMaker.cri.searchType eq 'c' ? 'selected':'' } style="font-size:16px;">내용</option>
								</select>		
									<input type="text" placeholder="Search Message"
										style="width: 250px; float: right;" name="keyword"
										id="messengerKeyword" value="${pageMaker.cri.keyword }">
									<span id="gridSearch" class="input-group-btn"
										style="display: inline;">
										<button id="messengerSearchBtn" class="btn sr-btn" type="button"
											style="float: right; padding: 5px;">
											<i class="fa fa-search"></i>
										</button>
									</span>
								<span id="gridSearchReset" style="display:none;">
								<button type="button" class="btn btn-sm btn-white">
									<i class="red ace-icon fa fa-times bigger-120"></i>
								</button>
							</span>							
							</form>
						</div>
					</div>
					<c:forEach var="messenger" items="${messenger }">
						<input type="hidden" id="mno" value="${messenger.messenger_no }" style="font-size:16px;">
						<table class="table table-inbox">
							<thead>
							</thead>
							<tr>
								<td style="text-align:center; width:7%; padding: 20px 0px 0px 20px;"
									class="inbox-small-cells">
									<input type="checkbox" id="messenger_checked" style="font-size:16px;"
									class="mail-checkbox" role="${messenger.messenger_check }" value="${messenger.messenger_no }"></td>
								<c:set var="check" value="${messenger.messenger_check }" />
								<c:if test="${check eq 'n' }">
									<td class="inbox-small-cells" style="font-size:16px;"
										style="width: 7%; text-align: center;"><i
										class="fa fa-envelope-o"></i></td>
								</c:if>
								<c:if test="${check eq 'y' }">
									<td style="width: 7%; text-align: center;"><i
										class="fa fa-envelope-open-o"></i></td>
								</c:if>
								<td style="text-align: center; width: 11%;"><a style="color:black;" href="#towrite" onclick="messenger_Detail(${messenger.messenger_no})">${messenger.messenger_receiver }</a></td>
								<td style="text-align: left; width: 45%;"><a style="color:black;"href="#detail" onclick="messenger_Detail(${messenger.messenger_no})">${messenger.messenger_title }</a></td>
								 <c:set var="fileCheck" value="${messenger.messenger_filecheck }" />
								 <c:if test="${fileCheck eq 'y' }">
								<td style="width: 50px; text-align: right;"><i
									class="fa fa-paperclip"></i></td>
								</c:if>	
								 <c:if test="${fileCheck eq 'n' }">
								<td style="width: 50px; text-align: right;"><i
									class="fa fa-times"></i></td>
								</c:if>	
								<td style="width: 200px; text-align: right;"><i
									class="glyphicon glyphicon-time"><fmt:formatDate
											value="${messenger.messenger_senddate }" pattern="yyyy-MM-dd hh:mm:ss" /></i></td>
								<td class="recycle"
									style="text-align: center; width: 100px; cursor: pointer;"
									onclick="messenger_recycle('${messenger.messenger_no }');"><i
									class="fa fa-trash-o"></i>휴지통</td>
							</tr>
						</table>
						<hr>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 모달 부분 -->
	
	<!-- 쪽지 보내기 -->
	<div id="write" class="overlay light">
		<div class="popup1">
			<h3>쪽지 보내기</h3>
			<div class="formpopup1">
				<form id="messengerForm" method="post" autocomplete="off" enctype="multipart/form-data">
					<input id="messenger_writer" name ="messenger_writer" type="hidden" value="${loginUser.member_id }">TO <br/>
					<input id="messenger_receiver" name="messenger_receiver" placeholder="받는 사람 아이디를 입력해 주세요" type="text" style="width : 250px;">	
					<br/>
					<input id="messenger_title" name="messenger_title" placeholder="제목을 30자 미만으로 적어주세요" type="text" style="width : 250px;">	
					<br/>
					<textarea id="messenger_content" name="messenger_content" placeholder="내용을 500자 미만으로 적어 주세요" style="resize: none; width: 250px; height: 250px;"></textarea>
					<br/>
					<div class="input-file">
						<input type="text" readonly="readonly" class="file-name" />
						<label for="attach" class="file-label">파일 첨부</label>
						<input type="file" name="messenger_file" id="attach" class="file-upload"/>
					</div>
					<div >
						
					</div>
				</form>
			</div>
			<br/> <br/>
			<div class="hamo">
				<button id="sendMsg" class="button3" >전송</button>
				<button id="cancelBtn" class="button3" onclick="messenger_modal_cancel()">취소</button>
			</div>
		</div>
	</div>
	
	<!-- 아이디 지정 쪽지 보내기 -->
	<div id="towrite" class="overlay light">
		<div class="popup1">
			<h3>쪽지 보내기</h3>
			<div class="formpopup1">
				<form id="tomessengerForm" method="post" autocomplete="off" enctype="multipart/form-data">
					<input id="tomessenger_writer" name ="tomessenger_writer" type="hidden" value="${loginUser.member_id }">TO <br/>
					<input id="tomessenger_receiver" name="tomessenger_receiver" type="text" style="width : 250px;" readonly="readonly">	
					<br/>
					<input id="tomessenger_title" name="tomessenger_title" placeholder="제목을 30자 미만으로 적어주세요" type="text" style="width : 250px;">	
					<br/>
					<textarea id="tomessenger_content" name="tomessenger_content" placeholder="내용을 500자 미만으로 적어 주세요" style="resize: none; width: 250px; height: 250px;"></textarea>
					<br/>
					<div class="input-file">
						<input type="text" readonly="readonly" class="file-name" />
						<label for="toattach" class="file-label" style="cursor: pointer;">파일 첨부</label>
						<input type="file" name="tomessenger_file" id="toattach" class="file-upload"/>
					</div>
					<div >
					</div>
				</form>
			</div>
			<br/> <br/>
			<div class="hamo">
				<button id="tosendMsg" class="button3" >전송</button>
				<button id="cancelBtn" class="button3" onclick="messenger_modal_cancel()">취소</button>
			</div>
		</div>
	</div>
	
	<!-- 상세보기 -->
	<div id="detail" class="overlay light">
		<div class="popup1">
			<div class="formpopup1">
				<form id="detailForm" action="/dlms/message/fileDownload" method="post" autocomplete="off" enctype="multipart/form-data">
				<input type="hidden" id="detailState" name = "detailState" value="1" />
				<input type="hidden" name ="realPath" id="realPath" />
				<input type="hidden" name="realName" id="realName" />
					<h3>From </h3><br/>
					<input id="detail_writer" name="detail_writer" type="text" style="width : 250px;" readonly="readonly">	
					<br/>
					<input id="detail_date" name="detail_date"  type="text" style="width : 250px; color:black;" readonly="readonly">	
					<br/><br/>
					<div id="detail_content" style="resize: none; width: 270px; height: 300px; color:black; overflow:scroll;"></div>
					<br/>
					<div class="input-file" style="width:197px; float:left;">
						<input type="text" readonly="readonly" name="fileName" id="fileName" class="file-name" style="width: 200px;"/>
					</div>
					<div class="input-file">
						<label class="file-label"><a class="button" onclick="fileDownload();" style="cursor: pointer;"><i class="fa fa-save"></i></a></label>
									
					</div>
				</form>
			</div>
			<br/> <br/>
			<div class="hamo">
				<button id="cancelBtn" class="button3" onclick="messenger_modal_cancel()">확인</button>
			</div>
		</div>
	</div>
	<nav aria-label="member list Navigation" class="col-xs-offset-5 col-xs-7" style="margin-top: 25px;">
	<ul class="pagination justify-content-center m-0">
		<li class="page-item">
			<a class="page-link" href="javascript:searchList_go(1);">
			<i class="glyphicon glyphicon-step-backward"></i>
			</a>
		</li>
		<li class="page-item">
			<a class="page-link" href="javascript:searchList_go(
			${pageMaker.prev ? pageMaker.startPage-1 : 1}				
			);"><i class="glyphicon glyphicon-chevron-left"></i></a>
		</li>
		<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="pageNum">						
		<li class="page-item 
			<c:out value="${pageMaker.cri.page == pageNum?'active':''}"/>">
			<a class="page-link" href="javascript:searchList_go(${pageNum});" >${pageNum }
			</a>
		</li>
		</c:forEach>
		<li class="page-item">
			<a class="page-link" href="javascript:searchList_go(
			${pageMaker.next ? pageMaker.endPage+1 : pageMaker.cri.page}			
			);"><i class="glyphicon glyphicon-chevron-right" ></i></a>
		</li>
		<li class="page-item">
			<a class="page-link" href="javascript:searchList_go(
				${pageMaker.realEndPage} );">
				<i class="glyphicon glyphicon-step-forward"></i></a>
		</li>	
	</ul>
</nav>   	

<form id="jobForm">
	<input type='hidden' name="page" value="${pageMaker.cri.page}" />
	<input type='hidden' name="perPageNum" value="${pageMaker.cri.perPageNum}"/>
	<input type='hidden' name="searchType" value="${pageMaker.cri.searchType }" />
	<input type='hidden' name="keyword" value="${pageMaker.cri.keyword }" />
</form>
</body>
<script>
function searchList_go(page,url){
	
	var jobForm=$('#jobForm');
	jobForm.find("[name='page']").val(page);
	jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
	jobForm.find("[name='keyword']").val($('div.input-group>input[name="keyword"]').val());
	jobForm.attr("method","post");
	if(url){
		jobForm.attr("action",url)
	}else{
		jobForm.attr("action","messenger_list")
	}
	
	jobForm.submit();
}
</script>
	

<%@include file="massage.js.jsp" %>
