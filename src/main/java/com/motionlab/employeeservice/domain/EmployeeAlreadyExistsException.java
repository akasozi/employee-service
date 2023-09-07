package com.motionlab.employeeservice.domain;

public class EmployeeAlreadyExistsException extends RuntimeException {
    public EmployeeAlreadyExistsException(String nationalId) {
        super("An employee with nationalId " + nationalId + " already exists!");
    }
}
