<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<%=request.getContextPath() %>/resources/css/qna/dist/switchery.css" rel="stylesheet">
	<script src="<%=request.getContextPath() %>/resources/css/qna/dist/switchery.js"></script>

<style>


#title {
    height: 25px;
    width: 88.5%;
    margin-top: 3px;
}
#secret{
	width: 20%;
    height: 30px;
    border: 0;
    color: blue;
}
.titls label{
	font-size: 15px;
    margin-top: 5px;
}
textarea[name=consult_content]+div{
	margin: 10px 20px;
}
.writerText{
	float: left;
}

#consult_writer {
    border: 1px solid black;
    width: 113px;
    font-size: 16px;
    width: 60%;
    margin-left: 27px;
}
.writerText label{
	font-size: 15px;
	margin-right: 11px;
}
.writerPwd{
	padding-top: 46px;
}
#pass{
	margin-right: 10px;
}
#password{
	height: 30px;
}
#buttons{
	float:right;
	padding-right: 21px;
}
#section-timesheet{
padding: 20px;
}
.switchery > small {
    background: #fff;
    border-radius: 100%;
    box-shadow: 0 1px 3px rgba(0, 0, 0, 0.4);
    height: 21px;
    position: absolute;
    top: 0;
    width: 20px;
}
.switchery {
    background-color: #fff;
    border: 1px solid #dfdfdf;
    border-radius: 20px;
    cursor: pointer;
    display: inline-block;
    height: 22px;
    position: relative;
    vertical-align: middle;
    width: 50px;
    -moz-user-select: none;
    -khtml-user-select: none;
    -webkit-user-select: none;
    -ms-user-select: none;
    user-select: none;
    box-sizing: content-box;
    background-clip: content-box;
    margin-left: 10px;
    margin-bottom: 2px;
}
section#main-container {
    height: auto;
    margin-top: 19px;
    min-height: 663px;
    font-size: 1.4em;
}
label{
font-size: 1.4em;
height: auto;
}
</style>

	
<body>
  <div class="FormController">

    <section id="section-timesheet" style="background-color: white; width: 100%;">
      <h3>&nbsp;&nbsp;&nbsp;상담문의 등록</h3><br>
      <div class="clearfix" style="width: 100%; background-color: white; height: 500px;">

        <form enctype="multipart/form-data" name="regist" method="post" action="/board/consult/regist" >
         	<div class="titls">
           <label class="col-xs-offset-1 col-xs-1" style="margin-left: 16px;padding-top: 2px;">제목</label>
           	<input class="col-xs-2" id="title" name="consult_title" type="text" placeholder="제목을 입력하세요" required >
			</div>
			<div class="writerPwd">
	  	       <div class="col-xs-offset-1 col-xs-4 writerText" style="margin-left: 10px;">
		  	       <label style="float: left; margin-left: 1%; margin-left: 0px;padding-top: 2px;">작성자</label>
		  	       <input class="col-xs-2" id="consult_writer" name="consult_writer" type="text" placeholder="작성자명을 입력해주세요."  value="${loginUser.member_id }"  required>
	  	       </div>
				 <div class="btn-group" style="width: 500px;height: 24px;">

						<label style="float: left; margin-left: 1%; margin-left: 0px; padding-top: 2px;">비밀글</label>
						<input id="secret" name="consult_type" type="checkbox" class="js-switch" value="일반글"/>

					&nbsp;<input id="password" name="consult_pwd" type="text" value="" placeholder="비밀번호를 입력하세요" style="width:300px; display: none;" >
	  	       </div>
  	       </div>
  	       <br/>
          <textarea id="content" name="consult_content"></textarea>
          <div id="buttons">
            <button id="regist" class="btn btn-primary flex-item btn-primary active" type="button" >등록</button>
            <button id="close" class="btn btn-danger flex-item btn-primary active" type="button" >목록</button>
          </div>
				<input type='hidden' name="page" value="${pageMaker.cri.page}" />
				<input type='hidden' name="perPageNum" value="${pageMaker.cri.perPageNum}"/>
				<input type='hidden' name="searchType" value="${pageMaker.cri.searchType }" />
				<input type='hidden' name="keyword" value="${pageMaker.cri.keyword }" />       
        </form>      
      </div>
    </section>

  </div>
  
</body>

	
<%@ include file="/WEB-INF/views/board/consult/consultRegist_js.jsp" %>
<%@ include file="/WEB-INF/views/board/consult/consultNote_js.jsp" %>
<%@ include file="/WEB-INF/views/board/consult/consultBoardList_js.jsp" %>




