package com.lazyman.pickupweb.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import javax.sql.DataSource;

@WebAppConfiguration
@ContextConfiguration(
        value = {"/applicationContext.xml", "file:src/main/webapp/WEB-INF/pickup-web-servlet.xml"})
@RunWith(SpringRunner.class)
public class SpringTest
{
    @Autowired
    private WebApplicationContext applicationContext;

    @Autowired
    private DataSource dataSource;

}
