package com.study.springboot202210kangseok.IocAndDi.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    //수동으로 Bean에 등록가능
    //@Component 에는 1개만 등록이 가능하지만 @Configuration 에는 빈 2개이상 등록가능

    @Bean
    public Test1 t1() {
        return new Test1();
    }

    @Bean
    public Test2 t2() {
        return new Test2();
    }

}
