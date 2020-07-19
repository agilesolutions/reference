package com.nocom.ref.reference.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDTO {

    private Integer age;
    private String gender;
    private String firstName;
    private String lastName;

}
