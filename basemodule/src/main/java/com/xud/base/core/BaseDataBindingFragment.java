package com.xud.base.core;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xuwd on 16/7/20.
 */
public abstract class BaseDataBindingFragment<T extends ViewDataBinding> extends BaseFragment {

    protected T mBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        mBinding.unbind();
        super.onDestroyView();
    }

    @LayoutRes
    protected abstract int getLayoutRes();
}
