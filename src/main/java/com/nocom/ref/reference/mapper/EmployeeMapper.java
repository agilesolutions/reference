package com.nocom.ref.reference.mapper;

import com.nocom.ref.reference.dto.EmployeeDTO;
import com.nocom.ref.reference.model.Employee;

import java.util.Random;

public class EmployeeMapper implements ObjectMapper<Employee, EmployeeDTO> {

    @Override
    public EmployeeDTO mapToDto(Employee o) {
        return EmployeeDTO.Buider().age(o.getAge()).gender(o.getGender()).build();
    }

    @Override
    public Employee mapFromDto(EmployeeDTO d) {
        return Employee.builder().id(new Random().nextInt()).age(21).firstName("Rob").lastName("Whatever").build()
    }
}
