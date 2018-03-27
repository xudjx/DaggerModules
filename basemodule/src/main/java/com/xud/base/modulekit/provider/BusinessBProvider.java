package com.xud.base.modulekit.provider;

/**
 * Created by xud on 2017/7/22.
 *
 * 这个是BusinessB模块暴露出的接口
 * 使用方式：
 * 1. BusinessB模块初始化的时候需要在BusinessBModuleKit中注册BusinessProvider
 * 2. 其他模块需要使用接口的时候从BusinessBModuleKit中获取
 */

public interface BusinessBProvider extends Provider {


    String getBusinessFlag();
}
