package com.lazyman.pickupweb.course;

import com.lazyman.pickupweb.BaseEntity;

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
public class CourseSchedule extends BaseEntity
{
    private Date time;

    @ManyToOne(targetEntity = Course.class, fetch = FetchType.LAZY)
    private Course course;

    @ManyToOne(targetEntity = Teacher.class, fetch = FetchType.LAZY)
    private Teacher teacher;

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

}
