package com.xud.modulea.di;

import com.xud.base.di.BaseViewModule;
import com.xud.base.di.PerView;
import com.xud.modulea.ui.ModuleADatabandingActivity;

import dagger.Component;

/**
 * Created by xud on 2018/4/10.
 */

@PerView
@Component(dependencies = BusinessAAppComponent.class, modules = BaseViewModule.class)
public interface DJDataBandingComponent extends android.databinding.DataBindingComponent {

    void inject(ModuleADatabandingActivity activity);
}
