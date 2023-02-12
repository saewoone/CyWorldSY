package com.cyoworld.dto;

import com.cyoworld.constant.SettingStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
public class SettingManageMenuDto {

    @Id
    @Column(name = "userSettingCode")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private SettingStatus albumPhoto;

    private SettingStatus albumVideo;

    private SettingStatus board;

    private SettingStatus diary;

    private SettingStatus guestbook;

    private SettingStatus bookmark;
}
