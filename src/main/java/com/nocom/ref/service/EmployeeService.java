package com.nocom.ref.service;

import com.nocom.ref.model.Employee;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class EmployeeService {

    private EmployeeService employeeService;

    @PreAuthorize("@securityUtils.isManager()")
    public List<Employee> findAdultMale() {



        return employeeService.findAdultMale();

    }
}
