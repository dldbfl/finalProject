<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
	.replyListWrap{
		height: 100px;
	}
	.profileImge{
		height: 60px;
		float: left;
		margin-right: 30px;
	}
	.replyInfo{
		height: 60px;
	}
	.freeboardDetailWrap{
		height: 100%;
	}
	.profileNameSp{
		height: 60px;
		margin-right: 15px;
	}
	.textAreaInfo{
		width: 100%;
	}
	
	.replyContent{
	    width: 960px;
	    height: auto;
    	overflow: auto;
	}
	.writeDate{
		float: right;
		color: darkgray;
	}
	.modifycompletePrevBtns{
		display: none;
	}
	#next{
		border-color: #A566FF;
		background: none;
	}

	#prev{
		border-color: #A566FF;
		background: none;
	}
	.freeText{
		width: 1100px;
		height: 300px;
	}
	.freeTitle{
		width: 80px;
	}
</style>
<body>
  <div class="row freeboardDetailWrap">
	<h3>커뮤니티 > 자유게시판</h3>
    <div id="contact-form" style="padding-top: 5px;">
	<form> 
		<div class="form-group has-success">
		<div align="right">
		    <button type="button" class="btn top btn-sm btn--purple" id="listBtn">닫기</button>
		    <button type="button" class="btn top btn-sm btn-white btn-bold" onclick="javascript:docPrint('document');">
					<i class="grey ace-icon fa fa-print bigger-120"></i><b>인쇄</b>
			</button>
		    <c:if test="${loginUser.member_id == freeboard.member_id }">
		    	<button type="button" class="btn top btn-sm btn--purple" id="freeModifyBtn">수정</button>
		    	<button type="button" class="btn top btn-sm btn--purple" id="removeBtn">삭제</button>
		    </c:if>
		</div>
		
		<div>
		<table>
		 		<tr>
		 			<td class="freeTitle" style="padding: 8px; font-weight: bold; font-size: 20px; color: #003399;">제목</td>
		 			<td class="freeText" style="padding: 8px; height: 15px; font-size: 20px;">${freeboard.freeboard_title}</td>
		 		</tr>
		 		<tr style="border-bottom: 1px">
		 			<td class="freeTitle" style="padding: 8px; font-weight: bold; font-size: 20px; color: #003399;">작성자</td>
		 			<td class="freeText" style="padding: 8px; height: 15px; font-size: 20px;">${freeboard.member_id}</td>
		 		</tr>
		 		<tr>
		 			<td class="freeTitle" style="padding: 8px; font-weight: bold; font-size: 20px; color: #003399;" valign="top">내용</td>
		 			<td class="freeText" style="padding: 8px; font-size: 20px;" valign="top">${freeboard.freeboard_content }</td>
		 		</tr>
		 		
		 		
		 </table>
		</div>
		</div>	
	</form>
	 <!-- 다음글 이전글 목록 -->
		<div id="ButNextPrev">
			<button id="next" class="btn" type="button" style="float: right; ">다음</button>
			<button id="prev" class="btn" type="button" style="float: right; margin-right: 5px;">이전</button>
		</div>
		
		<div id="TitleNextPrev">
			<table>
				<tbody>
					<tr>
						<td style="font-size: 18px;"><a href="<%=request.getContextPath() %>/board/free/detail?freeboard_no=${freeboard.nextNo }">이전글: ${freeboard.nextTitle}</a></td>
					</tr>
					<tr>
						<td style="font-size: 18px;"><a href="<%=request.getContextPath() %>/board/free/detail?freeboard_no=${freeboard.prevNo }">다음글: ${freeboard.prevTitle}</a></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- 끝 -->
		<div class="bg-danger" id="copy">현재 글 주소 복사하기 :
		<a href="<%=request.getContextPath()%>/board/free/detail?freeboard_no=${freeboard.freeboard_no }" onclick="copy_trackback(this.href); return false;">복사</a>
		</div>
		
 <!-- ***댓글리스트*** --> 
  		<hr/>
        <div id="repliesDiv">
        	<div class="comments">
			<div class="comment-wrapper">
				<div class="comment-block comtxt">
					<form action="/reply_ok" >
						<textArea style="width:100%; resize:none; height:60px; line-height:120%;" placeholder="댓글을 입력해 주세요" name="replytext" id="newReplyText"></textArea>
                  			<font color="#656565">현재 <span id="tmptext">0</span>/최대 1000byte(한글 500자, 영문 1000자)</font>
	                    <button type="button" class="btn btn1 btn--purple" style="float: right;" onclick="reply_regist_go();">등록</button>
					</form>
				</div>
			</div>
          	</div><!-- replies -->
      	</div><!-- repliesDiv -->
		<hr style="border: 2px solid;">      	
      	<h4>댓글</h4>
      	<hr style="border: 2px solid;">
      	<c:forEach items="${replyList }" var="reply" varStatus="status">
		    <div class="replyList${status.index} replyListWrap">
	      		<div class="replyInfo">
	      			<img class="profileImge" src="<%=request.getContextPath()%>/board/free/picture/${reply.freeboard_reply_replyer}" onerror="this.src='<%=request.getContextPath()%>/resources/images/info/사용자.png'">
	      			<div class="textAreaInfo">
	      				<div class="profileName">
	      				<input name="replyNo" id="replyNo${status.index}" type="hidden" value="${reply.freeboard_reply_no }">
	      					<span class="profileNameSp">${reply.freeboard_reply_replyer }</span>
	      					<c:if test="${reply.freeboard_reply_replyer == loginUser.member_id }">
		      					<span class="modifyCancelBtns${status.index}">
			      					<button type="button" class="btn btn-info" id="modifyBtn${status.index}" onclick="modifyTextOpen(this);" class="btn btn-info">수정</button>
			      					<button class="btn btn-warning" id="removeBtn${status.index}" onclick="removeReply(this);" >삭제</button>
		      					</span>
		      					<span class="modifycompletePrevBtns">
		      						<button type="button" class="btn btn-info" id="completeBtn${status.index}" onclick="modifyComplete(this);" class="btn btn-info">완료</button>
			      					<button class="btn btn-warning" id="cancelBtn${status.index}" onclick="modifyCancel(this);">이전</button>
		      					</span>
	      					</c:if>
	      					<span class="writeDate">${reply.freeboard_reply_regdate }</span>
	      				</div>
	      				<div class="onlyTextReply${status.index}">
	      					<label class="replyContent">${reply.freeboard_reply_content }</label>
	      				</div>
	      				<div class="">
	      				</div>
	      			</div>
	      		</div>
	      	</div> 
      	</c:forEach>   	 	
    </div>
   </div><!-- row -->
