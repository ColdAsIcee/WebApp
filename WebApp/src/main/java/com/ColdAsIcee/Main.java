package com.ColdAsIcee;

import com.ColdAsIcee.config.SpringConfig;
import com.ColdAsIcee.service.TestBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        TestBean bean = context.getBean(TestBean.class);
        String name = bean.getName();
        System.out.println("hello " + name);
    }
}
