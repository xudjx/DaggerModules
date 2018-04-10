package com.xud.modulea.ui;

import android.os.Bundle;

import com.xud.base.core.BaseDataBindingActivity;
import com.xud.modulea.R;
import com.xud.modulea.databinding.ModuleAFragmentDatabandBinding;

/**
 * Created by xud on 2018/4/10.
 */

public class ModuleADatabandingActivity extends BaseDataBindingActivity<ModuleAFragmentDatabandBinding> {

    @Override
    protected void onCreated(Bundle savedInstanceState) {
        super.onCreated(savedInstanceState);
        mBinding.setViewModel(new ViewModel());
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.module_a_fragment_databand;
    }

    public class ViewModel {

    }
}
