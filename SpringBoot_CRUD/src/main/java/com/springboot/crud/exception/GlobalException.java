package com.springboot.crud.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler{
	
	
    @Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Object>("Please change the http method request !!! ",HttpStatus.NOT_FOUND);
	}	
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
    		HttpHeaders headers, HttpStatus status, WebRequest request) {
    	// TODO Auto-generated method stub
    	return new ResponseEntity<Object>("Please change the method body", HttpStatus.BAD_REQUEST);
    }
	/*
	 * protected ResponseEntity<Object>
	 * handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException
	 * ex, HttpHeaders headers, HttpStatus status, WebRequest request) { // TODO
	 * Auto-generated method stub return new
	 * ResponseEntity<Object>("Please change the http Media Type !!!",
	 * HttpStatus.NOT_FOUND); }
	 */
    
    
    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
    		HttpHeaders headers, HttpStatus status, WebRequest request) {
    	// TODO Auto-generated method stub
    	return new ResponseEntity<Object>("Please change the HTTP Media Type !!!", HttpStatus.NOT_ACCEPTABLE);
    }
    
    
    
   
	

}
