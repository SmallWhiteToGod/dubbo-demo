package com.example.api.bean;

import java.io.Serializable;

public class Response implements Serializable {

    private String sid;

    private String respCode;

    private Object resepBody;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public Object getResepBody() {
        return resepBody;
    }

    public void setResepBody(Object resepBody) {
        this.resepBody = resepBody;
    }
}
