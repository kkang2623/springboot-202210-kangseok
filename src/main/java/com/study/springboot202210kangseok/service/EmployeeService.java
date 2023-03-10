package com.study.springboot202210kangseok.service;

import com.study.springboot202210kangseok.repository.EmployeeRepository;
import com.study.springboot202210kangseok.web.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public int addEmployee(EmployeeDto employeeDto) {
        return employeeRepository.saveEmployee(employeeDto) > 0 ? employeeDto.getEmpId() : 0;
    }

}