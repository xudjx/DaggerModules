package com.xud.modulea.ui;

import com.xud.base.core.BaseFragment;
import com.xud.base.di.BaseViewModule;
import com.xud.base.modulekit.BusinessAModuleKit;
import com.xud.modulea.di.ActivityComponent;
import com.xud.modulea.di.BusinessAAppComponent;
import com.xud.modulea.di.DaggerActivityComponent;

/**
 * Created by xud on 2018/3/25.
 */

public class BaseBusinessAFragment extends BaseFragment {

    private ActivityComponent activityComponent;

    public ActivityComponent activityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .businessAAppComponent((BusinessAAppComponent) BusinessAModuleKit.getInstance().getComponent())
                    .baseViewModule(new BaseViewModule(getActivity()))
                    .build();
        }
        return activityComponent;
    }
}
