package com.go.jinglesample.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class PercentProgressBar extends ProgressBar {

    private Paint textPaint;

    public PercentProgressBar(Context context) {
        super(context);
        init(context);
    }

    public PercentProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PercentProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(Color.WHITE);
        textPaint.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setLinearText(true);
    }

    @Override protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String textToDraw = getProgress() + "%";

        textPaint.setTextSize(2 * (canvas.getHeight() / 3));
        float[] widths = new float[textToDraw.length()];
        textPaint.getTextWidths(textToDraw, widths);
        float textWidth = 0;
        for (float letterSize : widths) {
            textWidth += letterSize;
        }

        float progressRatio = getProgress() / (float) getMax();
        int xPos = Math.round((canvas.getWidth() * progressRatio) - textWidth);
        int yPos = (int) ((canvas.getHeight() / 2) - ((textPaint.descent() + textPaint.ascent()) / 2));

        canvas.drawText(textToDraw, xPos, yPos, textPaint);
    }
}
