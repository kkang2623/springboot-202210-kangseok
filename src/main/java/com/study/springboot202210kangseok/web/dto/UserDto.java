package com.study.springboot202210kangseok.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

// *필수
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private int userId;

    @Pattern(regexp = "^[a-zA-Z0-9]{5,20}$" , message = "사용자이름은 영문,숫자 조합이어야하며 5자 이상 20자 이하로 작성하세요")
    private String username;
                    //(?= a) a가 포함되어야만 쓸 수 있다.      //bbbbba 긍정형 전방탐색(?=) a전까지 다 슬 수 있다
                    //(?! a) a가 불포함되어야만 쓸 수 있다.    //bbbbba 부정형 전밭탐색(?!) a가 발견된 것 전까지 쓸 수 없다
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*])[a-zA-Z0-9~!@#$%^&*]{8,16}$"
    ,message = "비밀번호는 영문, 숫자, 특수문자(~!@#$%^&*)를 포함하여 8~16자로 작성하세요")
    // 소문자 a-대문자 Z까지 하나 + 숫자 + 특수기호 +  8자이상 16자 이하로 설정을 하고
    private String password;

    @Pattern(regexp = "^[가-힣]{2,5}$" , message = "이름은 한글만 작성 가능하며 최대 5자 이하만 입력가능합니다")
    private String name;

    @NotBlank(message = "이메일을 입력해주세요")
    @Email
    private String email;
}
