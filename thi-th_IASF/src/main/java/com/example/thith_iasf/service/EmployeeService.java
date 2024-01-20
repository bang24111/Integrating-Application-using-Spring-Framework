package com.example.thith_iasf.service;

import com.example.thith_iasf.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> gets(EmployeeDto criteria);
    EmployeeDto getById(Long id);
    EmployeeDto save(EmployeeDto employeeDto);

    List<EmployeeDto> findEmployeesByName(String employeeName);

    Boolean deleteEmployee(Long id);
}
