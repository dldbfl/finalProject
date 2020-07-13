<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/login/registheader.css" />

	
<style>
	.wrap-content{
		border: 1px solid #e4e4e4;
		padding-top: 20px;
	}
	#pictureView{
		border: 1px solid green;
		height: 200px;
		width: 140px;
	}
	.wrap-profile{
		text-align: -webkit-center;
	}
	.profileImgeLabel{
		margin-top: 2px;
    	width: 140px;
	}
	#inputFile{
		display: none;	
	}
	
	.star{
		color: red;
	}
	
	
	.material-switch > input[type="checkbox"] {
    display: none;   
}

.material-switch > label {
    cursor: pointer;
    height: 0px;
    position: relative; 
    width: 40px;  
}

.material-switch > label::before {
    background: rgb(0, 0, 0);
    box-shadow: inset 0px 0px 10px rgba(0, 0, 0, 0.5);
    border-radius: 8px;
    content: '';
    height: 16px;
    margin-top: -8px;
    position:absolute;
    opacity: 0.3;
    transition: all 0.4s ease-in-out;
    width: 40px;
}
<%--   토글 스위치 CSS   --%>
.material-switch > label::after {
    background: rgb(255, 255, 255);
    border-radius: 16px;
    box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.3);
    content: '';
    height: 24px;
    left: -4px;
    margin-top: -8px;
    position: absolute;
    top: -4px;
    transition: all 0.3s ease-in-out;
    width: 24px;
}
.material-switch > input[type="checkbox"]:checked + label::before {
    background: inherit;
    opacity: 0.5;
}
.material-switch > input[type="checkbox"]:checked + label::after {
    background: inherit;
    left: 20px;
}
.student{
	border: 1px solid #e4e4e4;
}
.second-wrap{
	background:#add1ff;
	color:#304d33;
	height: 27px;
    border-radius: 5px 5px 0px 0px;
}
.idChildren{
	width: 34%;
}
.nameChildren{
	width: 26%;
}
.birthChildren{
	width:29%;
}
#member_id{
	width:125px;
}
#member_post{
    width: 30%;
}
#member_address2{
    width: 50%;
}

#member_id{
	width: 49%;
}
#member_pwd{
	width: 67%;
}
#member_pwdCheck{
	width: 51%;
}
#member_name{
	width: 76%;
}
.addr{
	width: 35%;
}
.idGroup{
	border: 1px solid;
	padding-top: 10px;
	height: 257px;
	border-left: 0px;
	padding-right: 0px;
}
input[name=member_email], .lastAddr{
	width: 27%;
}
.hightWrapper{
	height: 256px;
	width: 102.3%;
}
.lowWrap{
	height: 30px;
}
.tableWrap{
	display: table;
}
.col-md{
	padding: 0px;
}
.profileWrap{
    text-align: -webkit-center;
    border: 1px solid;
    width: 168px;
    border-right: 0px;
    height: 100.4%;
    padding-top: 10px;
}
.remark{
	width: 100%;
	resize: none;
}
input[name=member_emailFront]{
	width: 27%;
}
#idCheck{
  position: absolute;
  right: -3px;
  width: 20px;
  display: none;
}
#nameCheck{
  position: absolute;
  right: 7px;
  width: 20px;
  display: none;
}
#birthCheck{
  position: absolute;
  right: 37px;
  width: 20px;
  display: none;
}
#pwdcheckOK1 {
  position: absolute;
  right: -7px;
  width: 20px;
  display: none;
}
#pwdcheckOK2 {
  position: absolute;
  right: -6px;
  width: 20px;
  display: none;
}
#genderCheck{
  position: absolute;
  top: -2px;
  right: 0px;
  width: 20px;
  display: none;
}
#addrCheck{
  position: absolute;
  right: 22px;
  width: 20px;
  display: none;
}
#emailCheck{
   position: absolute;
   top: -2px;
   right: 85px;
   width: 20px;
   display: none;
}
#phoneCheck{
   position: absolute;
   top: 0px;
   right: 4px;
   width: 20px;
   display: none;
}
.mailAddr{
	width: 13%;
	height: 24px;
}
.textLabel{
	width: 100px;
	text-align: center;
}
.hover3:hover{ 
box-shadow: 0 80px 0 0 rgba(0,0,0,0.25) inset, 0 -80px 0 0 rgba(0,0,0,0.25) inset; 
}


