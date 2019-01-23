package com.dolton.study.ppm.ppmtool.error;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestErrorHandler
{
	@ExceptionHandler
	public ResponseEntity<RestErrorResponse> handleException(Exception ex)
	{
		RestErrorResponse rer = new RestErrorResponse();
		rer.setStatus(HttpStatus.BAD_REQUEST.value());
		rer.setMessage(ex.getMessage());
		rer.setTimeStamp(new Date().getTime());
		
		return new ResponseEntity<>(rer, HttpStatus.BAD_REQUEST);
	}
}
