package com.jwl.common.sys.aop;

import com.jwl.common.sys.annotation.Dosamething;
import com.jwl.common.sys.facade.LogFacade;
import com.jwl.log.facade.model.Log;
import com.netflix.discovery.converters.Auto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.*;

@Aspect
@Component
public class DoSameThing {

    @Autowired
    private LogFacade logFacade;

    @Pointcut("@annotation(dst)")
    public void pointcut(Dosamething dst) {

    }

//    @Around("pointcut(dst)")
//    public Object execHandle(ProceedingJoinPoint point, Dosamething dst){
//        try {
//            //通直钱
//           return point.proceed(point.getArgs());
//            //通知后
//            //正常返回
//        } catch (Throwable throwable) {
//            //执行异常
//            throwable.printStackTrace();
//        }
//        return null;
//    }

    @Before("pointcut(dst)")
    public void before(JoinPoint joinPoint, Dosamething dst) {

        System.out.println("调用了--" + dst.value() + ",参数:-->" + getParams(joinPoint, dst));
        Log log = new Log();
        log.setDesc(dst.value());
        log.setParams(getParams(joinPoint,dst));
        log.setMethodName(joinPoint.getSignature().getName());
        logFacade.add(log);
    }

    private Map<String, Object> getParams(JoinPoint joinPoint, Dosamething dst) {
        LocalVariableTableParameterNameDiscoverer discoverer
                = new LocalVariableTableParameterNameDiscoverer();
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();
        String[] argNames = discoverer.getParameterNames(targetMethod);
        Object[] args = joinPoint.getArgs();
        Set<String> set  = null;
        if (StringUtils.hasText(dst.key())) {
            set = new HashSet<>(Arrays.asList(dst.key().split(",")));
        }

        Map<String, Object> params = new HashMap();
        for (int i = 0; i < argNames.length; i++) {
            String argName = argNames[i];
            if (set == null || set.contains(argName)) {
                params.put(argName, Objects.toString(i >= args.length ? "" : args[i], ""));
            }
        }

        return params;
    }

}
