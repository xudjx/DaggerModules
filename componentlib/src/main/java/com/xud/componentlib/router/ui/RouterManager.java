package com.xud.componentlib.router.ui;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by xud on 2017/6/28.
 */

public class RouterManager {


    /**
     * Route Path
     */
    public static final String URL_MAIN_BUSINESS_A = "/businessAModule/main";
    public static final String URL_MAIN_BUSINESS_B = "/businessBModule/main";

    /**
     * Module application name
     */
    public static final String MODULE_A = "modulea";
    public static final String MODULE_B = "moduleb";

    public static void initRouter(Application application) {
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(application);
    }

    public static void goHome(Context context) {
        String packageName = context.getApplicationInfo().packageName;
        String suffix = packageName.substring(packageName.lastIndexOf(".") + 1);
        switch (suffix) {
            case MODULE_A:
                ARouter.getInstance().build(URL_MAIN_BUSINESS_A).navigation();
                break;
            case MODULE_B:
                ARouter.getInstance().build(URL_MAIN_BUSINESS_B).navigation();
                break;
        }
    }

    public static void newPage(String path) {
        ARouter.getInstance().build(path).navigation();
    }

}
