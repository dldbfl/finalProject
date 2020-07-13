<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="euc-kr"/>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/professor/professor.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/filedownload/jquery.fileDownload.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<head>
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<meta http-equiv="Pragma" content="no-cache"/>
</head>
<body>
	<div id="main">
	   <form id="modifyForm" action="modifyProfile" method="post" enctype="multipart/form-data" >
	   		<h3 style="margin-top: 20px;"><a href="<%=request.getContextPath()%>/myPage/professorMain" style="color:black;">마이페이지</a>><a id="head1" href="javascript:location.reload()" style="color:#308fe2;" >교수정보</a></h3>
			<div id="top-div">
			<input type="hidden" id="professor_id" name="professor_id" value="${professor.professor_id }">
			<input type="hidden" name="member_id" value="${member.member_id }">
			<button id="changeBtn" type="button">변경</button>
			<button id="cancelBtn" type="button" >취소</button>
			<button id="saveBtn" type="button">저장</button>
		</div>	
		<div id="mid-div">
			<div id="mid-profile">
				<div id="profile-img">
					<img id="profileImg"/>
				</div>
				<label id="addPicture"for="picture" class="btn btn-primary btn-file" style="display:none;">사진첨부 </label>
				<input type="file" id="picture" name="picture" style="display:none;" accept=".jpg,jepg" />
				<input id="inputFileName" class="form-control" type="hidden" name="member_picture" value="${member.member_picture }"/>
			</div>
			<div id="mid-div-1">	
				<table id="mid-table">
					<tbody>
						<tr>
							<th class="profile-th" scope="row" style="border-radius: 14px 0px 0px 0px;">이름</th>
							<td class="profile-td" colspan="7" ><input class="profile" type="text" name="member_name" value="${member.member_name }" readonly="readonly"></td>
						</tr>
						<tr>
							<th class="profile-th" scope="row">성별</th>
							<td class="profile-td" colspan="7"><input class="profile" type="text" name="member_gender" value="${member.member_gender }" readonly="readonly"></td>
						</tr>
						<tr>
							<th class="profile-th" scope="row">생년월일</th>
							<td class="profile-td" colspan="7"><input class="profile" type="text" name="member_birth" value="${member.member_birth }" readonly="readonly"></td>
						</tr>
						<tr>
							<th class="profile-th" scope="row">이메일</th>
							<td class="profile-td" id="mail-td" colspan="7" >
								<input id="ref-email" class="profile" type="text" name="member_email" value="${member.member_email }" readonly="readonly" >
								<div id="div-mail">
									<input type="text" name="member_emailFront" id="member_emailFront" style="width: 120px;"/>
									<span>@</span>
									<input type="text" name="member_emailBack" id="member_emailBack"  style="width: 120px;" />
									<button id="mailChk" type="button">인증</button>
									<input type="hidden" id="sendCheck"/>
									<input type="hidden" id="emailCheckKey"/>
								</div>
							</td>
						</tr>
						<tr>
							<th class="profile-th" scope="row">학력</th>
							<td class="profile-td" colspan="7" ><input name="professor_career_education" class="profile" type="text" value="${professor.professor_career_education }" readonly="readonly"></td>
						</tr>
						<tr>
							<th class="profile-th" scope="row" style="border-radius: 0px 0px 14px 0px;">희망지도</th>
							<td class="profile-td" id="l-border"colspan="7" ><input name="professor_hope_subject" class="profile" type="text" value="${professor.professor_hope_subject }" readonly="readonly"></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div id="mid-div-2" style="margin-top: 30px; float: left; width: 100%; text-align: left;">
				<label id="label1">주소</label>
				<input id="post"type="text" name="member_post" value="${member.member_post}" readonly="readonly">
				<button id="addressBtn" type="button" onclick="SearchAddress()">주소 검색</button><br/>
				<input id="add1" type="text" name="member_address1" value="${member.member_address1}" readonly="readonly"><br/>
				<input id="add2" type="text" name="member_address2" value="${member.member_address2}" readonly="readonly">
			</div>
		</div>
		<div id="bottom-div-1">	
			<table id="bottom-table">
				<tbody>
					<tr>
						<td class="career-head" style="width:18%; border-radius: 14px 0px 0px 0px;">회사명</td>
						<td class="career-head" style="width:18%;">주요업무</td>
						<td class="career-head" style="width:18%;">직책</td>
						<td class="career-head" style="width:30%;">재직기간</td>
						<td class="career-head" style="width:16%; border-radius: 0px 14px 0px 0px;">경력증명서</td>
					</tr>
					<c:forEach var="career" items="${career}" varStatus="status">
					<tr>														
						<td class="career-content" style="width:18%;"><input name="careerList[${status.index }].professor_career_company_name"class="profile" type="text" value="${career.professor_career_company_name}" readonly="readonly"></td>
						<td class="career-content" style="width:18%;"><input name="careerList[${status.index }].professor_career_mainjob"class="profile" type="text" value="${career.professor_career_mainjob }" readonly="readonly"></td>
						<td class="career-content" style="width:18%;"><input name="careerList[${status.index }].professor_career_position" class="profile" type="text" value="${career.professor_career_position }" readonly="readonly"></td>
						<td class="career-content" style="width:31%;">
							<input name="careerList[${status.index }].professor_career_startdate" class="profile" type="text" value="${career.professor_career_startdate }" readonly="readonly" style="width:40%;"> ~
							<input name="careerList[${status.index }].professor_career_lastdate" class="profile" type="text" value="${career.professor_career_lastdate }" readonly="readonly" style="width:40%;">
						</td>
						<c:set value="${career.type }" var="type" />
						<c:if test="${type eq '.jpg' or type eq '.jpeg'}">
						<td class="career-content" style="width:15%;">
							<div>
							<img class="addImg"onclick="download('${career.professor_career}')" width="20px;" height="20px;"src="<%=request.getContextPath() %>/resources/images/jpg.png">
							<input onchange="addFile(this,${status.index });" class="addFile" name="careerFile" type="file" style="display: none;" accept=".jpg,.gif,.jepg,.png">
							<input id="attach${status.index}" type="hidden" name="careerList[${status.index }].professor_career" value="${career.professor_career }">
							</div>
						</td>
						</c:if>
						<c:if test="${type eq '.gif'}">
						<td class="career-content" style="width:15%;">
							<div>
							<img class="addImg"onclick="download('${career.professor_career}')" width="20px;" height="20px;"src="<%=request.getContextPath() %>/resources/images/gif.png">
							<input onchange="addFile(this,${status.index });" class="addFile"  name="careerFile" type="file" style="display: none;" accept=".jpg,.gif,.jepg,.png">
							<input id="attach${status.index}" type="hidden" name="careerList[${status.index }].professor_career" value="${career.professor_career }">
							</div>
						</td>
						</c:if>
						<c:if test="${type eq '.png'}">
						<td class="career-content" style="width:15%;">
							<div>
							<img class="addImg"onclick="download('${career.professor_career}')" width="20px;" height="20px;"src="<%=request.getContextPath() %>/resources/images/png.png">
							<input onchange="addFile(this,${status.index });" class="addFile" name="careerFile" type="file" style="display: none;" accept=".jpg,.gif,.jepg,.png">
							<input id="attach${status.index}" type="hidden" name="careerList[${status.index }].professor_career" value="${career.professor_career }">
							</div>
						</td>
						</c:if>
					</tr>
					<input id="path" type="hidden" value="${career.path }">
					<input name="careerList[${status.index }].professor_career_no" type="hidden" value="${career.professor_career_no }">
					</c:forEach>
				</tbody>
			</table>
					<input id="typeFlag" value="0" type="hidden"  >
		</div>
		</form>
		 <div id="pwdCheck" style="background-color: white; width: 100%; height: 100%; display: none;">	
			<hr>
			<div id="content" style="margin-top: 20%; margin-left:20%; ">	
				<!-- form start-->
				<div id="register">
					<h3 style="font-weight: bold; font-size: 32px;">비밀번호 확인</h3>
					<hr>
					<label for="password" style="color: blue; margin-left:  100px; font-size: 20px;">비밀번호  </label>
					<input name="password" id="password" type="password" style="width: 380px;"/>
				</div>	
				<div style="width: 100%">
					<hr>
				</div>			
			</div>
				<div style="text-align: center;">
					<button type="button" id ="checkBtn" style="border-radius:15%; width:75px; height:38px; margin-left: 21%; color:white; background-color: #555555;">확인</button>
					&nbsp;<button type="button" id ="clearBtn" style="border-color:white; border-radius:15%; width:75px; height:38px;">취소</button>
					<hr>
				<hr>
				</div>
			<div id="content" style="margin-top: 20%;">	
			</div>
			<hr>				
		</div>
	</div>
