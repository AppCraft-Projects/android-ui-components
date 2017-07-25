package com.go.jinglesample.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.go.jinglesample.adapter.CircleImageTextAdapter;
import com.go.jinglesample.model.MutualFriend;
import com.go.jinglesample.model.Photo;
import com.go.jinglesample.R;
import com.go.jinglesample.model.User;
import com.go.jinglesample.model.UserTag;

import java.util.ArrayList;
import java.util.List;

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

    TextView locationText;

    TextView educationText;

    AboutTagsView aboutTagsView;

    TextView mutualFriendsTitle;
    RecyclerView mutualFriendsView;

    CardView mutualFriendsCardView;

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

        locationText = (TextView) findViewById(R.id.tv_user_details_location);

        educationText = (TextView) findViewById(R.id.tv_user_details_education);

        aboutTagsView = (AboutTagsView) findViewById(R.id.atv_user_details);

        mutualFriendsTitle = (TextView) findViewById(R.id.tv_user_detail_mutual_title);
        mutualFriendsView = (RecyclerView) findViewById(R.id.rv_user_detail_mutual_friends);
        mutualFriendsCardView = (CardView) findViewById(R.id.cv_user_details_mutual_friends);
    }

    public void setUser(final User user) {
        this.user = user;

        setPhotos(user);
        setName(user);
        setJob(user);
        setJingleBar(user.percent);
        setWhatIfWe(user.whatIfWe);
        setLocation(user.getCapitalizedCity());
        setEducation(user.education);
        setAboutTags(user.aboutTags);
        setMutualFriends(user.mutualFriends);
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

    private void setLocation(String city) {
        locationText.setText(city);
    }

    private void setEducation(String education) {
        educationText.setText(education);
    }

    private void setAboutTags(List<UserTag> aboutTags) {
        this.aboutTagsView.addJingleUserTags(aboutTags);
    }

    private void setMutualFriends(List<MutualFriend> mutualFriends) {
        if (mutualFriends != null && mutualFriends.size() != 0) {
            mutualFriendsTitle.setText(getResources().getString(R.string.stage_user_details_mutual_title).replace("{0}", String.valueOf(mutualFriends.size())));

            List<CircleImageTextAdapter.ImageTextItem> mutualImageTextItemList = new ArrayList<>(mutualFriends.size());
            for (MutualFriend mutualFriend : mutualFriends) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), mutualFriend.main_image_resid);
                mutualImageTextItemList.add(new CircleImageTextAdapter.ImageTextItem(mutualFriend.first_name, bitmap));
            }
            mutualFriendsView.setHasFixedSize(true);
            mutualFriendsView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
            mutualFriendsView.setAdapter(new CircleImageTextAdapter(mutualImageTextItemList));
        } else {
            mutualFriendsCardView.setVisibility(View.GONE);
        }
    }
}
