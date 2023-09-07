package com.motionlab.employeeservice;

import com.motionlab.employeeservice.domain.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EmployeeServiceApplicationTests {

	private static Validator validator;

	@BeforeAll
	static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	void whenAllFieldsCorrectThenValidationSucceeds() {
		var employee = new Employee("Abu", "Bizibu", "24964562");
		Set<ConstraintViolation<Employee>> violations = validator.validate(employee);
		assertThat(violations).isEmpty();
	}

}
