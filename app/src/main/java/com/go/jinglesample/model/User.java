package com.go.jinglesample.model;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public final class User implements Cloneable {
    public List<Photo> photos;

    public String first_name;
    public int age;

    public String job;
    public String company;

    public int percent;

    public String whatIfWe;

    public String city;
    private transient String capitalizedCity;

    public String education;

    public List<UserTag> aboutTags;

    public List<MutualFriend> mutualFriends;

    public List<String> commonLikes;

    public String status;

    private User user;

    public boolean jingleNotification;
    public boolean chatNotification;
    public boolean sound;

    public String getCapitalizedCity() {
        if (capitalizedCity == null) {
            StringBuilder sb = new StringBuilder(city);
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            capitalizedCity = sb.toString();
        }
        return capitalizedCity;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static User clone(final User from) {
        try {
            return (User) from.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
