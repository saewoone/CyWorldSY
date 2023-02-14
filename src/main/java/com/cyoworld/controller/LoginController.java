package com.cyoworld.controller;

import com.cyoworld.constant.Gender;
import com.cyoworld.dto.MemberFormDto;
import com.cyoworld.entity.Member;
import com.cyoworld.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;

    private final PasswordEncoder passwordEncoder;

    @GetMapping(value = "/login")
    public String loginPage(){

        return "member/login";
    }

    @GetMapping(value = "/login/error")
    public String loginError(Model model){
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");
        return "member/login";
    }

    @GetMapping(value = "/login/register")
    public String registerNewMember(Model model){
        MemberFormDto mfd = new MemberFormDto();
        mfd.setBirthdayYear(1900);
        mfd.setBirthdayMonth(1);
        mfd.setBirthdayDay(1);
        mfd.setGender(Gender.FEMALE);
        model.addAttribute("memberFormDto", mfd);
        return "member/register";
    }

    @PostMapping(value = "/login/register")
    public String registerMember(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "member/register";
        }
        if(!memberFormDto.getPassword().equals(memberFormDto.getPasswordCheck())){
            model.addAttribute("errorMessage", "비밀번호를 다시 확인해주세요.");
            return "member/register";
        }
        if(memberFormDto.isAgree() == false){
            model.addAttribute("errorMessage", "약관에 동의해주세요.");
            return "member/register";
        }

        try {
            Member member = Member.createMember(memberFormDto, passwordEncoder);
            memberService.saveMember(member);
        } catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "/member/register";
        }

        return "redirect:/login";
    }
}
