<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<!DOCTYPE html>
<title>창업 후기 수정</title>
<style>
	.breadcrumb-item a{
		text-decoration: none;
		cursor: pointer;
		color: green;
	}
	.quickMenu{
	    font-size: 1.2em;
	}
	.btns{
		margin: 20px 0px;
	}
	#content{
		resize: none;
	}
	#reviewRegist{
		color: gray;
	}
	.titleSpan{
	    text-align: center;
	    font-size: 1.4em;
	    background: lightblue;
	    border-radius: 5px;
	    line-height: 35px;
	}
	.contentLabel{
	    height: 300px;
	    border-radius: 7px;
	    line-height: 240px;
	    text-align: center;
	    font-size: 1.4em;
	    background: lightblue;
	}
	.contentWrap{
		
	}
	.footerBtn{
	    width: 20%;
	    font-size: 1.2em;
	    color: white;
	}
	.fileDrop{
		width:90%;
		height:100px;
		border:1px dotted gray;
		margin:auto;
	}
	.fileUpload{
		text-align: right;
	}
	.fileGroup{
	    height: 150px;
	    border: 1px solid;
	    overflow: auto;
	    padding: 19px;
	    font-size: 16px;
    }
    .uploadFileTeg{
	    border-radius: 7px;
	    line-height: 190px;
	    text-align: center;
	    font-size: 1.4em;
	    background: lightblue;
    }
    .titleText{
		font-size: 1.4em;
	    margin-left: 15px;
	    border-top: none;
	    border-left: none;
	    border-right: none;
	    border-bottom: 2.5px solid;
    }
    .reviewWriter{
	    text-align: center;
	    font-size: 1.4em;
	    background: lightblue;
	    border-radius: 5px;
	    line-height: 35px;
    }
    .inputWriter{
		border: 0px;
	    border: none;
	    cursor: default;
	    font-size: 1.4em;
	    margin-left: 15px;
    }
    .fileGroup input{
    	border: none;
		cursor: default;
    }
    
    input:focus {
    	outline:none;
    }
    .titleWrap{
    	height: 45px;
    }
    .mailbox-attachments{
	    margin-bottom: 16px;
    }
</style>
<body>
<br>
<br>

	<div class="registForm">
		<div class="reigstFormWrap"> 
			<div class="formHeaderRayout">
				<ul class="breadcrumb quickMenu">
					<li class="breadcrumb-item">
						<a href="/main"><i class="fa fa-home fa-lg" aria-hidden="true">홈</i></a>
					</li>
					<li class="breadcrumb-item">
						<a href="/board/foundReviewList" class="list">목록</a>
					</li>
					<li class="breadcrumb-item active">
						<span id="reviewRegist">후기등록</span>
					</li>
				</ul>
				
			</div>
					<hr>
			<div class="formWrap">
				<form action="/board/foundedReview/modify"  method="post" class="contentForm" enctype="multipart/form-data">
					<div class="titleWrap col-sm-auto">
						<input type="hidden" name="founded_review_no" value="${review.founded_review_no }">
						<span class="titleSpan col-sm-1">제목</span>
						<input type="text" class="titleText col-sm-5" name="founded_review_title" value="${review.founded_review_title }"/>
						<div class="col-sm-5">
							<label class="reviewWriter col-sm-5">작성자</label>
							<input type="text" class="inputWriter col-sm-6" name="founded_review_writer" value="${review.founded_review_writer}"  readonly />
						</div>
					</div>
					<div class=" contentWrap col-sm-auto">
						<span class="titleLabel contentLabel col-sm-1">내용</span>
						<div class="col-sm-11">
							<textarea  id="content" name="founded_review_content" onkeydown="CheckTextCount(this, 1000);">${review.founded_review_content }</textarea>
						</div>
					</div>
					<div class="form-group uploadFile">
