package com.jwl.common.sys.base;

public class Msg<D> {

    private int code;
    private D data;
    private String msg;
    public Msg() {
    }
    public Msg(int code) {
        this.code = code;
    }

    public Msg(int code, D data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public Msg(int code, D data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return code == 0;
    }

    public int getCode() {
        return code;
    }

    public D getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }
}
