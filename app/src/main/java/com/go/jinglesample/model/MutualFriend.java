package com.go.jinglesample.model;

import android.graphics.Bitmap;

public class MutualFriend implements Cloneable {
    public String first_name;
    public Bitmap main_image;

    public static MutualFriend clone(final MutualFriend from) {
        try {
            return (MutualFriend) from.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
