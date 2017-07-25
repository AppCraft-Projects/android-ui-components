package com.go.jinglesample.widget;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.StateListDrawable;

public final class TintedBitmapDrawable extends BitmapDrawable {
    private int tint;
    private int alpha;

    public static TintedBitmapDrawable fromColor(Resources res, int resId, int color) {
        return new TintedBitmapDrawable(res, resId, color);
    }

    public static TintedBitmapDrawable fromColor(Resources res, Bitmap bitmap, int color) {
        return new TintedBitmapDrawable(res, bitmap, color);
    }

    public static TintedBitmapDrawable fromColorRes(Resources res, int resId, int colorResId) {
        return new TintedBitmapDrawable(res, resId, res.getColor(colorResId));
    }

    public static TintedBitmapDrawable fromColorRes(Resources res, Bitmap bitmap, int colorResId) {
        return new TintedBitmapDrawable(res, bitmap, res.getColor(colorResId));
    }

    public static StateListDrawable fromEnabledState(Resources res, int resId, int enabledColorResId, int disabledColorResId) {
        StateListDrawable drawable = new StateListDrawable();
        drawable.addState(new int[]{-16842910}, fromColorRes(res, resId, disabledColorResId));
        drawable.addState(new int[0], fromColorRes(res, resId, enabledColorResId));
        return drawable;
    }

    public static StateListDrawable fromSelectedState(Resources res, int resId, int selectedColorResId, int unSelectedColorResId) {
        StateListDrawable drawable = new StateListDrawable();
        drawable.addState(new int[]{-16842913}, fromColorRes(res, resId, unSelectedColorResId));
        drawable.addState(new int[0], fromColorRes(res, resId, selectedColorResId));
        return drawable;
    }

    public static StateListDrawable fromActivatedState(Resources res, int resId, int activatedColorResId, int deactivatedColorResId) {
        StateListDrawable drawable = new StateListDrawable();
        drawable.addState(new int[]{16843518}, fromColorRes(res, resId, activatedColorResId));
        drawable.addState(new int[0], fromColorRes(res, resId, deactivatedColorResId));
        return drawable;
    }

    public TintedBitmapDrawable(Resources res, Bitmap bitmap, int tint) {
        super(res, bitmap);
        this.tint = tint;
    }

    public TintedBitmapDrawable(Resources res, int resId, int tint) {
        super(res, BitmapFactory.decodeResource(res, resId));
        this.tint = tint;
        this.alpha = Color.alpha(tint);
    }

    public void setTint(int tint) {
        this.tint = tint;
        this.alpha = Color.alpha(tint);
    }

    public void draw(Canvas canvas) {
        Paint paint = this.getPaint();
        if(paint.getColorFilter() == null) {
            paint.setColorFilter(new LightingColorFilter(this.tint, 0));
            paint.setAlpha(this.alpha);
        }

        super.draw(canvas);
    }
}
