package com.xxywebsite.web.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuxiaoyin
 * @since 2023/3/8
 **/
@RestController
@RequestMapping("/home")
@CrossOrigin("https://vitejs.dev")
public class HomeController {
    @GetMapping("/content")
    public String content() {
        return "home";
    }
}
