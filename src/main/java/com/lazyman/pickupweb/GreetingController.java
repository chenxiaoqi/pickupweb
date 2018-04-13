package com.lazyman.pickupweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.Size;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Author chenxiaoqi on 2017/6/16.
 */
@Controller
public class GreetingController {

    @Autowired
    private Validator validator;

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

    @GetMapping("/validation")
    @ResponseBody
    public String validation(Form form) {
        return validator.validate(form).toString();
    }

    @GetMapping("/validation2")
    @ResponseBody
    public String validation2(@Valid Form form, @Valid @Size(min = 3, max = 5) String password, BindingResult result) {
        return form.toString() + ":" + password + ":" + result;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handle(Exception e) {
        e.printStackTrace();
        return e.toString();
    }

}
