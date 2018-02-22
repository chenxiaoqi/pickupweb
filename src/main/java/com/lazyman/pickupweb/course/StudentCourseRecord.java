package com.lazyman.pickupweb.course;

import com.lazyman.pickupweb.BaseEntity;

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
@Entity(name = "studentCourseRecord")
public class StudentCourseRecord extends BaseEntity {
    @ManyToOne(targetEntity = Student.class, optional = false)
    private Student student;

    @ManyToOne(targetEntity = Teacher.class, optional = false)
    private Teacher teacher;

    @ManyToOne(targetEntity = CourseSchedule.class, optional = false)
    private CourseSchedule courseSchedule;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public CourseSchedule getCourseSchedule() {
        return courseSchedule;
    }

    public void setCourseSchedule(CourseSchedule courseSchedule) {
        this.courseSchedule = courseSchedule;
    }

}
