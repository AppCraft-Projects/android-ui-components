package com.go.jinglesample.repository;

import android.content.Context;

import com.go.jinglesample.callback.StageServiceCallback;
import com.go.jinglesample.model.User;
import com.go.jinglesample.model.realmModel.RealmUser;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class UserRepository {
    Realm realm;

    public UserRepository(final Context context) {
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    public void clearUsers() {
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
    }

    public void saveUsers(final List<User> users) {
        realm.beginTransaction();
        for (User user: users) {
            RealmUser realmUser = RealmUser.fromUser(user);
            realm.copyToRealm(realmUser);
        }
        realm.commitTransaction();
    }

    public void getAllUsers(final StageServiceCallback callback) {
        RealmResults<RealmUser> results = realm.where(RealmUser.class).findAll();
        List<RealmUser> usersInRealm = realm.copyFromRealm(results);
        List<User> users = RealmUser.toUsers(usersInRealm);
        callback.repositoryLoadSuccess(users);
    }

    public void filterUsersByFirstName(final String firstName, final StageServiceCallback callback) {
        final RealmResults<RealmUser> results = realm.where(RealmUser.class).equalTo("first_name", "GO").findAll();
        List<RealmUser> usersInRealm = realm.copyFromRealm(results);
        List<User> users = RealmUser.toUsers(usersInRealm);
        callback.repositoryLoadSuccess(users);
    }
}
