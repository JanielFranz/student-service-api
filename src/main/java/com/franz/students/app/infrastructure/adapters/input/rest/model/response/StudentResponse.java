package com.franz.students.app.infrastructure.adapters.input.rest.model.response;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentResponse  {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String address;
    //new field in the response
    private String timeStamp;
}
