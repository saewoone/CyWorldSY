package com.cyoworld.repository;

import com.cyoworld.entity.SettingMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SettingRepository extends JpaRepository<SettingMenu, Long> {

    @Query("select s from SettingMenu s " +
            "where s.member.userId = :userId")
    SettingMenu findByUserId(String userId);
}
