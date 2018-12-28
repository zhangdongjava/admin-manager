package com.jwl.common.sys.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Id;

@Data
@Accessors(chain = true)
public class Role {
    @Id
    private String id;
    private String roleName;



}
