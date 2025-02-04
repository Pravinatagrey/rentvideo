package com.nt.security;

import java.io.IOException;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
Set<String> roles= AuthorityUtils.authorityListToSet(authentication.getAuthorities());
	if(roles.contains("ADMIN")) {
	//	userrole="ADMIN";
		System.out.println(authentication.getAuthorities());
		response.sendRedirect("/api/success");
	}
	else {
	//	userrole="CUSTOMER";
		System.out.println(authentication.getAuthorities());
		response.sendRedirect("/user/success");
	}
	
	}

}
