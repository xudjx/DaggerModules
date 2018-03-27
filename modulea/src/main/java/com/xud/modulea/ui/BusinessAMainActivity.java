package com.xud.modulea.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xud.base.core.BaseActivity;
import com.xud.modulea.R;

/**
 * Created by xud on 2018/3/25.
 */

@Route(path = "/businessAModule/main")
public class BusinessAMainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.fragment_container, new BusinessAMainFragment()).commitAllowingStateLoss();
    }
}
