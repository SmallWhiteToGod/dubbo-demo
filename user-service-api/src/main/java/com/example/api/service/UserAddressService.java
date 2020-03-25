package com.example.api.service;


import com.example.api.bean.UserAddress;

import java.util.List;

public interface UserAddressService {

    List<UserAddress> getAddressByUserId(String userId);
}
