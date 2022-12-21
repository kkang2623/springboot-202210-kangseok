package com.study.springboot202210kangseok.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class CMRespDto<T> {
    private String message;
    private T data;
}
