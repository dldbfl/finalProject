<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
table{
		border-collapse:separate ;
		
	}
.container-dashboard {
    
    padding: 100px 30px 30px ;
   
}

.meminfo {
	cursor: pointer;
}

.popupLayer {
	position: absolute;
	display: none;
	background-color: #ffffff;
	border: solid 2px #d0d0d0;
	width: 350px;
	height: 150px;
	padding: 10px;
}
.popupLayer div {
	position: absolute;
	top: 5px;
	right: 15px;
}

div#picturePreView{
	height:120px;
	width:100px;
	border : 1px solid lightgray;  		
	
}

</style>
<body>
<br>
	<a>마이페이지</a> > <a>수강신청내역</a>
	<br>
	<h3>수강신청내역</h3>
	
	
<body class="blur-theme data-container-body">
	<div id="projectmaster" class="content">

			<div class="container-dashboard">
				<div class="container-dashboard-inner">
			
								
				<div class="table-responsive">
					<table class="table table-striped">
						<thead id="trtr">
							<tr >
								<th class="text-center">강의명</th>
								<th class="text-center">결제금액</th>
								<th class="text-center">결제일자</th>
								<th class="text-center">환불신청</th>
							</tr>
						</thead>
						<tbody>
						
						  <c:forEach items="${payList}" var="pay">
							<tr>
								<td class="text-center">
								<i class="fa text-center" aria-hidden="true">${pay.class_name}</i>
								</td>
								<td class="text-center">${pay.pay_price}</td>
								
								<td align="center">
									<i class="fa text-center" aria-hidden="true"><fmt:formatDate value="${pay.pay_complete_date}" pattern="yy-MM-dd"/></i>
								</td>

								<td align="center" class="text-center">
								
								<button onclick="cancelPay(${pay.pay_no},${pay.pay_price},'${pay.class_name}')">환불하기</button>
								</td>
							</tr>
						</c:forEach> 
							
						</tbody>
					</table>
				</div>
				
				
				<div>
					
				</div>
			</div>
		</div>
	</div>
	
</body>

  <script>
    function cancelPay(pay_no,pay_price,class_name) {
        var student_id='${loginUser.member_id}';
    	
        var jsonData= {
        		"pay_no":pay_no,
        	    "student_id":student_id,
        		"pay_price":pay_price,
        		"class_name":class_name,
        		};
        
    	$.ajax({
    	    type : "POST",
            url: '<%=request.getContextPath()%>/myPage/pay/payments/cancel',
            data : jsonData,
        	success:function(result) {
    			location.href="<%=request.getContextPath()%>/myPage/pay/cancelSuccess";
    		},
    		error:function(err){
    			location.href="<%=request.getContextPath()%>/myPage/pay/cancelFail";
    		}  
      	});
        
 
        
    }
  </script>
