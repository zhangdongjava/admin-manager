package com.jwl.common.sys.service.impl;

import com.jwl.common.sys.common.BaseServiceImpl;
import com.jwl.common.sys.mapper.AdminUserMapper;
import com.jwl.common.sys.model.AdminUser;
import com.jwl.common.sys.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

@Service
public class AdminUserServiceImpl extends BaseServiceImpl<AdminUser> implements AdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    public Mapper<AdminUser> mapper() {
        return adminUserMapper;
    }
}
