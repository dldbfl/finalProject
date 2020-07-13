<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<title>창업후기 등록</title>

<style>
	.breadcrumb-item a{
		text-decoration: none;
		cursor: pointer;
		color: green;
	}
	.quickMenu{
		font-size: 1.4em;
	}
	.btns{
		float: right;
		margin: 24px 0px;
		text-align: center;
	}
	#content{
		resize: none;
	}
	.titleLabel{
	   	text-align: center;
	    font-size: 1.4em;
	    background: lightblue;
	    border-radius: 5px;
	}
	.contentLabel{
		height: 300px;
	    border-radius: 7px;
	    line-height: 240px;
	}
	.cotentWrap{
		padding: 0px;
	}
	.footerBtn{
	    width: 20%;
	    font-size: 1.4em;
	    color: white;
	}
	.fileDrop{
		height:100px;
		border:1px dotted gray;
		margin:auto;
	}
	.fileGroup{
   		height: 166px;
	    border: 1px solid;
	    overflow: auto;
	    padding: 19px;
	    font-size: 16px;
	    width: 89.1%;
    	margin-left: 110px;
    }
    .uploadFileTeg{
	    height: 200px;
	    background: #add8e6;
	    border-radius: 12px;
	    line-height: 200px;
	    text-align: center;
	    font-size: 1.4em;
    }
    .titleText{
        height: 1.7em;
    }
    .reviewWriter{
	    text-align: center;
	    font-size: 1.4em;
	    background: #add8e6;
	    border-radius: 5px;
    }
    .reviewWriter~div{
    	font-size: 1.4em;
    }
    .inputWriter{
    	border: 0px;
    	border: none;
		cursor: default;
		outline:none;
    }
    .fileGroup input{
    	border: none;
		cursor: default;
    }
    
    input:focus {
    	outline:none;
    }
    .registForm{
    	height: 683.2px;
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
				<form action="/board/foundedReview/regist"  method="post" class="contentForm" enctype="multipart/form-data">
					<div class="  col-sm-auto">
						<span class="titleLabel  col-sm-1 ">제목</span>
						<div class="col-sm-6">
							<input type="text" class="titleText col-sm-12" name="founded_review_title"/>
						</div>
						<div class="col-sm-5">
							<span class="reviewWriter col-sm-5">작성자</span>
							<div class="col-sm-6">
								<input type="text" class="inputWriter col-sm-12" name="founded_review_writer" value="${loginUser.member_id }"  readonly />
							</div>
						</div>
					</div><br><br>
					<div class="cotentWrap col-sm-auto">
						<span class="titleLabel contentLabel  col-sm-1">내용</span>
						<div class="col-sm-11">
							<textarea  id="content" name="founded_review_content" onkeydown="CheckTextCount(this, 1000);"></textarea>
						</div>
					</div>
					<div class="form-group uploadFile">
<!-- 						<label for="fileUpload"><i class="fa fa-file fa-3x" aria-hidden="true"></i></label> -->
					<div class="uploadFileTeg col-sm-1">
						<span >업로드</span>
					</div>
						<div class="mailbox-attachments col-sm-11" >
							<div class="" id="pictureView" class="profileImgeLabel"></div>
							<span class=" btn btn-info btn-sm btn-flat col-sm-12" onclick="AddFiles();">파일 선택</span>
							<input id="inputFileName" class="form-control" type="hidden" name="member_picture" />
						</div>
					</div>
					<div class="fileGroup">
						<div class="fileOrigin col-sm-12"></div>
					</div>
					<br>	
					<div class="btns col-md-12">
						<button type="button" class="footerBtn btn btn-primary" onclick="registBtn();">등록</button>
						<button type="button" class="footerBtn btn btn-warning" onclick="history.back()">취소</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/summernote_js.jsp" %>

	<script>
	
	//동적 Input파일 생성
	function AddFiles(){
		
		var totalInputCount= $(".fileOrigin input").length;
		$(".fileOrigin").append("<input type='file' name='addFiles["+totalInputCount+"]' onchange='FileChange(this)'>");
		$("input[name='addFiles["+totalInputCount+"]'").css("display", "none");
		$("input[name='addFiles["+totalInputCount+"]'").click();
	}	
	
	
	function FileChange(obj){
		var totalInputCount= $(".fileOrigin input").length-1;
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
		$(".fileGroup").append("<input type='text' name='fileName["+totalInputCount+"]' readonly><i class='fa fa-times-circle fa-2x' aria-hidden='true' onclick='FileRemove(this);'></i><hr>");
		$(".fileGroup input:last").val(fileName);
		
	}
	function FileRemove(obj){
		
		//이전태그 이름 가져오기
		var preFileName=obj.previousSibling.name;
		
		//몇번째 값인지 숫자가져오기
		var removeNum=preFileName.charAt(preFileName.length-2);
		
		//아이콘 기준 앞뒤 태그 삭제
		obj.previousSibling.remove();
		obj.nextSibling.remove();
		
		//해당 input file태그 삭제 
		$("input[name='addFiles["+removeNum+"]'").remove();
		
		//아이콘 삭제 
		obj.remove();
		
		
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
		var fileCnt=$(".fileOrigin input").length;
		
		if(fileCnt==0){
			alert("첨부파일 등록은 필수 입니다.");
			return;
		}
		
		form.submit(); 
		
	}
	
	</script>
</body>
