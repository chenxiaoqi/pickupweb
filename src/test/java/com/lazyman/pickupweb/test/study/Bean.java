package com.lazyman.pickupweb.test.study;

import org.springframework.beans.factory.BeanNameAware;

/**
 * Author chenxiaoqi on 2017/8/20.
 */
public class Bean implements BeanNameAware {

    private String name;

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "name='" + name + '\'' +
                '}';
    }
}
