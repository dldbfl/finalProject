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
    margin-top: 40px;
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

  <div ng-controller="FormController" >
        <form enctype="multipart/form-data" name="regist" method="post" action="regist" >
    	  <section id="section-timesheet" ng-class="{ scale: success }">
    	  	<div class="inner" style="width: 100%;">

        
 			  <div id="buttons" >
 			  <a>고객센터</a> > <a>공지사항</a> > <a>글작성</a>   <br>   
	            <button id="regist" class="btn btn-primary flex-item btn-primary active hover3" type="button" style="float: right;background-color: #6099b9;border-color: #6099b9;">등록</button>
	            <button id="close" class="btn btn-danger flex-item btn-primary active hover3" type="button" style="float: right;margin-right: 5px;background-color: #fac564;border-color: #fac564;">목록</button>
	          </div>
				          
				          
				          
        <div style="height:30px; width: 100%;float: left; margin-bottom: 5px;margin-top: 5px;">
	  	    
	  	     <div style="width: 34%;height: 100%;float:left;" >
	        	 <label style=" background-color:#b5b5b5;height:100%; width: 114px;border-radius: 3px;text-align: center; padding-top:8px; float: left; ">구분</label>
				 <select class="" name="notice_point" id="notice_point" style="height:100%;float:left;margin-left: 5px;width: 68%;text-align: ">
					<option value="nomal" ${notice.notice_point eq 'nomal' ? 'selected':'' }>공지사항 일반글</option>
					<option value="notice" ${notice.notice_point eq '"notice"' ? 'selected':'' }>공지사항 중요글</option>
					<option value="free" ${notice.notice_point eq 'free' ? 'selected':'' }>자유게시판 중요글</option>
					<option value="lacture" ${notice.notice_point eq 'lacture' ? 'selected':'' }>수강후기 중요글</option>
					<option value="founded" ${notice.notice_point eq 'founded' ? 'selected':'' }>창업후기 중요글</option>
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
	          <input id="title" name="notice_title" type="text" placeholder="제목을 입력하세요" required style="height:100%;width:89.5%; margin-left: 5px;float: left;">
			</div>			
			
			<div style="height:302px; width: 100%;margin-top: 5%;">	
		         <label style=" background-color:#b5b5b5;height:100%; width: 10%;border-radius: 3px;float: left;text-align: center;padding-top:115px;">내용</label>
		          <textarea ng-model="ele.msg" id="content" name="notice_content"></textarea>
		  
		  			<div class="form-group" >								
						<div class="card card-outline card-success">
							<div class="card-header" style="height:30px; float: left;width: 100%;">
								<label style=" background-color:#b5b5b5;height:100%; width: 10%;border-radius: 3px;text-align: center;padding-top:8px;float: left;">첨부파일</label>
									<button class="btn btn-xs btn-primary" type="button" id="addFileBtn" style="height:100%;margin-left: 5px;width: 30px;">+</button>
								
							</div><br><br><br><br>								
							<div class="card-footer fileInput" >
							<br><br>
							</div>
						</div>
					</div>
			  
		    </div>

      </div>
    </section>
  </form>
 </div>
  
  	<form id="jobForm">
		  <input type='hidden' name="notice_point" value="${notice.notice_point}" />
	</form>
  
  



<%@ include file="/WEB-INF/views/summernote_js.jsp" %>
<%@ include file="/WEB-INF/views/board/notice/noticeRegist_js.jsp" %>
<%@ include file="/WEB-INF/views/board/notice/noticeAttach_js.jsp" %>


</body>

<script>



</script>
