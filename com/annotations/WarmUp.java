package com.annotations;

/**
 * @Description:
 * @Author: zdd
 * @Date: 2019/7/31
 */
public @interface WarmUp {
    int iterations() default 0;
}