<!-- 						<label for="fileUpload"><i class="fa fa-file fa-3x" aria-hidden="true"></i></label> -->
					<div class="uploadFileTeg col-sm-1">
						<label >업로드</label>
					</div>
						<div class="mailbox-attachments col-sm-11 ">
							<div class="" id="pictureView" class="profileImgeLabel"></div>
							<label class=" btn btn-info btn-sm btn-flat col-sm-12" onclick="AddFiles();">파일 선택</label>
							<input id="inputFileName" class="form-control" type="hidden" name="member_picture" />
						</div>
					</div>
					<div class="fileGroupWrap col-sm-11">
						<div class="fileGroup col-sm-12">
						<c:forEach	varStatus="status" items="${reviewImg}" var="review">
						<c:set var = "fileName" value = "${fn:split(review.founded_review_img_name,'$$')[1]}"/>
							<input type="text" name="fileName[${status.index}]" value="${fileName }" readonly>
								<i class="fa fa-times-circle fa-2x" aria-hidden="true" onclick="FileRemove(this);"></i>
							<hr>
							<input type="hidden" value="${review.founded_review_img_no }"/>
						</c:forEach>
						</div>
					</div> 
					<div class="fileOrigin">
					</div>
					<div class="removeFiles">
					</div>
					<br>	
					<div class="btns col-md-12 text-center">
						<button type="button" class="footerBtn btn btn-primary" onclick="registBtn();">등록</button>
						<button type="button" class="footerBtn btn btn-warning" onclick="javascript:history.go(-1);">취소</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/summernote_js.jsp" %>

	<script>
	var totalInputCount1=0;
	//동적 Input파일 생성
	function AddFiles(){
		$(".fileOrigin").append("<input type='file' name='addFiles["+totalInputCount1+"]' accept='image/gif,image/jpeg,image/jpg,image/png' onchange='FileChange(this)'>");
		$("input[name='addFiles["+totalInputCount1+"]'").css("display", "none");
		$("input[name='addFiles["+totalInputCount1+"]'").click();
		totalInputCount1++;
	}	
	
	
	var totalInputCount2=${fn:length(reviewImg)};
	//동적 Input파일 생성
	function FileChange(obj){
		var fileFormat= obj.value.substr(obj.value.lastIndexOf(".")+1).toUpperCase();
		if(fileFormat!="JPG" && fileFormat!="PNG" && fileFormat!="GIF" && fileFormat!="BMP" ){
			alert("이미지는 jpg , png, gif, bmp 형식만 가능합니다.");
			return;
		}
		if(obj.files[0].size>1024*1024*5){
			alert("사진 용량은 5MB 이하만 가능합니다.");
			return;
		};
		
		var fileName =obj.value.substr(obj.value.lastIndexOf("\\")+1);		
		$(".fileGroup").append("<input type='text' name='fileName["+totalInputCount2+"]' readonly><i class='fa fa-times-circle fa-2x' aria-hidden='true' onclick='FileRemove(this);'></i><hr>");
		$(".fileGroup input:last").val(fileName);
		totalInputCount2++;
	}
		var removeIndex=0;
	function FileRemove(obj){
		var preFileValue= $(obj).prev().val();
		var origin= $(obj).next().next().val();
		alert(origin);
			$(".removeFiles").append("<input type='hidden'  name='removefile["+removeIndex+"]'/>");
			$("input[name='removefile["+removeIndex+"]']").val(origin);
		//이전태그 이름 가져오기
		var preFileName=$(obj).prev().attr("name");
		//몇번째 값인지 숫자가져오기
		var removeNum=preFileName.charAt(preFileName.length-2);
		alert(removeNum);
		//아이콘 기준 앞뒤 태그 삭제
		$(obj).prev().remove();
		$(obj).next().next().remove();
		$(obj).next().remove();
		
		//해당 input file태그 삭제 
		$("input[name='addFiles["+removeNum+"]'").remove();
		
		//아이콘 삭제 
		obj.remove();
		removeIndex++;
		
	} 
	
	function registBtn(){
		
		var form = $("form");
		var title =$("input[name='founded_review_title']").val();
		var content =$("textarea[name='founded_review_content']").val();
		
		//제목 공백 입력시
		if(!title){
			alert("제목을 입력해주세요");
			$("input[name='founded_review_title']").focus();
			return;
		}
		
		//내용 공백 입력시
		if(!content){
			alert("내용을 입력해주세요");
			$("textarea[name='founded_review_content']").focus();
			return;
		}
		var fileCnt=$(".fileGroup input").length;
		
		if(fileCnt==0){
			alert("첨부파일 등록은 필수 입니다.");
			return;
		}
		
		form.submit(); 
		
	}
	
	</script>


</body>
