package com.xxl.job.core.handler.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * annotation for job handler
 *
 * @author 2016-5-17 21:06:49
 * @author zlikun
 * @see Component
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Component
public @interface JobHandler {

    String value() default "";

}
