package com.xud.moduleb.di;

import com.xud.base.di.BaseViewModule;
import com.xud.base.di.PerView;
import com.xud.moduleb.ui.BusinessBMainFragment;

import dagger.Component;

/**
 * Created by xud on 2017/7/5.
 */

@PerView
@Component(dependencies = BusinessBAppComponent.class, modules = BaseViewModule.class)
public interface ActivityComponent {

    void inject(BusinessBMainFragment fragment);
}
