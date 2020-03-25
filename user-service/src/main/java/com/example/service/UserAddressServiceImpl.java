package com.example.service;

import com.example.api.bean.UserAddress;
import com.example.api.service.UserAddressService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("userAddressServiceImpl")
public class UserAddressServiceImpl implements UserAddressService {

    public List<UserAddress> getAddressByUserId(String userId) {

        System.out.println("收到订单查询请求");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        UserAddress address1 = new UserAddress();
        address1.setId(1);
        address1.setUserId("test001");
        address1.setPhoneNum("15122223333");
        address1.setConsignee("Tom");

        UserAddress address2 = new UserAddress();
        address2.setId(2);
        address1.setUserId("test001");
        address2.setPhoneNum("15122223333");
        address2.setConsignee("Bob");
        return Arrays.asList(address1,address2);
    }
}
