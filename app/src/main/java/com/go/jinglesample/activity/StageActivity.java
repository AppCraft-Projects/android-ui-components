package com.go.jinglesample.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.go.jinglesample.R;
import com.go.jinglesample.model.MutualFriend;
import com.go.jinglesample.model.Photo;
import com.go.jinglesample.model.User;
import com.go.jinglesample.model.UserStatus;
import com.go.jinglesample.model.UserTag;
import com.go.jinglesample.widget.UserDetailsView;
import com.go.jinglesample.widget.UserListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StageActivity extends AppCompatActivity {

    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage);

        setTitle(getString(R.string.stage_title));

        users = getMockUsers();

        UserListView userListView = (UserListView) findViewById(R.id.ulv_stage);
        userListView.setUserList(users);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_user_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            SettingsActivity.startActivity(this, users.get(0));
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @NonNull
    private List<User> getMockUsers() {
        User user = new User();

        user.photos = getMockPhotos();

        user.first_name = "Gabor";
        user.age = 35;

        user.job = "HR asszisztens";
        user.company = "BigCommerce Kft.";

        user.percent = 75;

        user.whatIfWe = "Look for some tiny, crazy, hidden places, and have some quality time together.";

        user.city = "Budapest";

        user.education = "ETEL, Sociology";

        user.aboutTags = getMockUserTags();

        user.mutualFriends = getMockMutualFriends();

        user.commonLikes = new ArrayList<>(Arrays.asList("Biciklizés", "Borozás", "Gurmankodás"));

        user.status = UserStatus.JINGLE;

        return new ArrayList<>(Arrays.asList(user)) ;
    }

    private List<Photo> getMockPhotos() {
        Photo coverPhoto = new Photo();
        Photo photo1 = new Photo();
        Photo photo2 = new Photo();
        Photo photo3 = new Photo();

        coverPhoto.setBitmap(R.drawable.cover_photo);
        photo1.setBitmap(R.drawable.photo1);
        photo2.setBitmap(R.drawable.photo2);
        photo3.setBitmap(R.drawable.photo3);

        Photo[] photos = new Photo[] { coverPhoto, photo1, photo2, photo3 };
        return new ArrayList<>(Arrays.asList(photos));
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

    private List<MutualFriend> getMockMutualFriends() {
        MutualFriend friend1 = new MutualFriend();
        friend1.first_name = "Gerda";
        friend1.main_image_resid = R.drawable.photo1;

        MutualFriend friend2 = new MutualFriend();
        friend2.first_name = "Zsuzsa";
        friend2.main_image_resid = R.drawable.photo2;

        MutualFriend friend3 = new MutualFriend();
        friend3.first_name = "Zsófi";
        friend3.main_image_resid = R.drawable.photo3;

        return new ArrayList<>(Arrays.asList(friend1, friend2, friend3));
    }
}
