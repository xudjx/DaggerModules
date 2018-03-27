package com.xud.base.di;

import com.xud.base.Constants;
import com.xud.base.net.HttpApiService;
import com.xud.base.net.RestApi;
import com.xud.base.tools.RxBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xud on 2017/6/10.
 */

@Module
public class SingletonModule {

    @Provides
    @Singleton
    RxBus provideRxBus() {
        return RxBus.getInstance();
    }

    @Provides
    @Singleton
    HttpApiService provideHttpApiService(RestApi restApi) {
        return restApi.retrofitNet(Constants.BASE_URL).create(HttpApiService.class);
    }
}
