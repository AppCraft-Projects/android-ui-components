package com.go.jinglesample.model;

import org.parceler.Parcel;

@Parcel
public class MutualFriend implements Cloneable {
    public String first_name;
    public int main_image_resid;

    public static MutualFriend clone(final MutualFriend from) {
        try {
            return (MutualFriend) from.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
