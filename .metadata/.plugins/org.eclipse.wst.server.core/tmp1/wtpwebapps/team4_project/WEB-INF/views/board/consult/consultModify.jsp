<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<style>


#title{
	height: 30px;
    width: 490px;
    margin-top: 5px;
    margin-right: 14%;
	
}
#secret{
	width: 20%;
    height: 30px;
    border: 0;
    color: blue;
}
.titls label{
	font-size: 20px;
    margin-top: 5px;
}
textarea[name=consult_content]+div{
	margin: 10px 20px;
}
.writerText{
	float: left;
}

#consult_writer{
    border: 1px solid black;
    width: 113px;
    font-size: 19px;
    width: 60%;
    margin-left: 11%;
    
}
.writerText label{
	font-size: 20px;
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


section#main-container {
    height: auto;
  	margin-top: 50px;
    min-height: 663px;
    font-size: 1.4em;
}
.hover3:hover {
	box-shadow: 0 80px 0 0 rgba(0, 0, 0, 0.25) inset, 0 -80px 0 0
		rgba(0, 0, 0, 0.25) inset;
}
.btn{
font-size: 1em;
margin-bottom: 5px;
}

</style>

<head>

	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<link href="<%=request.getContextPath() %>/resources/css/qna/dist/switchery.css" rel="stylesheet">
	<script src="<%=request.getContextPath() %>/resources/css/qna/dist/switchery.js"></script>
    <title>등록</title>


<body>
  <div class="FormController">

    <section id="section-timesheet" style="background-color: white; width: 100%;">
	 <div class="clearfix">
      <h3>상담문의 수정</h3><br>
	 </div>
      <div class="clearfix" style="width: 100%; background-color: white; border-top: 2px solid steelblue; height: 500px;">

        <form enctype="multipart/form-data" name="modify" method="post" action="modify" >
         	<div class="titls">
           <label class="col-xs-offset-1 col-xs-1" style="margin-top: 5px;padding-left: 18px;">제목</label>
           	<input value="${consult.consult_title }" class="col-xs-2" id="title" name="consult_title" type="text" placeholder="제목을 입력하세요" required style="margin-left: 3%; width: 675px; " >
			</div>
			<div class="writerPwd">
	  	       <div class="col-xs-offset-1 col-xs-4 writerText">
		  	       <label style="float: left; margin-left: 1%;">작성자</label>
		  	       <input value="${consult.consult_writer }" class="col-xs-2" id="consult_writer" name="consult_writer" type="text" readonly="readonly" required>
	  	       </div>
					 <div class="btn-group">

						<span >비밀글 </span>
						<input id="secret" name="consult_type" type="checkbox" class="js-switch" value="일반글"/>

					<label id="pass" style="display: none;"  >비밀번호</label>
					<input id="password" name="consult_pwd" type="text" value="${consult.consult_pwd }" placeholder="비밀번호를 입력하세요" style="width:300px; display: none;" >
	  	       </div>
  	       </div>
  	       <br/>
          <textarea id="content" name="consult_content">${consult.consult_content }</textarea>
          <div id="buttons">
            <button id="modifyBtn" class="btn btn-primary flex-item btn-primary active hover3" type="button" >등록</button>
            <button id="close" class="btn btn-danger flex-item btn-primary active hover3" type="button" >취소</button>
          </div>
    			      
				<input type='hidden' name="consult_no" value="${consult.consult_no}" />
				<input type='hidden' name="page" value="${pageMaker.cri.page}" />
				<input type='hidden' name="perPageNum" value="${pageMaker.cri.perPageNum}"/>
				<input type='hidden' name="searchType" value="${pageMaker.cri.searchType }" />
				<input type='hidden' name="keyword" value="${pageMaker.cri.keyword }" />       
        </form>      
      </div>
    </section>

  </div>
<%@ include file="/WEB-INF/views/board/consult/consultModify_js.jsp" %>
<%@ include file="/WEB-INF/views/board/consult/consultNote_js.jsp" %>
</body>




