package com.MachineTest.Nimap.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.MachineTest.Nimap.Entity.ErrorResponse;

@ControllerAdvice
public class CategoryNotFoundAdvice 
{
	 @ExceptionHandler(CategoryNotFoundException.class)
	    public ResponseEntity<ErrorResponse> handleCategoryNotFoundException(CategoryNotFoundException ex) {
	        // Create an error response object with the exception message and 404 status code
	        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());

	        // Return ResponseEntity with the error response and 404 Not Found status
	        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	    }

}
