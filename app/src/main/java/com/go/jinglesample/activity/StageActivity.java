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
        UserListView userListView = (UserListView) findViewById(R.id.ulv_stage);
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
}
