package com.erikkramli.androidexamples.api.util;

import android.util.Log;

public final class PageNumberParser {

    private static final String TAG = PageNumberParser.class.getSimpleName();

    public static int parse(String source) {
        try {
            return Integer.parseInt(source.replaceAll("[\\D]", ""));
        } catch (NumberFormatException e) {
            Log.e(TAG, e.getMessage());
            return -1;
        }
    }

    private PageNumberParser() {}
}
