package com.jwl.common.sys.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.ui.Model;

import java.util.List;

@Data
@Accessors(chain = true)
public class Module {
    private String id;
    private String moduleName;
    private String url;
    private List<Model> childrens;
}
