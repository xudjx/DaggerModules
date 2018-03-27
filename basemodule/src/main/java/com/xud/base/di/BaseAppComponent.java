package com.xud.base.di;

import com.xud.base.net.HttpApiService;
import com.xud.base.net.RestApi;
import com.xud.base.tools.RxBus;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by xud on 2017/7/2.
 */

@Singleton
@Component(modules = {AppModule.class, SingletonModule.class})
public interface BaseAppComponent {

    RestApi restApi();

    RxBus rxBus();

    HttpApiService apiService();
}
