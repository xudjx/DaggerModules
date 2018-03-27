package com.xud.base.di;

import android.app.Activity;

import com.xud.base.core.AbstractActivity;
import com.xud.base.core.BaseFragment;

import dagger.Component;

/**
 * Created by xud on 2/27/16.
 *
 * 使用原则：
 * 1. BaseViewComponent最好不要被其他module以dependencies方式进行关联
 * 2. 其他module中应该应用BaseViewModule 而不是 BaseViewComponent
 */
@PerView
@Component(modules = BaseViewModule.class)
public interface BaseViewComponent {

    Activity activity();

    void inject(AbstractActivity activity);

    void inject(BaseFragment fragment);
}
