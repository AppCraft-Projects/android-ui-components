package com.go.jinglesample.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.github.rahatarmanahmed.cpv.CircularProgressView;
import com.go.jinglesample.R;
import com.go.jinglesample.adapter.StageAdapter;
import com.go.jinglesample.model.User;

import java.util.List;

public class UserListView extends FrameLayout {

    RecyclerView userList;
    FrameLayout loadingView;
    CircularProgressView circularProgressView;

    public UserListView(Context context) {
        super(context);
        init(context);
    }

    public UserListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public UserListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(final Context context) {
        View.inflate(context, R.layout.user_list_view, this);

        userList = (RecyclerView) findViewById(R.id.rv_stage_list);
        loadingView = (FrameLayout) findViewById(R.id.fl_loading);
        circularProgressView = (CircularProgressView) findViewById(R.id.progress_view);
    }

    public void setUserList(List<User> users) {
        StageAdapter stageAdapter = new StageAdapter(users);
        userList.setAdapter(stageAdapter);
    }
}
