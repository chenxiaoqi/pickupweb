package com.lazyman.pickupweb.dao;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
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
public class TeacherDaoImpl implements TeacherDao
{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Teacher> queryAll()
    {
        return this.sessionFactory.getCurrentSession().createQuery("from com.lazyman.pickupweb.dao.Teacher", Teacher.class).list();
    }

    @Override
    public int insert(Teacher teacher)
    {
        sessionFactory.getCurrentSession().save(teacher);
        return teacher.getId();
    }
}
