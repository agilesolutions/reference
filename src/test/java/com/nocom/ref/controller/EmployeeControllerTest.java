package com.nocom.ref.controller;

import com.nocom.ref.repository.EmployeePredicateRepository;
import com.nocom.ref.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {
    private static final String BASE_URL = "/api/v1/employee";

    private static MockMvc mockMvc;

    @Mock
    EmployeePredicateRepository employeeRepository;

    @Mock
    EmployeeService employeeService;

    @InjectMocks
    EmployeeController employeeController;

    @Before
    public void init() {

        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();

    }

    @Test
    public void test_find_adult_mail() throws Exception {

        ResultActions resultActions = mockMvc.perform(get(BASE_URL + "/employees")).andExpect(status().isOk());

        resultActions.andExpect(jsonPath("$.[0].age").value("23"));

    }

}
