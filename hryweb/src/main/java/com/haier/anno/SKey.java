package com.haier.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @Description:
 * @Author: luqiwei
 * @Date: 2018/8/2 14:01
 */
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SKey {
    String value() default "";
}
