package com.motionlab.employeeservice.domain;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String nationalId) {
        super("The employee with nationalId: " + nationalId + " was not found!");
    }
}
