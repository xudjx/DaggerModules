package com.xud.moduleb;

import com.xud.base.BaseApplication;
import com.xud.base.di.AppComponent;
import com.xud.base.modulekit.AppModuleComponentDelegate;
import com.xud.base.modulekit.BaseModuleKit;
import com.xud.base.modulekit.BusinessBModuleKit;
import com.xud.base.route.RouterManager;
import com.xud.moduleb.di.BusinessBAppComponent;
import com.xud.moduleb.di.DaggerBusinessBAppComponent;

/**
 * Created by xud on 2018/3/25.
 */

public class BusinessBApplication extends BaseApplication {

    private AppModuleComponentDelegate componentDelegate = new AppModuleComponentDelegate() {
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
        BusinessBModuleKit.getInstance().init(this, componentDelegate);
    }

    @Override
    public void registerProvider() {
        new BusinessBProviderRegister().regist();
    }

    private void initUtils() {
        RouterManager.initRouter(instance);
    }
}
