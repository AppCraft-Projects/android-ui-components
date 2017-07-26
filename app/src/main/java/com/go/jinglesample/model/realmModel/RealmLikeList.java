package com.go.jinglesample.model.realmModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

public class RealmLikeList {

    public static RealmString fromLike(final String from) {
        return new RealmString(from);
    }

    public static RealmList<RealmString> fromLikes(final List<String> fromList) {
        RealmList<RealmString> results = new RealmList<>();
        for (String like:fromList) {
            results.add(fromLike(like));
        }
        return results;
    }

    public static String toLike(final RealmString like) {
        return like.toString();
    }

    public static List<String> toLikes(final RealmList<RealmString> realmLikes) {
        List<String> results = new ArrayList<>();
        for (RealmString realmPhoto:realmLikes) {
            results.add(toLike(realmPhoto));
        }
        return results;
    }
}
