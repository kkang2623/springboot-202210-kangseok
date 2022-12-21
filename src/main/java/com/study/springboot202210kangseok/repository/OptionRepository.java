package com.study.springboot202210kangseok.repository;

import com.study.springboot202210kangseok.web.dto.CategoryDto;
import com.study.springboot202210kangseok.web.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //xml 구현해줌
public interface OptionRepository {
    public int saveCategory(CategoryDto categoryDto);
    public List<CategoryDto> getCategories();
    public int modifyCategory(CategoryDto categoryDto);
}