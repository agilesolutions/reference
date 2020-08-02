package com.nocom.ref.service;

import com.nocom.ref.model.Employee;
import com.nocom.ref.repository.EmployeePredicateRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @Mock
    EmployeePredicateRepository employeeRepository;

    @InjectMocks
    EmployeeService employeeService;

    @Before
    public void init() {

        Employee employee = Employee.builder().id(1).age(23).gender("M").firstName("Rong").lastName("Whatever").build();

        lenient().when(employeeRepository.findAdultMale()).thenReturn(Collections.singletonList(employee));

    }

    @Test
    public void test_find_adult_mail() {

        List<Employee> employees = employeeService.findAdultMale();

        assertNotNull(employees);
        assertTrue(employees.size() == 1);
        Mockito.verify(employeeRepository,Mockito.times(1)).findAdultMale();

    }



}
