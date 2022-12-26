package com.study.springboot202210kangseok.repository;

import com.study.springboot202210kangseok.web.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper //xml 구현해줌
public interface UserRepository {
    public int saveUser(UserDto userDto);
    public UserDto findUserByUserId(int userId);
    public UserDto findUserByUsername(String username);
}
