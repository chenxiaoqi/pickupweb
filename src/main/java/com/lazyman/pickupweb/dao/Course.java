package com.lazyman.pickupweb.dao;

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
@Entity(name = "Course")
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 128)
    private String name;

    private float price;

    private int classes;

    @ManyToOne(targetEntity = Teacher.class,fetch = FetchType.LAZY)
    private Teacher teacher;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public float getPrice()
    {
        return price;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    public int getClasses()
    {
        return classes;
    }

    public void setClasses(int classes)
    {
        this.classes = classes;
    }

    public Teacher getTeacher()
    {
        return teacher;
    }

    public void setTeacher(Teacher teacher)
    {
        this.teacher = teacher;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        return id == course.id;
    }

    @Override
    public int hashCode()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", classes=" + classes +
                ", teacher=" + teacher +
                '}';
    }
}
