package com.go.jinglesample.model;

import android.graphics.Bitmap;

import org.parceler.Parcel;

@Parcel
public final class Photo implements Cloneable {
    public int position;
    public String id;

    private Bitmap bitmap;

    public String image_url;

    private transient String fullImageUrl;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(final Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public static Photo clone(final Photo from) {
        try {
            return (Photo) from.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
