package com.xud.componentlib.router;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.xud.componentlib.applicationlike.IApplicationLike;

import java.util.HashMap;

/**
 * Center router, works for component-dynamic-load/remove and services add/remove/get
 * Created by mrzhang on 2017/6/15.
 */
public class Router {

    private HashMap<String, Object> services = new HashMap<>();
    //注册的组件的集合
    private static HashMap<String, IApplicationLike> components = new HashMap<>();

    private static volatile Router instance;

    private Router() {
    }

    public static Router getInstance() {
        if (instance == null) {
            synchronized (Router.class) {
                if (instance == null) {
                    instance = new Router();
                }
            }
        }
        return instance;
    }

    public synchronized <T> void addService(Class<T> tClass, T t) {
        if (tClass == null || t == null) {
            return;
        }
        services.put(tClass.getSimpleName(), t);
    }

    public synchronized <T> T getService(Class<T> tClass) {
        if (tClass == null || !services.containsKey(tClass.getSimpleName())) {
            return null;
        }
        return (T) services.get(tClass.getSimpleName());
    }

    public synchronized <T> void removeService(Class<T> tClass) {
        if (tClass == null || !services.containsKey(tClass.getSimpleName())) {
            return ;
        }
        services.remove(tClass.getSimpleName());
    }

    /**
     * 注册组件
     *
     * @param classname 组件名
     */
    public static void registerComponent(@Nullable String classname) {
        if (TextUtils.isEmpty(classname)) {
            return;
        }
        if (components.keySet().contains(classname)) {
            return;
        }
        try {
            Class clazz = Class.forName(classname);
            IApplicationLike applicationLike = (IApplicationLike) clazz.newInstance();
            applicationLike.onCreate();
            components.put(classname, applicationLike);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 反注册组件
     *
     * @param classname 组件名
     */
    public static void unregisterComponent(@Nullable String classname) {
        if (TextUtils.isEmpty(classname)) {
            return;
        }
        if (components.keySet().contains(classname)) {
            components.get(classname).onStop();
            components.remove(classname);
            return;
        }
        try {
            Class clazz = Class.forName(classname);
            IApplicationLike applicationLike = (IApplicationLike) clazz.newInstance();
            applicationLike.onStop();
            components.remove(classname);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
