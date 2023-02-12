package com.cyoworld.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class BookmarkController {

    @GetMapping(value = "/bookmark")
    public String bookmarkBoard(){

        return "bookmark/bookmarkBoard";
    }
}
