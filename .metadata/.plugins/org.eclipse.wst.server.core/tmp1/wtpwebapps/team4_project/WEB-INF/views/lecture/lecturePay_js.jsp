<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<body>
    <script>
    $('#payButton').on('click',function(){
        var IMP = window.IMP; // 생략가능
        IMP.init('imp43485671'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
        var msg;
        var pay_no='${payDetail.pay_no}';
        var student_id='${loginUser.member_id}';
        var lecture_no='${lecture.lecture_no}';
        var professor_id='${lecture.professor_id}';
        var lecture_title='${lecture.lecture_title}';
        var pay_price='${lecture.lecture_price}';
        var class_name='${payDetail.class_name}';
        var member_id='${loginUser.member_id}';
        var lecture_price='${payDetail.lecture_price}';
       	
        var jsonData= {
        		"pay_no":pay_no,
        		"lecture_no":lecture_no,
        	    "professor_id":professor_id,
        	    "student_id":student_id,
        		"lecture_title":lecture_title,
        		"pay_price":pay_price,
        		"class_name":class_name,
        		"member_id":member_id,
        		"lecture_price":lecture_price
        		};
        
        
        IMP.request_pay({
            pg : 'kakaopay',
            pay_method : 'card',
            merchant_uid : 'merchant_' + new Date().getTime(),
            name : '${lecture.lecture_title}',
            amount : '${lecture.lecture_price }',
            buyer_postcode : '123-456',
            //m_redirect_url : 'http://www.naver.com'
        }, function(rsp) {
            if ( rsp.success ) {
                //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
                
                jQuery.ajax({
                    url: "/pay/payIng", //cross-domain error가 발생하지 않도록 주의해주세요
            		dataType : 'text',
            		type : 'POST',
            		data : JSON.stringify(jsonData), //그냥 member 사용하면 error 발생!
            		contentType : 'application/json; charset=UTF-8',
            		
            		success:function(result) {
            			location.href="<%=request.getContextPath()%>/pay/paySuccess";
            		},
            		error:function(err){
            			location.href="<%=request.getContextPath()%>/pay/payFail";
            		}                    /*dataType: 'json',
                    data: {
                        imp_uid : rsp.imp_uid,
                        jsonData : jsonData
                        
                    }*/
                });
            } else {
                msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
                //실패시 이동할 페이지
                location.href="<%=request.getContextPath()%>/pay/payFail";
                alert(msg);
            }
        });
        
    });
    </script>
 
</body>
</html>
