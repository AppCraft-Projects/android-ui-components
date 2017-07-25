package com.go.jinglesample.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class AndroidUtils {
    public static int dpToPx(int dp, DisplayMetrics displayMetrics) {
        return (int) TypedValue.applyDimension(1, (float)dp, displayMetrics);
    }

    public static String getVersionName(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (Exception var2) {
            return "";
        }
    }
}
