<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<head>

<style type="text/css" id="fontFamilyStyleSheet">
body { 
	font-family: 'Malgun Gothic', sans-serif !important; 
	}
	.fileDrop{
		width:90%;
		height:100px;
		border:1px dotted gray;
		margin:auto;
	}
	select:disabled {
		background: lightgray;
	  	border:1px solid gray; 
	}
	  	
	
	
	input:read-only, 
	textarea:read-only{
	  cursor: not-allowed;
	}
	table{
			width:100%;
			border-collapse:separate ;
		}
		#writeBtn{
			width : 100px; 
		}
		
		.form-group{
			margin-top : 20px;	
		
		}
	.lbock{    
	/* width: 33.5%;  */
    margin-left: 10px;
    height: 45px;
    

	}
	
	
	.rbock{  
	    width: 33.5%;  
	/* width: 276px; */
    /* margin-left: 10px; */
    height: 45px;

	}

</style>

	<script src="<%=request.getContextPath()%>/resources/scripts/common.js"></script>
	<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
	<link href="<%=request.getContextPath() %>/resources/css/list/listCSS.css" rel="stylesheet">
	
	
	<!-- FAVIICON -->
	<link rel="shortcut icon" href="favicon.ico">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<!-- Le fav and touch icons -->
	<link rel="apple-touch-icon" sizes="114x114" href="apple-touch-icon-114x114.png" />
	<link rel="icon" type="images/svg+xml" href="images/logo.svg" />
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script type="text/javascript"></script>
		
</head>
<body >
		
		
		
	<form role="form" name=modifyform method=post>
	<input type="hidden" name="member_id" value="${studentList.member_id}">		
	<div class="col-sm-12" id="divID">
	<h1 style="margin-left:10px;">수강생 프로필</h1>
	<hr>
		
		<div id="image"  class="col-sm-5 " style="float: left;height: 300px;margin-left: 20px;">
			<img style="width: 168px;height: auto;border: 2px solid;" src="<%=request.getContextPath()%>/manager/student_detail/picture/${student.member_picture}">    
		</div>	
