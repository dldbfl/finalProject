<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- footer -->
<style>
		<style>

			blockquote, q {
				quotes: none;
			}
			blockquote:before, blockquote:after,
			q:before, q:after {
				content: '';
				content: none;
			}
			table {
				border-collapse: collapse;
				border-spacing: 0;
			}
		body{background-color:#d1d1d1;}
		.notice{width:100%; height:50px; overflow:hidden;}
		.rolling{position:relative; width:100%; height:auto;}
		.rolling li{width:100%; height:50px; line-height:50px;}
		.rolling_stop{display:block; width:100px; height:20px; background-color:#000; color:#fff; text-align:center;}
		.rolling_start{display:block; width:100px; height:20px; background-color:#000; color:#0f0; text-align:center;}
		
		.bookcover{
        		    position: relative;
				    top: -50px;
				    background-image: url(/resources/images/notebook.png);
				    background-size: 100%;
				    background-repeat: no-repeat;
				    background-color: unset;
				    background-position: center;
				    height: 900px;
				    padding-top: 120px;
			    
        }
        .bookcover h1{
        	position: relative;
		    left: 100px;
		    top: 30px;
		    font-family: sans-serif;
		    width: 40%;
        }
        .righttext{
        	overflow: hidden;
		    font-size: 18px;
		    height: 360px;
		    margin-top: 80px;
		    border: pink;
		    margin: 0px;
		    position: relative;
		    right: 80px;
		    top: 46px;
		    background: hsla(0, 100%, 100%, 0.3);
        }
        #buttonset{
			float: right;
		    margin-right: 8%;
		}
		.titlecover{
				/* background-image: url(/resources/images/shelf.png);
		        background-size: 105%;
			    background-repeat: no-repeat;
			    background-color: unset;
			    background-position: 15% 32%;
			    height: 128px;
			    width: 313px; */
			    height: 50px;
		} 
		.titlemessage{
			            position: relative;
					    left: 80px;
					    top: -52px;
					    font-family: sans-serif;
		}
		.titleimage1{
				        height: 60px;
					    width: 50%;
					    background-image: url(/resources/images/notice.png);
					    background-size: 130%;
					    background-repeat: no-repeat;
					    background-color: unset;
		}
		.memocover{ 
				background-image: url(/resources/images/memocover.png);
			    background-size: 105%;
			    background-repeat: no-repeat;
			    background-color: unset;
			    background-position: 10% 74%;
			    width: 701px;
			    height: 600px;
			    position: relative;
			    left: 751px;
			    top: -520px;
			    padding-top: 102px;
			    padding-left: 70px;
			    padding-right: 49px;
		
		}
		
</style>
<link href="<%=request.getContextPath() %>/resources/css/layout/footer.css" rel="stylesheet">	
<footer class="footer" style="padding: 10px; height: 100%;">

  <div class="footer-left col-md-4 col-sm-6" style="float: left; width: 23%">
  	<i class="bullhornIcon fa fa-bullhorn fa-lx" aria-hidden="true" style="color: red;"></i><span style="color: white;">&nbsp;공지사항</span>
  <div class="notice">
    <ul class="rolling" >
	</ul>
  </div>

  
    
  </div>
  <div style="width: 30%;float: left;">
  <p class="about" style="font-size: small;width: 70%">
      <a href="#" style="color: #a4f1a4;font-weight: bold;font-size: medium;"> 기업소개</a>
      <br>
            &nbsp;저희 기업은  E-Leaning System으로 지역경제 활성화를 위한 소상공인 창업지원를 제공하고 있습니다. 지역경제가 악화 되고 위축되는 가운데 창업으로 어려움을 겪고있는 예비창업인 또는 자영업자분들을 위해 재창업 및 창업의 기회를 주고자 E-Leaning System을 구축하여 운영하고 있습니다.  
    </p>
  </div>
  <div class="footer-center col-md-4 col-sm-6" style="width: 25%; margin-top: -10px;">
    <div style="font-size: small; height: 40px;">
      <i class="fa fa-map-marker"></i>
      <p><span> (대흥동)중앙로 76 영민빌딩 2층 </span> 대전, 중구</p>
    </div>
    <div style="font-size: small; height: 40px;">
      <i class="fa fa-phone"></i>
      <p> (042) 277 3120 </p>
    </div>
    <div style="font-size: small; height: 40px;">
      <i class="fa fa-envelope"></i>
      <p><a href="#"> godapple89@nate.com</a></p>
    </div>
  </div >
  <div class="footer-right col-md-4 col-sm-6" style="width: 20%;margin-top: -7px;">
    <h2 style="font-size: xx-large; font-weight: bold;color: #c8eaa8;"> D-LMS<span class="logoImge"></span></h2>
    <p class="menu" style="font-size: small;">
      <a href="/main"> Home</a> |
      <a href="<%=request.getContextPath()%>/enterprise/intro"> 기업소개</a> |
      <a href="<%=request.getContextPath()%>/board/notice/list"> 공지사항</a> |
      <a href="<%=request.getContextPath()%>/myPage/myPageMain"> 커뮤니티</a> |
      <a href="<%=request.getContextPath()%>/board/notice/list"> 고객센터</a>
    </p>
    <p class="name"> Company D-LMS &copy; 2020</p>
  </div>
  <script src="<%=request.getContextPath() %>/resources/scripts/common.js"></script>
  <script>
  	
  	//공지사항 
  	$.ajax({
  		url:"<%=request.getContextPath()%>/noticePointList",
  		type:"post",
  		dataType: "json",
		success:function(suc){
			if(suc.length <6){
				for(var i=0; i<suc.length; i++){
					var lis=$("<li></li>");
			  		var	as=$("<a></a>");
			  		as.attr("href","${pageContext.request.contextPath}/board/notice/detail?notice_no="+suc[i].notice_no);
					as.text(suc[i].notice_title);
					lis.append(as);
					$(".rolling").append(lis);
				}
					var height =  $(".notice").height();
					var num = $(".rolling li").length;
					console.log(num);
					var max = height * num;
					var move = 0;
					function noticeRoll(){
						move += height;
						$(".rolling").animate({"top":-move},1000,function(){
							if( move >= max ){
								$(this).css("top",0);
								move = 0;
							};
						});
					};
					setInterval(noticeRoll,2000);
					$(".rolling").append($(".rolling li").first().clone());
				
			}else if(suc.length >=6){
				
				for(var i=0; i<5; i++){
					var lis=$("<li></li>");
			  		var	as=$("<a></a>");
			  		as.attr("href","${pageContext.request.contextPath}/board/notice/detail?notice_no="+suc[i].notice_no);
					as.text(suc[i].notice_title);
					lis.append(as);
					$(".rolling").append(lis);
				}
				var height =  $(".notice").height();
				var num = $(".rolling li").length;
				
				console.log(num);
				var max = height * num;
				var move = 0;
				function noticeRolling(){
					move += height;
					$(".rolling").animate({"top":-move},1000,function(){
						if( move >= max ){
							$(this).css("top",0);
							move = 0;
						};
					});
				};
				setInterval(noticeRolling,2000);
				$(".rolling").append($(".rolling li").first().clone());
			}
		},
		error:function(err){
			
		}
  	})
  	
  		
  		
<%--   		as.attr("href","<%=reuqest.get") --%>
  
  
  
  
  

</script>
</footer>
</html>