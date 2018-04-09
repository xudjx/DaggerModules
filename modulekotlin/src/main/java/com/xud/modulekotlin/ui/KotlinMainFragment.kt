package com.xud.modulekotlin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import com.xud.base.core.BaseFragment
import com.xud.componentlib.router.ui.RouterManager
import com.xud.modulekotlin.R

/**
 * Created by xud on 2018/4/9.
 */

class KotlinMainFragment : BaseFragment() {

    private var detailView: TextView? = null
    private var jumpBtn: Button? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.module_kotlin_fragment_main, container, false)
        detailView = view.findViewById(R.id.detail)
        jumpBtn = view.findViewById(R.id.jump)
        initView()
        return view
    }

    private fun initView() {
        detailView!!.text = "This is kotlin test page"
        jumpBtn!!.setOnClickListener { RouterManager.newPage(RouterManager.URL_MAIN_BUSINESS_A) }
    }
}
