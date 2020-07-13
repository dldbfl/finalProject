package com.dlms.request;

import java.util.Date;

import com.dlms.dto.ConsultVO;
import com.dlms.dto.QnaVO;

/**
 * 
 * @사용목적 : 등록에 필요한 Request
 * @작성자 : 민태홍
 * @작성날짜 : 2020. 6. 10.
 * @마지막수정자 : 민태홍
 * @마지막수정일 : 2020. 6. 10.오후 3:14:24
 * @see :
 *
 */
public class ConsultRequest {

	private String consult_writer;
	private String consult_title;
	private String consult_content;
	private String consult_pwd;
	private String consult_type;

	public ConsultRequest() {
		super();
	}

	public String getConsult_writer() {
		return consult_writer;
	}

	public void setConsult_writer(String consult_writer) {
		this.consult_writer = consult_writer;
	}

	public String getConsult_title() {
		return consult_title;
	}

	public void setConsult_title(String consult_title) {
		this.consult_title = consult_title;
	}

	public String getConsult_content() {
		return consult_content;
	}

	public void setConsult_content(String consult_content) {
		this.consult_content = consult_content;
	}

	public String getConsult_pwd() {
		return consult_pwd;
	}

	public void setConsult_pwd(String consult_pwd) {
		this.consult_pwd = consult_pwd;
	}

	public String getConsult_type() {
		return consult_type;
	}

	public void setConsult_type(String consult_type) {
		this.consult_type = consult_type;
	}

	
	
	@Override
	public String toString() {
		return "ConsultRequest [consult_writer=" + consult_writer + ", consult_title=" + consult_title
				+ ", consult_content=" + consult_content + ", consult_pwd=" + consult_pwd + ", consult_type="
				+ consult_type + "]";
	}
	
	

	public ConsultRequest(String consult_writer, String consult_title, String consult_content, String consult_pwd,
			String consult_type) {
		super();
		this.consult_writer = consult_writer;
		this.consult_title = consult_title;
		this.consult_content = consult_content;
		this.consult_pwd = consult_pwd;
		this.consult_type = consult_type;
	}

	public ConsultVO toRegistConsultVO() {
		ConsultVO consult = new ConsultVO();

		consult.setConsult_title(this.consult_title);
		consult.setConsult_writer(this.consult_writer);
		consult.setConsult_content(this.consult_content);
		consult.setConsult_pwd(this.consult_pwd);
		consult.setConsult_type(this.consult_type);

		return consult;

	}

}
