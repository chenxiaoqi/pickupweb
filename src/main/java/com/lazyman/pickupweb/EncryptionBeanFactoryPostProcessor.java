package com.lazyman.pickupweb;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.*;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author c00286900
 * @version [版本号, 2018/3/31]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Component
public class EncryptionBeanFactoryPostProcessor implements BeanFactoryPostProcessor, EnvironmentAware
{

    private ConfigurableEnvironment environment;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException
    {
        MutablePropertySources propertySources = environment.getPropertySources();

        for (PropertySource propertySource : propertySources)
        {
            System.out.println("#"+propertySource);
            if (propertySource instanceof MapPropertySource)
            {
            }
        }
    }

    @Override
    public void setEnvironment(Environment environment)
    {
        this.environment = (ConfigurableEnvironment) environment;
    }
}
