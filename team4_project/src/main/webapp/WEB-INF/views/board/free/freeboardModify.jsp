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

</style>
<body>
  <div ng-controller="FormController">

    <div id="section-timesheet" ng-class="{ scale: success }">

      <h3>내 글 수정</h3>

      <div class="inner" style="width: 100%;">

        <form role="form" name=modifyForm method="post" action="modify" >
         	 <label for="title">제목</label><br/>
         <input ng-model="ele.title" type="text" name="freeboard_title" class="form-control" required value="${freeboard.freeboard_title}">

          <div class="form-group">
				<label for="writer">작성자</label> 
				<input type="text" id="member_id" readonly
					name="member_id" class="form-control" value="${loginUser.member_id }">
		</div>
         	
  		  <input id="freeboard_no" name="freeboard_no"  value="${freeboard.freeboard_no }" hidden="hidden">
  
          <label>내용 </label>
         <textarea ng-model="ele.msg" id="content" name="freeboard_content" >${freeboard.freeboard_content }</textarea>
		  
          <div id="buttons">
            <button id="addfreeModifyBtn"  class="btn btn-primary flex-item btn-primary active" type="button" >등록</button>
            <button id="cancelBtn" class="btn btn-danger flex-item btn-primary active" type="button" >뒤로가기</button>
          </div>
        </form>

      </div>

    </div>

  </div>
</body>

<%@ include file="/WEB-INF/views/summernote_js.jsp" %>
<%@ include file="/WEB-INF/views/board/free/freeboardList_js.jsp" %>
<script>
$('#addfreeModifyBtn').on("click",function(){
	var title=$('input[name="title"]');
	if(title.val()==""){
		alert("제목은 필수입니다.");
		title.focus();
		return;
	}
	var form=document.modifyForm;
	form.submit();
});
$('#cancelBtn').on('click',function(){
	history.go(-1);
});
</script>

</body>

