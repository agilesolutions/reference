package com.nocom.ref.controller;

import com.nocom.ref.dto.EmployeeDTO;
import com.nocom.ref.mapper.EmployeeMapper;
import com.nocom.ref.model.Employee;
import com.nocom.ref.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    private final EmployeeMapper employeeMapper;


    public ResponseEntity<EmployeeDTO> save(@Valid @RequestBody EmployeeDTO employee) {
        return ResponseEntity.ok(employeeMapper.mapToDto(employeeService.save(employeeMapper.mapFromDto(employee))));
    }
}
