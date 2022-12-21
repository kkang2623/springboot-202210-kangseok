package com.study.springboot202210kangseok.IocAndDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IocController {
    //Ioc 는 제어의 역전 개발자가 직접 뉴 해주지 않고 스프링이 어플리케이션이 실행이 되면 객체가 생성이 됨 //@Component 오버테이션을 달면 됨.
    //Ioc컨테이너 안의 @Component 오버테이션을 다 찾아서 new 객체를 자동으로 생성해줌.
    //UserServiceImpl은 @Component가 하나밖에 없어 싱글톤이 됨
    //@Autowired 는 Ioc 컨테이너에서 스캔을 하고 유저서비스객체 자료형을 자동으로 DI해준다.
    // 결론 : 프로그램에서 자동생성과 자동주입이 일어남.

    @Autowired //(required = false) //필수가 아니다.
    @Qualifier("usi3")
    private UserService userService;

    @ResponseBody
    @GetMapping("/ioc")
    public String iocTest(){
        userService.createUser();
        userService.getUser();
        userService.updateUser();
        userService.deleteUser();


        return null;
    }
}
