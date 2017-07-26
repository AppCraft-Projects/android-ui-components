package com.go.jinglesample.callback;

import com.go.jinglesample.model.User;

import java.util.List;

public interface StageServiceCallback {
    public void downloadSuccess(List<User> users);
    public void repositoryLoadSuccess(final List<User> users);
}
