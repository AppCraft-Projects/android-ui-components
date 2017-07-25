package com.go.jinglesample.model;

import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public final class Photo implements Cloneable {
    public int position;

    @SerializedName("id")
    public String id;

    @SerializedName("image_url")
    public String image_url;


    private int bitmapResId;
    private boolean toDelete;

    private String fullImageUrl;

    public int getBitmap() {
        return bitmapResId;
    }

    public void setBitmap(final int resId) {
        this.bitmapResId = resId;
        toDelete = false;
    }

    public static Photo clone(final Photo from) {
        try {
            return (Photo) from.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
