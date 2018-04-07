package com.xud.componentservice.modulea;

import android.support.v4.app.Fragment;

import com.xud.componentservice.CoreService;

/**
 * Created by xud on 2017/7/22.
 */

public interface BusinessAService extends CoreService {

    String getBusinessFlag();

    Fragment getMainFragment();
}
