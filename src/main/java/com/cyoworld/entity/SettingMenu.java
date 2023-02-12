package com.cyoworld.entity;

import com.cyoworld.constant.SettingStatus;
import com.cyoworld.dto.SettingManageMenuDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "userSettingTab")
@Getter
@Setter
public class SettingMenu {

    @OneToOne(fetch = FetchType.LAZY) // 일대일매핑
    @JoinColumn(name = "userCode")
    private Member member;

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

    public static SettingMenu createSettingMenu(Member member){
        SettingMenu settingMenu = new SettingMenu();
        settingMenu.setMember(member);
        settingMenu.setAlbumPhoto(SettingStatus.ON);
        settingMenu.setAlbumVideo(SettingStatus.ON);
        settingMenu.setBoard(SettingStatus.ON);
        settingMenu.setDiary(SettingStatus.ON);
        settingMenu.setGuestbook(SettingStatus.ON);
        settingMenu.setBookmark(SettingStatus.ON);
        return settingMenu;
    }

    public void updateSettingMenu(SettingManageMenuDto smmd){
        this.albumPhoto = smmd.getAlbumPhoto();
        this.albumVideo = smmd.getAlbumVideo();
        this.board = smmd.getBoard();
        this.diary = smmd.getDiary();
        this.guestbook = smmd.getGuestbook();
        this.bookmark = smmd.getBookmark();
    }
}
