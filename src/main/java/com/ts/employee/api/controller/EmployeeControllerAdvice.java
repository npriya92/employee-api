package com.ts.employee.api.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.ts.employee.api.exception.EmployeeAlreadyExistsException;
import com.ts.employee.api.exception.EmployeeNotFoundException;
import com.ts.employee.api.models.ErrorResponse;
@ControllerAdvice
public class EmployeeControllerAdvice {
	
	@ResponseBody
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
	ErrorResponse empNotFoundExceptionHandler(EmployeeNotFoundException ex) {
        return new ErrorResponse("error", ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(EmployeeAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    ErrorResponse employeeAlreadyExistsExceptionHandler(EmployeeAlreadyExistsException ex) {
        return new ErrorResponse("error", ex.getMessage());
    }

}
