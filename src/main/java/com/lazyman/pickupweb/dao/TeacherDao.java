package com.lazyman.pickupweb.dao;

import org.springframework.transaction.annotation.Transactional;

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
@Transactional
public interface TeacherDao
{
    @Transactional(readOnly = true)
    List<Teacher> queryAll();

    int insert(Teacher teacher);

}
