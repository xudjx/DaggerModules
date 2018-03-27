package com.xud.base.modulekit;

import com.xud.base.di.AppComponent;

/**
 * Created by xud on 2017/7/2.
 *
 * 每个模块的AppComponent初始化接口
 */

public interface AppModuleComponentDelegate {
    AppComponent initAppComponent();
}
