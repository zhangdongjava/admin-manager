package com.jwl.common.sys.service.impl;

import com.jwl.common.sys.annotation.Dosamething;
import com.jwl.common.sys.common.BaseServiceImpl;
import com.jwl.common.sys.mapper.ModuleMapper;
import com.jwl.common.sys.model.Module;
import com.jwl.common.sys.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Service
public class ModuleServiceImpl extends BaseServiceImpl<Module> implements ModuleService {


    @Autowired
    private ModuleMapper moduleMapper;

    @Override
    @Dosamething("菜单列表根据角色ID查询")
    public List<Module> selectByRoleId(String id) {
        return moduleMapper.selectByRoleId(id);
    }


    @Override
    public Mapper<Module> mapper() {
        return moduleMapper;
    }
}
