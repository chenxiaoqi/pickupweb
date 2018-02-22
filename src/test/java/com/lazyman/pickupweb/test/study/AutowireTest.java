package com.lazyman.pickupweb.test.study;

import com.lazyman.pickupweb.course.Student;
import com.lazyman.pickupweb.course.StudentDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

/**
 * Author chenxiaoqi on 2017/8/20.
 */
@ContextConfiguration(
        value = {"/applicationContext-test.xml"})
@RunWith(SpringRunner.class)
public class AutowireTest {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private StudentDao studentDao;

    @Test
    public void test()
    {
        AutowireCapableBeanFactory beanFactory = context.getAutowireCapableBeanFactory();
        Bean bean = new Bean();

        beanFactory.initializeBean(bean,"hoho");

        Assert.assertEquals("hoho",bean.getName());

        Student stu = new Student();
        stu.setEmail("fake@gmail.com");
        when(studentDao.get(anyInt())).thenReturn(stu);

        System.out.println(studentDao.get(1));

        verify(studentDao).get(2);

    }

}
