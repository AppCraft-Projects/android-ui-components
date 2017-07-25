package com.go.jinglesample.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;

import com.go.jinglesample.R;

public class UserAvatarImageView extends View {
    private static int IMAGE_SIZE = 0;

    public UserAvatarImageView(final Context context) {
        super(context);
        init(context);
    }

    public UserAvatarImageView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public UserAvatarImageView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void setImage(final Bitmap image) {
        setBackground(new CircularBitmapDrawable(image));
    }

    private void init(final Context context) {
        if (IMAGE_SIZE == 0) {
            IMAGE_SIZE = Math.round(getResources().getDimension(R.dimen.small_avatar_image_size));
        }
    }
}
