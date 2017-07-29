package com.lazyman.pickupweb.dao;

import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
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
public interface BaseDao<T>
{

    Serializable save(T entity);

    void update(T entity);

    void saveOrUpdate(T entity);

    void delete(T entity);

    T get(Serializable id);

    T load(Serializable id);

    List<T> findAll();

    Integer findRecordNumByPage(DetachedCriteria detachedCriteria);

    List<T> findByPage(DetachedCriteria detachedCriteria, Integer startIndex, Integer pageSize);

    List<T> findByCriteria(DetachedCriteria detachedCriteria);

    void executeUpdate(String queryName, Object... objects);

}
