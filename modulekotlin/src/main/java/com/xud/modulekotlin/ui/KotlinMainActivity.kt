package com.xud.modulekotlin.ui

import android.os.Bundle

import com.xud.base.core.BaseActivity
import com.xud.modulekotlin.R

/**
 * Created by xud on 2018/4/9.
 */

class KotlinMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_container)
        val fm = supportFragmentManager
        fm.beginTransaction().replace(R.id.fragment_container, KotlinMainFragment()).commitAllowingStateLoss()
    }
}
