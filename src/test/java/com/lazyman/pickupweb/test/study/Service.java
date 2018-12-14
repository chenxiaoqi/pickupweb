package com.lazyman.pickupweb.test.study;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author c00286900
 * @version [版本号, 2018/10/31]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Service implements DisposableBean,BeanNameAware
{

    private Bean bean;

    private String name;


    public void setBean(Bean bean)
    {
        this.bean = bean;
    }

    @Override
    public void destroy() throws Exception
    {
        System.out.printf("destroy service %s\n",name);
    }

    @Override
    public void setBeanName(String s)
    {
        this.name = s;
    }
}
