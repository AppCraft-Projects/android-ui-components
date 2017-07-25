package com.go.jinglesample.service;

import android.content.Context;

import com.go.jinglesample.asynctask.StageAsyncTask;
import com.go.jinglesample.callback.StageServiceCallback;
import com.go.jinglesample.callback.StageViewCallback;
import com.go.jinglesample.constants.Constants;
import com.go.jinglesample.model.User;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class StageService implements StageServiceCallback {

    StageAsyncTask downloadUserListTask;

    StageViewCallback callback;

    public void setCallback(@NotNull StageViewCallback callback) {
        this.callback = callback;
    }

    public StageService() {
        this.downloadUserListTask = new StageAsyncTask();
    }

    public void loadUsers() {
        downloadUserListTask.setCallback(this);
        downloadUserListTask.execute(Constants.STAGE_URL);
    }

    public void downloadSuccess(final List<User> users) {
        callback.populateUser(users);
    }
}
