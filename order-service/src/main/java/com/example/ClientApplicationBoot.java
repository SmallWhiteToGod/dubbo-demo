package com.example;

import com.example.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ClientApplicationBoot {

    private static ApplicationContext context = null;

    public static void main(String[] args) throws IOException {

        context = new ClassPathXmlApplicationContext("service-context.xml");

        System.out.println("======客户端开始启动======");
        //System.in.read();
        OrderService orderService = (OrderService)context.getBean("orderService");
        orderService.initOrder("test001");
    }
}
