package com.zingw.demo.controller;

import java.lang.annotation.*;

/**
 * @author zxw
 * @Desriiption:
 */
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemControllerLog {
    String description() default "";
}
