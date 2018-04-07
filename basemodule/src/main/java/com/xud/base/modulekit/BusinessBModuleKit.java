package com.xud.base.modulekit;

import android.app.Application;

import com.xud.base.di.AppComponent;

/**
 * Created by xud on 2018/3/26.
 */

public class BusinessBModuleKit {

    private static BusinessBModuleKit instance;
    private AppComponent component;

    public static BusinessBModuleKit getInstance() {
        if (instance == null) {
            synchronized (BusinessBModuleKit.class) {
                if (instance == null) {
                    instance = new BusinessBModuleKit();
                }
            }
        }
        return instance;
    }

    public BusinessBModuleKit init(AppModuleComponentDelegate appModuleComponentDelegate) {
        this.component = appModuleComponentDelegate.initAppComponent();
        return this;
    }

    public AppComponent getComponent() {
        return component;
    }
}
