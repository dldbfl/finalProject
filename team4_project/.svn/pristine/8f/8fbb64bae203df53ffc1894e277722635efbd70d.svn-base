<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<body>
<div class="popupLayer">
	<div>
		<span onClick="closeLayer(this)" style="cursor:pointer;font-size:1.5em" title="닫기">X</span>
	</div>

	<table border="0" style="font-size:9pt; width:100%;" cellspacing=0 cellpadding=0>
	<tr>
		<td valign="middle" align=center width=110>
		<img id='userphoto'  src="<%=request.getContextPath() %>/member/picture/${memberData.member_id}" BORDER=0 width="100" height="120" 
		onerror="this.src='<%=request.getContextPath() %>/resources/images/info/photo_user_default.gif';">
		</td>
		<td valign="center">
			<table id=Info width=99% border=0 cellpadding=0 cellspacing=0>
				<tr height=22>
					<td>&nbsp;<img src="<%=request.getContextPath()%>/resources/images/info/etc_infor_dot.gif" border=0>&nbsp;아이디 : ${memberData.member_id }</td>
				</tr>
				<tr height=22>
					<td>&nbsp;<img src="<%=request.getContextPath()%>/resources/images/info/etc_infor_dot.gif" border=0>&nbsp;이메일 : ${memberData.member_email }</td>
				</tr>
			
			</table>
		</td>
	</tr>
	</table>
	</div>
</body>

<script>
/*아이디 클릭시 팝업 생성*/
function closeLayer( obj ) {
		$(obj).parent().parent().hide();
	}

	$(function(){

		/* 클릭 클릭시 클릭을 클릭한 위치 근처에 레이어가 나타난다. */
		$('.meminfo').click(function(e)
		{
			var sWidth = window.innerWidth;
			var sHeight = window.innerHeight;

			var oWidth = $('.popupLayer').width();
			var oHeight = $('.popupLayer').height();

			// 레이어가 나타날 위치를 셋팅한다.
			var divLeft = e.clientX + 10;
			var divTop = e.clientY + 5;

			// 레이어가 화면 크기를 벗어나면 위치를 바꾸어 배치한다.
			if( divLeft + oWidth > sWidth ) divLeft -= oWidth;
			if( divTop + oHeight > sHeight ) divTop -= oHeight;

			// 레이어 위치를 바꾸었더니 상단기준점(0,0) 밖으로 벗어난다면 상단기준점(0,0)에 배치한다
			if( divLeft < 0 ) divLeft = 0;
			if( divTop < 0 ) divTop = 0;

			$('.popupLayer').css({
				"top": divTop,
				"left": divLeft,
				"position": "absolute"
			}).show();
		});

	});
</script>
