package com.xud.base.core;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

/**
 * Created by xud on 2018/4/10.
 */

public abstract class BaseDataBindingActivity<T extends ViewDataBinding> extends BaseActivity {

    protected T mBinding;

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, getLayoutRes());
        onCreated(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        mBinding.unbind();
        super.onDestroy();
    }

    @LayoutRes
    protected abstract int getLayoutRes();

    protected void onCreated(Bundle savedInstanceState) {
    }
}
