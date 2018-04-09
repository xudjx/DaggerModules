package com.xud.modulekotlin

import com.xud.componentlib.applicationlike.IApplicationLike
import com.xud.componentlib.router.Router
import com.xud.componentservice.modulekotlin.KotlinService
import com.xud.modulekotlin.serviceimpl.KotlinServiceImpl

/**
 * Created by xud on 2018/4/9.
 */

class ModuleKotlinAppLike : IApplicationLike {

    override fun onCreate() {
        Router.getInstance().addService(KotlinService::class.java, KotlinServiceImpl())
    }

    override fun onStop() {
        Router.getInstance().removeService(KotlinService::class.java)
    }
}
