package com.go.jinglesample.model.realmModel;

import io.realm.RealmObject;

public class RealmString extends RealmObject {

    public String innerString;

    public RealmString() {
        super();
    }

    public RealmString(String innerString) {
        super();
        this.innerString = innerString;
    }
}
