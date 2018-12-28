package com.jwl.common.sys.mapper;

import com.jwl.common.sys.model.Role;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface RoleMapper extends Mapper<Role> {

    Role selectById(@Param("id") Integer id);
}
