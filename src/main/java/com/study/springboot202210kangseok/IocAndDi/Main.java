package com.study.springboot202210kangseok.IocAndDi;


public class Main {

    private final UserService userService;

    public Main(UserService userService) {
        this.userService = userService;
    }

    public void run() {
        userService.createUser();
        userService.getUser();
        userService.updateUser();
        userService.deleteUser();
    }

    public static void main(String[] args) { //static 개념이 스프링에서는 Ioc로 바뀜
        UserService userService = UserServiceImpl1.getInstance();

        Main main = new Main(userService); // Class Main create. //의존성 주입 // public Main = Main main
        main.run();
    }
}

