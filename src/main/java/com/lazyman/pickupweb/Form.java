package com.lazyman.pickupweb;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Author chenxiaoqi on 2018/4/14.
 */
public class Form {

    @NotNull
    @Size(min = 6, max = 10)
    private String name;

    @Min(0)
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Form{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
