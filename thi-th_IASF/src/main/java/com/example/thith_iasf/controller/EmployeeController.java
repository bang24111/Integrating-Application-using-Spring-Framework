package com.example.thith_iasf.controller;

import com.example.thith_iasf.dto.EmployeeDto;
import com.example.thith_iasf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class EmployeeController {

    private static final int PAGE_SIZE = 20;
    private static final int PAGE_NUMBER = 0;
    @Autowired
    private EmployeeService service;

    //View
    @GetMapping(value = "/employees")
    public ModelAndView gets(@RequestParam(value = "employeeName", required = false) String employeeName,
                             HttpServletRequest request) {
        EmployeeDto criteria = new EmployeeDto();
        criteria.setPageSize(PAGE_SIZE);
        criteria.setPageNumber(PAGE_NUMBER);
        ModelAndView view = new ModelAndView("employee/list");
        List<EmployeeDto> employees = new ArrayList<EmployeeDto>();
        if (employeeName == null || employeeName.trim().isEmpty()) {
            employees = service.gets(criteria);
        } else  {
            employees = service.findEmployeesByName(employeeName);
        }
        view.addObject("employees", employees);
        return view;
    }

    @GetMapping(value = "/employee/detail")
    public ModelAndView detail(@RequestParam(required = false) Long id, HttpServletRequest request) {
        EmployeeDto employeeDto = new EmployeeDto();
        if (id != null) {
            employeeDto = service.getById(id);
        }
        ModelAndView view = new ModelAndView("employee/detail");
        view.addObject("employee", employeeDto);
        return view;
    }

    @GetMapping(value = "/employee/form")
    public ModelAndView form(@RequestParam(required = false) Long id, HttpServletRequest request) {
        EmployeeDto employeeDto = new EmployeeDto();
        if (id != null) {
            employeeDto = service.getById(id);
        }
        ModelAndView view = new ModelAndView("employee/form");
        view.addObject("employee", employeeDto);
        return view;
    }

    @PostMapping(value = "/employee/save")
    public ModelAndView save(@ModelAttribute() EmployeeDto employeeDto, HttpServletRequest request) {
        EmployeeDto employee = service.save(employeeDto);
        if (Objects.isNull(employee)) {
            return null;
        }
        return new ModelAndView("redirect:/employees");
    }

    @GetMapping(value = "/employee/delete")
    public ModelAndView delete(@RequestParam() Long id, HttpServletRequest request) {
        Boolean employee = service.deleteEmployee(id);
        if (!employee) {
            return null;
        }
        return new ModelAndView("redirect:/employees");
    }

}
