package com.lazyman.pickupweb;

import com.lazyman.pickupweb.course.*;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.support.OpenSessionInViewInterceptor;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Author chenxiaoqi on 2018/2/18.
 */
@Configuration
@PropertySource("pickupweb.properties")
public class PickupWebConfiguration implements ResourceLoaderAware{

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.driver_class_name}")
    private String jdbcDriverClassName;

    private ResourceLoader resourceLoader;

    @Bean
    public DataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(jdbcDriverClassName);
        basicDataSource.setUrl(jdbcUrl);
        return basicDataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(@Qualifier("hibernateProperties") Properties properties) {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setAnnotatedClasses(Teacher.class,
                Course.class,
                Student.class,
                StudentPay.class,
                CourseSchedule.class,
                StudentCourseRecord.class);
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setHibernateProperties(properties);
        return sessionFactoryBean;
    }

    @Bean(name = "hibernateProperties")
    public PropertiesFactoryBean hibernateProperties() {
        PropertiesFactoryBean factoryBean = new PropertiesFactoryBean();
        factoryBean.setLocation(resourceLoader.getResource("classpath:hibernate.properties"));
        return factoryBean;
    }

    @Bean("transactionManager")
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory){
        return new HibernateTransactionManager(sessionFactory);
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurerAdapter(SessionFactory sessionFactory){
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                OpenSessionInViewInterceptor interceptor = new OpenSessionInViewInterceptor();
                interceptor.setSessionFactory(sessionFactory);
                registry.addWebRequestInterceptor(interceptor);
            }
        };
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
