package com.xud.modulea.di;

import com.xud.base.di.BaseViewModule;
import com.xud.base.di.PerView;
import com.xud.modulea.ui.BusinessAMainFragment;

import dagger.Component;

/**
 * Created by xud on 2017/7/5.
 */

@PerView
@Component(dependencies = BusinessAAppComponent.class, modules = BaseViewModule.class)
public interface ActivityComponent {

    void inject(BusinessAMainFragment fragment);
}
