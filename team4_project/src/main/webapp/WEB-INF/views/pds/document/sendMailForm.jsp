<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html >
<head>
<!-- JQuery 3.4.1 -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<!--  JQuery 1.12.1 UI -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<!-- JQuery 2.2.0 Color -->
<script src="https://code.jquery.com/color/jquery.color-2.2.0.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<!-- 아이콘 모음 -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>

<!-- summernote 0.8.12 -->


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
	*{
		margin: 0px;
		padding: 0px;
	}

	html{
		padding: 20px;
		
	}
	.sendTable{
		width: 100%;
    	height: 615px;
	}
	.toName{
		 width: 167px;
    	 text-align: center;
	}
	.sendHeader{
		height: 43px;
	}
	.fileTr{
		height: 30px;
		border-bottom: 13px solid white;
	}
	.sender, .receiver{
		height: 50px;
	}
	.senderTd{
   		border-bottom: 2px solid;
	}
	.sendList{
		width: 100%;
	    font-size: 1.2em;
	    height: 100px;
	    overflow: scroll;
	}
	
	.modalTabel{
		width: 100%;
   		border-color: red;
   		
	}
	select{
		width: 100%;
		height: 100%;
	}
	.td11{
	}
	#td2{
		text-align: center;
	    padding: 10px;
	}
	.moveBtn{
		margin-right: 10px;
		width: 100px;
	}
	option{
		font-size: 1.2em;
	}
	.modal-title{
		display: contents;
	}
	tr th{
		width: 104px;
    	text-align: center;
	}
	.sendName{
		font-size: 1.3em;
		border-bottom: 2px solid;
	}
	.sendTime{
		float: right;
    	margin-right: 15px;
    	color: #6666;
	}
	.sendTitle{
		border-bottom: 2px solid;
	}
	
	input[name=subject]{
		width: 100%;
    	height: 100%;
    	border: none;
	}
	input[name=sendTitle]{
		width: 100%;
	}
	.contentTextarea{
		display: contents;
	}
	
	
	
.bms-cust-sub-search-form-line2-in-checkarea::-webkit-scrollbar {
  width: 8px;
  height: 8px;
  border: 3px solid #fff;
}
.bms-cust-sub-search-form-line2-in-checkarea::-webkit-scrollbar-button:start:decrement,
::-webkit-scrollbar-button:end:increment {
  display: block;
  height: 5px;
  background: #fff;
}
.bms-cust-sub-search-form-line2-in-checkarea::-webkit-scrollbar-track {
  background: #fff;
  -webkit-border-radius: 10px;
  border-radius:10px;
}
.bms-cust-sub-search-form-line2-in-checkarea::-webkit-scrollbar-thumb {
  height: 50px;
  width: 50px;
  background: rgba(0,0,0,.2);
  -webkit-border-radius: 8px;
  border-radius: 8px;
}
.note-editor{
	width: 129%;
}

.fa-times-circle{
	cursor: pointer;
}
.sendBtn{
	margin-left: 15px;
}

	
	
