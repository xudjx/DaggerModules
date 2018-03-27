package com.xud.base;

import android.app.Application;
import android.support.multidex.MultiDexApplication;

import com.xud.base.di.BaseAppComponent;
import com.xud.base.modulekit.BaseModuleKit;

/**
 * Created by xud on 2017/7/23.
 */

public abstract class BaseApplication extends MultiDexApplication {

    protected static Application instance;

    public static Application getInstance() {
        return instance;
    }

    // BaseAppComponent 要保证唯一来自于BaseModuleKit， 即只能被创建一次
    private BaseAppComponent baseAppComponent;

    public BaseAppComponent baseAppComponent() {
        if (baseAppComponent != null) {
            baseAppComponent = BaseModuleKit.getInstance().getComponent();
        }
        return baseAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        registerProvider();
    }

    public abstract void registerProvider();
}
