package com.cyoworld.service;

import com.cyoworld.entity.SettingMenu;
import com.cyoworld.repository.SettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SettingService {

    private final SettingRepository settingRepository;

    public SettingMenu findSettingMenuByUserId(String userId){
        SettingMenu settingMenu = settingRepository.findByUserId(userId);
        return settingMenu;
    }
}
