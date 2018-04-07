package com.xud.modulea.serviceimpl;

import android.support.v4.app.Fragment;

import com.xud.componentservice.modulea.BusinessAService;
import com.xud.modulea.ui.BusinessAMainFragment;

/**
 * Created by xud on 2018/4/7.
 */

public class BusinessAServiceImpl implements BusinessAService {

    @Override
    public String getBusinessFlag() {
        return "com.xud.business.a";
    }

    @Override
    public Fragment getMainFragment() {
        return new BusinessAMainFragment();
    }
}
