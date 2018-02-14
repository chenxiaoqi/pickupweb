package com.lazyman.pickupweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author c00286900
 * @version [版本号, 2018/2/11]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@SpringBootApplication
@ComponentScan
public class Example
{
    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(Example.class, args);

    }
}
