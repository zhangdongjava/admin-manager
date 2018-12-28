package com.jwl.common.sys.mapper;

import com.jwl.common.sys.model.Module;
import com.jwl.common.sys.model.Role;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface ModuleMapper extends Mapper<Module> {


    List<Module> selectByRoleId(@Param("roleId") String roleId);

}
