package com.debugcat.eventbusdemo;


import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class EventBoss {

    static volatile EventBoss eventBoss;

    private ArrayList<Subscribtion> mListSubscriber = new ArrayList();

    private EventBoss() {

    }

    public static EventBoss getDefault() {
        synchronized (EventBoss.class) {
            if (eventBoss == null) {
                eventBoss = new EventBoss();
            }
        }
        return eventBoss;
    }


    /**
     * 注册
     * @param object
     */
    public void register(Object object) {
        if (object ==  null) throw new IllegalArgumentException("register can not be null");
        Subscribtion subscribtion = getSubscription(object);
        if (subscribtion != null) {
            mListSubscriber.add(subscribtion);
        }
    }


    /**
     * 发布
     */
    public void post(Object event) {
        if (event != null) {
            for (int i = 0; i < mListSubscriber.size(); i++) {
                mListSubscriber.get(i).invoke(event);
            }
        }
    }


    private void scheduleEvent(Object event) {

    }


    private Subscribtion getSubscription(Object object) {
        Method[] methods = null;
        try {
            methods = object.getClass().getDeclaredMethods();
            for (Method method : methods) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    Subcriber annotations = method.getAnnotation(Subcriber.class);
                    if (annotations != null) {
                        return new Subscribtion(object, method);
                    }
                } else {
                    throw new IllegalArgumentException("subscriber parameter length must be 1");
                }
            }
        } catch (Throwable ex) {

        }
        return null;
    }
}