.careerDate{
	width: 312px;
}
/* #pictureView{
	width: 140px;
	height: 200px;
	background-image: url('c:\upload\member\profilePicture\student\63530c1f0d234a34a3fe27169fbeb2cf$$123.jpg');
} */
/* ${filePath}\\+""+${loginUser.member_picture } */
<style>
.inp{
width: 100%;
height: 100%;
text-align: center;
border: none;
}

.ted{
height: 100%;
text-align: center;
width: auto;
}
.pos{
height: 100%;
font-weight: bold;
background-color: #d9edf7;
text-align: center;
width: 275px;
}

</style>
<body>
<!-- ${filePath } -->

 	<div class="wrap">
		
			<h2>
				<a href="<%=request.getContextPath() %>/main" class="logoImage"></a>
			</h2>
		
		<div class="row idOpen">
				<a>마이페이지</a> > <a>개인정보변경</a><br><br><br>
				
				<button type="button" id="registBtn" onclick="RegistSubmit();" name="submitBtn" class="btn btn-primary flex-item btn-primary active hover3" style="float: right;background-color: #4db956;border-color: #4db956;margin-right: 15px;">수정하기</button>
	            
	            <button id="backBtn" class="btn btn-danger flex-item btn-primary active hover3" type="button" style="float: right;margin-right: 5px;background-color: #b5b5b5;border-color: #b5b5b5;">이전</button>
				
		</div>
		<div class="col-md-12 h-100 text-center second-wrap" >인적 사항</div>
		<h5><label><span class="star">*</span> 필수입력 사항입니다.</label></h5>
		<form class="form-horizontal reigstForm"   action="<%=request.getContextPath() %>/myPage/modifyMember" method="post" enctype="multipart/form-data">
			<div class="wrapper">
				<div class="hightWrapper">
				<div class="profileWrap col-xs-4 col-sm-2 control">
						<div class="form-group input-group">
							<div class="mailbox-attachments " style="text-align: center;">
<%-- 								<div class="" id="pictureView" class="profileImgeLabel" style="width: 140px; height: 200px; background-position: center; background-repeat: no-repeat; background-image: url('<%=request.getContextPath() %>/resources/uploadImg/${loginUser.member_picture }');"></div> --%>
<%-- 								<div class="" id="pictureView" class="profileImgeLabel" style="background-image: url('c:\upload\member\profilePicture\student\e915c1bf4fcb4002aa84006e235f6697$$아이유.jpg');"></div> -->
						        
						        
						        
