package com.go.jinglesample.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

public final class RoundedCornerDrawable extends Drawable {
    private final Paint paint;
    private final Path path;
    private final int margin;
    private final float[] corners;

    private BitmapShader bitmapShader;
    private RectF bitmapRect;

    public RoundedCornerDrawable(final Bitmap bitmap, final int margin, final float[] corners) {
        this.margin = margin;
        this.corners = corners;

        bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        bitmapRect = new RectF(0, 0, bitmap.getWidth(), bitmap.getHeight());

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);

        path = new Path();
    }

    public RoundedCornerDrawable(final int color, final int margin, final float[] corners) {
        this.margin = margin;
        this.corners = corners;

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(color);

        path = new Path();
    }

    @Override protected void onBoundsChange(final Rect bounds) {
        if (bitmapShader != null && bitmapRect != null) {
            final Matrix matrix = new Matrix();
            final RectF rect = new RectF(bounds);
            final float bitmapRatio = bitmapRect.width() / bitmapRect.height();
            final float ratio = bounds.width() / (float) bounds.height();
            if (bitmapRatio > ratio) {
                final float scale = (bitmapRatio - ratio) / 2f;
                rect.inset(-rect.width() * scale, -rect.height() * scale);
            }
            matrix.setRectToRect(bitmapRect, rect, Matrix.ScaleToFit.CENTER);
            bitmapShader.setLocalMatrix(matrix);
        }
        final RectF viewRect = new RectF(margin, margin, bounds.width() - margin, bounds.height() - margin);
        path.reset();
        path.addRoundRect(viewRect, corners, Path.Direction.CW);
    }

    @Override public void draw(final Canvas canvas) {
        canvas.drawPath(path, paint);
    }

    @Override public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override public void setAlpha(final int alpha) {
        paint.setAlpha(alpha);
    }

    @Override public void setColorFilter(final ColorFilter cf) {
        paint.setColorFilter(cf);
    }
}
