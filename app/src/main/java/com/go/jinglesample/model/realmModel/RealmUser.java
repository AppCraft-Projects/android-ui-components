package com.go.jinglesample.model.realmModel;

import com.go.jinglesample.model.MutualFriend;
import com.go.jinglesample.model.Photo;
import com.go.jinglesample.model.User;
import com.go.jinglesample.model.UserTag;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class RealmUser extends RealmObject implements Cloneable {

    public RealmString first_name;
    public int age;
    public RealmString job;
    public RealmString company;
    public int percentage;
    public RealmString what_if_we;
    public RealmString location;
    public RealmString education;
    public RealmList<RealmUserTag> about_tags;
    public RealmPhoto cover_photo;
    public RealmList<RealmPhoto> photos;
    public RealmList<RealmMutualFriend> common_friends;
    public int common_friends_number;
    public RealmList<RealmString> common_likes;
    public int common_likes_number;
    public RealmString status;

    public boolean jingleNotification;
    public boolean chatNotification;
    public boolean sound;

    public static RealmUser fromUser(final User from) {
        RealmUser result = new RealmUser();

        result.first_name = new RealmString(from.first_name);
        result.age = from.age;
        result.job = new RealmString(from.job);
        result.company = new RealmString(from.company);
        result.percentage = from.percentage;
        result.what_if_we = new RealmString(from.what_if_we);
        result.location = new RealmString(from.location);
        result.education = new RealmString(from.education);
        result.about_tags = RealmUserTag.fromUserTags(from.about_tags);
        result.cover_photo = RealmPhoto.fromPhoto(from.cover_photo);
        result.photos = RealmPhoto.fromPhotos(from.photos);
        result.common_friends = RealmMutualFriend.fromMutualFriends(from.common_friends);
        result.common_friends_number = from.common_friends_number;
        result.common_likes = RealmLikeList.fromLikes(from.common_likes);
        result.common_likes_number = from.common_likes_number;
        result.status = new RealmString(from.status);

        result.jingleNotification = from.jingleNotification;
        result.chatNotification = from.chatNotification;
        result.sound = from.sound;

        return result;
    }

    public User getUser() {
        return toUser(this);
    }

    public static User toUser(final RealmUser from) {
        User result = new User();

        result.first_name = from.first_name.innerString;
        result.age = from.age;
        result.job = from.job.innerString;
        result.company = from.company.innerString;
        result.percentage = from.percentage;
        result.what_if_we = from.what_if_we.innerString;
        result.location = from.location.innerString;
        result.education = from.education.innerString;
        result.about_tags = RealmUserTag.toUserTags(from.about_tags);
        result.cover_photo = RealmPhoto.toPhoto(from.cover_photo);
        result.photos = RealmPhoto.toPhotos(from.photos);
        result.common_friends = RealmMutualFriend.toMutualFriends(from.common_friends);
        result.common_friends_number = from.common_friends_number;
        result.common_likes = RealmLikeList.toLikes(from.common_likes);
        result.common_likes_number = from.common_likes_number;
        result.status = from.status.innerString;

        result.jingleNotification = from.jingleNotification;
        result.chatNotification = from.chatNotification;
        result.sound = from.sound;

        return result;
    }

    public static List<User> toUsers(final List<RealmUser> realmUsers) {
        List<User> results = new ArrayList<>();
        for (RealmUser realmUser:realmUsers) {
            results.add(toUser(realmUser));
        }
        return results;
    }

    public static RealmUser clone(final RealmUser from) {
        try {
            return (RealmUser) from.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
