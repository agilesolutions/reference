package com.nocom.ref.service;

import com.nocom.ref.model.Employee;
import com.nocom.ref.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @PreAuthorize("@securityUtils.isManager()")
    public List<Employee> findAdultMale() {



        return employeeRepository.findAdultMale();

    }

    public Employee save(Employee employee) {
        return employee;
    }
}
