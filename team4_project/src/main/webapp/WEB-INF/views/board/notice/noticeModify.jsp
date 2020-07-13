<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
@font-face {
  font-family: 'azo_sansbold';
  src: url('https://s3-us-west-2.amazonaws.com/s.cdpn.io/260783/rui_abreu_-_azosans-bold-webfont.eot');
  src: url('https://s3-us-west-2.amazonaws.com/s.cdpn.io/260783/rui_abreu_-_azosans-bold-webfont.eot?#iefix') format('embedded-opentype'), url('https://s3-us-west-2.amazonaws.com/s.cdpn.io/260783/rui_abreu_-_azosans-bold-webfont.woff2') format('woff2'), url('https://s3-us-west-2.amazonaws.com/s.cdpn.io/260783/rui_abreu_-_azosans-bold-webfont.woff') format('woff'), url('https://s3-us-west-2.amazonaws.com/s.cdpn.io/260783/rui_abreu_-_azosans-bold-webfont.woff') format('truetype'), url('https://s3-us-west-2.amazonaws.com/s.cdpn.io/260783/rui_abreu_-_azosans-bold-webfont.svg#azo_sansbold') format('svg');
  font-weight: normal;
  font-style: normal;
}

.inner {
  
    background-color: white;
}
section#main-container {
    background-color: white;
   
}

section {
    width: 100%;
    height: 100%;
}

.note-editor.note-frame {
    border: 1px solid #a9a9a9;
    width: 89.5%;
    float: right;
    height: 302px;
}
.hover3:hover {
	box-shadow: 0 80px 0 0 rgba(0, 0, 0, 0.25) inset, 0 -80px 0 0
		rgba(0, 0, 0, 0.25) inset;
}
</style>


<body>

          <form enctype="multipart/form-data" name=modifyForm method="post" action="modify" >
  			<input id="notice_no" name="notice_no"  value="${notice.notice_no }" hidden="hidden">
        
 			  <div id="buttons" style="margin-top: 100px;">
 			  <a>고객센터</a> > <a>공지사항</a> > <a>상세내용</a> > <a>글수정</a>  <br>    
	            <button id="close" class="btn btn-danger flex-item btn-primary active hover3" type="button" style="float: right;background-color: #F09819;border-color: #F09819;">목록</button>
	            <button id="backBtn" class="btn btn-danger flex-item btn-primary active hover3" type="button" style="float: right;margin-right: 5px;background-color: #b5b5b5;border-color: #b5b5b5;">이전</button>
	            <button id="modifyBtn" class="btn btn-primary flex-item btn-primary active hover3" type="button" style="float: right;background-color: #4db956;border-color: #4db956;margin-right: 5px;">수정</button>
	          </div>
				          
				     
				          
        <div style="height:30px; width: 100%;float: left; margin-bottom: 5px;margin-top: 5px;">
	  	    
	  	     <div style="width: 34%;height: 100%;float:left;" >
	        	 <label style=" background-color:#b5b5b5;height:100%; width: 114px;border-radius: 3px;text-align: center; padding-top:8px; float: left; ">구분</label>
				 <select class="" name="notice_point" id="notice_point" style="height:100%;float:left;margin-left: 5px;width: 68%;text-align: ">
					<option value="nomal" ${notice.notice_point eq 'nomal' ? 'selected':'' }>공지사항 일반글</option>
					<option value="notice" ${notice.notice_point eq '"notice"' ? 'selected':'' }>공지사항 중요글</option>
					<option value="free" ${notice.notice_point eq 'free' ? 'selected':'' }>자유게시판 중요글</option>
					<option value="lacture" ${notice.notice_point eq 'lacture' ? 'selected':'' }>수강후기 중요글</option>
					<option value="Faunded" ${notice.notice_point eq 'Faunded' ? 'selected':'' }>창업후기 중요글</option>
					<option value="consult" ${notice.notice_point eq 'consult' ? 'selected':'' }>상담문의 중료글</option>
					<option value="Q&A" ${notice.notice_point eq 'Q&A' ? 'selected':'' }>Q&A 중료글</option>
				 </select>
			 </div> 					
				
				
			 <div style="width: 33%;height: 100%;float:left;" >
	        	 <label style=" background-color:#b5b5b5;height:100%; width: 114px;border-radius: 3px;text-align: center; padding-top:8px; float: left; ">마감일</label>
				 <input id="notice_finishdate" name="notice_finishdate" value="" type="date" style="width: 67%;height: 100%;margin-left: 5px;">
			 </div> 			
				
				
				
				
			 <div style="width: 33%;height: 100%;float:left;" >
	        	 <label style=" background-color:#b5b5b5;height:100%; width: 114px;border-radius: 3px;text-align: center;padding-top:8px;float: left;">작성자</label>
	  	    	 <input id="notice_writer" name="notice_writer" type="text" value="admin" required readonly="readonly" style="height:100%;width:68%; margin-left: 5px;float: left;">
  	         </div> 
  	         
		</div>	
			
			
			
  	      	<div style="width: 100%;height: 30px;float:left;margin-bottom: 5px;" >					
			  <label style=" background-color:#b5b5b5;height:100%; width: 10%;border-radius: 3px;float: left;text-align: center;padding-top:8px;">제목</label>
	          <input id="title" name="notice_title" type="text" placeholder="제목을 입력하세요" required value="${notice.notice_title }" style="height:100%;width:89.5%; margin-left: 5px;float: left;">
			</div>			
			
			<div style="height:302px; width: 100%;margin-top: 5%;">	
		         <label style=" background-color:#b5b5b5;height:100%; width: 10%;border-radius: 3px;float: left;text-align: center;padding-top:115px;">내용</label>
		          <textarea id="content" name="notice_content">${notice.notice_content }</textarea>
		    </div>




		<div class="card-header" style="height:30px; width: 100%;margin-top: 5px;float: left;">
		<label style=" background-color:#b5b5b5;height:100%; width: 10%;border-radius: 3px;text-align: center;padding-top:8px;float: left;">첨부파일</label>
		<button class="btn btn-xs btn-primary" type="button" id="addFileBtn" style="height:100%;width: 30px;float: left;margin-left: 5px;">+</button>
		</div>	
		
										
		<div class="card-footer fileInput">
			<ul class="mailbox-attachments d-flex align-items-stretch clearfix" style="margin-top: 120px;">
				
				<c:forEach items="${notice.notice_attach}" var="attach" >
				<li class="attach-item">																			
					<div class="mailbox-attachment-info">
						<a  class="mailbox-attachment-name" name="attachedFile" attach-fileName="${attach.notice_filename }" attach-no="${attach.notice_data_no }">													
							<i class="fas fa-paperclip"></i>${attach.notice_filename }&nbsp;&nbsp;<button type="button" style="border:0;outline:0;" class="badge bg-red">X</button>																									
						</a>													
					</div>
				</li>	
				</c:forEach>
				
			</ul>
																
		</div>
		
<br><br><br><br><br>




  </form>
  
  	<form id="jobForm">
		  <input type='hidden' name="notice_point" value="${notice.notice_point}" />
	</form>
  
  



<%@ include file="/WEB-INF/views/summernote_js.jsp" %>
<%@ include file="/WEB-INF/views/board/notice/noticeModify_js.jsp" %>

</body>

