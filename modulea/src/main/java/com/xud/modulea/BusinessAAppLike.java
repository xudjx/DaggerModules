package com.xud.modulea;

import com.xud.base.di.AppComponent;
import com.xud.base.modulekit.AppModuleComponentDelegate;
import com.xud.base.modulekit.BaseModuleKit;
import com.xud.base.modulekit.BusinessAModuleKit;
import com.xud.componentlib.applicationlike.IApplicationLike;
import com.xud.componentlib.router.Router;
import com.xud.componentservice.modulea.BusinessAService;
import com.xud.modulea.di.BusinessAAppComponent;
import com.xud.modulea.di.DaggerBusinessAAppComponent;
import com.xud.modulea.intercept.ModuleAUIInterCeptor;
import com.xud.modulea.serviceimpl.BusinessAServiceImpl;

/**
 * Created by xud on 2018/4/7.
 */

public class BusinessAAppLike implements IApplicationLike {

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
        Router.getInstance().addService(BusinessAService.class.getSimpleName(), new BusinessAServiceImpl());
        BusinessAModuleKit.getInstance().init(componentDelegate);

        ModuleAUIInterCeptor.isRegister = true;
    }

    @Override
    public void onStop() {
        Router.getInstance().removeService(BusinessAService.class.getSimpleName());

        ModuleAUIInterCeptor.isRegister = false;
    }
}
