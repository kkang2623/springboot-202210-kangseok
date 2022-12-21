package com.study.springboot202210kangseok.IocAndDi.Student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component //상위 @Component  // 하위 @Controller @Service @Configuration @Repository
public class StudentServiceImpl implements StudentService {

    @Override
    public void printStudentInfo(Student student) {
        System.out.println("학번 : " + student.getStudentId());
        System.out.println("이름 : " + student.getStudentName());
    }
}
