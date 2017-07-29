package com.lazyman.pickupweb.dao;

import javax.persistence.*;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author c00286900
 * @version [版本号, 2017/7/26]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Entity(name = "StudentCourseRecord")
public class StudentCourseRecord
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = Student.class,optional = false)
    private Student student;

    @ManyToOne(targetEntity = Teacher.class,optional = false)
    private Teacher teacher;

    @ManyToOne(targetEntity = CourseSchedule.class,optional = false)
    private CourseSchedule courseSchedule;


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Student getStudent()
    {
        return student;
    }

    public void setStudent(Student student)
    {
        this.student = student;
    }

    public Teacher getTeacher()
    {
        return teacher;
    }

    public void setTeacher(Teacher teacher)
    {
        this.teacher = teacher;
    }

    public CourseSchedule getCourseSchedule()
    {
        return courseSchedule;
    }

    public void setCourseSchedule(CourseSchedule courseSchedule)
    {
        this.courseSchedule = courseSchedule;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentCourseRecord that = (StudentCourseRecord) o;

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
        return "StudentCourseRecord{" +
                "id=" + id +
                ", student=" + student +
                ", teacher=" + teacher +
                ", courseSchedule=" + courseSchedule +
                '}';
    }
}
