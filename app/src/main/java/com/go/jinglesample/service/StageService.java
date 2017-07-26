package com.go.jinglesample.service;

import android.content.Context;

import com.go.jinglesample.asynctask.StageAsyncTask;
import com.go.jinglesample.callback.StageServiceCallback;
import com.go.jinglesample.callback.StageViewCallback;
import com.go.jinglesample.constants.Constants;
import com.go.jinglesample.model.User;
import com.go.jinglesample.repository.ConfigurationRepository;
import com.go.jinglesample.repository.UserRepository;
import com.go.jinglesample.utils.TimeUtil;

import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.List;

public class StageService implements StageServiceCallback {

    ConfigurationRepository configurationRepository;
    UserRepository userRepository;

    StageAsyncTask downloadUserListTask;

    StageViewCallback callback;

    public void setCallback(@NotNull StageViewCallback callback) {
        this.callback = callback;
    }

    public StageService(final Context context) {
        this.downloadUserListTask = new StageAsyncTask();
        this.userRepository = new UserRepository(context);
        this.configurationRepository = new ConfigurationRepository(context);
    }

    public void getUserList() {
        final Date savedDownloadDate = configurationRepository.getDownloadDate();
        if (TimeUtil.isOlderThanFiveMins(savedDownloadDate)) {
            downloadUserListTask.setCallback(this);
            downloadUserListTask.execute(Constants.STAGE_URL);
        } else {
            userRepository.getAllUsers(this);
        }
    }

    public void loadUsers() {
        downloadUserListTask.setCallback(this);
        downloadUserListTask.execute(Constants.STAGE_URL);
    }

    @Override
    public void downloadSuccess(List<User> users) {
        callback.populateUser(users);
        userRepository.clearUsers();
        userRepository.saveUsers(users);
        configurationRepository.saveDownloadDate(new Date());
    }

    @Override
    public void repositoryLoadSuccess(List<User> users) {
        callback.populateUser(users);
    }
}
