package com.xud.base.di;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xud on 2/27/16.
 */
@Module
public class BaseViewModule {

    private final Activity activity;

    public BaseViewModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerView
    Activity provideActivity() {
        return this.activity;
    }
}
