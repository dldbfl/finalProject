<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link href="<%=request.getContextPath() %>/resources/css/lecture/lecture.css" rel="stylesheet">
<title>Insert title here</title>
<body>
<div class="container">
        <div>
		<h3>&nbsp;강의실</h3>
		</div>
    <div class="well well-sm">
        <strong>Display</strong>
        <div class="btn-group">
            <a href="#" id="list" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-th-list">
            </span>List</a> <a href="#" id="grid" class="btn btn-default btn-sm"><span
                class="glyphicon glyphicon-th"></span>Grid</a>
        </div>
    </div>
    <div id="products" class="row list-group">
      <c:forEach items="${lectureDataList}" var="lecture" >
        <div class="item  col-xs-4 col-lg-4">
            <div class="thumbnail">
                <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt="" />
                <div class="caption">
                    <h3 class="group inner list-group-item-heading">${lecture.lecture_data_filename}</h3>
                    <p class="group inner list-group-item-text"><fmt:formatDate value="${lecture.lecture_data_regdate}" pattern="yyyy-MM-dd"/>등록일인데..</p>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <p class="lead">${lecture.professor_id} 교수님</p>
                        </div>
                        <div class="col-xs-12 col-md-6" align="right">
                            <a class="btn btn-success" href="<%=request.getContextPath()%>/lecture/video?lecture_data_no=${lecture.lecture_data_no }">영상 보기</a>
                        </div>
                    </div>
                </div>
            </div><!-- thumbnail -->
        </div><!-- item -->
       </c:forEach> 
   
    </div><!-- products -->
</div>

</body>

<script>
 $(document).ready(function() {
    $('#list').click(function(event){event.preventDefault();$('#products .item').addClass('list-group-item');});
    $('#grid').click(function(event){event.preventDefault();$('#products .item').removeClass('list-group-item');$('#products .item').addClass('grid-group-item');});
}); 
</script>