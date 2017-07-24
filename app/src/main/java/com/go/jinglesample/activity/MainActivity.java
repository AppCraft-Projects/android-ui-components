package com.go.jinglesample.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.go.jinglesample.model.Photo;
import com.go.jinglesample.R;
import com.go.jinglesample.model.User;
import com.go.jinglesample.widget.UserDetailsView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserDetailsView userDetailsView = (UserDetailsView) findViewById(R.id.udv_user_details);

        Photo photo = new Photo();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.photo_placeholder);
        photo.setBitmap(bitmap);
        User user = getMockUser();
        userDetailsView.setUser(user);
    }

    @NonNull
    private User getMockUser() {
        User user = new User();

        Photo photo = new Photo();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.photo_placeholder);
        photo.setBitmap(bitmap);

        user.photos = new ArrayList<Photo>();
        user.photos.add(photo);
        user.photos.add(photo);
        user.photos.add(photo);
        user.photos.add(photo);

        user.first_name = "Gabor";
        user.age = 35;

        return user;
    }
}
