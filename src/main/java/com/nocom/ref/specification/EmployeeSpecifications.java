package com.nocom.ref.specification;

import com.nocom.ref.model.Employee;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class EmployeeSpecifications {

    public static Specification<Employee> getEmployeesByName(String name) {
        return new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder criteriaBuilder) {
                Predicate equalPredicate = criteriaBuilder.equal(root.get("firstName"), name);
                return equalPredicate;
            }
        };
    }

    public static Specification<Employee> getEmployeesByAge(Integer age) {
        return new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder criteriaBuilder) {
                Predicate equalPredicate = criteriaBuilder.equal(root.get("age"), name);
                return equalPredicate;
            }
        };
    }

    /**
     * I like to add this because without it if no criteria is specified then
     * everything is returned. Because that's how queries work without where
     * clauses. However, if my user doesn't provide any criteria I want to
     * say no results found.
     **/
    public static Specification<Employee> isEmpty() {
        return new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder criteriaBuilder) {
                Predicate equalPredicate = criteriaBuilder.equal(root.get("id"), -1);
                return equalPredicate;
            }

        };
    }
}
