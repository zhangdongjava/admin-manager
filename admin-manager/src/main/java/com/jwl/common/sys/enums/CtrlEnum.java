package com.jwl.common.sys.enums;

import com.jwl.common.sys.common.BaseService;
import com.jwl.common.sys.model.Module;
import com.jwl.common.sys.model.Role;
import com.jwl.common.sys.service.ModuleService;
import com.jwl.common.sys.service.RoleService;

public enum  CtrlEnum {

    ROLE("role", RoleService.class, Role.class),
    MODULE("module", ModuleService.class, Module.class);

    CtrlEnum(String serviceName, Class<? extends BaseService> serviceClass, Class<?> modelClass) {
        this.serviceName = serviceName;
        this.serviceClass = serviceClass;
        modelClass = modelClass;
    }

    private String serviceName;
    private Class<? extends BaseService> serviceClass;
    private Class<?> modelClass;

    public Class<? extends BaseService> getServiceClass(){
        return serviceClass;
    }
    public Class getModelClass(){
        return modelClass;
    }

    public String getServiceName() {
        return serviceName;
    }
}
