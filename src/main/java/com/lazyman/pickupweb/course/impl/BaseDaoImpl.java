package com.lazyman.pickupweb.course.impl;

import com.lazyman.pickupweb.course.BaseDao;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author c00286900
 * @version [版本号, 2017/7/19]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>
{
    private Class<T> clazz;

    public BaseDaoImpl()
    {
        Class c = this.getClass();
        Type type = c.getGenericSuperclass();
        ParameterizedType pType = (ParameterizedType) type;
        Type[] actualTypeArguments = pType.getActualTypeArguments();

        clazz = (Class<T>) (actualTypeArguments[0]);
    }

    @Override
    public Serializable save(T entity)
    {
        return this.getHibernateTemplate().save(entity);
    }

    @Override
    public void update(T entity)
    {
        this.getHibernateTemplate().update(entity);
    }

    @Override
    public void saveOrUpdate(T entity)
    {
        this.getHibernateTemplate().saveOrUpdate(entity);
    }

    @Override
    public void delete(T entity)
    {
        this.getHibernateTemplate().delete(entity);
    }

    @Override
    public T get(Serializable id)
    {
        return this.getHibernateTemplate().get(this.clazz, id);
    }

    @Override
    public T load(Serializable id)
    {
        return this.getHibernateTemplate().load(this.clazz, id);
    }

    @Override
    public List<T> findAll()
    {
        return (List<T>) this.getHibernateTemplate().find("from " + this.clazz.getName());
    }

    @Override
    public Integer findRecordNumByPage(DetachedCriteria detachedCriteria)
    {

        detachedCriteria.setProjection(Projections.rowCount());
        List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        detachedCriteria.setProjection(null);
        if (list.size() > 0)
        {
            return list.get(0).intValue();
        }
        return null;
    }

    @Override
    public List<T> findByPage(DetachedCriteria detachedCriteria, Integer startIndex, Integer pageSize)
    {
        detachedCriteria.setResultTransformer(DetachedCriteria.ROOT_ENTITY);
        return (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria, startIndex, pageSize);
    }

    @Override
    public List<T> findByCriteria(DetachedCriteria detachedCriteria)
    {
        return (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
    }

    @Override
    public void executeUpdate(String queryName, Object... objects)
    {
        Session session = this.getSessionFactory().getCurrentSession();
        Query query = session.getNamedQuery(queryName);
        int i = 0;
        if (objects != null)
        {
            for (Object object : objects)
            {
                query.setParameter(i++, object);
            }
        }
        query.executeUpdate();
    }
}
