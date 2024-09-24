package com.employeemanagement.service.impl;

import com.employeemanagement.dto.EmployeeDto;
import com.employeemanagement.exception.ResourceNotFoundException;
import com.employeemanagement.mapper.EmployeeMapper;
import com.employeemanagement.model.Employee;
import com.employeemanagement.repository.EmployeeRepository;
import com.employeemanagement.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;

    //build add employee rest api
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEntity(employeeDto);
        Employee saveEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(saveEmployee);
    }

    //get employee by id
    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employeeById = employeeRepository.findById(employeeId).orElseThrow(()->
                new ResourceNotFoundException("Employee is Not Exists with given id: ",employeeId));
        return EmployeeMapper.mapToEmployeeDto(employeeById);
    }

    //get all employee list
    @Override
    public List<EmployeeDto> getEmployeeList() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    //update employee
    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->
                new ResourceNotFoundException("Employee is Not Exists with given id: ",employeeId));
       employee.setFirstName(updateEmployee.getFirstName());
       employee.setLastName(updateEmployee.getLastName());
       employee.setEmail(updateEmployee.getEmail());

       Employee saveEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(saveEmployee);
    }

    //delete employee
    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->
                new ResourceNotFoundException("Employee is not Exists with given id: ",employeeId));
        employeeRepository.deleteById(employeeId);

    }

}