<%-- 								<div class="" id="pictureView" class="profileImgeLabel" style="background-image: url('${filePath}/${loginUser.member_picture }');"></div> --%>
<%-- 								<div class="" id="pictureView" class="profileImgeLabel" style="background-image: url('${fullName}');"></div> --%>
								<div class="" id="pictureView" class="profileImgeLabel" ></div>
								
									<label for="picture" class=" btn btn-info btn-sm btn-flat" style="margin-top: 5px;">파일선택</label>
									<input type="file" id="picture" name="picture" style="display:none;" />
									
									<input id="inputFileName" class="form-control" type="hidden" name="member_picture" value="${loginUser.member_picture }"/>
							</div>
						</div>
				</div>
				<div class="col-xs-8 col-sm-10 idGroup" >
					<div class="form-group ">
						<div class="col-md-5 idChildren">
								<label class="textLabel"><span class="star">*</span>아이디</label>
								<input readonly="readonly" value="${loginUser.member_id}" type="text" id="member_id" name="member_id" onkeyup="this.value=this.value.replace(/[ㄱ-ㅎㅏ-ㅣ가-힣  ~!@#$%^&*()_+|<>?:{}\- ]/g, '');">
								<input type="hidden" name="student_id" />
								
								<img src="<%=request.getContextPath() %>/resources/images/checkOK.png" id="idCheck" class="idCheck">
								<input type="hidden" class="searchIdCheck"/>
						</div>
						<div class="col-md-4 nameChildren">
								<label><span class="star">*</span>이름</label>
								<input readonly="readonly" value="${loginUser.member_name }" type="text" id="member_name" name="member_name" onkeyup="this.value=this.value.replace(/[0-9~!@#$%^&*()_+|<>?:{}\- ]/g,'');" maxlength="50">
								<img src="<%=request.getContextPath() %>/resources/images/checkOK.png" id="nameCheck" class="nameCheck">
						</div>
							<div class="col-md-3 birthChildren">
							<label><span class="star">*</span>생년월일</label>
							<input readonly="readonly" type="date" name="member_birth" value="${loginUser.member_birth }">
							<img src="<%=request.getContextPath() %>/resources/images/checkOK.png" id="birthCheck" class="birthCheck">
					</div>
					<input type="hidden"  name="member_authority" />
					</div>
					<div class="form-group col-md-12" >
						<div class="row col-md-4 addr">
								<label class="textLabel"><span class="star">*</span>주소</label>
								<input type="text" id="member_post" name="member_post" readonly value="${loginUser.member_post }">
								<button class="btn btn-info btn-xs" type="button" onclick="SearchAddress();">우편번호</button>
								<img src="<%=request.getContextPath() %>/resources/images/checkOK.png" id="addrCheck" class="addrCheck">
						</div>
						<div class="col-md-3">
								<label><span class="star">*</span>비밀번호</label>
								<input type="password" id="member_pwd" name="member_pwd" onkeyup="pwdCheck(this);" value="${loginUser.member_pwd }">
								<img src="<%=request.getContextPath() %>/resources/images/checkOK.png" id="pwdcheckOK1" class="checkOK1">
								
						</div>
						
				
						<div class="col-md-3" >
								<label><span class="star">*</span>비밀번호 확인</label>
								<input type="password" id="member_pwdCheck"  onkeyup="pwdMatched()" value="${loginUser.member_pwd }">
								<img src="<%=request.getContextPath() %>/resources/images/checkOK.png" id="pwdcheckOK2" class="checkOK1">
						</div>
				
					</div>
					<div class="form-group col-md-12" >
						<div class="row col-md-12">
								<label class="textLabel"><span class="star">*</span>상세주소</label>
								<input type="text" id="member_address1" name="member_address1" readonly value="${loginUser.member_address1 }">
								<input type="text" id="member_address2" name="member_address2" readonly value="${loginUser.member_address2 }">
						</div>
					</div>
					<div class="form-group col-md-12" >
						<div class="row col-md-9" style="width: 550px;">
							<label class="textLabel"><span class="star">*</span>이메일</label>
							<input type="text" name="member_emailFront" class="member_emailFront"  />
							<span>@</span>
							<input type="text" name="member_emailBack" class="member_emailBack" readonly />
							<select class="mailAddr">
								<option selected>---선택---</option>
								<option value="naver.com" >네이버</option>
								<option value="nate.com">네이트</option>
								<option value="gmail.com">구글</option>
								<option>직접입력</option>
							</select>
							<img src="<%=request.getContextPath() %>/resources/images/checkOK.png" id="emailCheck" class="emailCheck">
						</div>
						<div class=" col-md-3">
							<button style="height: 24px;padding-bottom: 5px;" type="button" class="btn btn-info btn-xs" onclick="emailSendCheckNum();">이메일인증</button>
							<input type="hidden" id="sendCheck"/>
							<input type="hidden" id="emailCheckKey"/>
						</div>
					</div>	
					<div class="form-group col-md-12">
							<div class="row col-md-9">
								<label class="textLabel"><span class="star">*</span>휴대폰번호</label>
								<input type="text" name="member_phone1" onkeyup="focusMove1();" onkeypress="inNumber();" maxlength="3">
								<span>-</span>
								<input type="text" name="member_phone2" onkeyup="focusMove2();" onkeypress="inNumber();" maxlength="4">
								<span>-</span>
								<input type="text" name="member_phone3" onkeyup="focusMove3();" onkeypress="inNumber();" maxlength="4">
								<img src="<%=request.getContextPath() %>/resources/images/checkOK.png" id="phoneCheck" class="phoneCheck">
							</div>
							<div class="col-md-2 text-center">
								<h5 class="okText">개인정보열람동의</h5>
							</div>
							
			                <div class="material-switch pull-right col-md-1">
			                    <input id="member_infoOpenId"  type="checkbox" />
			                    <label for="member_infoOpenId" class="label-info"></label>
			                </div>
					</div>

	
					<input type="hidden"  name="member_infoOpen"  value="${loginUser.member_infoOpen}" />
					
					<input type="hidden"  name="member_eventReception" value="${memAgree}" />	
				</div>
				</div>
					<!-- 원하는 분야 -->
				<br>
				<br>
				
				
				<%------------------------학생 추가 사항 시작 ------------------------%>
			
				
					<br>
					<br>
					<div class="" style="margin-top: -60px;">
						<div class="studentTabeleWrap">
						<div class="col-md-12 h-100 text-center second-wrap" >자격증 보유 사항</div>
						<table id="certificateTable" border="1" style="width: 100%; " >
							<tbody id="certificateTbody">
							<tr style="height: 40px;">
								<td class="pos">자격증명</td>
								<td class="pos">자격 구분</td>
								<td class="pos">취득 일자</td>
								<td class="pos">발급 기관</td>
								<td><button type="button" class="plusBtn fa fa-plus fa-2x hover3" style="width: 45px;height: 100%;background-color: #0068f7;border-color: #0068f7;" aria-hidden="true" onclick="AddCertificateText();"></button></td>
							</tr>
							<c:forEach items="${certificateList}" var="certificateList" varStatus="vs" >
							<tr style="height: 40px;">
								<td class="ted"><input style="width: 100%;text-align: center;border: none;" class="inp" name="certificate[${vs.index}].student_certificate_name" value="${certificateList.student_certificate_name}"></td>
								<td class="ted"><input style="width: 100%;text-align: center;border: none;" class="inp" name="certificate[${vs.index}].student_certificate_division" value="${certificateList.student_certificate_division}"></td>
								<td class="ted"><input style="width: 100%;text-align: center;border: none;" class="inp" name="certificate[${vs.index}].student_certificate_date" value="${certificateList.student_certificate_date}"></td>
								<td class="ted"><input style="width: 100%;text-align: center;border: none;" class="inp" name="certificate[${vs.index}].student_certificate_agency" value="${certificateList.student_certificate_agency}"></td>
								<td><button type="button" class="minusBtn fa fa-minus fa-2x hover3" style="width: 45px;height: 100%;background-color: #f1f1f1;border-color: #f1f1f1;" aria-hidden="true" onclick="certificateARemove(this);"></button></td>
							 																													
							</tr>
						
							</c:forEach>
							
							</tbody>
						</table>
						<c:forEach items="${certificateList}" var="certificateList" varStatus="vs" >
							<input type="hidden" name="certificate[${vs.index}].student_certificate_no" value="${certificateList.student_certificate_no}">
						
						</c:forEach>
						</div>
					<div class="">
							<div class="col-md-12 h-100 text-center second-wrap" style="margin-top: 21px;">비고</div>
							<br>
							<br>
							<textarea name="student_remark" class="remark" rows="4" cols="151" >${studentInfo.student_remark }</textarea>
						</div>
					</div>
				<%------------------------학생 추가 사항 끝 ------------------------%>
				
				<%------------------------교수 추가 사항 끝 ------------------------%>
				
				
				<div class="col-md-12 professor" style="padding: 0px;">
					<div class="col-md-12 lowWrap">
						<div class="row col-md-6">
							<label>희망 지도  분야</label>
							<input type="text" class="" name="professor_hope_subject"  style="width: 61%"/>
						</div>
						<div class="row col-md-6">
							<label>최종 학력</label>
							
							<input type="hidden" class="" name=professor_career_education  style="width: 61%"/>
							<select class="lastEdu">
								<option>초졸</option>
								<option>중졸</option>
								<option>고졸</option>
								<option>대졸</option>
								<option>대학원졸</option>
							</select>
							
						</div>
					</div>
					<div class="proFessorTabeleWrap">
						<div class="col-md-12 h-100 text-center second-wrap" >경력 리스트</div>
						<table id="careerTable" border="1" style="width: 100%; " >
							<tr>
								<td colspan="6">경력 사항</td>
							</tr>
							<tr>
								<td>회사명</td>
								<td>주요 업무</td>
								<td>직 책</td>
								<td>재직기간</td>
								<td>경력증명서</td>
								<td>추가/삭제</td>
							</tr>
							<tr>
								<td><input type="text" name="career[0].professor_career_company_name" ></td>
								<td><input type="text" name="career[0].professor_career_mainjob"></td>
								<td><input type="text" name="career[0].professor_career_position"></td>
								<td class="careerDate"><input type="date" class="careerFristDay0"> ~ <input type="date" class="careerLastDay0"  >
									<input type="hidden" name="career[0].professor_career_startdate">
									<input type="hidden" name="career[0].professor_career_lastdate" ></td>
								<td><input type="file" name="careerFile[0]"></td>
									<td><i class="plusBtn fa fa-plus fa-2x" aria-hidden="true" onclick="AddCareerText();"></i></td>
							</tr>
							
						</table>
					<div class="">
							<div class="col-md-12 h-100 text-center second-wrap" >비고</div>
							<br>
							<br>
							<textarea name="professor_remark" class="remark" rows="4" cols="151" ></textarea>
						</div>
					</div>
				</div>
			</div>
			
		</form>
	</div>
	<!-- 경력사항 추가 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.3/handlebars.min.js" ></script>
