package com.go.jinglesample.callback;

import com.go.jinglesample.model.User;

import java.util.List;

public interface StageViewCallback {
    public void populateUser(final List<User> users);
}
