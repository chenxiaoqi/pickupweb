package com.lazyman.pickupweb.test.study;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author c00286900
 * @version [版本号, 2018/10/31]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class DisposeOrderTest
{
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-test.xml");

        context.getBean("service");
        context.getBean("bean");

        context.close();
    }
}
