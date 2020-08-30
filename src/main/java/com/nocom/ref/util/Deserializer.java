package com.nocom.ref.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nocom.ref.model.Employee;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class Deserializer {

    ObjectMapper objectMapper = new ObjectMapper();

    Employee employee;

    {
        try {
            employee = objectMapper.readValue(new ClassPathResource(
                    "data/employees.json").getFile(), Employee.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
