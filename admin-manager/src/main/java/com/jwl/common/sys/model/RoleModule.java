package com.jwl.common.sys.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RoleModule {
    private String roleId;
    private String moduleId;
}
