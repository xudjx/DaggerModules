package com.xud.modulea;

import com.xud.base.BaseApplication;
import com.xud.base.di.AppComponent;
import com.xud.base.modulekit.AppModuleComponentDelegate;
import com.xud.base.modulekit.BaseModuleKit;
import com.xud.base.modulekit.BusinessAModuleKit;
import com.xud.componentlib.router.Router;
import com.xud.componentlib.router.ui.RouterManager;
import com.xud.componentservice.modulea.BusinessAService;
import com.xud.modulea.di.BusinessAAppComponent;
import com.xud.modulea.di.DaggerBusinessAAppComponent;
import com.xud.modulea.serviceimpl.BusinessAServiceImpl;

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
    }

    @Override
    public void initComponentDi() {
        BusinessAModuleKit.getInstance().init(componentDelegate);
    }

    @Override
    public void registerRouter() {
        RouterManager.initRouter(instance);
        Router.getInstance().addService(BusinessAService.class, new BusinessAServiceImpl());
    }
}
