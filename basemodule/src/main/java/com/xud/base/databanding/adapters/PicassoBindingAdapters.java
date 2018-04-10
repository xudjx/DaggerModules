package com.xud.base.databanding.adapters;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.xud.baselib.utils.PicassoHelperUtils;

/**
 * Created by Zwei on 11/23/15.
 */
public class PicassoBindingAdapters {

    @BindingAdapter(value = {"imageUrl"})
    public static void loadImage(ImageView view, String url) {
        PicassoHelperUtils.displayImage(url, view);
    }

    @BindingAdapter(value = {"imageUrl", "imageError"})
    public static void loadImage(ImageView view, String url, Drawable error) {
        PicassoHelperUtils.displayImage(url, view, error);
    }

    @BindingAdapter(value = {"imageUrl", "imageError", "imageWidth", "imageHeight", "imageCenterCrop"}, requireAll = false)
    public static void loadImage(ImageView view, String url, Drawable error, int width, int height, boolean centerCrop) {
        PicassoHelperUtils.displayImage(view, url, error, width, height, centerCrop);
    }
}