<script id="certificate-template" type="text/x-handlebars-template">
	<tr>
		<td class="ted"><input style="width: 100%;text-align: center;border: none;" class="inp" type="text" name="certificate[{{index}}].student_certificate_name"></td>
		<td class="ted"><input style="width: 100%;text-align: center;border: none;" class="inp" type="text" name="certificate[{{index}}].student_certificate_division"></td>
		<td class="ted"><input style="width: 100%;text-align: center;border: none;" class="inp" type="date" name="certificate[{{index}}].student_certificate_date"></td>
		<td class="ted"><input style="width: 100%;text-align: center;border: none;" class="inp" type="text" name="certificate[{{index}}].student_certificate_agency"></td>
		<td><button type="button" class="minusBtn fa fa-minus fa-2x hover3" style="width: 45px;height: 100%;background-color: #f1f1f1;border-color: #f1f1f1;" aria-hidden="true" onclick="certificateARemove(this);"></button></td>
	</tr>
</script>
<script id="career-template" type="text/x-handlebars-template">
	<tr>
		<td><input style="width: 100%;text-align: center;border: none;" type="text" name="career[{{index}}].professor_career_company_name"></td>
		<td><input style="width: 100%;text-align: center;border: none;" type="text" name="career[{{index}}].professor_career_mainjob"></td>
		<td><input style="width: 100%;text-align: center;border: none;" type="text" name="career[{{index}}].professor_career_position"></td>
		<td class="careerDate"><input type="date" class="careerFristDay{{index}}" onchange="pickStartDate(this,this.value);" > ~ <input type="date" class="careerLastDay{{index}}" onchange="pickLastDate(this,this.value);"  >
			<input style="width: 100%;text-align: center;border: none;" type="hidden" name="career[{{index}}].professor_career_startdate"/>
			<input style="width: 100%;text-align: center;border: none;" type="hidden" name="career[{{index}}].professor_career_lastdate"/></td>
		<td><input style="width: 100%;text-align: center;border: none;" type="file" name="careerFile[{{index}}]"></td>
		<td><i class="minusBtn fa fa-minus fa-2x" aria-hidden="true" onclick="AddTextRemove(this);" ></i></td>
	</tr>
	
