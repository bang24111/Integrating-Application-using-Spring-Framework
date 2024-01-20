package com.example.thith_iasf.service.impl;

import com.example.thith_iasf.dto.EmployeeDto;
import com.example.thith_iasf.entity.Employee;
import com.example.thith_iasf.mapper.EmployeeMapper;
import com.example.thith_iasf.repository.EmployeeRepository;
import com.example.thith_iasf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repository;
    @Autowired
    private EmployeeMapper mapper;

    @Override
    public List<EmployeeDto> gets(EmployeeDto criteria) {
        Pageable pageable = PageRequest.of(criteria.getPageNumber(), criteria.getPageSize());
        Page<Employee> employees = repository.findAll(pageable);

        return employees.getContent()
                .stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getById(Long id) {
        Optional<Employee> employee = repository.findById(id);
        return mapper.entityToDto(employee.get());
    }

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        Employee employee = mapper.dtoToEntity(employeeDto);
        if (Objects.isNull(employee)) {
            return null;
        } else {
            Employee returnEntity = repository.save(employee);
            return mapper.entityToDto(returnEntity);
        }
    }

    @Override
    public List<EmployeeDto> findEmployeesByName(String employeeName) {
        List<Employee> employees = repository.findEmployeesByName(employeeName);

        return employees.stream().map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteEmployee(Long id) {
        if (id == null) return false;
        repository.delete(Employee.builder().id(id).build());
        return true;
    }
}
