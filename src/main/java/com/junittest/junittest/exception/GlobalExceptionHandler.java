
package com.junittest.junittest.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

//	@ExceptionHandler(EmailIdAlreadyExsistException.class)
//	public ResponseEntity<Object> handleEmailIdAlreadyExsistException(EmailIdAlreadyExsistException ex){
//		
//		String message = ex.getMessage();
//		List<String> details = new ArrayList<>();
//		details.add("Email Already Exist in database");
//		
//		ApiErrors errors = new ApiErrors(message, details, HttpStatus.BAD_REQUEST, LocalDateTime.now());
//		
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
//	}
	
//	@ExceptionHandler(EmployeeNotFoundException.class)
//	public ResponseEntity<Object> employeeNotFoundException(EmployeeNotFoundException emp){
//		
//		String message = emp.getMessage();
//		List<String> details = new ArrayList();
//		details.add("Employee details are not here");
//		
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(details);
//	}
}