</script>
</body>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>



$("#pictureView").css("background-image", "url('<%=request.getContextPath()%>/myPage/profile')")
				 .css("background-position", "center")
				 .css("background-size", "100% 100%");








var totalTelNo = "${loginUser.member_phone}";
var firstNo = totalTelNo.substr(0,3);
var middleNo = totalTelNo.substr(3,4);
var finishNo = totalTelNo.substr(7,4);

$("input[name='member_phone1']").val(firstNo);
$("input[name='member_phone2']").val(middleNo);
$("input[name='member_phone3']").val(finishNo);




var totalEmail = "${loginUser.member_email}";
var email = totalEmail.split("@");

for(i=0;i<email.length;i++) {
	}
	var emailFront = email[0]; 
	var emailBack = email[1]; 

$("input[name='member_emailFront']").val(emailFront);
$("input[name='member_emailBack']").val(emailBack);

/* 
var birth = "${loginUser.member_birth}";

var yyyy = birth.substr(0,4);
var mm = birth.substr(4,2);
var dd = birth.substr(6,2);
var totalDate = yyyy + "-" + mm + "-" + dd;

$("input[name='member_birth']").val(totalDate);
 */




 var careerIndex=1;
	var memberType= "${member}";
	
	if(memberType =="professor"){
		$(".student").remove();
	}else{
		$(".professor").remove();
				
	}
	// date 값 가져와서 넣기 
	 $(".careerFristDay0").change(function(){
		 alert("test");
		 var fristday =$(this).val();
		 $("input[name='career[0].professor_career_startdate']").val(fristday);
	 })
	 // date 값 가져와서 넣기
	 $(".careerLastDay0").change(function(){
		 var lastday =$(this).val();
		 $("input[name='career[0].professor_career_lastdate']").val(lastday);
	 })
	 
	 //동적 date 값 가져와서 넣기 
	 function pickStartDate(input,obj){
		 var className=$(input).attr("class");
		 alert(className);
		 indexName=className.charAt(className.length-1);
		 $("input[name='career["+indexName+"].professor_career_startdate']").val(obj);
	 }
	//동적 date 값 가져와서 넣기 
	 function pickLastDate(input,obj){
		 var className=$(input).attr("class");
		 alert(className);
		 indexName=className.charAt(className.length-1);
		 $("input[name='career["+indexName+"].professor_career_lastdate']").val(obj);
	 }
	 
	 $(".lastEdu").change(function(){
		var education=$(".lastEdu option:selected").val();
		$("input[name='professor_career_education']").val(education);
	 })

	//수정 하기 버튼 클릭시 회원가입 진행 
	function RegistSubmit(){
		 
		var pictureName=$("input[name='member_picture']").val();
		if(!pictureName){
			alert("프로필사진을 선택하세요");
			return;
		}
		
		var post=$("input[name='member_post']").val();
		if(!post){
			alert("우편번호를 입력하세요");
			$("input[name='member_post']").focus();
			return;
		}
		
		var addr=$('#member_address2').val();
		if(!addr){
			alert("나머지주소를 입력하세요");
			$('#member_address2').focus();
			return;
		}
		
		var pwd=$("input[name='member_pwd']").val();
		if(!pwd){
			alert("비밀번호를 입력하세요");
			$("input[name='member_pwd']").focus();
			return;
		}		
		var pwdCheck=$('#member_pwdCheck').val();
		if(!pwdCheck){
			alert("비밀번호를 입력하세요");
			$('#member_pwdCheck').focus();
			return;
		}
		//이메일 공백 확인
		var email1=$("input[name='member_emailFront']").val();
		if(!email1){
			alert("이메일주소를 입력하세요1");
			$("input[name='member_emailFront']").focus();
			return;
		}
		var email2=$("input[name='member_emailBack']").val();
		if(!email2){
			alert("이메일주소를 입력하세요2");
			$("input[name='member_emailBack']").focus();
			return;
		}
		//이메일 인증메일과 작성 이메일 일치 여부 확인
		var emailAddr=email1+"@"+email2;
		var sendCheck=$("#sendCheck").val();
		var emailCheckKey=$("#emailCheckKey").val();
		if(emailAddr != sendCheck){
			alert("정보를 수정하시려면 이메일 인증은 필수입니다.");
			return;
		}
		
		
		//휴대폰 공백 확인
		var phone1=$("input[name='member_phone1']").val();
		if(!phone1){
			alert("휴대폰번호를 입력하세요");
			$("input[name='member_phone1']").focus();
			return;
		}
		var phone2=$("input[name='member_phone2']").val();
		if(!phone2){
			alert("휴대폰번호를 입력하세요");
			$("input[name='member_phone2']").focus();
			return;
		}
		var phone3=$("input[name='member_phone3']").val();
		if(!phone3){
			alert("휴대폰번호를 입력하세요");
			$("input[name='member_phone3']").focus();
			return;
		}
		var form=$("form");
		if(memberType =="professor"){
			form.removeAttr("action");
			form.attr("action","${pageContext.request.contextPath}/commons/registMemberProfessor");
		}
		
		$.ajax({
			url:"<%=request.getContextPath()%>/commons/registBtnEmailCheck?email_address="+sendCheck+"&email_checktext="+emailCheckKey,
			type:"get",
			success:function(){
					form.submit();
			},
			error:function(){
				alert("이메일 인증 실패 \n 다시 이메일 인증 하세요");
				$("input[name='member_emailFront']").val("");
				$("input[name='member_emailFront']").focus();
				$("input[name='allCheckOK']").val("N");
			}
		})
	}
	
	  
	//프로필이미지 기능
	$('input#picture').on('change',function(event){
		
		var fileFormat= this.value.substr(this.value.lastIndexOf(".")+1).toUpperCase();
		if(fileFormat!="JPG"){
			alert("이미지는 jpg 형식만 가능합니다.");
			return;
		}
		if(this.files[0].size>1024*1024*1){
			alert("사진 용량은 1MB 이하만 가능합니다.");
			return;
		};
		
		document.getElementById('inputFileName').value=this.files[0].name;
		
		if(this.files && this.files[0]){
			var reader = new FileReader();
			
			reader.onload = function(e){
				//이미지 미리보기
				$('div#pictureView'). css({'background-image':'url('+e.target.result+')',
					'background-position' :'center',
					'background-size':'cover',
					'background-repeat':'no-repeat'
				});
			}
			reader.readAsDataURL(this.files[0]);
		}
	});
	
	
	
	
	

	//비밀번호 정규식 확인
	function pwdCheck(obj){
	var check = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,16}/;
		var pwd=obj.value
		var bool=check.test(pwd);
		if(bool){
			$("#pwdcheckOK1").css("display","inline");
			
		}else{
			$("#pwdcheckOK1").css("display","none");
		}
	}
	
	//비밀번호 재확인 기능
	function pwdMatched(){
		
	var pwd=$("#member_pwd").val();
	var pwdcheck=$("#member_pwdCheck").val();
	
		if(pwd == pwdcheck){
			$("#pwdcheckOK2").css("display","inline");
		}else{
			$("#pwdcheckOK2").css("display","none");
		}

	}
	
	
	//다음 주소 검색 API
	function SearchAddress(){
	    new daum.Postcode({
	        oncomplete: function(data) {
	        	 // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }                

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                $('#member_post').val(data.zonecode);
                $('#member_address1').val(addr);
                // 커서를 상세주소 필드로 이동한다.
                $('#member_address2').removeAttr("readonly");
                $('#member_address2').focus();
	        }
	    }).open();
    }

	
	$("#member_address2").change(function(){
		if($("input[name='member_address2']").val()!=""){
			$("#addrCheck").css("display","inline");
		}else{
			$("#addrCheck").css("display","none");
		}
	})
	
	//이메일 selectBOX 선택에 따른 이벤트 
	$(".mailAddr").change(function(){
		var pickText=$('.mailAddr option:selected').text();
		var pickValue=$('.mailAddr option:selected').val();
		if(pickText=="직접입력"){
			$(".member_emailBack").removeAttr("readonly");
			$(".member_emailBack").val("");
		}else if(pickText=="---선택---"){
			$(".member_emailBack").val("");
			$(".member_emailBack").attr("readonly","readonly");
		}else{
			$(".member_emailBack").val(pickValue);
			$(".member_emailBack").attr("readonly","readonly");
		}
		
	})

	//이메일 인증 버튼
	function emailSendCheckNum(){
		
		var emailfront= $(".member_emailFront").val();
		var emailback= $(".member_emailBack").val();
		if(!emailfront || !emailback){
			alert("이메일을 입력하세요");
			return;
		}
		var emailAddr=emailfront+"@"+emailback;
		$.ajax({
			url:"<%=request.getContextPath()%>/commons/emailSendCheckNum?emailAddr="+emailAddr,
			type:"get",
			dataType:'text',
			success:function(suc){
				alert("이메일발송 성공");
				
				$("#emailCheck").css("display","inline");
				//가입이메일과 인증이메일받는 이메일 확인용
				$("#sendCheck").val(emailAddr);
				$("#emailCheckKey").val(suc);
			},
			error:function(err){
				alert("이메일 발송 실패");
				$("#emailCheck").css("display","none");
			}
			
		})
	}
	//휴대폰 숫자만 입력 기능
	function inNumber(){
		   if(event.keyCode<48 || event.keyCode>57){
		       event.returnValue=false;
		    }
		}

	//휴대폰번호 입력시 커서 이동 및  유무에따른 체크 이미지 표시
	function focusMove1(){
		var phone1Val= $("input[name='member_phone1']").val();
		var phone1Leng = $("input[name='member_phone1']").val().length;
		var phone2Leng = $("input[name='member_phone2']").val().length;
		var phone3Leng = $("input[name='member_phone3']").val().length;
		
		if(phone1Leng == 3 && phone2Leng == 4 && phone3Leng == 4 ){
			$("#phoneCheck").css("display","inline");
		}else{
			$("#phoneCheck").css("display","none");
		}
		
		if(phone1Leng == 3){
			$("input[name='member_phone2']").focus();
		}
	}
	//휴대폰번호 입력시 커서 이동 및 체크 이미지 표시
	function focusMove2(){
		var phone1Leng = $("input[name='member_phone1']").val().length;
		var phone2Leng = $("input[name='member_phone2']").val().length;
		var phone3Leng = $("input[name='member_phone3']").val().length;

		if(phone1Leng == 3 && phone2Leng == 4 && phone3Leng == 4 ){
			$("#phoneCheck").css("display","inline");
		}else{
			$("#phoneCheck").css("display","none");
		}
		
		if($("input[name='member_phone2']").val().length == 4){
			$("input[name='member_phone3']").focus();
		}
	}
	//휴대폰번호 입력시  체크 이미지 표시
	function focusMove3(){
		var phone1Leng = $("input[name='member_phone1']").val().length;
		var phone2Leng = $("input[name='member_phone2']").val().length;
		var phone3Leng = $("input[name='member_phone3']").val().length;

		if(phone1Leng == 3 && phone2Leng == 4 && phone3Leng == 4 ){
			$("#phoneCheck").css("display","inline");
		}else{
			$("#phoneCheck").css("display","none");
		}
		
		if($("input[name='member_phone2']").val().length == 4){
			$("input[name='member_phone3']").focus();
		}
	}

	//정보공개 여부값 가져오기
	var valu = $("input[name='member_infoOpen']").val();
	if(valu == "Y"){
		$('#member_infoOpenId').attr('checked','checked');
		$("input[name='member_infoOpen']").val("Y");
    	$('.okText').css("color","green");
	}else{
		$("input[name='member_infoOpen']").val("N");
    	$('.okText').css("color","black");
	}
		
		
	//정보 공개 여부 토글 버튼
	$('#member_infoOpenId').change(function() {
		if($(this).prop('checked')){
	    	$("input[name='member_infoOpen']").val("Y");
	    	$('.okText').css("color","green");
	    }else{
	    	$("input[name='member_infoOpen']").val("N");
	    	$('.okText').css("color","black");
	    }
	})
	
	
	
	
	
	
	
