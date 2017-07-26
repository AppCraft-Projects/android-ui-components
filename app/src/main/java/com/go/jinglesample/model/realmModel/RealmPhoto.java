package com.go.jinglesample.model.realmModel;

import com.go.jinglesample.model.Photo;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

public class RealmPhoto extends RealmObject implements Cloneable {

    public int position;
    public RealmString id;
    public RealmString image_url;

    public static RealmPhoto fromPhoto(final Photo from) {
        RealmPhoto result = new RealmPhoto();
        result.position = from.position;
        result.id = new RealmString(from.id);
        result.image_url = new RealmString(from.image_url);

        return result;
    }

    public static RealmList<RealmPhoto> fromPhotos(final List<Photo> fromList) {
        RealmList<RealmPhoto> results = new RealmList<RealmPhoto>();
        for (Photo photo:fromList) {
            results.add(fromPhoto(photo));
        }
        return results;
    }

    public Photo getPhoto() {
        return toPhoto(this);
    }


    public static Photo toPhoto(final RealmPhoto realmPhoto) {
        Photo result = new Photo();

        result.position = realmPhoto.position;
        result.id = realmPhoto.id.toString();
        result.image_url = realmPhoto.image_url.toString();

        return result;
    }

    public static List<Photo> toPhotos(final RealmList<RealmPhoto> realmPhotoList) {
        List<Photo> results = new ArrayList<Photo>();
        for (RealmPhoto realmPhoto:realmPhotoList) {
            results.add(toPhoto(realmPhoto));
        }
        return results;
    }

    public static RealmPhoto clone(final RealmPhoto from) {
        try {
            return (RealmPhoto) from.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
