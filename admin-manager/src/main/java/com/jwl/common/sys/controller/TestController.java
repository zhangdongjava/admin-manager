package com.jwl.common.sys.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    @PreAuthorize("hasAnyAuthority('1')")
    public Object test(){

        return "test";
    }
}
