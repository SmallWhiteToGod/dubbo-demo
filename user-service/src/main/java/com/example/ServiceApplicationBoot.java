package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ServiceApplicationBoot {

    private static ApplicationContext context = null;

    public static void main(String[] args) throws IOException {

        context = new ClassPathXmlApplicationContext("service-context.xml");

        System.out.println("======服务端启动======");
        System.in.read();
    }
}
