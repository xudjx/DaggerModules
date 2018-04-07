package com.xud.moduleb.serviceimpl;

import android.support.v4.app.Fragment;

import com.xud.componentservice.moduleb.BusinessBService;
import com.xud.moduleb.ui.BusinessBMainFragment;

/**
 * Created by xud on 2018/4/7.
 */

public class BusinessBServiceImpl implements BusinessBService {

    @Override
    public String getBusinessFlag() {
        return "com.xud.business.b";
    }

    @Override
    public Fragment getMainFragment() {
        return new BusinessBMainFragment();
    }
}
