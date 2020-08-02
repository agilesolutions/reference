package com.nocom.ref.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {

    @Id
    private Integer id;

    private String street;

    private String city;

    @ManyToOne
    @JoinColumn(name="employee_id", nullable=false)
    private Employee employee;
}
