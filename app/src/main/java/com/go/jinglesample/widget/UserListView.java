package com.go.jinglesample.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.github.rahatarmanahmed.cpv.CircularProgressView;
import com.go.jinglesample.R;
import com.go.jinglesample.adapter.StageAdapter;
import com.go.jinglesample.asynctask.StageAsyncTask;
import com.go.jinglesample.callback.StageViewCallback;
import com.go.jinglesample.constants.Constants;
import com.go.jinglesample.model.User;
import com.go.jinglesample.service.StageService;

import java.util.List;

public class UserListView extends FrameLayout implements StageViewCallback {

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

        userList.setHasFixedSize(true);
        userList.setLayoutManager(new LinearLayoutManager(context));

        final int itemPadding = (int) getResources().getDimension(R.dimen.margin8);
        final RecyclerView.ItemDecoration paddingDecoration = new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.left += itemPadding;
                outRect.right += itemPadding;
                outRect.top += itemPadding;
                outRect.bottom += itemPadding;
            }
        };
        userList.addItemDecoration(paddingDecoration);
    }

    public void loadUsers() {
        StageService service = new StageService();
        service.setCallback(this);
        service.loadUsers();
    }

    @Override
    public void populateUser(final List<User> users) {
        StageAdapter stageAdapter = new StageAdapter(users);
        userList.setAdapter(stageAdapter);
    }
}
