package com.nocom.ref.mapper;

import com.nocom.ref.dto.EmployeeDTO;
import com.nocom.ref.model.Employee;
import static com.nocom.ref.repository.EmployeeRepository.getMaxId;

import java.util.Random;

public class EmployeeMapper implements ObjectMapper<Employee, EmployeeDTO> {

    @Override
    public EmployeeDTO mapToDto(Employee o) {
        return EmployeeDTO.builder()


                .age(o.getAge()).gender(o.getGender()).build();
    }

    @Override
    public Employee mapFromDto(EmployeeDTO d) {
        return Employee.builder().id(getMaxId()).age(21).firstName("Rob").lastName("Whatever").build();
    }
}
