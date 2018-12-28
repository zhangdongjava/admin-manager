package com.jwl.common.sys.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.METHOD)
public @interface Dosamething {

    String value() default "";

    String key() default "";


}
