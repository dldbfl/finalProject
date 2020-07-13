<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
height:100%;
	width:100%;
	border : 1px solid lightgray;  		
	background-position: center;
	background-repeat: no-repeat;
	background-size: 100% 100%;
</style>

<body>
    <!-- Main Content -->
	<div style="padding-top: 5px;">
		<h3>모집강의</h3>	
        <!-- Image List -->
        <div class="col-sm-4" style="margin-top: 10%;">
          <div class="image-detail" style="width: 350px; height: 350px;
          				background-position: center;
          				background-repeat: no-repeat;
						background-size: 100% 100%;
          				background-image: url('<%=request.getContextPath()%>/manager/picture/${lecture.lecture_img});">
            <%-- <img src="/manager/picture/${lecture.lecture_img}" data-zoom-image="/manager/picture/${lecture.lecture_img}"> --%>
          </div>
          
        </div>
        <!-- End Image List -->

        <div class="col-sm-8" style="margin-top: 10%;">
          <table class="table table-detail" style="font-size: 1.4em;">
            <tbody>
             <tr>
                <td>훈련과정명</td>
                <td>
                 <span>${lecture.lecture_title }</span>
                </td>
              </tr>
         
              <tr>
                <td>담당교수</td>
                <td>
                  <div class="input-qty">
                    <span>${lecture.professor_id }</span>
                  </div>
                </td>
              </tr>
           
              <tr>
                <td>모집기간</td>
                <td>
                 <p><fmt:formatDate value="${lecture.lecture_recruit_date}" pattern="yyyy.MM.dd"/> ~ <fmt:formatDate value="${lecture.lecture_recruit_status}" pattern="yyyy.MM.dd"/> 까지 모집  </p>
                </td>
              </tr>
              <tr>
                <td>수강기간</td>
                <td>
                 <p><fmt:formatDate value="${lecture.lecture_progress}" pattern="yyyy.MM.dd"/> ~ <fmt:formatDate value="${lecture.lecture_end}" pattern="yyyy.MM.dd"/> 수강 예정  </p>
                </td>
              </tr>
             
              <tr>
                <td>수강료</td>
                <td>
                  <div class="price">
                    <p class="price-old">${lecture.lecture_price}원</p>
                  </div>
                </td>
              </tr>
              <tr>
                <td></td>
                <td>
                 	<a class="btn btn-theme m-b-1" href="<%=request.getContextPath()%>/pay/charLMS?lecture_no=${lecture.lecture_no }" style="font-size: 18px;"><i class="fa fa-shopping-cart"></i>신청하기</a>
                 <!--  <button cl	ass="btn btn-theme m-b-1" type="button" id="pay"><i class="fa fa-shopping-cart"></i> 신청하기</button> -->
                  <!-- <button class="btn btn-theme m-b-1" type="button"><i class="fa fa-align-left"></i> Add to Compare</button> -->
                  <button class="btn m-b-1" type="button" id="char" style="background-color: #fff; font-size: 18px;"><i class="fa fa-bars"></i> 목록</button>
                </td>
              </tr>
            </tbody>
          </table>
        </div>

        <div class="col-md-8">

          <!-- Nav tabs -->
          <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active"><a href="#desc" aria-controls="desc" role="tab" data-toggle="tab">강의 상세소개</a></li>
          </ul>
          <!-- End Nav tabs -->

          <!-- Tab panes -->
          <div class="tab-content tab-content-detail">

              <!-- Description Tab Content -->
              <div role="tabpanel" class="tab-pane active" id="desc">
                <div class="well">
                  <p>
                    ${lecture.lecture_content}
                  </p>
                </div>
              </div>
              <!-- End Description Tab Content -->

              </div>
              </div>
      </div>        
</body>
<script>
$('#char').on('click',function(e){
	location.href="<%=request.getContextPath()%>/lecture/list";
});


</script>

