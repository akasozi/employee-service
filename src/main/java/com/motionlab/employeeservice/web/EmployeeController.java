package com.motionlab.employeeservice.web;

import com.motionlab.employeeservice.domain.Employee;
import com.motionlab.employeeservice.domain.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public Iterable<Employee> get() {
        return employeeService.viewEmployeeList();
    }

    @GetMapping("/{nationalId}")
    public Employee getByNationalId(@PathVariable String nationalId) {
       return employeeService.viewEmployeeDetails(nationalId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee post(@Valid @RequestBody Employee employee) {
        return employeeService.addNewEmployee(employee);
    }

    @PutMapping("/{nationalId}")
    public Employee put(@PathVariable String nationalId, @Valid @RequestBody Employee employee) {
        return employeeService.updateEmployeeDetails(nationalId, employee);
    }

    @DeleteMapping("{nationalId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String nationalId) {
        employeeService.removeEmployee(nationalId);
    }


}
