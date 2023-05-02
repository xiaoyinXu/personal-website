package com.xxywebsite.web.controller;

import com.xxywebsite.web.dto.LoginDto;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xuxiaoyin
 * @since 2023/3/8
 **/
@RestController
@RequestMapping("/home")
public class HomeController {
    @GetMapping("/content")
    public String content() {
        return "home";
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginDto loginDto, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String originUrl = request.getHeader("Origin");
        response.setStatus(401);
        response.addCookie(new Cookie("user-session", loginDto.getUsername()));
        response.setHeader("location", originUrl);
    }
}
