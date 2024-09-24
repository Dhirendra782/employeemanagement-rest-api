package com.employeemanagement.mapper;

import com.employeemanagement.dto.EmployeeDto;
import com.employeemanagement.model.Employee;

public class EmployeeMapper {


    //Convert Employee into EmployeeDto
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );

        return employeeDto;
    }

    //Convert EmployeeDto into Employee
    public static Employee mapToEntity(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
        return employee;
    }

}
