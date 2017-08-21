package com.lazyman.pickupweb.test.study;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author chenxiaoqi on 2017/8/20.
 */
@ContextConfiguration(
        value = {"/applicationContext-test.xml"})
@RunWith(SpringRunner.class)
public class AutowireTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void test()
    {
        AutowireCapableBeanFactory beanFactory = context.getAutowireCapableBeanFactory();
        Bean bean = new Bean();

        beanFactory.initializeBean(bean,"hoho");

        Assert.assertEquals("hoho",bean.getName());
    }

}
