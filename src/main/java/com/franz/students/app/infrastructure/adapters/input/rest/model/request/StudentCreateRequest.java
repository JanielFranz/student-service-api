package com.franz.students.app.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class StudentCreateRequest {

    @NotBlank(message = "Field first name cannot be empty or null")
    private String firstName;

    @NotBlank(message="Field last name cannot be empty or null")
    private String lastName;

    @NotNull(message = "Field age cannot be empty or null")
    @Min(value = 1, message = "Field age must be greater than 0")
    private Integer age;

    private String address;
}
