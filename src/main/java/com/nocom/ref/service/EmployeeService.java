package com.nocom.ref.service;

import com.nocom.ref.model.Employee;
import com.nocom.ref.problem.EmployeeNotFoundException;
import com.nocom.ref.repository.EmployeePredicateRepository;
import com.nocom.ref.repository.EmployeeRepository;
import com.nocom.ref.specification.EmployeeSpecifications;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

import  static com.nocom.ref.specification.EmployeeSpecifications.*;


@AllArgsConstructor
@Service
public class EmployeeService {

    private EmployeePredicateRepository employeePredicateRepository;

    private EmployeeRepository employeeRepository;

    @PreAuthorize("@securityUtils.isManager()")
    public List<Employee> findAdultMale() {

        return employeePredicateRepository.findAdultMale();

    }

    public Employee findById(Long id) {

        return employeeRepository
                .findOne(Specification.where(getEmployeesById(id)))
                .orElseThrow(() -> new EmployeeNotFoundException(id));

    }


    public List<Employee> findByName(String name, Integer age) {

        List<Specification<Employee>> specs = new ArrayList<>();

        Optional.ofNullable(name)
                .filter(Predicate.not(Objects::isNull))
                .ifPresentOrElse(p -> specs.add(Specification.where(getEmployeesByName(name))),() -> specs.add(Specification.where(isEmpty())));

        specs.get(0).and(getEmployeesByAge(21));
        //Specification<Employee> spec = Specification.where(getEmployeesByName(name));

        return employeeRepository.findAll(specs.get(0));

    }


    public Employee save(Employee employee) {
        return employee;
    }
}
