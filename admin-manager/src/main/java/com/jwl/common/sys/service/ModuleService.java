package com.jwl.common.sys.service;

import com.jwl.common.sys.common.BaseService;
import com.jwl.common.sys.model.Module;
import com.jwl.common.sys.model.Role;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ModuleService extends BaseService<Module> {

    List<Module> selectByRoleId(String id);


}
