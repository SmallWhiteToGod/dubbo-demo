package com.example.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.api.bean.Request;
import com.example.api.bean.Response;
import com.example.api.service.RouterBySidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/")
public class RouterController {

    @Resource(name="routerBySidService")
    private RouterBySidService routerBySidService;

    @ResponseBody
    @RequestMapping(value = "/router/{sid}",method = RequestMethod.GET)
    public Response router(@PathVariable("sid") String sid){
        Request request = new Request();
        if (sid != null && !sid.equals("0")){
            request.setSid(sid);
        }
        System.out.println("输入的sid:"+sid);

        request.setReqBody("输入的参数为"+sid);
        Response response = routerBySidService.process(request);
        return response;
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String view(){
        return "index";
    }

}
