package com.dlms.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler{

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String member_id=request.getParameter("member_id");
		System.out.println("member_id : " + member_id);
		request.setAttribute("msg", exception.getMessage());
		request.setAttribute("member_id", member_id);
		super.onAuthenticationFailure(request, response, exception);
	}
	
	

}
