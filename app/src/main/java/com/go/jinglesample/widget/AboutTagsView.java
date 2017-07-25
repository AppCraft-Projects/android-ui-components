package com.go.jinglesample.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.go.jinglesample.R;
import com.go.jinglesample.model.UserTag;

import org.apmem.tools.layouts.FlowLayout;

import java.util.List;

public class AboutTagsView extends LinearLayout {

    private FlowLayout flowLayout;
    private TextView titleText;

    public AboutTagsView(Context context) {
        super(context);
        init(context);
    }

    public AboutTagsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public AboutTagsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(final Context context) {
        View.inflate(context, R.layout.about_tags_view, this);

        setOrientation(VERTICAL);

        flowLayout = (FlowLayout) findViewById(R.id.fl_about_tags);
        titleText = (TextView) findViewById(R.id.tv_about_tags_title);
    }

    public void addJingleUserTags(final List<UserTag> tags) {
        for (UserTag tag : tags) {
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.about_tag_view, flowLayout, false);
            textView.setText(tag.name);
            textView.setSelected(true);
            flowLayout.addView(textView);
        }
        if (flowLayout.getChildCount() > 0) {
            titleText.setVisibility(VISIBLE);
        }
    }
}
