package com.example.filter;

import com.alibaba.dubbo.rpc.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.util.ReflectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

/**
 * 消费端拦截器  为报文的sid赋值
 * sid作为路由字段 配合后面的router 路由到对应的服务端
 */
public class InitSidFilter implements Filter {

    private final static Logger logger = LoggerFactory.getLogger(InitSidFilter.class);

    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        Object[] args = invocation.getArguments();
        System.out.println("拦截器收到消费端发出报文"+JSONObject.toJSONString(args));
        if (args != null && args.length > 0) {
            Object arg = args[0];
            if (arg instanceof String) {//参数是String
                JSONObject jsonObject = JSON.parseObject((String)arg);
                if (null == jsonObject.get("sid")) {
                    jsonObject.put("sid", getSid());
                    args[0] = jsonObject.toString();
                }
            }else if (arg instanceof JSONObject){//参数是JSONObject
                if (((JSONObject)arg).get("sid") == null) {
                    ((JSONObject)arg).put("sid", getSid());
                }
            }else {//参数是对象
                Class<?> clazz = arg.getClass();
                Method getId = ReflectUtil.getMethod(clazz, "getSid", new Class[] {});
                Method setId = ReflectUtil.getMethod(clazz, "setSid", new Class[] {String.class});
                try {
                    if (getId != null && getId.invoke(arg) == null && setId != null) {
                        setId.invoke(arg, getSid());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return invoker.invoke(invocation);
    }


    private String getSid() {
        String sid = String.valueOf(10000000 + new Random().nextInt(10000000));
        System.out.println("生成的sid为[{}]"+sid);
        return sid;
    }
}