</style>
<script>
	window.onload = function(){
			 upList=document.getElementById("baseList");
			 downList=document.getElementById("addList");
	}
	
	//한개씩 추가사항에 넣기
	function toDown() {
		var x = upList.selectedIndex;
		var y = upList.options;
		var idx = y[x].index;
		console.log("선택한 index : " + idx);

			if(idx == -1){
				alert("선택하세요");
				return;
			}
		upValue = upList.options[idx].value
		upText = upList.options[idx].text
		upRole = upList.options[idx].getAttribute("role");
		opt = document.createElement("option");
		opt.style.color="blue";
		opt.value = upValue;
		opt.text = upText;
		opt.setAttribute('role',upRole);
		
		downList.appendChild(opt);
		upList.removeChild(upList.options[idx]);
	}
	// 추가사항 1개씩 삭제하는 기능
	function toUp() {
		var x = downList.selectedIndex;
		var y = downList.options;
		var idx = y[x].index;
		console.log("선택한 index : " + idx);

			if(idx == -1){
				alert("선택하세요");
				return;
			}
	downVale = downList.options[idx].value
	downText = downList.options[idx].text
	dowRole = downList.options[idx].getAttribute("role");
	opt = document.createElement("option");
	opt.style.color="blue";
	opt.value = downVale;
	opt.text = downText;
	opt.setAttribute('role',dowRole);
	
	upList.appendChild(opt);
	downList.removeChild(downList.options[idx]);
	}
	
	//추가사항 모두삭제하는 기능 
	function AllDown(){
		//배열은 0부터 시작하기때문에 총길이에서 -1을뺀다
		leng =upList.length-1
		//뒤에서부터 하나하나씩 삭제 하기 
		for(i=leng; i>=0; i--){
			upValue = upList.options[i].value;
			upText = upList.options[i].text;
			upRole = upList.options[i].getAttribute("role");
			if(upValue != "status2"){
				opt = document.createElement("option");
				opt.style.color="blue";
				opt.value = upValue;
				opt.text = upText;
				opt.setAttribute('role',upRole);
				downList.appendChild(opt);
;				upList.removeChild(upList.options[i]);
			}
		}
		
	}
	
	function AllUp() {
		//총길이
		leng =downList.length
		
		//총길이를 알아서 값 하나하나 올리기
		for(i=0; i<leng; i++){
			downText = downList.options[i].text
			downRole = downList.options[i].getAttribute("role");
			opt = document.createElement("option");
			opt.style.color="blue";
			opt.value = "status1";
			opt.text = downText;
			opt.setAttribute('role',downRole);
			
			upList.appendChild(opt);
		}
		
		//자식요소 다지우기
		while (downList.firstChild) {
			 downList.removeChild(downList.firstChild);
	    }
	}
