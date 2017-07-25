package com.go.jinglesample.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.go.jinglesample.model.Photo;
import com.go.jinglesample.R;
import com.go.jinglesample.model.User;
import com.go.jinglesample.model.UserTag;
import com.go.jinglesample.widget.UserDetailsView;

import java.util.ArrayList;
import java.util.Arrays;

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

        Photo coverPhoto = getPhoto(R.drawable.cover_photo);
        Photo photo1 = getPhoto(R.drawable.photo1);
        Photo photo2 = getPhoto(R.drawable.photo2);
        Photo photo3 = getPhoto(R.drawable.photo3);
        user.photos = new ArrayList<Photo>(Arrays.asList(coverPhoto, photo1, photo2, photo3));

        user.first_name = "Gabor";
        user.age = 35;

        user.job = "HR asszisztens";
        user.company = "BigCommerce Kft.";

        user.percent = 75;

        user.whatIfWe = "Look for some tiny, crazy, hidden places, and have some quality time together.";

        user.city = "Budapest";

        user.education = "ETEL, Sociology";

        user.aboutTags = getMockUserTags();

        return user;
    }

    @NonNull
    private Photo getPhoto(int resId) {
        Photo photo = new Photo();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resId);
        photo.setBitmap(bitmap);
        return photo;
    }

    private ArrayList<UserTag> getMockUserTags() {
        UserTag userTag1 = new UserTag();
        userTag1.name = "Biciklizés szerpentinen";

        UserTag userTag2 = new UserTag();
        userTag2.name = "Úszás a tengerben";

        UserTag userTag3 = new UserTag();
        userTag3.name = "Jó sok alvás";

        UserTag userTag4 = new UserTag();
        userTag4.name = "Néhány pohár bor sosem árt";

        UserTag userTag5 = new UserTag();
        userTag5.name = "Romantikus vacsorák";

        return new ArrayList<>(Arrays.asList(userTag1, userTag2, userTag3, userTag4, userTag5));
    }
}
