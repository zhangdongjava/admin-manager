package com.jwl.common.sys.facade;

import com.jwl.log.facade.model.Log;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "log-manager")
public interface LogFacade {

    @PostMapping("/log/add")
    String add(@RequestBody Log log);
}
