package com.go.jinglesample.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.go.jinglesample.R;
import com.squareup.picasso.Picasso;

public class CircleImageItemView extends LinearLayout {

    public static final int MODE_BOTTOM_TEXT = 0;
    public static final int MODE_TOP_TEXT = 1;
    private int mode = MODE_BOTTOM_TEXT;

    private TextView topTextView;
    private ImageView imageView;
    private TextView bottomTextView;

    private String text;
    private int textColor = -1;

    private int imageWidth = -1;
    private int imageHeight = -1;

    private String image_url;

    private Picasso picasso;

    public CircleImageItemView(Context context) {
        super(context);
        init(context);
    }

    public CircleImageItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CircleImageItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(final Context context) {
        View.inflate(context, R.layout.circle_image_item_view, this);

        topTextView = (TextView) findViewById(R.id.tv_top_text);
        imageView = (ImageView) findViewById(R.id.iv_image);
        bottomTextView = (TextView) findViewById(R.id.tv_bottom_text);

        picasso = Picasso.with(getContext());
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTextColor(int resId) {
        this.textColor = resId;
    }

    public void setImageSize(int width, int height) {
        this.imageWidth = width;
        this.imageHeight = height;
        imageView.getLayoutParams().height = imageHeight;
        imageView.getLayoutParams().width = imageWidth;
    }

    public void setImageBitmap(String image_url) {
        this.image_url = image_url;
    }

    public void setupView() {
        final int textSize = -1;
        if (mode == MODE_BOTTOM_TEXT) {
            bottomTextView.setVisibility(View.VISIBLE);
            bottomTextView.setText(text);
            if (textColor != -1) {
                bottomTextView.setTextSize(textSize);
            }
            if (textColor != -1) {
                bottomTextView.setTextColor(getResources().getColor(textColor));
            }
            topTextView.setVisibility(View.GONE);
            setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
        } else {
            topTextView.setVisibility(View.VISIBLE);
            topTextView.setText(text);
            if (textColor != -1) {
                topTextView.setTextSize(textSize);
            }
            if (textColor != -1) {
                topTextView.setTextColor(getResources().getColor(textColor));
            }
            bottomTextView.setVisibility(View.GONE);
            setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP);
        }

        picasso.load(image_url)
                .resize(imageWidth, imageHeight)
                .placeholder(R.drawable.photo_placeholder)
                .centerCrop().into(imageView);
        // imageView.setImageDrawable(new CircularBitmapDrawable(bitmap));
    }
}
