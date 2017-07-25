package com.go.jinglesample.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.go.jinglesample.R;
import com.go.jinglesample.model.MutualFriend;
import com.go.jinglesample.model.Photo;
import com.go.jinglesample.model.User;
import com.go.jinglesample.model.UserTag;
import com.go.jinglesample.widget.SettingsView;
import com.go.jinglesample.widget.UserDetailsView;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SettingsActivity extends AppCompatActivity {

    private static final String EXTRA_USER = "extra.user";

    public static void startActivity(final Context context, final User user) {
        Intent intent = new Intent(context, SettingsActivity.class);
        intent.putExtra(EXTRA_USER, Parcels.wrap(user));
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setTitle(R.string.settings_title);

        final Intent intent = getIntent();
        final User user = Parcels.unwrap(intent.getParcelableExtra(EXTRA_USER));
        if (user == null) {
            finish();
            return;
        }

        SettingsView settingsView = (SettingsView) findViewById(R.id.sv_settings);
        settingsView.setupViewDefaults(user);
    }
}
