package com.go.jinglesample.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

import com.go.jinglesample.Photo;
import com.go.jinglesample.R;

public class UserDetailsView extends ScrollView {

    UserPhotoView coverPhoto;
    UserPhotoView firstPhoto;
    UserPhotoView secondPhoto;
    UserPhotoView thirdPhoto;

    public UserDetailsView(Context context) {
        super(context);
        init(context);
    }

    public UserDetailsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public UserDetailsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(final Context context) {
        setFillViewport(true);
        setVerticalScrollBarEnabled(false);
        setOverScrollMode(OVER_SCROLL_NEVER);

        View.inflate(context, R.layout.user_details_view, this);

        coverPhoto = (UserPhotoView) findViewById(R.id.upv_user_details_cover);
        firstPhoto = (UserPhotoView) findViewById(R.id.upv_user_details_1);
        secondPhoto = (UserPhotoView) findViewById(R.id.upv_user_details_2);
        thirdPhoto = (UserPhotoView) findViewById(R.id.upv_user_details_3);
    }

    public void setPhotos(final Photo photo) {
        coverPhoto.setType(UserPhotoView.TYPE_COVER);
        coverPhoto.setPhoto(photo);

        firstPhoto.setType(UserPhotoView.TYPE_NORMAL);
        firstPhoto.setPhoto(photo);

        secondPhoto.setType(UserPhotoView.TYPE_NORMAL);
        secondPhoto.setPhoto(photo);

        thirdPhoto.setType(UserPhotoView.TYPE_NORMAL);
        thirdPhoto.setPhoto(photo);
    }
}
