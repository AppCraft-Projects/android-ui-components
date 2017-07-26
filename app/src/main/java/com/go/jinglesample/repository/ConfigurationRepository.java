package com.go.jinglesample.repository;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.Date;

public class ConfigurationRepository {
    static final String SHARED_PREFERENCES_KEY = "com.go.t360jingledemo.repository.shared_configuration";
    static final String DOWNLOAD_DATE_FIELD = "com.go.t360jingledemo.repository.download_date";

    SharedPreferences preferences;

    public ConfigurationRepository(final Context context) {
        preferences = ((Activity) context).getSharedPreferences(SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE);
    }

    public void saveDownloadDate(final Date date) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong(DOWNLOAD_DATE_FIELD, date.getTime());
        editor.apply();
    }

    public Date getDownloadDate() {
        return new Date(preferences.getLong(DOWNLOAD_DATE_FIELD, 0));
    }
}