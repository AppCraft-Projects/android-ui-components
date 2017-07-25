package com.go.jinglesample.utils;

import android.util.DisplayMetrics;
import android.util.TypedValue;

public class AndroidUtils {
    public static int dpToPx(int dp, DisplayMetrics displayMetrics) {
        return (int) TypedValue.applyDimension(1, (float)dp, displayMetrics);
    }
}
