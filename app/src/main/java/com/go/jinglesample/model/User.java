package com.go.jinglesample.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public final class User implements Cloneable {
    @SerializedName("first_name")
    public String first_name;
    @SerializedName("age")
    public int age;
    @SerializedName("job")
    public String job;
    @SerializedName("company")
    public String company;
    @SerializedName("percentage")
    public int percentage;
    @SerializedName("what_if_we")
    public String what_if_we;
    @SerializedName("location")
    public String location;
    @SerializedName("education")
    public String education;
    @SerializedName("about_tags")
    public List<UserTag> about_tags;
    @SerializedName("cover_photo")
    public Photo cover_photo;
    @SerializedName("photos")
    public List<Photo> photos;
    @SerializedName("common_friends")
    public List<MutualFriend> common_friends;
    @SerializedName("common_friends_number")
    public int common_friends_number;
    @SerializedName("common_likes")
    public List<String> common_likes;
    @SerializedName("common_likes_number")
    public int common_likes_number;
    @SerializedName("status")
    public String status;

    public boolean jingleNotification;
    public boolean chatNotification;
    public boolean sound;

    public static User clone(final User from) {
        try {
            return (User) from.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
