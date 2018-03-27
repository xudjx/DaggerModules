package com.xud.moduleb;

import com.xud.base.modulekit.BusinessBModuleKit;
import com.xud.base.modulekit.provider.BusinessBProvider;
import com.xud.base.modulekit.provider.ProviderRegister;

/**
 * Created by xud on 2017/7/23.
 */

public class BusinessBProviderRegister implements ProviderRegister {

    private BusinessBProvider businessBProvider = new BusinessBProvider() {
        @Override
        public String getBusinessFlag() {
            return "com.xud.business.b";
        }
    };

    @Override
    public void regist() {
        BusinessBModuleKit.getInstance().registerProvider(businessBProvider);
    }
}