<%----------------------------학생  js-------------------------------%>
	
	// 학생추가입력사항 index
	var certificateIndex=1;

	//학생 자격증 번호 input hidden에 옴겨 넣는 작업
	$("span.certificate_no").change(function(){
	$("input[name='student_certificate_no']").val($(this).text()); 
	})
	
	//진행 상태  breadcrumb 변경
	$('#step2').removeClass('class','active').addClass('completed');
	$('#step3').addClass('active');
	
	
	
	//창업동기 Select문		
	function inMotivation(){
		 var motivation=$(".motivation").val();
		$("input[name='student_business_purpose']").val(motivation); 
	}


	$(".selectMotive").change(function(){
	if($('.selectMotive option:selected').text()=="직접입력"){
		$(".motivation").attr("type","text");
	}else{
		$(".motivation").attr("type","hidden");
		var pick=$('.selectMotive option:selected').text();
		$("input[name='student_business_purpose']").val(pick);
	}
	
	
	})
	
	//창업 경험 유무
	$("input[name='experiencen']").change(function(){
		var vv=$("input[name='experiencen']").prop('checked');
		if(!vv){
			$("input[name='student_experience']").val("Y");
		}else{
			$("input[name='student_experience']").val("N");
		}
	})
	
	
	var certificateIndex = $("tbody[id='certificateTbody']").find('tr').length-1;
	//자격증 보유사항 입력 갯수 지정(최대 7개) 
	function AddCertificateText(){
	
		if($("#certificateTable tr").length == 7){
			return;
		}
		var certificate =Handlebars.compile($('#certificate-template').html());
	
		$('#certificateTbody').append(certificate({index:certificateIndex}));
		certificateIndex++;	 
		
		
	}
	//자격 보유사항 중 선택 ROW 삭제  
	function certificateARemove(obj){
		var tr=$(obj).parent().parent();
		
		tr.remove();

	}
	
	
	
	$('#backBtn').on('click', function(){
		history.go(-1);
	});

	
	
	
	
	
	
<%----------------------------학생  js-------------------------------%>
<%----------------------------교수 js-------------------------------%>

//자격증 보유사항 입력 갯수 지정(최대 7개) 
function AddCareerText(){

	if($("#careerTable tr").length == 9){
		return;
	}
	var career =Handlebars.compile($('#career-template').html());

	 $('#careerTable').append(career({index:careerIndex}));
	 careerIndex++;	 
}
//자격 보유사항 중 선택 ROW 삭제  
function AddTextRemove(obj){
		
	var tr=$(obj).parent().parent();
	
	tr.remove();
	
}
	
	
</script>


