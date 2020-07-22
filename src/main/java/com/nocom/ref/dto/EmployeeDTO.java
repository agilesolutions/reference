package com.nocom.ref.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@Builder
public class EmployeeDTO {

    @NotNull
    private Integer age;

    @NotEmpty(message = "Gender is mandatory")
    private String gender;

    @Schema(example = "Rob", required = true)
    @NotEmpty(message = "First name is mandatory")
    private String firstName;

    @Schema(example = "Whatever", required = true)
    @NotEmpty(message = "Last name is mandatory")
    private String lastName;


}
