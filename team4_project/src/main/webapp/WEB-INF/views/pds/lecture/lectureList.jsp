<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<link href="<%=request.getContextPath() %>/resources/css/pds/lecture/lecture.css" rel="stylesheet">

<body>
<div style="margin-bottom: 50px;">
   <div id="div-lectureData" style="display:'';">
	<div >
	 	<h3><a href="<%=request.getContextPath()%>/myPage/professorMain" style="color: black;">마이페이지</a>><a href="<%=request.getContextPath()%>/professor/pds/main" style="color: black;">자료실</a>><a href="<%=request.getContextPath()%>/pds/lecture/list" style="color: #3199f1;">동영상 자료실</a></h3>
	 	<c:if test="${count < 20 }">
	 	 <button id="registBtn">등록</button>
	 	 </c:if>
	 	 <c:if test="${count == 20}">
	 	 <button id="alertBtn">등록</button>
	 	 </c:if>
	 </div>	
	 	<br/>
	 <c:if test="${empty lectureData }">
	 	<h3 style=" margin-top:200px;text-align: center;">불러올 데이터가 없습니다</h3>
	 </c:if>
	 <c:if test="${not empty lectureData }">
	<c:forEach var="data" items="${lectureData }" varStatus="i">
		<div class="lectre-div">
		<h5 class="lecture-h5">${i.count}회차  ${data.lecture_data_filename}<br/><fmt:formatDate value="${data.lecture_data_regdate}" pattern="yyyy-MM-dd"/></h5>
		<img class="lecture-img" img-index="${data.lecture_data_no }" style="border: 2px solid black;">
		<input type="hidden" value="${data.lecture_data_no } " id="lecture_no${i.index}">

		<c:if test="${data.draft_status eq '결재반려' }">
			<h4 class="lecture-h4">결재 반려</h4>
		</c:if>
		<c:if test="${data.draft_status eq '결재대기' }">
			<h4 class="lecture-h4">결재 대기</h4>
		</c:if>
		<c:if test="${data.draft_status eq '결재승인' }">
			<h4 class="lecture-h4">결재 승인</h4>
		</c:if>
		</div>
	</c:forEach>
	</c:if>
  </div>	
    <form id="draft" method="post" enctype="multipart/form-data" action="draft">
	<div id="div-draft" style="display: none;">
    	<div id="header">
        	<div class="header bg-white">            		
         			<div class="logo col-sm-12">기안서</div>
             		<div class="col-sm-7" style="padding:0px;">             		
              		<div class="col-sm-4 lblock"><label>기안자(ID)</label></div>
              		<div class="col-sm-8 lblock5">
              			<input class="darft-input" name="professor_id" type="text" value="${loginUser.member_id }" readonly="readonly" >
              		</div>
              		<div class="col-sm-4 lblock"><label>기안일자</label></div>
              		<div class="col-sm-8 lblock5">
              			<input class="darft-input" name="draft_regdate" type="date">
              		</div> 
              		<div class="col-sm-4 lblock"><label>마감일자</label></div>
              		<div class="col-sm-8 lblock5">
              			<input class="darft-input" name="draft_deadline" type="date">
              		</div> 
              		<div class="col-sm-4 lblock"><label>제목</label></div>
              		<div class="col-sm-8 lblock5">
              			<input class="darft-input" name="draft_title" type="text">
              		</div>                 		          	
          		</div>
          			<div class="col-sm-1 mblock"><label class="mblocktext">결<br>재</label></div>
          		<div class="col-sm-4" style="padding:0px;">
          			<div class="col-sm-6 rblock2"><label>관리자</label></div>
          			<div class="col-sm-6 rblock2"><label>담당교수</label></div>
          			<div class="col-sm-6 rblock3">
					</div>
         			<div class="col-sm-6 rblock3">
         				<label style="font-size: 30px; margin-left: 15px; margin-top: 38px;"></label>
         			</div>	      			
          		</div>
            </div>
        </div>
        <div class="col-sm-12" style="padding: 0px;">          
            <div class="row">
            	<div class="col-sm-12">
                	<div class="main-content bg-white">
           				<div class="col-sm-12 lblock4" style="padding: 0px;">
           					<label id="imageFile">썸네일</label>
       						<div class="col-sm-5 pull-left" style="background-color: white;">
       							<input onchange="addImage(this);" name="imageFile" type="file" accept=".jpg,.gif,.jepg,.png" style="margin-top:2px; float: left;">
       						</div>
       						<label id="movieFile">영상파일</label>
       						<div class="col-sm-5 pull-left" style="background-color: white;">
       							<input onchange="addMovie(this);" name="movieFile" type="file" accept=".mp4,.avi,.mov,.wmv" style="margin-top:2px; float: left;">
       						</div>
           				</div>
              			<div class="col-sm-12 lblock3" style="padding: 0px;">
              				<textarea id="draft-textarea" name="draft_content" ></textarea>
              			</div>
              			<div class="col-sm-4"></div>
              			<div class="col-sm-4">
              				<div class="pull-left"> 
							  	<input style="display:none;" />
								<button id="submitBtn" class="form-control" type="button" 
								style="color: black; border: 2px solid;margin-top: 10px;">전송</button>
							</div>
							<div class="pull-right"> 
							  	<input style="display:none;" />
								<button id="canselBtn" class="form-control" type="button" 
								style="color: black; border: 2px solid;margin-top: 10px;">취소</button>
							</div>
              			</div>
              			<div class="col-sm-4"></div>
               	    </div>
                </div>
            </div> 
        </div> 
       </div>        
     </form>    
     </div>      
	<script>
		$('#canselBtn').on('click',function(){
			location.reload();
		});
		
		$('#registBtn').on('click',function(){
			$('#div-lectureData').attr('style','display:none;')
			$('#div-draft').attr('style','display:"";')
		});
		$('#submitBtn').on('click',function(){
			var form = $('#draft');
			var title = $('input[name=draft_title]').val();
			var content = $('#draft-textarea').val();
			var regdate = $('input[name=draft_regdate]').val();
			var draft_deadline = $('input[name=draft_deadline]').val();
			var imgFile = $('input[name=imageFile]').val();
			var movieFile = $('input[name=movieFile]').val();
			if(title.length > 50){
				alert('제목은 50자 미만으로 입력해 주세요');
				return false;
			}
			if(content.length > 1000){
				alert('내용은 1000자 미만으로 입력해 주세요')
				return false;
			}
			if(title.length <= 0){
				alert('제목을 입력해 주세요');
				return false;
			}
			if(content.length <= 0){
				alert('내용을 입력해 주세요')
				return false;
			}
			if(regdate.length <= 0){
				alert('날짜를 선택해 주세요')
				return false;
			}
			if(draft_deadline.length <= 0){
				alert('마갈날짜를 선택해 주세요.')
				return false;
			}
			
			if(imgFile.length <= 0){
				alert('썸네일을 첨부해야 합니다')
				return false;
			}
			
			if(movieFile.length <= 0){
				alert('영상을 첨부해야 합니다')
				return false;
			}
			
			form.submit();
			
		});
		
		function addImage(fileObj) {
		 	pathpoint = fileObj.value.lastIndexOf('.');
		    filepoint = fileObj.value.substring(pathpoint+1,fileObj.length);
		    filetype = filepoint.toLowerCase();
		    if(filetype=='jpg' || filetype=='gif' || filetype=='png' || filetype=='jpeg') {
				   var filePath = fileObj.value;
				   var fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
				   $('input[name=imageFile]').val(fileName)

		    } else {
		        alert('이미지 파일만 선택할 수 있습니다.')
				$('input[name=imageFile]').val('');		        
		        return false;
		    }	   	
		}
		function addMovie(fileObj) {
		 	pathpoint = fileObj.value.lastIndexOf('.');
		    filepoint = fileObj.value.substring(pathpoint+1,fileObj.length);
		    filetype = filepoint.toLowerCase();
		    if(filetype=='mp4' || filetype=='avi' || filetype=='mov' || filetype=='wmv') {
				   var filePath = fileObj.value;
				   var fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
				   $('input[name=movieFile]').val(fileName)

		    } else {
		        alert('영상 파일만 선택할 수 있습니다.')
				$('input[name=movieFile]').val('');		        
		        return false;
		    }	   	
		}
		
		$('#alertBtn').on('click',function(){
			alert('등록은 20개 까지만 가능합니다')
		});
		<c:forEach var="data" items="${lectureData }" varStatus="i">
		var index = '${data.lecture_data_no}';
		$("img[img-index='${data.lecture_data_no}']").attr("src", "<%=request.getContextPath()%>/lecture/img?lecture_data_no="+index)
		console.log($(".lecture-img").attr("src"))
		$(".lecture-img").css("background-position", "center")
		$(".lecture-img").css("width","300px")
		$(".lecture-img").css("height","280px")
		</c:forEach>
	</script>
</body>
