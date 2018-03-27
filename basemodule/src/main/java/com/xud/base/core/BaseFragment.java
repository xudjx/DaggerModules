package com.xud.base.core;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.xud.base.R;
import com.xud.base.di.BaseViewComponent;
import com.xud.base.di.BaseViewModule;
import com.xud.base.di.DaggerBaseViewComponent;

/**
 * Created by xud on 2/27/16.
 */
public class BaseFragment extends Fragment {

    protected Context mContext;

    private BaseViewComponent mBaseViewComponent;

    public BaseViewComponent component() {
        if (mBaseViewComponent == null) {
            mBaseViewComponent = DaggerBaseViewComponent.builder()
                    .baseViewModule(new BaseViewModule(getActivity()))
                    .build();
        }
        return mBaseViewComponent;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        component().inject(this);
        setHasOptionsMenu(true);
    }

    public void setTitle(int titleId) {
        getBaseActivity().setTitle(titleId);
    }

    public void setTitle(CharSequence title) {
        getActivity().setTitle(title);
    }

    public void setTitleDrawable(@DrawableRes int left, @DrawableRes int top, @DrawableRes int right, @DrawableRes int bottom, int padding) {
        if(getBaseActivity() != null) {
            getBaseActivity().setTitleDrawable(left, top, right, bottom, padding);
        }
    }

    public void setTitleClickListener(View.OnClickListener clickListener) {
        if(getBaseActivity() != null) {
            getBaseActivity().setTitleClickListener(clickListener);
        }
    }

    public View getTitleView() {
        return getBaseActivity().titleTextView;
    }

    public void setHomeAsUpIndicator(@DrawableRes int res) {
        BaseActivity activity = getBaseActivity();
        if (activity != null) {
            activity.setHomeAsUpIndicator(res);
        }
    }

    public void setHomeAsUpIndicator(@NonNull Drawable drawable) {
        BaseActivity activity = getBaseActivity();
        if (activity != null) {
            activity.setHomeAsUpIndicator(drawable);
        }
    }

    public void setHomeAsUpIndicator(boolean enabled) {
        BaseActivity activity = getBaseActivity();
        if (activity != null) {
            activity.setHomeAsUpIndicator(enabled);
        }
    }

    public void supportInvalidateOptionsMenu() {
        if (getActivity() != null) {
            getActivity().supportInvalidateOptionsMenu();
        }
    }

    public BaseActivity getBaseActivity() {
        return getActivity() != null && getActivity() instanceof BaseActivity ? (BaseActivity) getActivity() : null;
    }

    public Application getApplication() {
        return getActivity().getApplication();
    }

    public Toolbar getActivityToolbar() {
        final BaseActivity activity = getBaseActivity();
        return activity != null ? activity.getToolbar() : null;
    }

    protected void setSupportActionBar(Toolbar toolbar) {
        if (getActivityToolbar() != null) {
            getActivityToolbar().setVisibility(View.GONE);
        }

        final BaseActivity activity = getBaseActivity();
        if (toolbar != null && activity != null) {
            activity.setSupportActionBar(toolbar);
            activity.setupActionBar();
            activity.setTitleView(toolbar.findViewById(R.id.title));
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mContext == null) {
            mContext = getContext();
        }
    }

    @Override
    public Context getContext() {
        return super.getContext() == null ? mContext : super.getContext();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public final String getStringIfAdded(@StringRes int resId) {
        return isAdded() ? getResources().getString(resId) : "";
    }

    public final String getStringIfAdded(@StringRes int resId, Object... formatArgs) {
        return isAdded() ? getResources().getString(resId, formatArgs) : "";
    }

}