</script>
<title>공유하기(이메일발송)</title>
</head>
<body>
	<div class="wrap">
		<h3>이메일 쓰기</h3>
		<form action="sendEmailShare" method="post">
			<button class="btn btn-warning sendBtn" type="button" onclick="sendBtn();" >전송</button>
			<table class="sendTable"  cellpadding="0" cellspacing="0">
				<tr class="receiver">
					<th>보내는사람</th>
					<td class="sendName" colspan="2">${loginUser.member_name }(${loginUser.member_id })      <span class="sendTime"></span></td>
				</tr>
				<tr class="sender">
					<th>받는 사람</th>
					<td class="senderTd">
						<div id="sendList" class="sendList  bms-cust-sub-search-form-line2-in-checkarea">
						</div>
					</td>
					<td class="toName">
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#ModalCenter">주소록</button>
					<!-- Modal -->
					<div class="modal fade" id="ModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
					  <div class="modal-dialog modal-dialog-centered" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					      <br>
					        <h3 class="modal-title" id="exampleModalLongTitle">교수 주소록</h3>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true"><i class="fa fa-times fa-lg" aria-hidden="true"></i></span>
					    
					        </button>
					      </div>
					      <div class="modal-body">
					      <div class="td11">
								<select ondblclick="toDown()" id="baseList"  name="left" multiple size="7" class="bms-cust-sub-search-form-line2-in-checkarea">
									<c:forEach items="${professorList }" var="proList">
				   							<option role="${proList.member_id }" value="status${proList.member_status }">${proList.member_name }(${proList.member_email })</option>
								  	 	</c:forEach>
								</select>
							</div>
							<div id= "td2">
								<button type="button" class="moveBtn" onclick="toDown()" value=">"><i class="fa fa-angle-down fa-lg" aria-hidden="true"></i></button>
								<button type="button" class="moveBtn" onclick="AllDown()" value=">>"><i class="fa fa-angle-double-down fa-lg" aria-hidden="true"></i></button>
								<button type="button" class="moveBtn" onclick="toUp()" value="<"><i class="fa fa-angle-up fa-lg" aria-hidden="true"></i></button>
								<button type="button" class="moveBtn" onclick="AllUp()" value="<<"><i class="fa fa-angle-double-up fa-lg" aria-hidden="true"></i></button>
								
							</div>
							<div class ="td12">
								<select ondblclick="toUp()" id="addList"  name="right" multiple size="7" class="bms-cust-sub-search-form-line2-in-checkarea" >
								
								</select>
							</div>
						  </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소하기</button>
					        <button type="button" onclick="professorName();" class="btn btn-primary">등록하기</button>
					      </div>
					    </div>
					  </div>
					</div>
					 <%--   <select>
					   	<c:forEach items="${professorList }" var="proList">
					   		<option value="status${proList.member_status }">${proList.member_name }(${proList.member_id })</option>
					   	</c:forEach>
					   </select> --%>
				   </td>
				</tr>
				<tr class="sendHeader">
				   <th>제목</th>
				   <td class="sendTitle" colspan="2">
						<input type="text" name="sendTitle" size="40">
				   </td>
				</tr>
				<tr class="fileTr">
				   <th style="padding-top: 14px;">첨부파일</th>
				   <td colspan="2" style="padding-top: 20px;"><p>${documentInfo.originalName }</p>
				   <input type="hidden" name=""/></td>
				</tr>
				<tr>
				   <th>내용</th>
				   <td class="contentTextarea" colspan="2"><textarea  id="content" name="sendContent" onkeydown="CheckTextCount(this, 1000);">
				   	제목 :	${documentInfo.document_title }
				   	내용 :	${documentInfo.document_content }
				   	----------------------------------------------------------------------------------------------------------------------------------------------------------
				   </textarea></td>
				</tr>
				
			</table>
			<input type="hidden" name="documentNum" value="${documentInfo.document_no }"/>
		</form>
	</div>
	
	<%@ include file="/WEB-INF/views/summernote_js.jsp" %>
	<script>
	
	function professorName(){
			var addListSize= $("#addList").children().length;
			
			for(var i=1; i<addListSize+1; i++){
				var thisOption=$("#addList option:nth-child("+i+")").text();
				var arr=thisOption.split("(");
				var name=arr[0];
				var email=arr[1].replace(")","");
				var id=$("#addList option:nth-child("+i+")").attr("role");
				console.log()
				$(".sendList").append("<span role='"+id+"'>"+thisOption+"<i class='fa fa-times-circle fa-lg' style='color:red;' onclick='CancelBtn(this);' aria-hidden='true'></i></span><br>");
			}
			$('.modal').modal("hide"); //닫기 
	}
	
	function CancelBtn(obj){
			$(obj).parent().next().remove();
			$(obj).parent().remove();
	}
	
		$("input[name='subject']").focus();
	
		var date = new Date();
		date=moment(date).format('YYYY-MM-DD HH:mm:ss');
		$(".sendTime").text(date);
		
		$("option[value='status0']").attr("disabled","disabled");
		$("option[value='status0']").css("color","#666");
		$("option[value='status1']").css("color","blue");	
		$("option[value='status2']").attr("disabled","disabled");
		$("option[value='status2']").css("color","#666");
		
		
	function sendBtn(){
		var titleVal=$("input[name='sendTitle']").val();
		if(!(titleVal.trim()) && !titleVal){
			alert("제목을 입력해주세요")
			return;
		}
		
		var addrleng=$(".sendList").children("span").length;
		if(addrleng==0){
			alert("받는사람을 추가하세요");
			return;
		}
		
		for(var i =0; i<addrleng; i++){
			var thisSpan=$(".sendList").children("span")[i];
			
			var thisSpanText=$(".sendList").children("span")[i].innerText;
			console.log("thisSpanText : " + thisSpanText);
			var arr=thisSpanText.split("(");
			var emailAddr=arr[1].replace(")","");
		 	var id = thisSpan.getAttribute('role');
			console.log("emailAddr : " + emailAddr)
			console.log("id : " + id)
			
		 	$("table").append("<input type='hidden' name='member["+i+"].member_email'/>")
			$("table").append("<input type='hidden' name='member["+i+"].member_id'/>")
			$("input[name='member["+i+"].member_email']").val(emailAddr);
			$("input[name='member["+i+"].member_id']").val(id); 
		} 
		
	 	var form=$("form");
		form.submit(); 
	}
		
		
	</script>
	
</body>
</html>
