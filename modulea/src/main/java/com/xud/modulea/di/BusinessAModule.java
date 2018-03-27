package com.xud.modulea.di;

import com.xud.base.Constants;
import com.xud.base.di.AppScope;
import com.xud.base.net.RestApi;
import com.xud.modulea.net.BusinessAApi;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xud on 2017/6/10.
 */

@Module
public class BusinessAModule {

    @Provides
    @AppScope
    BusinessAApi provideBusinessAApi(RestApi restApi) {
        return restApi.retrofitNet(Constants.BASE_URL).create(BusinessAApi.class);
    }
}
