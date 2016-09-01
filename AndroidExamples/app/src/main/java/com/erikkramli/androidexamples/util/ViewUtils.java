package com.erikkramli.androidexamples.util;

import android.view.View;

public final class ViewUtils {

    public static void visible(View... views) {
        setVisibility(View.VISIBLE, views);
    }

    public static void invisible(View... views) {
        setVisibility(View.INVISIBLE, views);
    }

    public static void gone(View... views) {
        setVisibility(View.GONE, views);
    }

    public static void setVisibility(int flag, View... views) {
        for (View v : views) {
            v.setVisibility(flag);
        }
    }

    private ViewUtils() {}
}
