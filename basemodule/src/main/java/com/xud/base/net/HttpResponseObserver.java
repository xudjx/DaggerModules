package com.xud.base.net;

import com.orhanobut.logger.Logger;
import com.xud.base.tools.RxBus;

import rx.Observer;

/**
 * Created by xud on 2/19/16.
 */
public abstract class HttpResponseObserver<T> implements Observer<T> {

    private RxBus rxBus;

    public HttpResponseObserver() {
    }

    public HttpResponseObserver(RxBus rxBus) {
        this.rxBus = rxBus;
    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        Logger.e(e, "error message : %s", e.getMessage());
        ApiError error = new ApiError(e);
        if (!onError(error)) {
            handleError(error);
        }
    }

    /**
     * 错误处理回调
     *
     * @param error
     * @return true:已经handle, false: 统一handle
     */
    protected boolean onError(ApiError error) {
        return false;
    }

    private void handleError(ApiError error) {
        if (rxBus == null) {
            rxBus = RxBus.getInstance();
        }
        rxBus.post(ApiError.class, error);
    }
}
