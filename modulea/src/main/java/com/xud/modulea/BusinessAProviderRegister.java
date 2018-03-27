package com.xud.modulea;

import com.xud.base.modulekit.BusinessAModuleKit;
import com.xud.base.modulekit.provider.BusinessAProvider;
import com.xud.base.modulekit.provider.ProviderRegister;

/**
 * Created by xud on 2017/7/23.
 */

public class BusinessAProviderRegister implements ProviderRegister {

    private BusinessAProvider businessAProvider = new BusinessAProvider() {
        @Override
        public String getBusinessFlag() {
            return "com.xud.business.a";
        }
    };

    @Override
    public void regist() {
        BusinessAModuleKit.getInstance().registerProvider(businessAProvider);
    }
}
