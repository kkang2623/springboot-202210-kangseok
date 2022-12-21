package com.study.springboot202210kangseok.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// *필수
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private int userId;
    private String username;
    private String password;
    private String name;
    private String email;
}
