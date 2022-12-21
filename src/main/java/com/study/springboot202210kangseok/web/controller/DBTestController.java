package com.study.springboot202210kangseok.web.controller;

import com.study.springboot202210kangseok.service.UserService;
import com.study.springboot202210kangseok.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
// @ResponseBody 를 달면 text/plain '데이터'응답을 한다.
//특징 : 일반 @Controller은 응답을 할 때 html로 응답하지만 @RestController는 바디를 달지 않아도 데이터만 응답한다.

@RequestMapping("/api/db/test")
//이 클래스 안에 들어있는 모든 메소드들의 주소를 중복시켜준다.
// ex) /api/db/test 기본적으로 들어가서 중복으로 안 써도 된다.
public class DBTestController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto){
        //<?> = 와일드카드를 쓴 이유는 다양한 클래스가 오기 떄문이다.
        //@RequestBody 제이슨이면 무조건 달기 요청상태는 무조건 제이슨형태로 와야한다.
        System.out.println(userDto);
        int userId = userService.addUser(userDto);
//        return new ResponseEntity<>("응답할 데이터", HttpStatus.CREATED);
        //ResponseEntity 객체로 리턴을 해야한다. BAD_REQUEST를 쓰면 상태코드가 400번이 된다.
        //유저서비스에 있는 애드유저에 전달 -> Dto를 유저레파짓토리에 준다
        return ResponseEntity.created(URI.create("/api/db/test/user" + userId)).body(userDto);
//      빌더형식 스태틱메소드에서 바로 리스폰스엔티티를 쓸 수 있다.
    }

    @GetMapping("/user/{userId}") //{userId} @PathVariable userId으 값이 들어가서 출력해줌
    public ResponseEntity<?> getUser(@PathVariable int userId){
        UserDto userDto = userService.getUser(userId);
        return ResponseEntity.ok().body(userDto);
    }

}
