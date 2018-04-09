package com.xud.app;

import com.xud.base.BaseApplication;
import com.xud.componentlib.router.Router;
import com.xud.componentlib.router.ui.RouterManager;

/**
 * Created by xud on 2018/3/27.
 */

public class MainApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        Router.registerComponent("com.xud.modulea.BusinessAAppLike");
        Router.registerComponent("com.xud.moduleb.BusinessBAppLike");
        Router.registerComponent("com.xud.modulekotlin.ModuleKotlinAppLike");
    }

    @Override
    public void initComponentDi() {

    }

    @Override
    public void registerRouter() {
        RouterManager.initRouter(instance);
    }
}
