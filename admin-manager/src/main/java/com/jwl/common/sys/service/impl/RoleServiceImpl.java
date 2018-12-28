package com.jwl.common.sys.service.impl;

import com.jwl.common.sys.common.BaseServiceImpl;
import com.jwl.common.sys.mapper.RoleMapper;
import com.jwl.common.sys.model.Role;
import com.jwl.common.sys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Mapper<Role> mapper() {
        return roleMapper;
    }
}
