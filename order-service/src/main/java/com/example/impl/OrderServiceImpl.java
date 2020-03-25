package com.example.impl;


import com.example.api.bean.UserAddress;
import com.example.service.OrderService;
import com.example.api.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserAddressService userAddressService;
    /**
     * 初始化订单
     * @param userId 用户id
     */
    @Override
    public void initOrder(String userId) {
        System.out.println("开始查询客户id为"+userId+"的订单");

        //查询用户的收获地址 使用dubbo远程调用
        List<UserAddress> list = userAddressService.getAddressByUserId(userId);

        System.out.println("客户"+userId+"的订单列表:");
        System.out.println(Arrays.toString(list.toArray()));
    }
}
