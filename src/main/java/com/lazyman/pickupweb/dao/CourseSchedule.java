package com.lazyman.pickupweb.dao;

import javax.persistence.*;
import java.sql.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author c00286900
 * @version [版本号, 2017/7/26]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Entity(name = "CourseSchedule")
public class CourseSchedule
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date time;

    @ManyToOne(targetEntity = Course.class, fetch = FetchType.LAZY)
    private Course course;

    @ManyToOne(targetEntity = Teacher.class, fetch = FetchType.LAZY)
    private Teacher teacher;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Date getTime()
    {
        return time;
    }

    public void setTime(Date time)
    {
        this.time = time;
    }

    public Course getCourse()
    {
        return course;
    }

    public void setCourse(Course course)
    {
        this.course = course;
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

        CourseSchedule that = (CourseSchedule) o;

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
        return "CourseSchedule{" +
                "id=" + id +
                ", time=" + time +
                ", course=" + course +
                ", teacher=" + teacher +
                '}';
    }
}
