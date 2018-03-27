package com.xud.base.net;

import android.content.Context;
import android.os.Process;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.google.gson.GsonBuilder;
import com.xud.base.tools.NetWorkCheckUtils;
import com.xud.base.tools.RxBus;
import com.xud.base.tools.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xud on 2/15/16.
 */
@Singleton
public final class RestApi {
    public static final long CONNECT_TIME_OUT = 30L;
    public static final long READ_TIME_OUT = 30L;
    public static final long WRITE_TIME_OUT = 30L;

    public static final boolean DEBUG = true;

    private Context context;
    private RxBus rxBus;

    private OkHttpClient mOkHttpClient;

    public static final String HEAD_PARAMS = "params";
    public static final String HEAD_APP_ID = "Request-App-Id";
    public static final String HEAD_TIME_STAMP = "Request-Timestamp";
    public static final String HEAD_SIGNATURE = "Request-Signature";
    public static final String HEAD_CACHE_CONTROL = "Cache-Control";
    public static final String PARAMS_NO_CACHE = "no-cache";

    public static final int MAX_POOL_SIZE = 10;
    public static final int INITIAL_CORE_POOL_SIZE = 1;
    public static final long KEEP_ALIVE_TIME = 60L;
    public static final int CORE_POOL_SIZE = Math.min(MAX_POOL_SIZE, Runtime.getRuntime().availableProcessors() + 1);

    public static final ThreadPoolExecutor HTTP_EXECUTOR = new ThreadPoolExecutor(INITIAL_CORE_POOL_SIZE, MAX_POOL_SIZE,
            KEEP_ALIVE_TIME, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), r -> new Thread(() -> {
        Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
        r.run();
    }, "DaJiaHttp-Idle"));

    @Inject
    public RestApi(Context context, RxBus rxBus) {
        this.context = context;
        this.rxBus = rxBus;
    }

    /**
     * 指定 RxJavaCallAdapterFactory 为 Call Adapter
     */
    public Retrofit retrofitNet(String url) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(setupClient())
                .build();
    }

    /**
     * 不指定Call Adapter。 适用于 SyncApiService
     */
    public Retrofit retrofitNoRxJavaNet(String url) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .client(setupClient())
                .build();
    }

    public OkHttpClient setupClient() {
        if (mOkHttpClient == null) {
            HttpLoggingInterceptor loggingInterceptor = getHttpLoggingInterceptor();

            mOkHttpClient = new OkHttpClient.Builder()
                    .dispatcher(new Dispatcher(HTTP_EXECUTOR))
                    .cache(getHttpCache())
                    .addInterceptor(loggingInterceptor)
                    .addInterceptor(getCacheInterceptor())
                    .addNetworkInterceptor(getCacheInterceptor())
                    .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
                    .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                    .writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS)
                    .build();
        }

        return mOkHttpClient;
    }

    public Interceptor getCacheInterceptor() {
        return new Interceptor() {

            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                final String method = request.method();
                final String cacheControl = request.header(HEAD_CACHE_CONTROL);

                if (!NetWorkCheckUtils.isNetAvailable(context) && needCache(method, cacheControl)) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }

                Response originalResponse = chain.proceed(request);

                if (NetWorkCheckUtils.isNetAvailable(context) && needCache(method, cacheControl)) {

                    CacheControl responseCacheControl = originalResponse.cacheControl();
                    if (responseCacheControl == null
                            || responseCacheControl.noStore()
                            || responseCacheControl.noCache()
                            || responseCacheControl.mustRevalidate()
                            || responseCacheControl.maxAgeSeconds() == 0) {
                        return originalResponse.newBuilder()
                                .header("Cache-Control", "public, max-age=" + 1)
                                .build();
                    }
                }

                return originalResponse;
            }

            private boolean needCache(String method, String cacheControl) {
                return !TextUtils.isEmpty(method)
                        && method.toUpperCase().equals("GET")
                        && !StringUtils.equals(cacheControl, PARAMS_NO_CACHE);
            }
        };
    }

    public Cache getHttpCache() {
        File httpCacheDirectory = new File(context.getCacheDir(), "responses");
        Cache cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);
        return cache;
    }

    /**
     * 设置OkHttp的日志信息
     */
    @NonNull
    private HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        HttpLoggingInterceptor.Level logLevel = DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.BASIC;
        loggingInterceptor.setLevel(logLevel);
        return loggingInterceptor;
    }
}