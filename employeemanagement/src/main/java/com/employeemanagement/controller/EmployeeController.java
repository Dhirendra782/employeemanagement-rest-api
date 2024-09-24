package com.employeemanagement.controller;

import com.employeemanagement.dto.EmployeeDto;
import com.employeemanagement.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto saveEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }

    //build get all employee list rest api
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployeeList() {
        List<EmployeeDto> getList = employeeService.getEmployeeList();
        return new ResponseEntity<>(getList,HttpStatus.OK);
    }

    //build get employee id rest api
    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long employeeId) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }

    //build update employee rest api
    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long employeeId,
                                                      @RequestBody EmployeeDto updateEmployee) {
        EmployeeDto update = employeeService.updateEmployee(employeeId,updateEmployee);

        return new ResponseEntity<>(update,HttpStatus.OK);
    }

    //build delete employee rest api
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>("Employee Deleted Successfully",HttpStatus.OK);

    }

}
