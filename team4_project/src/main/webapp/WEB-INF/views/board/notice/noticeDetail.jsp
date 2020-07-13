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

section#main-container {
    margin-top: 50px;
}

.form-group {
    height: 30px;
}
.hover3:hover {
	box-shadow: 0 80px 0 0 rgba(0, 0, 0, 0.25) inset, 0 -80px 0 0
		rgba(0, 0, 0, 0.25) inset;
}
section#main-container {
    height: auto;
    margin-top: 19px;
    min-height: 663px;
    font-size: 1.4em;
}

</style>

<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/filedownload/jquery.fileDownload.js"></script>
<body>
		
		<h2>공지사항 내용</h2>
    

      <div class="inner" style="width: 100%;">

 		  <div>
            <button id="close" class="btn btn-danger flex-item btn-primary active hover3" type="button" style="float: right;background-color: #F09819;border-color: #F09819; font-size: 1.4em;height: auto;">목 록</button>
            <c:if test="${loginUser.member_authority=='ADMIN'}">
            <button id="delete" class="btn btn-danger flex-item btn-primary active hover3" type="button" style="float: right;margin-right: 5px;background-color: #f74747;border-color: #f74747;">삭 제</button>&nbsp;&nbsp;
            <button id="modify" class="btn btn-primary flex-item btn-primary active hover3" type="button" style="float: right;background-color: #4db956;border-color: #4db956;margin-right: 5px;">수 정</button>&nbsp;&nbsp;
            </c:if>
          </div>

	<div style="float: left;width: 100%;height: 30px;margin-bottom:5px;margin-top: 5px;">
		<label style=" background-color:#b5b5b5;height:100%; width: 10%;border-radius: 3px;text-align: center; float: left; padding-top: 5px;">제목</label>
        <input style="border:none; margin-left:5px; float: left;height: 100%;width: 89.5%;" id="notice_title"  name="notice_title" type="text" value="${notice.notice_title}" required disabled>
	</div>
	
	<div style="float: left;width: 100%;height: 30px;margin-bottom:5px;">
	    <label style=" background-color:#b5b5b5;height:100%; width: 10%;border-radius: 3px;text-align: center; padding-top:5px; float: left; ">작성자</label>
        <input style="border:none;margin-left:5px; float: left;height: 100%;width: 89.5%;" id="notice_title"  name="notice_writer" type="text" value="${notice.notice_writer}" required disabled>
	</div>

	<div style="float: left;width: 100%;height: 30px;margin-bottom:5px;">
        <label style=" background-color:#b5b5b5;height:100%; width: 10%;border-radius: 3px;text-align: center; padding-top:5px; float: left; ">작성일</label>
        <input style="border:none;margin-left:5px; float: left;height: 100%;width: 89.5%;" id="notice_regdate"  name="notice_regdate" type="text" value="<fmt:formatDate value="${notice.notice_regdate}" pattern="yyyy-MM-dd"/>" required disabled>
	</div>	  
					
	<div style="float: left;height:250px; width: 100%;margin-bottom: 5px;">	
         <label style=" background-color:#b5b5b5;height:100%; width: 10%;border-radius: 3px;float: left;text-align: center;padding-top:115px;">내용</label>
         <div style="background-color:#f9f9f9; float: left;margin-left:5px;height:100%;width: 89.5%;overflow-y: scroll;">${notice.notice_content}</div>
    </div>
					
    <div style="float: left;height:30px; width: 100%;margin-bottom: 5px;">	
		 <label style=" background-color:#b5b5b5;height:100%; width: 10%;border-radius: 3px;float: left;text-align: center;padding-top:5px;">첨부파일</label>
		 
		 
						
		 <div style="background-color:#f9f9f9; float: left;margin-left:5px;height:100%;width: 89.5%;">
			<div class="form-group col-sm-12">
							<div class="card card-outline card-success" style="height: 30px;">
								<div class="card-header">
									 
								</div>			
								<div class="card-footer" style="height: 30px;">
									<div class="row" style="height: 30px;">
										<c:forEach items="${notice.notice_attach  }" var="attach">
											<div class="col-md-4 col-sm-4 col-xs-12"  style="cursor:pointer; height: 30px;width: 160px;"
												 onclick="getFile()">
												<div class="info-box" style="height: 30px;width: 150px;">	
														
													<div class="info-box-content" style="color: blue;width: 150px;text-overflow: ellipsis; height: 30px;float: left;text-overflow: ellipsis;" >
														<a class ="info-box-number" style="font-size: small;text-overflow: ellipsis;width: 100%;float: left;"><i class="glyphicon glyphicon-floppy-disk fa-2x"></i>&nbsp;${attach.notice_filename }</a>
														<input value="${attach.notice_data_no }" type="hidden" id="attachNo">
													</div>
												</div>
											 </div>											 
										</c:forEach>
									</div>
								</div>				
							</div>
						</div>
			</div>			
			
	</div>
			
			
			
			

		

		 <br><br>
          <div style="margin-top: 5px;">
            <button id="prev" class="btn btn-primary flex-item btn-primary active btn-xs hover3" type="button" style="width: 50px;height: 30px;float: right;margin-right: 5px;background-color: #b5b5b5;border-color: #b5b5b5;font-size: 1.4em;height: auto;position: relative;left: 6%;top: -222px;">></button>
            <button id="next" class="btn btn-primary flex-item btn-primary active btn-xs hover3" type="button" style="width: 50px;height: 30px;float: right;background-color: #b5b5b5;border-color: #b5b5b5;font-size: 1.4em;height: auto;position: relative;left: -96%;top: -222px;"><</button>
          </div>


		<div>
			<table>
				<tbody>
				
					<tr>
						<td><a href="<%=request.getContextPath() %>/board/notice/detail?notice_no=${notice.nextNo }">이전글 : ${notice.nextTitle}</a></td>
					</tr>
					<tr>
						<td><a href="<%=request.getContextPath() %>/board/notice/detail?notice_no=${notice.prevNo }">다음글 : ${notice.prevTitle}</a></td>
					</tr>
				</tbody>
			</table>
		</div>

<br><br><br><br><br>
		<form role="form">
							<input id="notice_no" type='hidden' name='notice_no' value="${notice.notice_no }">
							<input type='hidden' name='notice_title' value="${notice.notice_title }">
							<input type="hidden" name="perPageNum" value="${param.perPageNum }">
							<input type="hidden" name="searchType" value="${param.searchType }">
							<input type="hidden" name="keyword" value="${param.keyword }">
				</form>
						<input type="hidden" id="filePath" name="filePath" value="">
						<input type="hidden" id="fileName" name="fileName" value="">
						<input type="hidden" id="originalName" name="originalName" value="">
							
      </div>
  
	<%@ include file="/WEB-INF/views/board/notice/noticeDetail_js.jsp" %>
</body>







