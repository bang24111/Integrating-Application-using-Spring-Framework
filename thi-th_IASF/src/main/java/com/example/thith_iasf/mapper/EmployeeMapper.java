package com.example.thith_iasf.mapper;

import com.example.thith_iasf.dto.EmployeeDto;
import com.example.thith_iasf.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee dtoToEntity(EmployeeDto employeeDto);
    EmployeeDto entityToDto(Employee employee);
}
