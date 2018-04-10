package com.xud.baselib.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DimenRes;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Target;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Max on 16/7/28.
 */
public class PicassoHelperUtils {

    public static final int IMAGE_CORNER_RADIUS_SMALL = 5;
    private static final String PICASSO_CACHE = "picasso-cache";

    private static Context mContext;

    private static Picasso instance;

    public static String URL_STATIC_BASE = "";

    public static void init(Context context) {
        mContext = context;
        instance = new Picasso.Builder(context).build();
        Picasso.setSingletonInstance(instance);
    }


    public static void displayImage(String url, ImageView view) {
        if (!TextUtils.isEmpty(url)) {
            Picasso.get().load(parseUri(url)).fit().centerInside().into(view);
        }
    }

    public static void displayImage(String url, ImageView view, int defaultIconRes) {
        if (!TextUtils.isEmpty(url)) {
            Picasso.get().load(parseUri(url)).fit().centerInside().placeholder(defaultIconRes).error(defaultIconRes)
                    .into(view);
        } else {
            view.setImageResource(defaultIconRes);
        }
    }

    public static void displayImage(String url, ImageView view, Drawable defaultIconRes) {
        if (!TextUtils.isEmpty(url)) {
            Picasso.get().load(parseUri(url)).fit().centerInside().placeholder(defaultIconRes).error(defaultIconRes)
                    .into(view);
        } else {
            view.setImageDrawable(defaultIconRes);
        }
    }

    public static void displayImage(ImageView view, String url, Drawable defaultIconRes, int width, int height, boolean
            centerCrop) {
        if (!TextUtils.isEmpty(url)) {
            final RequestCreator creator = Picasso.get().load(parseUri(url));
            if (defaultIconRes != null) {
                creator.placeholder(defaultIconRes).error(defaultIconRes);
            }
            if (width > 0 && height > 0) {
                creator.resize(width, height);
            }
            if (centerCrop) {
                creator.centerCrop();
            }
            creator.into(view);
        } else {
            view.setImageDrawable(defaultIconRes);
        }
    }

    public static void loadImage(String url, Drawable defaultIconRes, int width, int height, boolean centerCrop, Target target) {
        if (!TextUtils.isEmpty(url)) {
            final RequestCreator creator = Picasso.get().load(parseUri(url));

            if (defaultIconRes != null) {
                creator.placeholder(defaultIconRes);
            }

            if (defaultIconRes != null) {
                creator.error(defaultIconRes);
            }

            if (width > 0 && height > 0) {
                creator.resize(width, height);
            }
            if (centerCrop) {
                creator.centerCrop();
            }
            creator.into(target);
        }
    }

    public static void displayImageDimen(ImageView view, String url, Drawable defaultIconRes, @DimenRes int widthDimen,
                                         @DimenRes int heightDimen, boolean centerCrop) {
        if (!TextUtils.isEmpty(url)) {
            final RequestCreator creator = Picasso.get().load(parseUri(url)).placeholder(defaultIconRes).error
                    (defaultIconRes).resizeDimen(widthDimen, heightDimen);
            if (centerCrop) {
                creator.centerCrop();
            }
            creator.into(view);
        } else {
            view.setImageDrawable(defaultIconRes);
        }
    }

    public static void downloadImages(List<String> urls, DownloadCallBack callBack) {
        final Queue<String> queue = new LinkedList();
        for (String imageUrl : urls) {
            queue.add(imageUrl);
        }
        ImageView imageView = new ImageView(mContext);
        downloadImage(queue, imageView, callBack);
    }

    private static void downloadImage(Queue queue, ImageView imageView, DownloadCallBack callBack) {
        if (queue.isEmpty()) {
            callBack.success();
        }
        Picasso.get().load((String) queue.poll()).into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                downloadImage(queue, imageView, callBack);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }

    private static Uri parseUri(String url) {
        if (new File(url).exists()) {
            return Uri.fromFile(new File(url));
        } else if (url.startsWith("content://")) {
            return Uri.parse(url);
        } else {
            return Uri.parse(getRealImageUrl(url));
        }
    }

    private static String getRealImageUrl(String url) {
        if (url != null && url.startsWith("/")) {
            return URL_STATIC_BASE + url;
        }
        return url;
    }

    public interface DownloadCallBack {
        void success();

        void failed();
    }
}
