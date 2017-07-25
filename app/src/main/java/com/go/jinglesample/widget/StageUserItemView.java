package com.go.jinglesample.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.go.jinglesample.R;
import com.go.jinglesample.activity.UserDetailsActivity;
import com.go.jinglesample.model.User;
import com.go.jinglesample.model.UserStatus;

public class StageUserItemView extends CardView {

    private static final float IMAGE_RATIO = 1.2f;

    private User jingleUser;

    ImageView userImage;
    ImageView shadowView;
    TextView nameAgeText;
    TextView jobText;
    PercentProgressBar meterProgress;
    TextView whatIfText;
    ImageView stageItemButton;
    ImageView mutualImage;
    TextView mutualText;
    ImageView tagsImage;
    TextView tagsText;

    int imageWidth;
    int imageHeight;
    int shadowHeight;

    public StageUserItemView(Context context) {
        super(context);
        init(context);
    }

    public StageUserItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public StageUserItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(final Context context) {
        View.inflate(context, R.layout.stage_user_item_view, this);

        userImage = (ImageView) findViewById(R.id.iv_stage_image);
        shadowView = (ImageView) findViewById(R.id.iv_shadow);
        nameAgeText = (TextView) findViewById(R.id.tv_stage_name_age);
        jobText = (TextView) findViewById(R.id.tv_stage_job_city);
        meterProgress = (PercentProgressBar) findViewById(R.id.pb_stage_meter);
        whatIfText = (TextView) findViewById(R.id.tv_what_if_text);
        stageItemButton = (ImageView) findViewById(R.id.iv_stage_button);
        mutualImage = (ImageView) findViewById(R.id.iv_mutual_icon);
        mutualText = (TextView) findViewById(R.id.tv_mutual_text);
        tagsImage = (ImageView) findViewById(R.id.iv_tags_icon);
        tagsText = (TextView) findViewById(R.id.tv_tags_text);

        setCardBackgroundColor(getResources().getColor(R.color.user_details_card_background_white));

        final int itemPadding = (int) getResources().getDimension(R.dimen.margin8);

        if(imageHeight == 0) {
            imageWidth = getResources().getDisplayMetrics().widthPixels - (itemPadding * 2);
            imageHeight = Math.round(imageWidth / IMAGE_RATIO);
            shadowHeight = imageHeight / 3;
        }

        final ColorStateList textColorStateList = new ColorStateList(
                new int [][] {
                        new int[] {android.R.attr.state_enabled},
                        new int[] {-android.R.attr.state_enabled}
                },
                new int[] {
                        getResources().getColor(R.color.grey_enabled),
                        getResources().getColor(R.color.grey_disabled)
                }
        );

        mutualText.setTextColor(textColorStateList);
        tagsText.setTextColor(textColorStateList);

        mutualImage.setBackground(TintedBitmapDrawable.fromEnabledState(getResources(),
                R.drawable.ic_group_white_24dp, R.color.grey_enabled, R.color.grey_disabled));
        tagsImage.setBackground(TintedBitmapDrawable.fromEnabledState(getResources(),
                R.drawable.ic_loyalty_white_24dp, R.color.grey_enabled, R.color.grey_disabled));
    }

    public void setJingleUser(final User jingleUser) {
        this.jingleUser = jingleUser;
    }

    public void setupView() {
        userImage.getLayoutParams().height = imageHeight;
        shadowView.getLayoutParams().height = shadowHeight;

        userImage.setImageBitmap(jingleUser.photos.get(0).getBitmap());

        nameAgeText.setText(jingleUser.first_name + ", " + jingleUser.age);

        final boolean jobVisibility = !TextUtils.isEmpty(jingleUser.job);
        jobText.setText(jingleUser.job);
        jobText.setVisibility(jobVisibility ? View.VISIBLE : View.GONE);

        whatIfText.setText(TextUtils.isEmpty(jingleUser.whatIfWe) ? "" : jingleUser.whatIfWe);

        meterProgress.setMax(100);
        meterProgress.setProgress(Math.round(jingleUser.percent));

        setupMutualFriendsAndTags();
        setupStageItemButton();

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                UserDetailsActivity.startActivity(getContext());
            }
        });
    }

    private void setupMutualFriendsAndTags() {
        if (jingleUser.mutualFriends== null || jingleUser.mutualFriends.size() == 0) {
            mutualText.setText("0");
            mutualText.setEnabled(false);
            mutualImage.setEnabled(false);
        } else {
            mutualText.setText(Integer.toString(jingleUser.mutualFriends.size()));
            mutualText.setEnabled(true);
            mutualImage.setEnabled(true);
        }

        int commonLikesCount = 0;
        if (jingleUser.commonLikes != null && jingleUser.commonLikes.size() > 0) {
            commonLikesCount = jingleUser.commonLikes.size();
        }
        tagsText.setText(String.valueOf(commonLikesCount));
        if (commonLikesCount > 0) {
            tagsText.setEnabled(true);
            tagsImage.setEnabled(true);
        } else {
            tagsText.setEnabled(false);
            tagsImage.setEnabled(false);
        }
    }

    private void setupStageItemButton() {
        switch (jingleUser.status) {
            case UserStatus.DEFAULT:
                stageItemButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_like_80dp));
                break;
            case UserStatus.LIKED:
                stageItemButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_wait_blue_80dp));
                break;
            case UserStatus.JINGLE:
                stageItemButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_chat_blue_80dp));
                break;
        }
    }
}
