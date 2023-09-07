package com.motionlab.employeeservice.persistence;

import com.motionlab.employeeservice.domain.Employee;
import com.motionlab.employeeservice.domain.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryEmployeeRepository implements EmployeeRepository {

    private static final Map<String, Employee> employees = new ConcurrentHashMap<>();

    @Override
    public Iterable<Employee> findAll() {
        return employees.values();
    }

    @Override
    public Optional<Employee> findByNationalId(String nationalId) {
        return existsByNationalId(nationalId) ? Optional.of(employees.get(nationalId)) : Optional.empty();
    }

    @Override
    public boolean existsByNationalId(String nationalId) {
        return employees.get(nationalId) != null;
    }

    @Override
    public Employee save(Employee employee) {
        employees.put(employee.nationalId(), employee);
        return employee;
    }

    @Override
    public void deleteByNationalId(String nationalId) {
         employees.remove(nationalId);
    }
}
