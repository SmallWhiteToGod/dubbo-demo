package com.example;

import com.alibaba.fastjson.JSONObject;
import com.example.api.bean.Response;
import com.example.controller.RouterController;
import com.example.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Scanner;

public class ClientApplicationBoot {

    private static ApplicationContext context = null;

    public static void main(String[] args) throws IOException {

        context = new ClassPathXmlApplicationContext("service-context.xml");

        System.out.println("======客户端开始启动======");

//        OrderService orderService = (OrderService)context.getBean("orderService");
//        orderService.initOrder("test001");

        routerTest();
    }

    private static void routerTest() {
        RouterController controller = (RouterController) context.getBean("routerController");

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Response response = controller.router(sc.nextLine());
            System.out.println(JSONObject.toJSONString(response));
        }
    }
}
