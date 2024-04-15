package com.example.springsecuritysection9.filter;

import java.io.IOException;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CsrfCookieFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// (CsrfToken)request here we are trying to read the CsrfToken available inside the HttpServletRequest request and we are typecasting the request into CsrfToken
		CsrfToken csrfToken = (CsrfToken)request.getAttribute(CsrfToken.class.getName());
		
		// when we send the csrfToken value as response header the spring security framework takes care of generating the cookie and send the same to the browser/ our UI application as part of the response
		if(csrfToken.getHeaderName() != null) {
			response.setHeader(csrfToken.getHeaderName(), csrfToken.getToken());
		}
		filterChain.doFilter(request, response);
	}

}
