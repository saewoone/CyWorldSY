package com.cyoworld.dto;

import com.cyoworld.constant.Gender;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class MemberFormDto {

    @NotBlank(message = "아이디를 입력해주세요.")
    private String userId;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Length(min = 6, max = 16, message = "비밀번호는 6자 이상, 16자 이하로 입력해주세요.")
    private String password;

    @NotBlank(message = "비밀번호 확인을 위해 한 번 더 입력해주세요.")
    private String passwordCheck;

    @NotBlank(message = "이름을 입력해주세요.")
    private String name;

    //private String birthday;

    @NotNull(message = "연도를 입력해주세요.")
    private int birthdayYear;
    @NotNull(message = "월을 입력해주세요.")
    private int birthdayMonth;
    @NotNull(message = "일을 입력해주세요.")
    private int birthdayDay;

    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "이메일 형식이 아닙니다.")
    private String email;

    @NotBlank(message = "주소를 입력해주세요.")
    private String address;

    @NotNull(message = "성별을 골라주세요.")
    private Gender gender;

    @NotNull(message = "약관에 동의해주세요.")
    private boolean agree = false;
}
