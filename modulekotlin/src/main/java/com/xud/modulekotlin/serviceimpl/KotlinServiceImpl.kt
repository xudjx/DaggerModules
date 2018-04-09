package com.xud.modulekotlin.serviceimpl

import android.support.v4.app.Fragment

import com.xud.componentservice.modulekotlin.KotlinService
import com.xud.modulekotlin.ui.KotlinMainFragment

/**
 * Created by xud on 2018/4/9.
 */

class KotlinServiceImpl : KotlinService {

    override fun getMainFragment(): Fragment? {
        return KotlinMainFragment()
    }
}
