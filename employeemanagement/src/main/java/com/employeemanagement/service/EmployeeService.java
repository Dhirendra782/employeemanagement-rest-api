package com.employeemanagement.service;

import com.employeemanagement.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    //create employee
    public EmployeeDto createEmployee(EmployeeDto employeeDto);

    //get employee by id
    public EmployeeDto getEmployeeById(Long employeeId);

    //get all employee list
    public List<EmployeeDto> getEmployeeList();

    //update employee
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee);

    //delete employee
    public void deleteEmployee(Long employeeId);
}
