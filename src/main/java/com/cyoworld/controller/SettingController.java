package com.cyoworld.controller;

import com.cyoworld.dto.SettingManageMenuDto;
import com.cyoworld.entity.Member;
import com.cyoworld.entity.SettingMenu;
import com.cyoworld.service.SettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/setting")
public class SettingController {
    private final SettingService settingService;

    @GetMapping(value = "")
    public String settingBoard(Model model, Principal principal){
//        SettingMenu settingMenu = settingService.findSettingMenuByUserId(principal.getName());
//
//        SettingManageMenuDto smmd = new SettingManageMenuDto();
//        smmd.setId(settingMenu.getId());
//        smmd.setAlbumPhoto(settingMenu.getAlbumPhoto());
//        smmd.setAlbumVideo(settingMenu.getAlbumVideo());
//        smmd.setBoard(settingMenu.getBoard());
//        smmd.setDiary(settingMenu.getDiary());
//        smmd.setGuestbook(settingMenu.getGuestbook());
//        smmd.setBookmark(settingMenu.getBookmark());
//
//        model.addAttribute("settingManageMenuDto", smmd);

        model.addAttribute("settingManageMenuDto", new SettingManageMenuDto());
        return "setting/settings";
    }
}
