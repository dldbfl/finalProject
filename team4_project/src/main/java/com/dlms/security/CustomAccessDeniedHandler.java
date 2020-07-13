package com.dlms.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDenided)
			throws IOException, ServletException {
		response.setStatus(HttpStatus.FORBIDDEN.value());
		
		
		if(accessDenided instanceof AccessDeniedException) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if(auth != null &&
					((User)auth.getPrincipal()).getAuthorities().contains(new SimpleGrantedAuthority("USER"))){
				request.setAttribute("msg", "접근 권한이 없습니다.");
			}
		}
		request.getRequestDispatcher("/error/denied-page").forward(request, response);
		
	}

}
