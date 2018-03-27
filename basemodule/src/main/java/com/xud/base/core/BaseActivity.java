package com.xud.base.core;

import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xud.base.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xud on 2/27/16.
 * <p>
 * BaseActivity: 基本的UI在此处进行统一处理， 比如 AppBar，BackListener等
 */
public class BaseActivity extends AbstractActivity {
    public static final int RESULT_DELETE = 2;
    public static final int RESULT_QR_SUCCESS = 3;
    public static final int RESULT_EDIT = 5;

    @Nullable
    @BindView(R2.id.toolbar)
    protected Toolbar toolbar;

    @Nullable
    @BindView(R2.id.title)
    protected TextView titleTextView;

    private CharSequence mTitle;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        setup();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        setup();
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        setup();
    }

    private void setup() {
        ButterKnife.bind(this);
        installToolbar2Actionbar();
        setupActionBar();
        setupTitle();
    }

    @Override
    public void setSupportActionBar(@Nullable Toolbar toolbar) {
        super.setSupportActionBar(toolbar);
        this.toolbar = toolbar;
    }

    private void installToolbar2Actionbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    public void setupActionBar() {
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }

    private void setupTitle() {
        if (titleTextView != null) {
            titleTextView.setText(mTitle);
            titleTextView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        setupTitle();
    }

    public void setTitleDrawable(@DrawableRes int left, @DrawableRes int top, @DrawableRes int right, @DrawableRes int bottom, int padding) {
        if(titleTextView != null) {
            titleTextView.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
            titleTextView.setCompoundDrawablePadding(padding);
        }
    }

    public void setTitleClickListener(View.OnClickListener clickListener) {
        if(titleTextView != null && clickListener != null ) {
            titleTextView.setOnClickListener(clickListener);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void setHomeAsUpIndicator(@DrawableRes int resId) {
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(resId);
        }
    }

    public void setHomeAsUpIndicator(@NonNull Drawable drawable) {
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(drawable);
        }
    }

    public void setHomeAsUpIndicator(boolean enabled) {
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(enabled);
        }
    }

    public void setTitleView(View titleView) {
        if (titleView != null && titleView instanceof TextView) {
            this.titleTextView = (TextView) titleView;
        }
    }

    public void onBackKeyListener() {
        onBackPressed();
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public CharSequence getToolBarTitle() {
        return mTitle;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onBackKeyListener();
        }
        return false;
    }
}
