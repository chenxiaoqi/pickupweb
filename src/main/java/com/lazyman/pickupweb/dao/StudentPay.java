package com.lazyman.pickupweb.dao;

import com.lazyman.pickupweb.model.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author c00286900
 * @version [版本号, 2017/7/27]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Entity(name = "studentPay")
public class StudentPay extends BaseEntity
{
    private Date date;

    private float fee;

    @ManyToOne(targetEntity = Student.class, optional = false)
    private Student student;

    @ManyToOne(targetEntity = Course.class, optional = false)
    private Course course;

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public float getFee()
    {
        return fee;
    }

    public void setFee(float fee)
    {
        this.fee = fee;
    }

    public Student getStudent()
    {
        return student;
    }

    public void setStudent(Student student)
    {
        this.student = student;
    }

    public Course getCourse()
    {
        return course;
    }

    public void setCourse(Course course)
    {
        this.course = course;
    }

}
