package com.lazyman.pickupweb.test;

import com.lazyman.pickupweb.course.Course;
import com.lazyman.pickupweb.course.CourseDao;
import com.lazyman.pickupweb.course.Teacher;
import com.lazyman.pickupweb.course.TeacherDao;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

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

public class CourseDaoTest extends SpringTest
{

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private TeacherDao teacherDao;

    @Sql(statements = {
            "insert into Teacher (id,name,phoneNumber,email) values(1,'cxq_100','13814063078','cxq@163.com')",
            "insert into Course (id,name,price,classes,teacher_id) values(1,'math',1880,10,1)",
    })
    @Test
    @Commit
    public void test()
    {

        Teacher teacher = teacherDao.load(1);
        Course course = new Course();
        course.setClasses(10);
        course.setPrice(1880);
        course.setName("physic");
        course.setTeacher(teacher);
        courseDao.save(course);

//        System.out.println(course);
         course = courseDao.get(1);
        Assert.assertEquals(1880,course.getPrice(),0);

        System.out.println("###########"+ courseDao.findAll());
    }


    @Test
    @Commit
    public void test1()
    {

    }
}
