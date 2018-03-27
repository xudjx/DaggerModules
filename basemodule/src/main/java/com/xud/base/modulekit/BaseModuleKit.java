package com.xud.base.modulekit;

import android.app.Application;

import com.xud.base.BaseApplication;
import com.xud.base.di.AppModule;
import com.xud.base.di.BaseAppComponent;
import com.xud.base.di.DaggerBaseAppComponent;

/**
 * Created by xud on 2017/7/2.
 */

public class BaseModuleKit {

    private static BaseModuleKit instance;
    private BaseAppComponent component;

    public static BaseModuleKit getInstance() {
        if (instance == null) {
            synchronized (BaseModuleKit.class) {
                if (instance == null) {
                    instance = new BaseModuleKit();
                    Application application = BaseApplication.getInstance();
                    instance.component = DaggerBaseAppComponent.builder().appModule(new AppModule(application)).build();
                }
            }
        }
        return instance;
    }

    public BaseAppComponent getComponent() {
        return component;
    }
}
