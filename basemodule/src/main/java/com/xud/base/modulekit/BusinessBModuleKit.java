package com.xud.base.modulekit;

import android.app.Application;

import com.xud.base.di.AppComponent;
import com.xud.base.modulekit.provider.BusinessBProvider;

/**
 * Created by xud on 2018/3/26.
 */

public class BusinessBModuleKit {

    private static BusinessBModuleKit instance;
    private Application application;
    private AppComponent component;
    private BusinessBProvider businessBProvider;

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

    public BusinessBModuleKit init(Application application, AppModuleComponentDelegate appModuleComponentDelegate) {
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

    public void registerProvider(BusinessBProvider provider) {
        this.businessBProvider = provider;
    }

    public BusinessBProvider getBusinessBProvider() {
        if (businessBProvider == null) {
            throw new NullPointerException("LoginProvider not registered");
        }
        return businessBProvider;
    }
}