<script>

$("#profileImg").attr("src", "<%=request.getContextPath()%>/professor/profile/img")
				.css("background-position", "center")
				.css("width","230px")
				.css("height","230px");
			

	//변경 버튼 누를때 수정화면으로 전환
	$('#changeBtn').on('click',function(){
		$('#modifyForm').attr('style','display:none;')
		$('#pwdCheck').attr('style','display:inline;')
			
	});

	$('#cancelBtn').on('click',function(){
		location.reload();
	});
	
	$('#checkBtn').on('click',function(){
		var password = $('#password').val();
		var id = $('#professor_id').val();

		var check = {"password":password,"id":id};
		$.ajax({
			url:"checkPwd",
			type:"post",
			data:check,
			success:function(res){
				$('#modifyForm').attr('style','display:inline;')
				$('#pwdCheck').attr('style','display:none;')
		 		$('#head1').text('정보 변경')
		 		$('#head1').attr('style','color:#308fe2')
		 		$('#changeBtn').attr('style','display:none;');
		 		$('#saveBtn').attr('style','display:block');
		 		$('#cancelBtn').attr('style','display:block');
		 		$('#addPicture').attr('style','display:block; width: 100px; margin-left: 50px; margin-top: 5px;');
		 		$('.profile').attr('readonly', false);
		 		$('#addressBtn').attr('style','display:inline');
		 		$('#ref-email').attr('style','display:none;');
		 		var mail = $('#ref-email').val();
		 		var front = mail.substring(0,mail.lastIndexOf('@'));
		 		var back = mail.substring(mail.lastIndexOf('@')+1);
		 		$('#member_emailFront').val(front);
		 		$('#member_emailBack').val(back);
		 		$('#div-mail').attr('style','display:block');
		 		$('.addImg').attr('style','display:none;');
		 		$('.addFile').attr('style','display:inline;margin-left:20px;');
			},
			error:function(er){
				alert('비밀번호가 일치하지 않습니다.')
			}
		});
	});
	
	$('#clearBtn').on('click',function(){
		$('#pwdCheck').attr('style','display:none;')
		$('#modifyForm').attr('style','display:inline;')
	});
	
	function download(career) {
		var original = career;
		var path = $('#path').val();
		var downName = career.substring(career.lastIndexOf('$$')+2);
		var file = { "fileName": original, "filePath": path, "downloadName":downName };

		$.fileDownload("<%=request.getContextPath()%>/pds/document/fileDownload", {
			httpMethod: "POST",
		    data: file,
			successCallback: function(){
			
	   			
			},
			failCallback: function(){
			
			}
		});
	}
	//파일 추가
	function addFile(fileObj,index) {
		 	pathpoint = fileObj.value.lastIndexOf('.');
		    filepoint = fileObj.value.substring(pathpoint+1,fileObj.length);
		    filetype = filepoint.toLowerCase();
		    if(filetype=='jpg' || filetype=='gif' || filetype=='png' || filetype=='jpeg' || filetype=='bmp') {
		    	  $('#typeFlag').val(0)
				   var filePath = fileObj.value;
				   var fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
				   document.getElementById("attach"+index).value = fileName;

		    } else {
		        alert('이미지 파일만 선택할 수 있습니다.')
		        $('input[name=careerFile]').val("")
		        $('#typeFlag').val(1)
		        return false;
		    }
		    if(filetype=='bmp') {
		        upload = confirm('BMP 파일은 웹상에서 사용하기엔 적절한 이미지 포맷이 아닙니다.\n그래도 계속 하시겠습니까?');
		        if(!upload) return false;
		    }
		   
		
	}
	
	$('#mailChk').on('click',function(){
	
		var emailfront= $("#member_emailFront").val();
		var emailback= $("#member_emailBack").val();
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
				//가입이메일과 인증이메일받는 이메일 확인용
				$("#ref-email").val(emailAddr);
				$("#sendCheck").val(emailAddr);
				$("#emailCheckKey").val(suc);
			},
			error:function(err){
				alert("이메일 발송 실패");
				$("#emailCheck").css("display","none");
			}	
		});
  });	
	
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
                $('#post').val(data.zonecode);
                $('#add1').val(addr);
                // 커서를 상세주소 필드로 이동한다.
                $('#add2').attr("readonly",false);
                $('#add2').focus();
                $('#add2').val('');
                $('#add2').attr("placeholder",'나머지 주소를 입력하세요');
	        }
	    }).open();
    }
	
	//프로필이미지 기능
	$('input#picture').on('change',function(event){

		var fileFormat= this.value.substr(this.value.lastIndexOf(".")+1).toUpperCase();
		if(fileFormat!="JPG"){
			alert("이미지는 jpg 형식만 가능합니다.");
			return;
		}
		if(this.files[0].size>1024*1024*2){
			alert("사진 용량은 2MB 이하만 가능합니다.");
			return;
		};
		
		document.getElementById('inputFileName').value=this.files[0].name;

		if(this.files && this.files[0]){
			var reader = new FileReader();
			
			reader.onload = function(e){
				//이미지 미리보기
				$('#profileImg').removeAttr('src')
					.css({'background-image':'url('+e.target.result+')',
					'background-position' :'center',
					'background-size':'cover',
					'background-repeat':'no-repeat'
				});
			}
			reader.readAsDataURL(this.files[0]);
		}
	});
	
	$('#saveBtn').on('click', function(){
		
		var mem_name=$("input[name='member_name']").val();
		if(!mem_name){
			alert("이름을 입력하세요");
			$("input[name='member_name']").focus();
			return;
		}
		
		var gender=$("input[name='member_gender']").val();
		if(!gender){
			alert("성별을 입력하세요");
			$("input[name='member_gender']").focus();
			return;
		}
		
		var birth=$("input[name='member_birth']").val();
		if(!birth){
			alert("생년월일을 선택하세요");
			$("input[name='member_birth']").focus();
			return;
		}
		
		var post=$("input[name='member_post']").val();
		if(!post){
			alert("우편번호를 입력하세요");
			$("input[name='member_post']").focus();
			return;
		}
		
		var addr=$("input[name='member_address2']").val();
		if(!addr){
			alert("나머지주소를 입력하세요");
			$('#member_address2').focus();
			return;
		}
		
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
			alert("이메일 인증은 필수입니다.");
			return;
		}
	    
	    var typeChk = $('#typeFlag').val();
	    if(typeChk == 1){
	    	alert('이미지 파일을 제외한 다른 형식의 파일로 변경 할 수 없습니다 .');
	    	return false;
	    }
	    
		var form = $('#modifyForm');
		form.submit();
	});
	
</script>
</body>
