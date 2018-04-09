package com.xud.modulekotlin

import com.xud.base.BaseApplication
import com.xud.componentlib.router.Router
import com.xud.componentservice.modulekotlin.KotlinService
import com.xud.modulekotlin.serviceimpl.KotlinServiceImpl

/**
 * Created by xud on 2018/4/9.
 */

class KotlinApplication : BaseApplication() {

    override fun initComponentDi() {

    }

    override fun registerRouter() {
        Router.getInstance().addService(KotlinService::class.java, KotlinServiceImpl())
    }
}
