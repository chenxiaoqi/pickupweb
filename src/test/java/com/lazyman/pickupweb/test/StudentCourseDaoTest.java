package com.lazyman.pickupweb.test;

import com.lazyman.pickupweb.dao.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author c00286900
 * @version [版本号, 2017/7/27]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class StudentCourseDaoTest extends SpringTest
{


    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private CourseScheduleDao courseScheduleDao;

    @Autowired
    private StudentCourseRecordDaoImpl studentClassRecordDao;

    @Test
    @Transactional
    public void test()
    {
        Student student = new Student();
        student.setName("peter");
        student.setEmail("peter@qq.com");
        student.setPhoneNumber("13852456568");
        studentDao.save(student);

        Teacher teacher = new Teacher();
        teacher.setName("mike");
        teacher.setEmail("mike@qq.com");
        teacher.setPhoneNumber("15445456689");
        teacherDao.save(teacher);

        Course course = new Course();
        course.setName("math");
        course.setTeacher(teacher);
        course.setPrice(188.8f);
        course.setClasses(10);
        courseDao.save(course);


        CourseSchedule courseSchedule = new CourseSchedule();
        courseSchedule.setCourse(course);
        courseSchedule.setTeacher(teacher);
        courseSchedule.setTime(new Date(System.currentTimeMillis()));
        courseScheduleDao.save(courseSchedule);

        StudentCourseRecord studentCourseRecord = new StudentCourseRecord();
        studentCourseRecord.setCourseSchedule(courseSchedule);
        studentCourseRecord.setStudent(student);
        studentCourseRecord.setTeacher(teacher);
        studentClassRecordDao.save(studentCourseRecord);

    }
}
