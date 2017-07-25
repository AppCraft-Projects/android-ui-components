package com.go.jinglesample.model;

public class UserTag implements Cloneable {
    public String id;
    public String name;

    public static UserTag clone(final UserTag from) {
        try {
            return (UserTag) from.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
