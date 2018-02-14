package com.lazyman.pickupweb.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import javax.sql.DataSource;

@WebAppConfiguration
@ContextConfiguration(
        value = {"/applicationContext.xml", "file:src/main/webapp/WEB-INF/pickup-web-servlet.xml"})
@RunWith(SpringRunner.class)
@Sql(statements = {
        "delete from StudentCourseRecord",
        "delete from CourseSchedule",
        "delete from Course",
        "delete from Teacher",
        "delete from Student",
}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public abstract class SpringTest
{
    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    protected DataSource dataSource;

}
