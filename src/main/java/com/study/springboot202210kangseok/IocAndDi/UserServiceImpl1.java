package com.study.springboot202210kangseok.IocAndDi;

public class UserServiceImpl1 implements UserService {

    //싱글톤 만들기
    private static UserServiceImpl1 instance = null;
    private UserServiceImpl1(){}
    public static UserServiceImpl1 getInstance(){
        if(instance==null){
            instance = new UserServiceImpl1();
        }
        return instance;
        //싱글톤 끝
    }



    @Override
    public void createUser() {
        System.out.println("사용자 등록");
    }

    @Override
    public void getUser() {
        System.out.println("사용자 조회");

    }

    @Override
    public void updateUser() {
        System.out.println("사용자 수정");

    }

    @Override
    public void deleteUser() {
        System.out.println("사용자 삭제");

    }
}
