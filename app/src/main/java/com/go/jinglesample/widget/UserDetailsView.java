package com.go.jinglesample.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.go.jinglesample.model.Photo;
import com.go.jinglesample.R;
import com.go.jinglesample.model.User;

public class UserDetailsView extends ScrollView {

    User user;

    UserPhotoView coverPhoto;
    UserPhotoView firstPhoto;
    UserPhotoView secondPhoto;
    UserPhotoView thirdPhoto;

    TextView nameText;

    TextView jobCompanyText;

    PercentProgressBar percentProgressBar;

    WhatIfWeFieldView whatIfWeFieldView;

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

        coverPhoto  = (UserPhotoView) findViewById(R.id.upv_user_details_cover);
        firstPhoto  = (UserPhotoView) findViewById(R.id.upv_user_details_1);
        secondPhoto = (UserPhotoView) findViewById(R.id.upv_user_details_2);
        thirdPhoto  = (UserPhotoView) findViewById(R.id.upv_user_details_3);

        nameText     = (TextView) findViewById(R.id.tv_user_details_name);

        jobCompanyText  = (TextView) findViewById(R.id.tv_user_details_job);

        percentProgressBar = (PercentProgressBar) findViewById(R.id.pb_details_meter);

        whatIfWeFieldView = (WhatIfWeFieldView) findViewById(R.id.wifwv_user_details);
    }

    public void setUser(final User user) {
        this.user = user;

        setPhotos(user);
        setName(user);
        setJob(user);
        setJingleBar(user.percent);
        setWhatIfWe(user.whatIfWe);
    }

    private void setPhotos(final User user) {
        Photo photoCover = user.photos.get(0);
        Photo photo1 = user.photos.get(1);
        Photo photo2 = user.photos.get(2);
        Photo photo3 = user.photos.get(3);

        this.coverPhoto.setType(UserPhotoView.TYPE_COVER);
        this.coverPhoto.setPhoto(photoCover);

        this.firstPhoto.setType(UserPhotoView.TYPE_NORMAL);
        this.firstPhoto.setPhoto(photo1);

        this.secondPhoto.setType(UserPhotoView.TYPE_NORMAL);
        this.secondPhoto.setPhoto(photo2);

        this.thirdPhoto.setType(UserPhotoView.TYPE_NORMAL);
        this.thirdPhoto.setPhoto(photo3);
    }

    private void setName(User user) {
        final SpannableStringBuilder nameBuilder = new SpannableStringBuilder(user.first_name);
        nameBuilder.append(", ");
        nameBuilder.setSpan(new StyleSpan(Typeface.BOLD), 0, nameBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        nameBuilder.append(Integer.toString(user.age));
        this.nameText.setText(nameBuilder);
    }

    private void setJob(User user) {
        StringBuilder jobText = new StringBuilder();
        jobText.append(user.job)
                .append(" @")
                .append(user.company);

        jobCompanyText.setText(jobText);
    }

    public void setJingleBar(final int percent) {
        percentProgressBar.setVisibility(View.VISIBLE);
        percentProgressBar.setMax(100);
        percentProgressBar.setProgress(percent);
    }

    private void setWhatIfWe(String whatIfWe) {
        this.whatIfWeFieldView.setBodyText(whatIfWe);
    }
}
