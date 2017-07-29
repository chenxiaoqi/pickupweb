package com.lazyman.pickupweb.dao;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class StudentPay
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date date;

    private float fee;

    @ManyToOne(targetEntity = Student.class, optional = false)
    private Student student;

    @ManyToOne(targetEntity = Course.class, optional = false)
    private Course course;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentPay that = (StudentPay) o;

        return id == that.id;
    }

    @Override
    public int hashCode()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return "StudentPay{" +
                "id=" + id +
                ", date=" + date +
                ", fee=" + fee +
                ", student=" + student +
                ", course=" + course +
                '}';
    }
}
