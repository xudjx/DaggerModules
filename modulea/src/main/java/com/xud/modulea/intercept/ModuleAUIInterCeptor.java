package com.xud.modulea.intercept;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.xud.baselib.MainLooper;
import com.xud.componentlib.router.ui.RouterManager;

/**
 * Created by xud on 2018/4/8.
 */

@Interceptor(priority = 1, name = "moduleA组件拦截器")
public class ModuleAUIInterCeptor implements IInterceptor {

    public static boolean isRegister;
    Context mContext;

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        if (isRegister) {
            callback.onContinue(postcard);
        } else if (RouterManager.URL_MAIN_BUSINESS_A.equals(postcard.getPath())) {
            MainLooper.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(mContext, "moduleA组件组件已经卸载", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public void init(Context context) {
        mContext = context;
    }
}
