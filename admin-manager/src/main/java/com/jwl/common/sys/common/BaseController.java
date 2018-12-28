package com.jwl.common.sys.common;

import com.alibaba.fastjson.JSON;
import com.jwl.common.sys.base.Msg;
import com.jwl.common.sys.base.PageRequest;
import com.jwl.common.sys.base.PageResponse;
import com.jwl.common.sys.enums.CtrlEnum;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("baseCtrl")
public class BaseController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @GetMapping("/{serverName}/{key}")
    public Object get(@PathVariable("serverName") String serverName, @PathVariable("key") Object key) {
        CtrlEnum ctrlEnum = getCtrlEnumByServiceName(serverName);
        if (ctrlEnum == null) {
            return new Msg<>(1, null, "配置有误!");
        }
        return applicationContext.getBean(ctrlEnum.getServiceClass()).findById(key);
    }

    @PostMapping("/{serverName}/page")
    public Object page(@PathVariable("serverName") String serverName, HttpServletRequest request, PageRequest pageRequest) {
        CtrlEnum ctrlEnum = getCtrlEnumByServiceName(serverName);
        if (ctrlEnum == null) {
            return new Msg<>(1, null, "配置有误!");
        }
        Object params = getParamsByRequest(request, ctrlEnum.getModelClass());
        BaseService baseService = applicationContext.getBean(ctrlEnum.getServiceClass());
        List<Object> list = baseService.selectByRowBounds(params, new RowBounds(pageRequest.getOffset(), pageRequest.getPageSize()));
        int total = baseService.count(params);
        PageResponse response = new PageResponse(list, pageRequest, total);
        Msg<PageResponse> msg = new Msg<>(0, response);
        return msg;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    public Object getParamsByRequest(HttpServletRequest request, Class modelClass) {
        Map<String, String[]> map = request.getParameterMap();
        Map<String, Object> m = new HashMap<>();
        map.forEach((key, value) -> m.put(key, value != null && value.length > 1 ? value : value != null ? value[0] : ""));
        return JSON.parseObject(JSON.toJSONString(m), modelClass);
    }

    private CtrlEnum getCtrlEnumByServiceName(String serviceName) {
        CtrlEnum[] values = CtrlEnum.values();
        for (CtrlEnum value : values) {
            if (value.getServiceName().equals(serviceName)) {
                return value;
            }
        }
        return null;
    }
}
