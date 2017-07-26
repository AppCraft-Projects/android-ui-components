package com.go.jinglesample.model.realmModel;

import com.go.jinglesample.model.MutualFriend;
import com.go.jinglesample.model.MutualFriend;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

public class RealmMutualFriend extends RealmObject implements Cloneable {

    public RealmString first_name;
    public RealmString image_url;
    public int main_image_resid;

    public static RealmMutualFriend fromMutualFriend(final MutualFriend from) {
        RealmMutualFriend result = new RealmMutualFriend();
        result.first_name = new RealmString(from.first_name);
        result.image_url = new RealmString(from.image_url);
        result.main_image_resid = from.main_image_resid;

        return result;
    }

    public static RealmList<RealmMutualFriend> fromMutualFriends(final List<MutualFriend> fromList) {
        RealmList<RealmMutualFriend> results = new RealmList<>();
        for (MutualFriend mutualFriend:fromList) {
            results.add(fromMutualFriend(mutualFriend));
        }
        return results;
    }

    public MutualFriend getMutualFriend() {
        return toMutualFriend(this);
    }


    public static MutualFriend toMutualFriend(final RealmMutualFriend realmMutualFriend) {
        MutualFriend result = new MutualFriend();

        result.first_name = realmMutualFriend.first_name.toString();
        result.image_url = realmMutualFriend.image_url.toString();
        result.main_image_resid = realmMutualFriend.main_image_resid;

        return result;
    }

    public static List<MutualFriend> toMutualFriends(final RealmList<RealmMutualFriend> realmMutualFriendList) {
        List<MutualFriend> results = new ArrayList<>();
        for (RealmMutualFriend realmMutualFriend:realmMutualFriendList) {
            results.add(toMutualFriend(realmMutualFriend));
        }
        return results;
    }

    public static RealmMutualFriend clone(final RealmMutualFriend from) {
        try {
            return (RealmMutualFriend) from.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
