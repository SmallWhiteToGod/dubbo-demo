package com.example.api.bean;

import java.io.Serializable;

/**
 * 请求报文格式
 */
public class Request implements Serializable {

    private String sid;

    private Object reqBody;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Object getReqBody() {
        return reqBody;
    }

    public void setReqBody(Object reqBody) {
        this.reqBody = reqBody;
    }
}
