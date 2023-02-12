package com.cyoworld.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class GuestbookController {

    @GetMapping(value = "/guestbook")
    public String guestbookBoard(){

        return "guestbook/guestbookBoard";
    }
}
