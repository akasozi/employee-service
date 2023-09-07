package com.motionlab.employeeservice.domain;

import java.util.Optional;

public interface EmployeeRepository {

    Iterable<Employee> findAll();
    Optional<Employee> findByNationalId(String nationalId);
    boolean existsByNationalId(String nationalId);
    Employee save(Employee employee);
    void deleteByNationalId(String nationalId);
}
