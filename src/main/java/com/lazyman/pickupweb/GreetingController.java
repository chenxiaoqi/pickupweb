package com.lazyman.pickupweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by chenxiaoqi on 2017/6/16.
 */
@Controller
public class GreetingController {

    @RequestMapping(value = "/greeting.action",method = RequestMethod.GET)
    public String greeting(@RequestParam(value = "name",required = false,defaultValue = "World") String name, Model model){
        model.addAttribute("name",name);
        return "/greeting.jsp";
    }

}
