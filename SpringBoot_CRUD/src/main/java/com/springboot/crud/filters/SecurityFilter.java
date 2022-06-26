package com.springboot.crud.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.springboot.crud.controller.EmployeeController;

@Component

public class SecurityFilter implements Filter{
	Logger logger= LoggerFactory.getLogger(EmployeeController.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		logger.info("Inside the Security Filter");
		chain.doFilter(request, response);
	}
}
