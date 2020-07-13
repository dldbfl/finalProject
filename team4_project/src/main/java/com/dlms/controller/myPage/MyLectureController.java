package com.dlms.controller.myPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dlms.dto.LectureVO;
import com.dlms.dto.MemberVO;
import com.dlms.dto.PayVO;
import com.dlms.dto.RefundVO;
import com.dlms.service.member.MemberService;
import com.dlms.service.pay.PayService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/myPage/pay")
public class MyLectureController {

	@Autowired
	private PayService payService;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/list")
	public ModelAndView lecturePayList(ModelAndView mnv, PayVO pay,HttpSession session)throws Exception{
		String url = "/myPage/myLectureList.page";
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		String student_id = loginUser.getMember_id(); 
		
		List<PayVO> payList = payService.selectPayMyList(student_id);
		System.out.println("controller+payList:"+payList);
		mnv.addObject("payList",payList);
		mnv.setViewName(url);
		return mnv;
		
	}
	@RequestMapping(value="/payments/cancel")
	public ModelAndView refundDetail(ModelAndView mnv, RefundVO refund,PayVO pay, HttpSession session)throws Exception{
		String url = "/myPage/refundDetail.page";
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
			System.out.println("loginUser++"+loginUser);
			System.out.println("마이페+payVO++"+pay);
		int pay_no = pay.getPay_no();
			//System.out.println(pay_no);
		//결제취소 성공시 pqy에 컬럼 삭제
		System.out.println("pay_no"+pay_no);
		payService.deletePayNo(pay_no);
		
		refund.setPay_no(pay_no);
		//결제 취소 refund입력
		payService.insertRefund(refund);
			//System.out.println("refund+++"+refund);
		//회원등급을 수강생에서 회원으로 전환
		memberService.updateUserAuthority(loginUser.getMember_id());
		
		mnv.setViewName(url);
		return null;
	}
	
	@RequestMapping(value="/cancelSuccess")
	public ModelAndView paySuccess(ModelAndView mnv)throws Exception{
		String url = "/myPage/cancelSuccess.page";
		mnv.setViewName(url);
		return mnv;
	}
	@RequestMapping(value="/cancelFail")
	public ModelAndView payFail(ModelAndView mnv)throws Exception{
		String url = "/myPage/cancelFail.page";
		mnv.setViewName(url);
		return mnv;
	}	
	
	/*public static final String IMPORT_TOKEN_URL = "https://api.iamport.kr/users/getToken";
	public static final String IMPORT_PAYMENTINFO_URL = "https://api.iamport.kr/payments/find/";
	public static final String IMPORT_CANCEL_URL = "https://api.iamport.kr/payments/cancel";
	public static final String IMPORT_PREPARE_URL = "https://api.iamport.kr/payments/prepare";

	public static final String KEY = "8362829191316425";
	public static final String SECRET = "PvN2B1BpneEdsDjrMEDq6VWykmsT1a0QGNThOvHcKmpdZIELnicue92ywusxFsnlfhD4MkgxGFKGoprL";

	public String getImportToken() {
		String result = "";
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(IMPORT_TOKEN_URL);
		Map<String, String> m = new HashMap<String, String>();
		m.put("imp_key", KEY);
		m.put("imp_secret", SECRET);
		try {
			post.setEntity(new UrlEncodedFormEntity(convertParameter(m)));
			HttpResponse res = client.execute(post);
			ObjectMapper mapper = new ObjectMapper();
			String body = EntityUtils.toString(res.getEntity());
			JsonNode rootNode = mapper.readTree(body);
			JsonNode resNode = rootNode.get("response");

			result = resNode.get("access_token").asText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}*/
	
	
	
	//Map을 사용해서 Http요청 파라미터를 만들어 주는 함수 
/*	private List<NameValuePair> convertParameter(Map<String,String> paramMap){
		List<NameValuePair> paramList = new ArrayList<NameValuePair>();	 
		
		Set<Entry<String,String>> entries = paramMap.entrySet(); 
		for(Entry<String,String> entry : entries) {
			 paramList.add(new BasicNameValuePair(entry.getKey(), entry.getValue())); 
		
		} return paramList; 
	} */
	
	//결제취소 
/*	public int cancelPayment(String token, String mid) { 
		HttpClient client = HttpClientBuilder.create().build(); 
		HttpPost post = new HttpPost(IMPORT_CANCEL_URL); 
		Map<String, String> map = new HashMap<String, String>(); 
	
		post.setHeader("Authorization", token); map.put("merchant_uid", mid); 
	
		String asd = "";
		 try { 
	
			post.setEntity(
		new UrlEncodedFormEntity(convertParameter(map))
			);
			 HttpResponse res = client.execute(post);
			 ObjectMapper mapper = new ObjectMapper(); 
			 String enty = EntityUtils.toString(res.getEntity()); 
				JsonNode rootNode = mapper.readTree(enty); 
				asd = rootNode.get("response").asText(); 
		} catch (Exception e) {
			 e.printStackTrace(); 
		} if (asd.equals("null")) {
			 System.err.println("환불실패");
			 return -1; 
		} else {
			 System.err.println("환불성공"); 
				return 1; 
		} 
		
	}*/

}
