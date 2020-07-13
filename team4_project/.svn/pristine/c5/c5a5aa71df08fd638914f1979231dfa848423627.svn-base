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
    margin-top: 101px;
}

#notice_close:hover {
	background: #C7C4FF;
}

#notice_delete:hover{
	background: #C7C4FF;
}
#notice_modify:hover{
	background: #C7C4FF;
}
.buttons{
	width:90px;
	float: right;
	margin: 5px;
}


</style>

<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/filedownload/jquery.fileDownload.js"></script>
<body>
		 		
      <div class="inner" style="width: 100%;margin-top: -60px;font-size: 20px;">

 		  <div class="detailNote" align="left">
            <button id="notice_close" class="btn btn-block buttons" type="button" style="border-color: #C7C4FF;">목 록</button>
	        <button id="notice_delete" class="btn btn-block buttons" type="button" style="border-color: #C7C4FF;">삭 제</button>
           	<button id="notice_modify" class="btn btn-block buttons" type="button" style="border-color: #C7C4FF;">수 정</button>
          </div>

	<div style="float: left;width: 100%;height: 50px;margin-bottom:5px;margin-top: 5px;">
		<label style=" background-color:#D6C7ED;height:100%; width: 10%;border-radius: 3px;text-align: center; padding-top:12px; float: left; ">제목</label>
        <input style="border:none; margin-left:5px; float: left;height: 100%;width: 89.5%;" id="notice_title"  name="notice_title" type="text" value="${notice.notice_title}" required disabled>
	</div>
	
	<div style="float: left;width: 100%;height: 50px;margin-bottom:5px;">
	    <label style=" background-color:#D6C7ED;height:100%; width: 10%;border-radius: 3px;text-align: center; padding-top:12px; float: left; ">작성자</label>
        <input style="border:none;margin-left:5px; float: left;height: 100%;width: 89.5%;" id="notice_title"  name="notice_writer" type="text" value="${notice.notice_writer}" required disabled>
	</div>

	<div style="float: left;width: 100%;height: 50px;margin-bottom:5px;">
        <label style=" background-color:#D6C7ED;height:100%; width: 10%;border-radius: 3px;text-align: center; padding-top:12px; float: left; ">작성일</label>
        <input style="border:none;margin-left:5px; float: left;height: 100%;width: 89.5%;" id="notice_regdate"  name="notice_regdate" type="text" value="<fmt:formatDate value="${notice.notice_regdate}" pattern="yyyy-MM-dd"/>" required disabled>
	</div>	  
					
	<div style="float: left;height:303px; width: 100%;margin-bottom: 5px;">	
         <label style=" background-color:#D6C7ED;height:100%; width: 10%;border-radius: 3px;float: left;text-align: center;padding-top:125px;">내용</label>
         <div style="background-color:#f9f9f9; float: left;margin-left:5px;height:100%;width: 89.5%;">${notice.notice_content}</div>
    </div>
					
    <div style="float: left;height: 70px;width: 100%;margin-bottom: 5px;">	
		 <label style=" background-color:#D6C7ED;height:100%; width: 10%;border-radius: 3px;float: left;text-align: center;padding-top:20px;">첨부파일</label>
		 
		 
						
		 <div style="background-color:#f9f9f9; float: left;margin-left:5px;height:100%;width: 89.5%;">
			<div class="form-group col-sm-10">
							<div class="card card-outline card-success">
								<div class="card-header">
									 
								</div>			
								<div class="card-footer">
									<div class="row">
										<c:forEach items="${notice.notice_attach  }" var="attach">
											<div class="col-md-4 col-sm-4 col-xs-12"  style="cursor:pointer;"
												 onclick="getFile()">
												<div class="info-box" style="padding: 20px;">	
														
													<div class="info-box-content" style="color: blue;width: 100%;text-overflow: ellipsis;" >
														<a class ="info-box-number" style="font-size: small;text-overflow: ellipsis;"><i class="glyphicon glyphicon-floppy-disk fa-2x"></i>&nbsp;${attach.notice_filename }</a>
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
          <div>
            <button id="prev" class="btn " type="button" style="width: 50px;height: 30px;float: right;margin-right: 8px; background-color: #E3C4FF; border-color: #E3C4FF;">></button>
            <button id="next" class="btn " type="button" style="margin-right: 20px;width: 50px;height: 30px;float: right;background-color: #E3C4FF; border-color: #E3C4FF;"><</button>
          </div>


		<div class="managerNoteDetail">
			<table>
				<tbody>
				
					<tr>
						<td><a href="<%=request.getContextPath() %>/manager/detail?notice_no=${notice.nextNo }">이전글 : ${notice.nextTitle}</a></td>
					</tr>
					<tr>
						<td><a href="<%=request.getContextPath() %>/manager/detail?notice_no=${notice.prevNo }">다음글 : ${notice.prevTitle}</a></td>
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
  
	<%@ include file="/WEB-INF/views/manager/notice/noticeDetail_js.jsp" %>
</body>







