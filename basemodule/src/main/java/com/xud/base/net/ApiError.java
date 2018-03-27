package com.xud.base.net;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.net.ConnectException;

import retrofit2.HttpException;

/**
 * Created by xuwd on 16/7/19.
 */
public class ApiError extends CommonException {

    /**
     * 定义所有的错误码
     */
    public static final int ERROR_TYPE_UNKNOWN = -1;
    public static final int ERROR_TYPE_CONNECT = -2; // 连接超时
    public static final int ERROR_TYPE_HTTP = -3; // 连接超时

    public static final int ERROR_BAD_QEQUEST = 400; // bad request and check error code
    public static final int ERROR_UNAUTHORIZED = 401;
    public static final int ERROR_FORBIDDEN = 403;
    

    public Error error;
    public String message;
    public int code;
    public int errorType;

    public ApiError() {
    }

    public ApiError(Throwable e) {
        if (e instanceof HttpException) {
            this.errorType = ERROR_TYPE_HTTP;
            this.code = ((HttpException) e).code();
            this.message = ((HttpException) e).message();
            try {
                String error = ((HttpException) e).response().errorBody().string();
                Logger.e("value %s", error);
                parseErrorBody(error);
            } catch (IOException e1) {
                Logger.e("get message %s", e1);
            } catch (JsonSyntaxException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } else if (e instanceof RuntimeException) {
            RuntimeException exception = (RuntimeException) e;
            // todo
        } else if (e instanceof ConnectException) {
            this.errorType = ERROR_TYPE_CONNECT;
            this.message = e.getMessage();
        } else {
            this.errorType = ERROR_TYPE_UNKNOWN;
            this.message = e.getMessage();
            Logger.e("error %s", this);
        }
    }

    private void parseErrorBody(String errorBody) {
        Logger.e("error %s", errorBody);
        if (TextUtils.isEmpty(errorBody)) {
            return;
        }
        // TODO: 2018/3/26
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public class Error {
        public int code;
        public String message;
        public String extra;
    }
}
