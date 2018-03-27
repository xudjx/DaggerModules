package com.xud.moduleb.di;

import com.xud.base.Constants;
import com.xud.base.di.AppScope;
import com.xud.base.net.RestApi;
import com.xud.moduleb.net.BusinessBApi;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xud on 2017/6/10.
 */

@Module
public class BusinessBModule {

    @Provides
    @AppScope
    BusinessBApi provideBusinessBApi(RestApi restApi) {
        return restApi.retrofitNet(Constants.BASE_URL).create(BusinessBApi.class);
    }
}
