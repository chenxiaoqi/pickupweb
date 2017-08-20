package com.lazyman.pickupweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Author chenxiaoqi on 2017/7/2.
 */
@Controller
@RequestMapping(path = "/login/login.action")
public class Login {

    @GetMapping
    public String loginPage(){
        return "/login/login";
    }

    @PostMapping
    public String login(@RequestParam String name, @RequestParam String password, Model model)
    {
        model.addAttribute("name",name);
        model.addAttribute("password",password);
        return "/login/success";
    }


}
