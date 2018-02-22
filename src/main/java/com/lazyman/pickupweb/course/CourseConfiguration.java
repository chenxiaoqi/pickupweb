package com.lazyman.pickupweb.course;

import com.lazyman.pickupweb.course.impl.*;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author chenxiaoqi on 2018/2/16.
 */
@Configuration
public class CourseConfiguration {

    @Bean
    public CourseDao courseDao(SessionFactory sessionFactory){
        CourseDaoImpl dao = new CourseDaoImpl();
        dao.setSessionFactory(sessionFactory);
        return dao;
    }

    @Bean
    public CourseScheduleDao courseScheduleDao(SessionFactory sessionFactory){
        CourseScheduleDaoImpl dao = new CourseScheduleDaoImpl();
        dao.setSessionFactory(sessionFactory);
        return dao;
    }

    @Bean
    public StudentDao studentDao(SessionFactory sessionFactory){
        StudentDaoImpl dao = new StudentDaoImpl();
        dao.setSessionFactory(sessionFactory);
        return dao;
    }

    @Bean
    public StudentClassRecordDao studentClassRecordDao(SessionFactory sessionFactory){
        StudentClassRecordDaoImpl dao =  new StudentClassRecordDaoImpl();
        dao.setSessionFactory(sessionFactory);
        return dao;
    }

    @Bean
    public TeacherDao teacherDao(SessionFactory sessionFactory){
        TeacherDaoImpl dao = new TeacherDaoImpl();
        dao.setSessionFactory(sessionFactory);
        return dao;
    }
}
