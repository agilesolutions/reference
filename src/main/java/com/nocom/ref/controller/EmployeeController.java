package com.nocom.ref.controller;

import com.nocom.ref.dto.EmployeeDTO;
import com.nocom.ref.mapper.EmployeeMapper;
import com.nocom.ref.model.Employee;
import com.nocom.ref.problem.EmployeeNotFoundException;
import com.nocom.ref.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    private final EmployeeMapper employeeMapper;


    @PutMapping(value = "/save")
    public ResponseEntity<EmployeeDTO> save(@Valid @RequestBody EmployeeDTO employee) {
        return ResponseEntity.ok(employeeMapper.mapToDto(employeeService.save(employeeMapper.mapFromDto(employee))));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<EmployeeDTO>  getEmployee(@PathVariable("id") Long id) {

        return ResponseEntity.ok(employeeMapper.mapToDto(employeeService.findById(id)));
    }

    @GetMapping(value = "/employees")
    public ResponseEntity<List<EmployeeDTO>> findAdultMale() {
        return ResponseEntity.ok(employeeMapper.mapToDtos(employeeService.findAdultMale()));
    }

}
