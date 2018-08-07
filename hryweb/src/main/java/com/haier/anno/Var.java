package com.haier.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/8/6 18:48
 */
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Var {
    String value() default "";
}
