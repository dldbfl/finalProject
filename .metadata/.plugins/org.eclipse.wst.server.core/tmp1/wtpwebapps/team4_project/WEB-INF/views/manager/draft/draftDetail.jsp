<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
<title>기안서 상세 보기</title>
</head>
	<link href="<%=request.getContextPath() %>/resources/css/draft/bootstrap.min.css" rel="stylesheet" />
	<link href="<%=request.getContextPath() %>/resources/css/draft/style.css" rel="stylesheet" type="text/css" />
	<!-- JQuery 3.4.1 -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	 <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/filedownload/jquery.fileDownload.js"></script>
<body>

<div class="container">
	<!--header start-->
	<div class="row">
    	<div class="col-sm-12">
        	<div class="header bg-white">            		
         			<div class="logo col-sm-9">기안서 결재</div>
             		<div class="rblock col-sm-2">
             			<label style="margin-top:10px;">${draft.draft_no}</label>
           			</div>
             		<div class="col-sm-1 rblock5">문서<br>번호</div>
             		<div class="col-sm-7">             		
              		<div class="col-sm-4 lblock"><label>기안자 ID</label></div>
              		<div class="col-sm-8 lblock5">
              			<label>${draft.professor_id}</label>
              		</div>
              		<div class="col-sm-4 lblock"><label>기안일자</label></div>
              		<div class="col-sm-8 lblock5">
              			<label>${draft.draft_regdate}</label>
              		</div> 
              		<div class="col-sm-4 lblock"><label>마감일자</label></div>
              		<div class="col-sm-8 lblock5">
              			<label>${draft.draft_deadline}</label>
              		</div> 
              		<div class="col-sm-4 lblock"><label>기안</label></div>
              		<div class="col-sm-8 lblock5">
              			<label>${draft.draft_title}</label>
              		</div>                 		          	
          		</div>
          			<div class="col-sm-1 mblock"><label class="mblocktext">결<br>재</label></div>
          		<div class="col-sm-4">
          			<div class="col-sm-6 rblock2"><label>관리자</label></div>
          			<div class="col-sm-6 rblock2"><label>담당교수</label></div>
          			<div class="col-sm-6 rblock3">
							<c:if test="${draft.draft_status eq '결재대기' }">
								<select  class="form-control statusbox" name="change_status" id="change_status">
									<option value="결재대기" selected="selected">대 기</option>
									<option value="결재승인">승 인</option>
									<option value="결재반려">반 려</option>					
								</select>	
							</c:if>
							<c:if test="${draft.draft_status eq '결재승인' }">
								<select  class="form-control statusbox" name="change_status" disabled="disabled" id="change_status">								
									<option value="결재승인" selected="selected">승 인</option>
									<option value="결재대기">대 기</option>
									<option value="결재반려">반 려</option>
								</select>
							</c:if>
							<c:if test="${draft.draft_status eq '결재반려' }">
								<select  class="form-control statusbox" name="change_status" disabled="disabled" id="change_status">
									<option value="결재반려" selected="selected">반 려</option>
									<option value="결재승인">승 인</option>
									<option value="결재대기">대 기</option>
								</select>
							</c:if>
					</div>
         			<div class="col-sm-6 rblock3">
         				<label style="font-size: 30px; margin-left: 15px; margin-top: 38px;">${name}</label>
         			</div>
      			      			
          		</div>
            </div>
        </div>
    </div>
    
    
    	<!--left sidebar-->
		            
        <div class="col-sm-12">
        	
            <!--main content-->           
            <div class="row">
            	<div class="col-sm-12">
                	<div class="main-content bg-white">
           				<div class="col-sm-10 lblock4">
           					<label style="margin-left: 10px;">첨부파일</label>
           						<div class="col-sm-2 pull-right"> <!-- onclick="getFile()" -->
									<select style="width:100px; margin-top:3px; height:30px;"id="fileSelect">											
							 			<option selected disabled>다운로드</option>			           	
								<!-- <label style="border: 2px solid;"> -->
							 			<%-- <c:out value="${Draft_attachVO.draft_attach_filename}" />	 --%>
							 			<option value="${data.lecture_data_filename}">${videoFile}</option>
							 			<option value="${data.lecture_data_image}">${imageFile}</option>
							 		</select>
							 		<input type="hidden" id="attach_path" value="${path }" >
	           					</div>
           					<!-- <div class="pull-right"> 
							  	<input style="display:none;" />
								<button id="cBtn" class="form-control" type="button"
								style="color: black; border: 2px solid;margin-top: 10px;">취소</button>
							</div> -->
           				</div>
              			<div class="col-sm-2 lblock">
              				<c:if test="${draft.draft_check == 0 }"> 
              					<label>MEDIA <input type="checkbox" name="media" value="media" onclick="return false" checked="checked"></label>
              				</c:if>              				
              				<c:if test="${draft.draft_check == 1 }"> 
              					<label>MEDIA <input type="checkbox" name="media" value="lecture" onclick="return false"></label>
              				</c:if>
              			</div>
              			<div class="col-sm-12 lblock3">
              				<label style="font-size: 17px;font-weight: bold;margin-left: 10px;">${draft.draft_content}</label>
              			</div>
              			<div class="col-sm-4"></div>
              			<div class="col-sm-4">
              				<div class="pull-left"> 
							  	<input style="display:none;" />
								<button id="submitBtn" class="form-control" type="button" onclick="modify();"
								style="color: black; border: 2px solid;margin-top: 10px;">확인</button>
							</div>
							<div class="pull-right"> 
							  	<input style="display:none;" />
								<button id="canselBtn" class="form-control" type="button" onclick="cansel();"
								style="color: black; border: 2px solid;margin-top: 10px;">취소</button>
							</div>
              			</div>
              			<div class="col-sm-4"></div>
               	    </div>
                </div>
            </div>           
        </div>        
        <!--right sidebar-->      
    <!--footer start-->
    <div class="row">
    	<div class="col-sm-12">
        	<div class="footer bg-white">
            	<div class="copyright">
                	<p>Copyright &copy; NurlTheme 2020, Made from <a href="http://www.naver.com" target="_blank">누리.hand</a></p>
                </div>
            </div>
        </div>
    </div>
</div>

</body>

<script>
function modify(){
	var change_status = $('#change_status').val();
	location.href="<%=request.getContextPath()%>/manager/draft/modify_status?draft_no=${draft.draft_no}&change_status="+ change_status
}; 

function cansel(){
	window.opener.location.reload();
	window.close();
};

$("#fileSelect").change(function(){
	var target = document.getElementById("fileSelect");
	var fileName = $('#fileSelect').val();
	var filePath = $('#attach_path').val();
	var originalName = target.options[target.selectedIndex].text
	var file = { "fileName": fileName, "filePath": filePath, "originalName":originalName };
	var flag = confirm('파일을 다운로드 하겠습니까?');
	if(flag == true){

		$.fileDownload("<%=request.getContextPath()%>/manager/draft/getDown", {
			httpMethod: "POST",
		    data: file,
			successCallback: function(){
			
	   			
			},
			failCallback: function(){
			
			}
		});
		
		}
	});

</script>
