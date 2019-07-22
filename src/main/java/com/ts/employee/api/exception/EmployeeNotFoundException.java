package com.ts.employee.api.exception;

public class EmployeeNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1648033371767370283L;

	public EmployeeNotFoundException(Long empid) {
        super("could not find employee with empid: '" + empid + "'");
    }
}
