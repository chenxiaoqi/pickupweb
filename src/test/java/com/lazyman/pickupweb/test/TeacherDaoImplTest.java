package com.lazyman.pickupweb.test;

import com.lazyman.pickupweb.dao.Teacher;
import com.lazyman.pickupweb.dao.TeacherDao;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
public class TeacherDaoImplTest extends SpringTest
{
    @Autowired
    private TeacherDao teacherDao;

    @Test
    public void testLoadAll()
    {
        Teacher teacher = new Teacher();
        teacher.setName("cxq");
        int teacherId = teacherDao.insert(teacher);
        Assert.assertNotEquals(0, teacherId);

        List<Teacher> teachers = teacherDao.queryAll();
        Assert.assertEquals(1, teachers.size());

        Teacher teacherFromQuery = teachers.get(0);

        Assert.assertEquals(teacherId, teacherFromQuery.getId());
        Assert.assertEquals("cxq", teacherFromQuery.getName());
        Assert.assertNotSame(teacher, teacherFromQuery);

    }

}