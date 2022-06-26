package com.sprinboot.crud.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.crud.filters.SecurityFilter;

@Configuration
public class FilterConfiguration {
	
	@Bean
	public FilterRegistrationBean<SecurityFilter> registertionBean(){
		FilterRegistrationBean<SecurityFilter> filter =new FilterRegistrationBean<SecurityFilter>();
		filter.setFilter(new SecurityFilter());
		filter.addUrlPatterns("/api/c1/allEmployees*");
		return filter;
		
	}

}
