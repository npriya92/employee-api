package com.ts.employee.api.exception;

public class EmployeeAlreadyExistsException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeAlreadyExistsException(Long empid) {
        super("employee already exists for empid: '" + empid + "'");
    }
}
