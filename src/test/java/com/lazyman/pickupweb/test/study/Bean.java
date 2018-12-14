package com.lazyman.pickupweb.test.study;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;

/**
 * Author chenxiaoqi on 2017/8/20.
 */
public class Bean implements BeanNameAware, DisposableBean
{

    private String name;

    @Override
    public void setBeanName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return "Bean{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void destroy() throws Exception
    {
        System.out.printf("destroy bean %s\n", name);
    }
}
