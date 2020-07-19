package com.nocom.ref.mapper;

import com.nocom.ref.dto.EmployeeDTO;
import com.nocom.ref.model.Employee;
import static com.nocom.ref.repository.EmployeeRepository.getNextId;

public class EmployeeMapper implements ObjectMapper<Employee, EmployeeDTO> {

    @Override
    public EmployeeDTO mapToDto(Employee o) {
        return EmployeeDTO.builder()


                .age(o.getAge()).gender(o.getGender()).build();
    }

    @Override
    public Employee mapFromDto(EmployeeDTO d) {
        return Employee.builder().id(getNextId()).age(21).firstName("Rob").lastName("Whatever").build();
    }
}
