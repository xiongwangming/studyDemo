package com.ming.sparearray.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName com.ming.sparearray.spring
 * @Author 24206
 * @Date 2020/3/27 16:49
 **/
@Configuration
public class Config {

    @Bean
    public Person person(){
        return new Person("张三",12);
    }
}
