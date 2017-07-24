package com.go.jinglesample.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.go.jinglesample.R;

public class WhatIfWeFieldView extends LinearLayout {

    private TextView bodyText;

    public WhatIfWeFieldView(Context context) {
        super(context);
        init(context);
    }

    public WhatIfWeFieldView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public WhatIfWeFieldView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(final Context context) {
        View.inflate(context, R.layout.what_if_we_field_view, this);
        setOrientation(VERTICAL);

        this.bodyText = (TextView) findViewById(R.id.tv_what_if_body);
    }

    public void setBodyText(final String bodyText) {
        this.bodyText.setText(bodyText);
    }
}
