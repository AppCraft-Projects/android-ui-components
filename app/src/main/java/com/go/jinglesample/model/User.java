package com.go.jinglesample.model;

import java.util.List;

public final class User implements Cloneable {
    public List<Photo> photos;

    public String first_name;
    public int age;

    public String job;
    public String company;

    public String city;

    public static User clone(final User from) {
        try {
            return (User) from.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
