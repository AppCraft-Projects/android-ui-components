package com.go.jinglesample.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class MutualFriend implements Cloneable {
    @SerializedName("first_name")
    public String first_name;
    @SerializedName("image_url")
    public String image_url;
    public int main_image_resid;

    public static MutualFriend clone(final MutualFriend from) {
        try {
            return (MutualFriend) from.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
