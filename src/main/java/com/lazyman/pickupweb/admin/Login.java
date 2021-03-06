package com.lazyman.pickupweb.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Author chenxiaoqi on 2017/7/2.
 */
@Controller
@RequestMapping("/login")
public class Login
{

    private static Logger LOG = LoggerFactory.getLogger(Login.class);

    @Autowired
    private ServletContext context;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(produces = {"application/json"})
    @ResponseBody
    public Map<String, String> login(
            @RequestParam String name,
            @RequestParam String password)
    {
        boolean success = jdbcTemplate.query("SELECT * FROM user WHERE name=? and password=?", ResultSet::next, name, password);

        Map<String, String> map = new HashMap<>();
        if (success)
        {
            map.put("name", name);
            map.put("password", password);
        }
        else
        {
            map.put("error","name or password miss match.");
        }
        return map;
    }
}
