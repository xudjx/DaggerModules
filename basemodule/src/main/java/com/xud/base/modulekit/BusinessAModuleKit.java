package com.xud.base.modulekit;

import android.app.Application;

import com.xud.base.di.AppComponent;
import com.xud.base.modulekit.provider.BusinessAProvider;

/**
 * Created by xud on 2018/3/25.
 */

public class BusinessAModuleKit {

    private static BusinessAModuleKit instance;
    private Application application;
    private AppComponent component;
    private BusinessAProvider businessAProvider;

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

    public BusinessAModuleKit init(Application application, AppModuleComponentDelegate appModuleComponentDelegate) {
        this.application = application;
        this.component = appModuleComponentDelegate.initAppComponent();
        return this;
    }

    public Application getApplication() {
        return application;
    }

    public AppComponent getComponent() {
        return component;
    }

    public void registerProvider(BusinessAProvider provider) {
        this.businessAProvider = provider;
    }

    public BusinessAProvider getBusinessAProvider() {
        if (businessAProvider == null) {
            throw new NullPointerException("LoginProvider not registered");
        }
        return businessAProvider;
    }

}
