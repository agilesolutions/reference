package com.nocom.ref.service;

import com.nocom.ref.dto.AdvancedSearchDTO;
import com.nocom.ref.model.Employee;
import com.nocom.ref.problem.EmployeeNotFoundException;
import com.nocom.ref.repository.EmployeePredicateRepository;
import com.nocom.ref.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.nocom.ref.specification.EmployeeSpecifications.*;


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


    public List<Employee> findByName(AdvancedSearchDTO dto) {

        // this is what you should do as first step at CS
        Optional<Specification<Employee>> spec = Optional.empty();

        // this is what you should do every intermediate argument at CS
        Optional.ofNullable(dto.getName())
                .ifPresent(p -> { spec.ifPresentOrElse(s -> spec.get().and(getEmployeesByName(p)),() -> spec.of(Specification.where(getEmployeesByName(dto.getName()))));  });

        // this is what you should do every intermediate argument at CS
        Optional.ofNullable(dto.getAge())
                .ifPresent(p -> { spec.ifPresentOrElse(s -> spec.get().and(getEmployeesByAge(p)),() -> spec.of(Specification.where(getEmployeesByAge(dto.getAge()))));  });

        // this is what you should do every intermediate argument at CS
        Optional.ofNullable(dto.getStreet()).filter()
                .ifPresent(p -> { spec.ifPresentOrElse(s -> spec.get().and(getEmployeesByStreet(p)),() -> spec.of(Specification.where(getEmployeesByStreet(dto.getStreet()))));  });


        // this is what you should do as final step at CS
        Specification<Employee>finalSpec = spec.orElse(Specification.not(isEmpty()));

        return employeeRepository.findAll(finalSpec);

    }




    public Employee save(Employee employee) {
        return employee;
    }
}
