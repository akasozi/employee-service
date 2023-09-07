package com.motionlab.employeeservice.domain;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Iterable<Employee> viewEmployeeList() {
        return employeeRepository.findAll();
    }

    public Employee viewEmployeeDetails(String nationalId) {
        return employeeRepository.findByNationalId(nationalId)
                .orElseThrow(() -> new EmployeeNotFoundException(nationalId));
    }

    public Employee addNewEmployee(Employee employee) {
        if (employeeRepository.existsByNationalId(employee.nationalId())) {
            throw new EmployeeAlreadyExistsException(employee.nationalId());
        }
        return employeeRepository.save(employee);
    }

    public void removeEmployee(String nationalId) {
        employeeRepository.deleteByNationalId(nationalId);
    }

    public Employee updateEmployeeDetails(String nationalId, Employee employee) {
        return employeeRepository.findByNationalId(nationalId)
                .map(existingEmployee -> {
                    var employeeToUpdate = new Employee(
                            employee.firstName(),
                            employee.lastName(),
                            existingEmployee.nationalId()
                    );
                    return employeeRepository.save(employeeToUpdate);
                })
                .orElseGet(() -> addNewEmployee(employee));
    }

}
