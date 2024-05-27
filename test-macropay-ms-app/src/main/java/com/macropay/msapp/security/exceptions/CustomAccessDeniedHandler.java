package com.macropay.msapp.security.exceptions;

import java.io.IOException;

import org.springframework.http.HttpStatus;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/*
@Component
public class CustomAccessDeniedHandler extends AccessDeniedHandlerImpl {
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type", "application/json;charset=UTF-8");
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.getWriter().write(new ObjectMapper().writeValueAsString(""));
	}
	
}
*/
