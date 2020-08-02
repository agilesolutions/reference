package com.nocom.ref.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {


    @Id
    private Integer id;
    private Integer age;
    private String gender;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy="employee")
    private Set<Address> addresses;

}