<!-- 	<input id="image"  class="col-sm-5 " style="float: left;height: 270px;margin-left: 20px;" type="image" src="/resources/uploadImg\${professor.member_picture}">  -->
		<!-- <img src="http://placeimg.com/1200/600/any">   
		<img src="/resources/uploadImg\${professor.member_picture}">         -->
         <div class="col-sm-7">
         	<input readonly class="col-sm-4 lbock" value="이름">
			<input readonly  class="col-sm-8 rbock" value="${student.member_name}">   
			<input readonly class="col-sm-4 lbock" value="성별">                 
			<input readonly  class="col-sm-8 rbock" value="${student.member_gender}"> 
			<input readonly class="col-sm-4 lbock" value="이메일">             
			<input readonly  class="col-sm-7 rbock" value="${student.member_email}">    
			<input readonly class="col-sm-4 lbock" value="휴대폰 번호">          
			<input readonly  class="col-sm-8 rbock" value="${student.member_phone}"> 
			<input readonly class="col-sm-4 lbock" value="생년월일">                 
			<input readonly  class="col-sm-8 rbock" value="${student.member_birth}">  
			<input readonly class="col-sm-4 lbock" value="상태">                 
		   	<c:choose>
				<c:when test="${student.member_status eq 1}">
				  <input readonly  class="col-sm-8 rbock" value="활성">  
				</c:when>
				<c:when test="${student.member_status eq 0}"> 
				  <input readonly  class="col-sm-8 rbock" value="정지">  
				</c:when>
			</c:choose>
			<input readonly class="col-sm-4 lbock" value="희망업종">	
			<c:if test="${student.student_hope_business == null}">	
				<input readonly  class="col-sm-7 rbock" value = "없음">
			</c:if>
			<c:if test="${student.student_hope_business != null}">
				<input readonly  class="col-sm-7 rbock" value = "${student.student_hope_business}">
			</c:if>
		</div>         	          
	 </div>
	 
	 <div class="main-content" style="display:none">
		<div class="main-content-inner">
			<div class="page-content">
				<table id="table">
					<caption>Student Profile</caption>
					<thead>
						<tr>
							<th></th>
							<th></th>
							<th></th>
							
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>이름</th>
							<td>${student.member_picture}</td>
							<!-- <td>Text</td> -->
							<!-- <td rowspan="2">Text</td> -->
						</tr>
						<tr>
							<th>이메일</th>
							<td>${student.member_email}</td>
						</tr>						
						<tr>
							<th>휴대폰 번호</th>
							<td>${student.member_phone}</td>
						</tr>						
						<tr>
							<th>생년월일</th>
							<td>${student.member_birth}</td>
						</tr>
						<tr>
							<th>재직</th>							
							<c:choose>	
								<c:when test="${student.member_status eq 1}">	
									<td>없음</td>							
								</c:when>
								<c:when test="${student.member_status eq 0}">	
									<td>없음</td>							
								</c:when>
								<c:otherwise> 
								  	<td>가입 대기중</td>
								</c:otherwise>			
							</c:choose>					
						</tr>					
						<tr>
							<th>전공</th>							
							<c:if test="${student.student_hope_business == null}">	
								<td>없음</td>
							</c:if>
							<c:if test="${student.student_hope_business != null}">
								<td>${student.student_hope_business}</td>
							</c:if>							
						</tr>
						  
					</tbody>
				</table>
			</div>			
		</div>
	</div>
		 
	<hr>
 	<div id= "printID1" style="float: right; margin-right: 30px;">
		<button type="button" class="btn top btn-sm btn-white btn-bold" onclick="fnExcelReport('table','profile');">
				<i class="grey ace-icon fa fa-print bigger-120"></i><b>Download</b>
		</button>		
		<button type="button" class="btn top btn-sm btn-white btn-bold" onclick="javascript:divPrint('document');">
				<i class="grey ace-icon fa fa-print bigger-120"></i><b>인쇄</b>
		</button>
		<!-- <button type="button" class="btn btn-sm btn-white btn-bold" onclick="goSubmit('post');">
			<i class="red ace-icon fa fa-check bigger-120"></i><b>확인</b>
		</button> -->
		<button type="button" class="btn btn-sm btn-white btn-bold" onclick="javascript:goSubmit('close');">
			<i class="grey ace-icon fa fa-times bigger-120"></i><b>닫기</b>
		</button>
		
	</div>
		 
		 
		 
		 
</form>
</body>



<!-- form submit -->
<script>
function goSubmit(cmd){ 
	var form = document.modifyform;
	switch(cmd) {
	case "post":		
		form.submit();		
		break;
	case "close":
		window.close();
		return;
		break;
	default:
		return;
		break;
	}	
};

function fnExcelReport(id, title) {
	var tab_text = '<html xmlns:x="urn:schemas-microsoft-com:office:excel">';
	tab_text = tab_text + '<head><meta http-equiv="content-type" content="application/vnd.ms-excel; charset=UTF-8">';
	tab_text = tab_text + '<xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet>'
	tab_text = tab_text + '<x:Name>Test Sheet</x:Name>';
	tab_text = tab_text + '<x:WorksheetOptions><x:Panes></x:Panes></x:WorksheetOptions></x:ExcelWorksheet>';
	tab_text = tab_text + '</x:ExcelWorksheets></x:ExcelWorkbook></xml></head><body>';
	tab_text = tab_text + "<table border='1px'>";
	var exportTable = $('#' + id).clone();
	exportTable.find('input').each(function (index, elem) { $(elem).remove(); });
	tab_text = tab_text + exportTable.html();
	tab_text = tab_text + '</table></body></html>';
	var data_type = 'data:application/vnd.ms-excel';
	var ua = window.navigator.userAgent;
	var msie = ua.indexOf("MSIE ");
	
	var fileName = title + '.xls';
	//Explorer 환경에서 다운로드
	if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./)) {
	if (window.navigator.msSaveBlob) {
	var blob = new Blob([tab_text], {
	type: "application/csv;charset=utf-8;"
	});
	navigator.msSaveBlob(blob, fileName);
	}
	} else {
	var blob2 = new Blob([tab_text], {
	type: "application/csv;charset=utf-8;"
	});
	var filename = fileName;
	var elem = window.document.createElement('a');
	elem.href = window.URL.createObjectURL(blob2);
	elem.download = filename;
	document.body.appendChild(elem);
	elem.click();
	document.body.removeChild(elem);
	}
}

</script>


