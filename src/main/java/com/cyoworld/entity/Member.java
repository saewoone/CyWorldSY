package com.cyoworld.entity;

import com.cyoworld.constant.Gender;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    private String birthday;
    private int birthdayYear;
    private int birthdayMonth;
    private int birthdayDay;

    private String email;

    private String address;

    private Gender gender;

    //profileImg
    //homeImg
    
    //createMember할 때 new SettingMenu -> 기본값(전체 ON)으로 갖고있게

}
