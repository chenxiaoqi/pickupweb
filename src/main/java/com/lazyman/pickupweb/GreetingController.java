package com.lazyman.pickupweb;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Author chenxiaoqi on 2017/6/16.
 */
@Controller
public class GreetingController {

    @RequestMapping(value = "/greeting.action", method = RequestMethod.GET)
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "/greeting.jsp";
    }

    @GetMapping("/redirect")
    public ResponseEntity<String> redirect() throws URISyntaxException {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(new URI("http://www.baidu.com"));
        return new ResponseEntity<>(null, headers, HttpStatus.FOUND);
    }

}
