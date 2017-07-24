package com.go.jinglesample.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.go.jinglesample.model.Photo;
import com.go.jinglesample.R;

public class UserPhotoView extends FrameLayout {

    public static final int TYPE_COVER = 0;
    public static final int TYPE_NORMAL = 1;

    public static final float COVER_RATIO = 2.3f;

    private static int CORNER_RADIUS = 0;

    RoundedCornerView photoImage;
    ProgressBar progressBar;

    private Photo photo;

    private DisplayMetrics displayMetrics;

    public UserPhotoView(Context context) {
        super(context);
        init();
    }

    public UserPhotoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public UserPhotoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.user_photo_view, this);

        photoImage = (RoundedCornerView) findViewById(R.id.rcv_user_photo);
        progressBar = (ProgressBar) findViewById(R.id.pb_user_photo);

        this.displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    }

    public void setType(final int type) {
        switch (type) {
            case TYPE_COVER:
                LinearLayout.LayoutParams lp =
                        new LinearLayout.LayoutParams(displayMetrics.widthPixels, (int) (displayMetrics.widthPixels / COVER_RATIO));
                setLayoutParams(lp);
                break;
            case TYPE_NORMAL:
                final int margin = (int) TypedValue.applyDimension(1, (float)8, displayMetrics);
                final int halfMargin = margin / 2;
                final int size = (displayMetrics.widthPixels - 4 * margin) / 3;
                lp = new LinearLayout.LayoutParams(size, size);
                lp.setMargins(halfMargin, halfMargin, halfMargin, halfMargin);
                setLayoutParams(lp);
                photoImage.setCorners(CORNER_RADIUS, CORNER_RADIUS, CORNER_RADIUS, CORNER_RADIUS);
                break;
        }
    }

    public void setPhoto(final Photo photo) {
        this.photo = photo;
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) getLayoutParams();
        if (lp == null || lp.width <= 0) {
            setType(TYPE_NORMAL);
            lp = (LinearLayout.LayoutParams) getLayoutParams();
        }
        if (photo.getBitmap() != null) {
            photoImage.setBitmap(photo.getBitmap());
        } else {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.photo_placeholder);
            photoImage.setBitmap(bitmap);
        }
    }

    public void setLoading(final boolean loading) {
        progressBar.setVisibility(loading ? View.VISIBLE : View.GONE);
        photoImage.setVisibility(loading ? View.INVISIBLE : View.VISIBLE);
    }

    public Photo getValue() {
        return photo;
    }
}
