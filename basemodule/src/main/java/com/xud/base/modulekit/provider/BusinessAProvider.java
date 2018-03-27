package com.xud.base.modulekit.provider;

/**
 * Created by xud on 2017/7/22.
 *
 * 这个是BusinessA模块暴露出的接口
 * 使用方式：
 * 1. BusinessA模块初始化的时候需要在BusinessAModuleKit中注册BusinessAProvider
 * 2. 其他模块需要使用接口的时候从BusinessAModuleKit中获取
 */

public interface BusinessAProvider extends Provider {


    String getBusinessFlag();
}
