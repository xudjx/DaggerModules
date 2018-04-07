package com.xud.base.modulekit;

import com.xud.base.di.AppComponent;
/**
 * Created by xud on 2018/3/25.
 */

public class BusinessAModuleKit {

    private static BusinessAModuleKit instance;
    private AppComponent component;

    public static BusinessAModuleKit getInstance() {
        if (instance == null) {
            synchronized (BusinessAModuleKit.class) {
                if (instance == null) {
                    instance = new BusinessAModuleKit();
                }
            }
        }
        return instance;
    }

    public BusinessAModuleKit init(AppModuleComponentDelegate appModuleComponentDelegate) {
        this.component = appModuleComponentDelegate.initAppComponent();
        return this;
    }

    public AppComponent getComponent() {
        return component;
    }
}
