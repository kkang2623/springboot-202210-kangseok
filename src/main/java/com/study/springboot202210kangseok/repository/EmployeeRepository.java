package com.study.springboot202210kangseok.repository;

import com.study.springboot202210kangseok.web.dto.EmployeeDto;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface EmployeeRepository {
    public int saveEmployee(EmployeeDto employeeDto);
}