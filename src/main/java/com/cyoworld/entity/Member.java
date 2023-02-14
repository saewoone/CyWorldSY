package com.cyoworld.entity;

import com.cyoworld.constant.Gender;
import com.cyoworld.dto.MemberFormDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
public class Member {
    @Id
    @Column(name = "userCode")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String userId;

    private String password;

    private String name;

    //private String birthday;
    private int birthdayYear;
    private int birthdayMonth;
    private int birthdayDay;

    private String email;

    private String address;

    private Gender gender;

    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder){
        Member member = new Member();
        member.setUserId(memberFormDto.getUserId());
        String password = passwordEncoder.encode(memberFormDto.getPassword());
        member.setName(memberFormDto.getName());
        member.setBirthdayYear(memberFormDto.getBirthdayYear());
        member.setBirthdayMonth(memberFormDto.getBirthdayMonth());
        member.setBirthdayDay(memberFormDto.getBirthdayDay());
        member.setEmail(memberFormDto.getEmail());
        member.setAddress(memberFormDto.getAddress());
        member.setPassword(password);
        member.setGender(memberFormDto.getGender());
        return member;
    }

    //profileImg
    //homeImg
    
    //createMember할 때 new SettingMenu -> 기본값(전체 ON)으로 갖고있게

}
