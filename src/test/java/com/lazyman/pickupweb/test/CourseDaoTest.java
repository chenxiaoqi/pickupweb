package com.lazyman.pickupweb.test;

import com.lazyman.pickupweb.dao.Course;
import com.lazyman.pickupweb.dao.CourseDao;
import com.lazyman.pickupweb.dao.Teacher;
import com.lazyman.pickupweb.dao.TeacherDao;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.awt.*;
import java.io.Serializable;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author c00286900
 * @version [版本号, 2017/7/19]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Transactional
@Sql(statements = {
        "insert into Teacher (id,name,phoneNumber,email) values(1,'cxq_100','13814063078','cxq@163.com')",
        "insert into Course (id,name,price,classes,teacher_id) values(1,'math',1880,10,1)",
})
@Sql(statements = {
        "delete from Course",
        "delete from Teacher"
}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class CourseDaoTest extends SpringTest
{

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private TeacherDao teacherDao;


    @Test
    @Commit
    public void test()
    {

//        Teacher teacher = teacherDao.findById(1);
//        Course course = new Course();
//        course.setClasses(10);
//        course.setPrice(1880);
//        course.setName("physic");
//        course.setTeacher(teacher);
//        courseDao.save(course);

//        System.out.println(course);
        Course course = courseDao.findById(1);
        System.out.println(course);
    }


    @Test
    @Commit
    public void test1()
    {

    }
}
