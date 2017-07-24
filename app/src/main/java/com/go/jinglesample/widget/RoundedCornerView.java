package com.go.jinglesample.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import com.go.jinglesample.R;

public final class RoundedCornerView extends View {
    private float[] corners;
    private int topLeftCornerRadius;
    private int topRightCornerRadius;
    private int bottomRightCornerRadius;
    private int bottomLeftCornerRadius;

    public RoundedCornerView(final Context context) {
        super(context);
    }

    public RoundedCornerView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        readAttributes(context, attrs);
        init();
    }

    public RoundedCornerView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        readAttributes(context, attrs);
        init();
    }

    private void init() {
        corners = new float[]{
                topLeftCornerRadius,
                topLeftCornerRadius,
                topRightCornerRadius,
                topRightCornerRadius,
                bottomRightCornerRadius,
                bottomRightCornerRadius,
                bottomLeftCornerRadius,
                bottomLeftCornerRadius
        };
    }

    private void readAttributes(final Context context, final AttributeSet attrs) {
        final TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.RoundedCornerView, 0, 0);
        try {
            topLeftCornerRadius = Math.round(ta.getDimension(R.styleable.RoundedCornerView_topLeftCornerRadius, 0.0f));
            topRightCornerRadius = Math.round(ta.getDimension(R.styleable.RoundedCornerView_topRightCornerRadius, 0.0f));
            bottomRightCornerRadius = Math.round(ta.getDimension(R.styleable.RoundedCornerView_bottomRightCornerRadius, 0.0f));
            bottomLeftCornerRadius = Math.round(ta.getDimension(R.styleable.RoundedCornerView_bottomLeftCornerRadius, 0.0f));
        } finally {
            ta.recycle();
        }
    }

    public void setCorners(final float topLeftRadius, final float topRightRadius, final float bottomRightRadius, final float bottomLeftRadius) {
        corners = new float[] {
                topLeftRadius,
                topLeftRadius,
                topRightRadius,
                topRightRadius,
                bottomRightRadius,
                bottomRightRadius,
                bottomLeftRadius,
                bottomLeftRadius
        };
    }

    public void setBitmap(final Bitmap bitmap) {
        if (bitmap != null) {
            setBackground(new RoundedCornerDrawable(bitmap, 0, corners));
        } else {
            setBackgroundColor(Color.TRANSPARENT);
        }
    }
}
