package com.xud.base.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xud on 2017/6/14.
 */

@Module(includes = SingletonModule.class)
public class AppModule {
    private final Application application;

    public AppModule(Application app) {
        application = app;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return application;
    }
}
