package com.motionlab.employeeservice.domain;

import javax.validation.constraints.NotBlank;

public record Employee(
        @NotBlank(message = "The first name must be provided")
        String firstName,
        @NotBlank(message = "The last name must be provided")
        String lastName,
        @NotBlank(message = "The national id must be provided")
        String nationalId) {
}
