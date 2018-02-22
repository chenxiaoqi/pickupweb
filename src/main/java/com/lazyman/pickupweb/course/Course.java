package com.lazyman.pickupweb.course;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lazyman.pickupweb.NamedEntity;

import javax.persistence.*;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author c00286900
 * @version [版本号, 2017/7/19]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Entity(name = "course")
public class Course extends NamedEntity {
    private float price;

    private int classes;

    @ManyToOne(targetEntity = Teacher.class, fetch = FetchType.LAZY)
    private Teacher teacher;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getClasses() {
        return classes;
    }

    public void setClasses(int classes) {
        this.classes = classes;
    }

    @JsonIgnore
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

}
