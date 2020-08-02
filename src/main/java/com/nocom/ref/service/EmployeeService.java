package com.nocom.ref.service;

import com.nocom.ref.model.Employee;
import com.nocom.ref.repository.EmployeePredicateRepository;
import com.nocom.ref.repository.EmployeeRepository;
import com.nocom.ref.specification.EmployeeSpecifications;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class EmployeeService {

    private EmployeePredicateRepository employeePredicateRepository;

    private EmployeeRepository employeeRepository;

    @PreAuthorize("@securityUtils.isManager()")
    public List<Employee> findAdultMale() {

        return employeePredicateRepository.findAdultMale();

    }

    public Employee findById(Integer id) {

        return employeePredicateRepository.findById(id);

    }


    public List<Employee> findByName(String name) {

        return employeeRepository.findAll(Specification.where(EmployeeSpecifications.getEmployeesByNameSpec(name)));

    }


    public Employee save(Employee employee) {
        return employee;
    }
}
