package com.xud.modulea;

import com.xud.base.BaseApplication;
import com.xud.base.di.AppComponent;
import com.xud.base.modulekit.AppModuleComponentDelegate;
import com.xud.base.modulekit.BaseModuleKit;
import com.xud.base.modulekit.BusinessAModuleKit;
import com.xud.base.route.RouterManager;
import com.xud.modulea.di.BusinessAAppComponent;
import com.xud.modulea.di.DaggerBusinessAAppComponent;

/**
 * Created by xud on 2018/3/25.
 */

public class BusinessAApplication extends BaseApplication {

    private AppModuleComponentDelegate componentDelegate = new AppModuleComponentDelegate() {
        @Override
        public AppComponent initAppComponent() {
            BusinessAAppComponent appComponent = DaggerBusinessAAppComponent.builder()
                    .baseAppComponent(BaseModuleKit.getInstance().getComponent())
                    .build();
            return appComponent;
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        initUtils();
        BusinessAModuleKit.getInstance().init(this, componentDelegate);
    }

    @Override
    public void registerProvider() {
        new BusinessAProviderRegister().regist();
    }

    private void initUtils() {
        RouterManager.initRouter(instance);
    }
}
