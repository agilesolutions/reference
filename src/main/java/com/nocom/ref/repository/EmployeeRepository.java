package com.nocom.ref.repository;

import com.nocom.ref.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long>,
        JpaSpecificationExecutor<Employee> {
}