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
textarea[name=qna_content]+div{
	margin: 10px 20px;
}
.writerText{
	float: left;
}

#qna_writer{
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


</style>

<head>
	<link href="<%=request.getContextPath() %>/resources/css/qna/dist/switchery.css" rel="stylesheet">
	<script src="<%=request.getContextPath() %>/resources/css/qna/dist/switchery.js"></script>
    <title>수정</title>


<body>
  <div class="FormController">

    <section id="section-timesheet" style="background-color: white; width: 100%;">
	 <div class="clearfix">
      <h1>Q&A수정</h1>
      <br>
	 </div>
      <div class="clearfix" style="width: 100%; background-color: white; border-top: 2px solid steelblue; height: 500px;">

        <form enctype="multipart/form-data" id="modify" method="post" action="/board/qna/modify" >
         	<div class="titls">
           <label class="col-xs-offset-1 col-xs-1" >제목</label>
           	<input class="col-xs-2" id="title" name="qna_title" type="text" value="${qna.qna_title }" required style="margin-left: 3%; width: 675px; " >
			</div>
			<div class="writerPwd">
	  	       <div class="col-xs-offset-1 col-xs-4 writerText">
		  	       <label style="float: left; margin-left: 1%;">작성자</label>
		  	       <input class="col-xs-2" style="height: 30px; font-size: 15px; " id="qna_writer" name="qna_writer" type="text" value="${loginUser.member_id }" readonly="readonly" required>
	  	       </div>
				 <div class="btn-group">
				 	<c:if test="${not empty qna.qna_password }">
					<span><img id="type" src="<%=request.getContextPath() %>/resources/images/lock.png"></span>&nbsp;
					<input id="secret" name="qna_type" type="checkbox" checked class="js-switch" value="비밀글"/>
					<label id="pass" style="display: inline;"  >비밀번호</label><input id="password" name="qna_password" type="text" value="${qna.qna_password }"  style="width:300px; display: inline;" >
					</c:if>
					<c:if test="${empty qna.qna_password }">
					<span><img id="type" src="<%=request.getContextPath() %>/resources/images/unlock.png"></span>&nbsp;
					<input id="secret" name="qna_type" type="checkbox" class="js-switch" value="일반글"/>
					<label id="pass" style="display: none;"  >비밀번호</label><input id="password" name="qna_password" type="text" value="" placeholder="비밀번호를 입력하세요" style="width:300px; display: none;" >
					</c:if>
					
	  	       </div>
  	       </div>
  	       <br/>
          <textarea id="content" name="qna_content">${qna.qna_content}</textarea>
          <div id="buttons">
            <button id="modifyBtn" class="btn btn-primary flex-item btn-primary active" type="button" >저장</button>
            <button id="close" class="btn btn-danger flex-item btn-primary active" type="button" >닫기</button>
          </div>
          			<input type='hidden' name="qna_no" value="${qna.qna_no}" />
          			<input type='hidden' name="page" value="${pageMaker.page}" />
					<input type='hidden' name="perPageNum" value="${pageMaker.perPageNum}"/>
					<input type='hidden' name="searchType" value="${pageMaker.searchType }" />
					<input type='hidden' name="keyword" value="${pageMaker.keyword }" />
        </form>      
      </div>
    </section>

  </div>
</body>
	<script>
	var elem = document.querySelector('.js-switch');

	var init =new Switchery(elem,{
		    // primary color
		    color             :'#FF0033',
		    secondaryColor    :'#66FF00',
		    className         :'switchery',
		    disabled          :false,
		    disabledOpacity   : 0.5,
		    speed             :'0.4s',
		    // 'small', 'large'
		    size              :'default'
	    
	});

	elem.onchange =function(){
		if($("input:checkbox[name=qna_type]").is(":checked") == true) {
			$('#secret').attr('value', "비밀글");
			$('#pass').attr('style', "display: ''; height:35px;")
			$('#password').attr('style', "display:'';")
			$('#type').attr('src','<%=request.getContextPath() %>/resources/images/lock.png')

		}
		else{
			$('#secret').attr("value","일반글");
			$('#pass').attr('style', "display:none;")
			$('#password').attr('style', "display:none;")
			$('#password').val('')
			$('#type').attr('src','<%=request.getContextPath() %>/resources/images/unlock.png')
		}

	}
	</script>
</html>
<%@ include file="qnanote_js.jsp" %>
<%@ include file="/WEB-INF/views/board/qna/qna.js.jsp" %>

</body>


