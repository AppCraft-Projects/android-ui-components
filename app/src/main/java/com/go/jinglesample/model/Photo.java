package com.go.jinglesample.model;

import com.go.jinglesample.R;
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
        int result = R.drawable.photo_placeholder;
        if (bitmapResId > 0) {
            result = bitmapResId;
        }
        return result;
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
