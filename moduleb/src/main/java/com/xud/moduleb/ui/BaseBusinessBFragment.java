package com.xud.moduleb.ui;

import com.xud.base.core.BaseFragment;
import com.xud.base.di.BaseViewModule;
import com.xud.base.modulekit.BusinessAModuleKit;
import com.xud.base.modulekit.BusinessBModuleKit;
import com.xud.moduleb.di.ActivityComponent;
import com.xud.moduleb.di.BusinessBAppComponent;
import com.xud.moduleb.di.DaggerActivityComponent;

/**
 * Created by xud on 2018/3/25.
 */

public class BaseBusinessBFragment extends BaseFragment {

    private ActivityComponent activityComponent;

    public ActivityComponent activityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .businessBAppComponent((BusinessBAppComponent) BusinessBModuleKit.getInstance().getComponent())
                    .baseViewModule(new BaseViewModule(getActivity()))
                    .build();
        }
        return activityComponent;
    }
}
