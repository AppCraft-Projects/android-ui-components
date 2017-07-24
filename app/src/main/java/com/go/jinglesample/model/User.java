package com.go.jinglesample.model;

import java.util.List;

public final class User implements Cloneable {
    public String first_name;
    public int age;
    public List<Photo> photos;

    public static User clone(final User from) {
        try {
            return (User) from.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
