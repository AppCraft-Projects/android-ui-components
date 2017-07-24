package com.go.jinglesample.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

import com.go.jinglesample.R;

public class UserDetailsView extends ScrollView {

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
    }
}
