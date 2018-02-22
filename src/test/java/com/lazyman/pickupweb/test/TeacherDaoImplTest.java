package com.lazyman.pickupweb.test;

import com.lazyman.pickupweb.course.Teacher;
import com.lazyman.pickupweb.course.TeacherDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author c00286900
 * @version [版本号, 2017/7/18]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Sql(statements = {"delete from Teacher"})
public class TeacherDaoImplTest extends SpringTest
{


    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private DataSource dataSource;


    @Test

    @Transactional()
    @Commit
    public void testLoadAll()
    {
        Teacher teacher = new Teacher();
        teacher.setName("陈小奇");
        int teacherId = (Integer) teacherDao.save(teacher);
        Assert.assertNotEquals(0, teacherId);

        List<Teacher> teachers = teacherDao.findAll();
        Assert.assertEquals(1, teachers.size());

        Teacher teacherFromQuery = teachers.get(0);

        Assert.assertEquals(teacherId, teacherFromQuery.getId());
        Assert.assertEquals("陈小奇", teacherFromQuery.getName());
        Assert.assertSame(teacher, teacherFromQuery);

        Teacher teacherFromGet = teacherDao.get(teacherId);
        Assert.assertSame(teacherFromGet, teacherFromQuery);
    }

    @Test
    public void testLazy()
    {
        JdbcTemplate template = new JdbcTemplate(dataSource, false);
        template.update("INSERT INTO Teacher (id,name,phoneNumber,email) VALUES(1,'cxq_100','13814063078','cxq@163.com')");
        Session session1 = sessionFactory.openSession();
        Teacher teacherLoad = session1.load(Teacher.class, 1);

        Teacher teacherGet = session1.get(Teacher.class, 1);

        Assert.assertSame(teacherGet, teacherLoad);
        session1.close();

        Session session2 = sessionFactory.openSession();
        Assert.assertNotSame(session1, session2);
        Teacher teacher2 = session2.get(Teacher.class, 1);
        Assert.assertNotSame(teacherGet, teacher2);

        session2.close();

    }

    @Test
    public void test2()
    {

        Teacher teacher = new Teacher();
        teacher.setName("cxq");
        teacher.setPhoneNumber("xxx");
        teacher.setEmail("xxx");

        Session session1 = sessionFactory.openSession();
        int teacherId = (int) session1.save(teacher);


        Teacher teacher2 = session1.get(Teacher.class, teacherId);
        Assert.assertSame(teacher, teacher2);
        session1.close();

        Session session2 = sessionFactory.openSession();
        teacher2 = session2.get(Teacher.class, 1);
        Assert.assertNotSame(teacher, teacher2);
        session2.close();

    }


}