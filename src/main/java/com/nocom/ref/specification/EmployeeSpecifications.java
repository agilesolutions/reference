package com.nocom.ref.specification;

import com.nocom.ref.model.Employee;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class EmployeeSpecifications {

    /**
     * where firstName = @id
     * @param id
     * @return
     */
    public static Specification<Employee> getEmployeesById(Long id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    /**
     * where firstName = @name
     * @param name
     * @return
     */
    public static Specification<Employee> getEmployeesByName(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("firstName"), name);
    }

    /**
     * where age = @age
     * @param age
     * @return
     */
    public static Specification<Employee> getEmployeesByAge(Integer age) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("age"), age);
    }

    /**
     * I like to add this because without it if no criteria is specified then
     * everything is returned. Because that's how queries work without where
     * clauses. However, if my user doesn't provide any criteria I want to
     * say no results found.
     **/
    public static Specification<Employee> isEmpty() {

        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), -1);
    }
}
