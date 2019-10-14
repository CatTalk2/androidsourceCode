package com.debugcat.eventbusdemo;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * 处理事件绑定
 */
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface BindListener {
}
