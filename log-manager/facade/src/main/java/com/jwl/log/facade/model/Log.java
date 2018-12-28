package com.jwl.log.facade.model;

import java.util.Map;

public class Log {

    private String desc;
    private Map<String,Object> params;
    private String methodName;
    private String serviceName;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String toString() {
        return "Log{" +
                "desc='" + desc + '\'' +
                ", params=" + params +
                ", methodName='" + methodName + '\'' +
                ", serviceName='" + serviceName + '\'' +
                '}';
    }
}
