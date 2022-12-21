package com.study.springboot202210kangseok.service;

import com.study.springboot202210kangseok.web.dto.CMRespDto;
import com.study.springboot202210kangseok.web.dto.UserDto;
import com.study.springboot202210kangseok.web.exception.CustomTestException;
import com.sun.net.httpserver.Headers;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestController1 {


    //@RestController + String = plain/text
    @GetMapping("/api/test/user-dto/str") //handler 맵핑에  Method를 등록
    public String getUserDtoStr(){
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();

        return userDto.toString();
    }


//    @GetMapping("/api/test/user-dto/obj") //handler 맵핑에  Method를 등록
//    public UserDto getUserDtoObj(){ // UserDto = 객체(Object)  RestController + Object = Json
//        UserDto userDto = UserDto.builder()
//                .userId(100)
//                .username("abc")
//                .password("1234")
//                .build();
//
//        return userDto;
//    }
    @GetMapping("/api/test/user-dto/obj")
    //ResponseEntity<와일드카드 == ? > 를 주게되면 아무 바디를 써도 됨.
    public ResponseEntity<?> getUserDtoObj(){
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();
        //헤더에 보내는 방식
        HttpHeaders headers = new HttpHeaders();
        headers.set("UserDto",userDto.toString());
//        return new ResponseEntity<>(headers , HttpStatus.OK);
        return ResponseEntity.ok()
                .headers(headers)
                .body(userDto);

        //body에 보내는 방식.
//        return new ResponseEntity<UserDto>(userDto, null, 400); ==
//        return new ResponseEntity<UserDto>(userDto = 바디, HttpStatus.BAD_REQUEST);
        //제네릭<UserDto 가 위에 선언이 되어있으면 없어도 됨.>
//        return ResponseEntity.ok().body(""); //ok == HttpStaus
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userDto);

    }
    @GetMapping("/api/test/user-dto/cm")
    public ResponseEntity<?> getUserDto(){
        UserDto userDto = UserDto.builder()
                .username("trst")
                .password("1234")
                .build();

        return ResponseEntity.ok().body(new CMRespDto<>("test유저 정보 응답",null));
    }
    @PostMapping("/api/test/user")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto){


        if(userDto.getUsername().isBlank()){
            Map<String ,String > errorMap = new HashMap<>();
            errorMap.put("username", "아이디를 입력하세요.");

            throw new CustomTestException("유효성 검사실패", errorMap);
        }

        userDto.setUserId(200);
        return ResponseEntity.created(null)
                .body(new CMRespDto<>(userDto.getUserId() + "사용자 추가 성공!" , userDto));
    }
}
