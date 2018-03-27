package com.xud.modulea.di;

import com.xud.base.di.AppComponent;
import com.xud.base.di.AppScope;
import com.xud.base.di.BaseAppComponent;
import com.xud.base.tools.RxBus;
import com.xud.modulea.net.BusinessAApi;

import dagger.Component;

/**
 * Created by xud on 2017/6/10.
 *
 * 以AppComponent标识的Component需要保证注入的实例时全局单例的，
 * 经过测试，该注入方式可以保证LoginAppComponent 和 BaseAppComponent 获取到的实例是一致的，比如分别通过这两个注入获取到的 rxBus实例一样
 */
@AppScope
@Component(dependencies = BaseAppComponent.class, modules = {BusinessAModule.class})
public interface BusinessAAppComponent extends AppComponent {

    RxBus rxBus();

    BusinessAApi businessAApi();
}
