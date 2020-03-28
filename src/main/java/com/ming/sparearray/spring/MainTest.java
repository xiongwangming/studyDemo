package com.ming.sparearray.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName com.ming.sparearray.spring
 * @Author 24206
 * @Date 2020/3/27 16:49
 **/
public class MainTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Config.class);
        Person person = (Person) annotationConfigApplicationContext.getBean("person");
        System.out.println(person);
    }
}
