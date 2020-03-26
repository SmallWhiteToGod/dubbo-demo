package com.example.service;

import com.alibaba.fastjson.JSONObject;
import com.example.api.bean.Request;
import com.example.api.bean.Response;
import com.example.api.service.RouterBySidService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("routerBySidService")
public class RouterBySidServiceImpl implements RouterBySidService {

    private final static Logger logger = LoggerFactory.getLogger(RouterBySidService.class);

    @Value("${machineSize}")
    private int machineSize;

    @Value("${machineId}")
    private int machineId;

    public Response process(Request request) {
        //logger.info("[{}]机器收到Sid为[{}]的请求:{}",machineId,request.getSid(), JSONObject.toJSONString(request));
        System.out.println("["+machineId+"]机器收到Sid为["+request.getSid()+"]的请求:"+JSONObject.toJSONString(request));

        int sid = Integer.parseInt(request.getSid());

        String respBody = sid % machineSize == machineId?"路由正确!!!":"路由错误!!!";
        System.out.println(respBody);

        return initResponse(request.getSid(),respBody);
    }

    private Response initResponse(String sid, String respBody) {
        Response response = new Response();
        response.setSid(sid);
        response.setRespCode(machineId+"/"+machineSize+"号机器返回");
        response.setResepBody(respBody);
        return response;
    }
}
