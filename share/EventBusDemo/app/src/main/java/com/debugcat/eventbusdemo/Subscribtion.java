package com.debugcat.eventbusdemo;

import java.lang.reflect.Method;

/**
 * 描述register & method
 */
public class Subscribtion {

    private Object mObject;

    private Method method;

    public Subscribtion(Object mObject, Method method) {
        this.mObject = mObject;
        this.method = method;
    }

    public Object getmObject() {
        return mObject;
    }

    public void setmObject(Object mObject) {
        this.mObject = mObject;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public void invoke(Object event) {
        if (method != null) {
            try {
                method.invoke(this.mObject, event);
            } catch (Throwable throwable) {

            }
        }
    }
}
