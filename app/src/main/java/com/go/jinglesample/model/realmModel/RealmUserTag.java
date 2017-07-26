package com.go.jinglesample.model.realmModel;

import com.go.jinglesample.model.UserTag;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

public class RealmUserTag extends RealmObject implements Cloneable {

    public RealmString id;
    public RealmString name;

    public static RealmUserTag fromUserTag(final UserTag from) {
        RealmUserTag result = new RealmUserTag();
        result.id = new RealmString(from.id);
        result.name = new RealmString(from.name);

        return result;
    }

    public static RealmList<RealmUserTag> fromUserTags(final List<UserTag> fromList) {
        RealmList<RealmUserTag> results = new RealmList<>();
        for (UserTag userTag:fromList) {
            results.add(fromUserTag(userTag));
        }
        return results;
    }

    public UserTag getUserTag() {
        return toUserTag(this);
    }

    public static UserTag toUserTag(final RealmUserTag realmUserTag) {
        UserTag result = new UserTag();

        result.id = realmUserTag.id.toString();
        result.name = realmUserTag.name.toString();

        return result;
    }

    public static List<UserTag> toUserTags(final RealmList<RealmUserTag> realmUserTagList) {
        List<UserTag> results = new ArrayList<>();
        for (RealmUserTag realmUserTag:realmUserTagList) {
            results.add(toUserTag(realmUserTag));
        }
        return results;
    }

    public static RealmUserTag clone(final RealmUserTag from) {
        try {
            return (RealmUserTag) from.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
