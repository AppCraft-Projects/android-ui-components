package com.go.jinglesample.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.go.jinglesample.Photo;
import com.go.jinglesample.R;
import com.go.jinglesample.widget.UserDetailsView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserDetailsView userDetailsView = (UserDetailsView) findViewById(R.id.udv_user_details);

        Photo photo = new Photo();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.photo_placeholder);
        photo.setBitmap(bitmap);
        userDetailsView.setPhotos(photo);
    }
}
