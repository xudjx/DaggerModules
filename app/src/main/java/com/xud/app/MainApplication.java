package com.xud.app;

import com.xud.base.BaseApplication;
import com.xud.base.di.AppComponent;
import com.xud.base.modulekit.AppModuleComponentDelegate;
import com.xud.base.modulekit.BaseModuleKit;
import com.xud.base.modulekit.BusinessAModuleKit;
import com.xud.base.modulekit.BusinessBModuleKit;
import com.xud.base.route.RouterManager;
import com.xud.modulea.BusinessAProviderRegister;
import com.xud.modulea.di.BusinessAAppComponent;
import com.xud.modulea.di.DaggerBusinessAAppComponent;
import com.xud.moduleb.BusinessBProviderRegister;
import com.xud.moduleb.di.BusinessBAppComponent;
import com.xud.moduleb.di.DaggerBusinessBAppComponent;

/**
 * Created by xud on 2018/3/27.
 */

public class MainApplication extends BaseApplication {

    private AppModuleComponentDelegate businessAComponentDelegate = new AppModuleComponentDelegate() {
        @Override
        public AppComponent initAppComponent() {
            BusinessAAppComponent appComponent = DaggerBusinessAAppComponent.builder()
                    .baseAppComponent(BaseModuleKit.getInstance().getComponent())
                    .build();
            return appComponent;
        }
    };

    private AppModuleComponentDelegate businessBComponentDelegate = new AppModuleComponentDelegate() {
        @Override
        public AppComponent initAppComponent() {
            BusinessBAppComponent appComponent = DaggerBusinessBAppComponent.builder()
                    .baseAppComponent(BaseModuleKit.getInstance().getComponent())
                    .build();
            return appComponent;
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        initUtils();
        BusinessAModuleKit.getInstance().init(this, businessAComponentDelegate);
        BusinessBModuleKit.getInstance().init(this, businessBComponentDelegate);
    }

    @Override
    public void registerProvider() {
        new BusinessAProviderRegister().regist();
        new BusinessBProviderRegister().regist();
    }

    private void initUtils() {
        RouterManager.initRouter(instance);
    }
}
