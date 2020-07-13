<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.Date"%>

<body>
<div ng-controller="FormController">

    <div id="section-timesheet" ng-class="{ scale: success }">

      <h2>자유게시판 등록</h2>

      <div class="inner">
      
          
        <form role="form" method="post" action="regist.do" name="regist">
         <label for="title">제목</label><br/>
         <input ng-model="ele.title" type="text" name="freeboard_title" class="form-control" placeholder="제목을 입력하세요" required>

          <div class="form-group">
				<label for="writer">작성자</label> 
				<input type="text" id="member_id" readonly
					name="member_id" class="form-control" value="${loginUser.member_id }">
		</div>

          <label>내용 <span>(타인에게 불쾌감을 주는 내용은 권고없이 삭제될 수 있습니다.)</span></label>
          <textarea ng-model="ele.msg" id="content" name="freeboard_content" onkeydown="CheckTextCount(this, 1000);"></textarea>

          <div id="projects">
        
          </div>

          <div id="buttons" align="right">
            <button class="btn button grey flex-item" type="reset" ng-click="clearInfo()" onclick="godelete('post','');">취소</button>
            <button id="regist" class="btn btn-primary flex-item btn-primary active" type="button" >등록</button>
            
          </div>
        </form>

      </div>

     

    </div>

   

 </div>
<%@ include file="/WEB-INF/views/summernote_js.jsp" %>
<%@ include file="/WEB-INF/views/board/free/freeboardList_js.jsp" %>
<%@ include file="/WEB-INF/views/board/free/freeboardRegist_js.jsp" %>
</body>