</body>
<script>
	//자유게시판 상세보기 글번호
	boardNum="${freeboard.freeboard_no }";
	
	//자유게시판 상세보기에서 리플 수정완료시 변경기능
	function modifyComplete(obj){
		var idName=$(obj).attr('id');
		var btnIndex=idName.slice(-1);			//해당 게시물위치번호
		var textareas=$(".onlyTextReply"+btnIndex+" textarea").val();		//작성한 글 내용 값 가져오기
		var replyNum=$("#replyNo"+btnIndex).val();							//댓글번호 가져오기
		console.log(replyNum);
		
	  	var data={
				"freeboard_reply_content" : textareas,
				"freeboard_reply_no"	: replyNum
		}
		
		$.ajax({
			url:"/freeBoardReply/replyUpLoad",
			type:"post",
			data:JSON.stringify(data),
			contentType:"application/json; charest=UTF-8",
			success:function(suc){
				alert("성공");
				$(obj).parent().prev().show();
				$(obj).parent().hide();
				$(".onlyTextReply"+btnIndex).children().first().show();
				$(".onlyTextReply"+btnIndex).children().last().remove();
				location.reload();
			},
			error:function(err){
				alert("오류");
			}
		})  
	}

	//자유게시판 상세보기에서 리플 수정시 수정메뉴 도출 기능
	function modifyTextOpen(obj){
		var idName=$(obj).attr('id');
		var btnIndex=idName.slice(-1);		//해당 게시물위치번호
		$(obj).parent().next().show();		
		$(obj).parent().hide();
		
		var beforeText=$(".onlyTextReply"+btnIndex).children().first().text();
		
		$(".onlyTextReply"+btnIndex).children().first().hide();
		$(".onlyTextReply"+btnIndex).append("<textArea style='width:87%; resize:none; height:60px; line-height:120%;'>"+beforeText+"</textArea>")
	}
	
	//자유게시판 상세보기에서 리플 수정시  수정화면이전으로 돌리는 기능
	function modifyCancel(obj){
		var idName=$(obj).attr('id');
		var btnIndex=idName.slice(-1);
		$(obj).parent().prev().show();
		$(obj).parent().hide();
		$(".onlyTextReply"+btnIndex).children().first().show();
		$(".onlyTextReply"+btnIndex).children().last().remove();
	}
	
	//자유게시판 상세보기에서 리플 등록 기능
	function reply_regist_go(){

		var content=$("#newReplyText").val();
		var writer="${loginUser.member_id}";
		
		if(writer == ""){
			alert("로그인후 작성가능합니다.")
			return;
			
		}
		var data={
			"freeboard_no" : boardNum,
			"freeboard_reply_content"	: content,
			"freeboard_reply_replyer"	: writer
		}
		
		$.ajax({
			url:"/freeBoardReply/regist",
			type:'post',
			data: JSON.stringify(data),
			contentType:"application/json; charset=UTF-8" ,
			success:function(suc){

				location.reload();
			},
			error:function(err){
				alert("등록실패");
			}
		})
		
	}
	
	function removeReply(obj){
		var idName=$(obj).attr('id');
		var btnIndex=idName.slice(-1);		//해당 게시물위치번호
		var replyNum=$("#replyNo"+btnIndex).val();
		console.log($("#replyNo"+btnIndex).attr("id"))
		alert(replyNum);
		$.ajax({
			url:"/freeBoardReply/remove?replyNum="+replyNum,
			type:'get',
			success:function(suc){
				location.reload();
			},
			error:function(err){
				alert("삭제실패");
			}
		})
		
		$(".replyList"+btnIndex).remove();
	}
	
	$('button#removeBtn').on('click', function(e){

		var answer = confirm("정말 삭제하시겠습니까?");
		var freeboard_no = "${freeboard.freeboard_no}";
		
		if(answer){
			$.ajax({
				url:"<%=request.getContextPath()%>/board/free/remove",
				type:"get",
				contentType:"application/json; charset=UTF-8" ,
				data:{"freeboard_no":freeboard_no},
				success:function(suc){
					alert("삭제되었습니다");
					location.href="<%=request.getContextPath()%>/board/free";
				},
				error:function(err){
				 	alert("삭제실패"); 
				}
			})
			
		}
		
	});
	
	function copy_trackback(trb) {
		var IE=(document.all)?true:false;
		if (IE) {
		if(confirm("해당 글 주소입니다"))
		window.clipboardData.setData("Text", trb);
		} else {
		temp = prompt("Ctrl+C를 눌러 클립보드로 복사하세요", trb);
		}
		}

</script>

<%@ include file="/WEB-INF/views/board/free/freeboardDetail_js.jsp" %>

