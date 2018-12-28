package com.jwl.logmananger.core.controller;

import com.jwl.log.facade.model.Log;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {

    @PostMapping("/add")
    public String add(@RequestBody Log log){
        System.out.println("添加->"+log);
        return "success";
    }
}
