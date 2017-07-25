package com.go.jinglesample.asynctask;

import android.os.AsyncTask;

import com.go.jinglesample.callbacks.StageViewCallback;
import com.go.jinglesample.model.User;
import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StageAsyncTask extends AsyncTask<String, String, User[]> {

    StageViewCallback callback;

    public void setCallback(StageViewCallback callback) {
        this.callback = callback;
    }

    @Override
    protected User[] doInBackground(String... urls) {
        User[] users = null;

        HttpURLConnection urlConnection = null;

        String urlString = urls[0];
        try {
            URL url = new URL(urlString);
            urlConnection = (HttpURLConnection) url.openConnection();
            BufferedInputStream stream = new BufferedInputStream(urlConnection.getInputStream());
            String jsonString = streamToString(stream);

            Gson gson = new Gson();
            users = gson.fromJson(jsonString, User[].class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return users;
    }

    @Override protected void onPostExecute(final User[] tempUsers) {
        super.onPostExecute(tempUsers);
        List<User> users = new ArrayList<>(Arrays.asList(tempUsers));
        callback.populateUser(users);
    }

    private String streamToString(final InputStream stream) {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        if (stream != null) {
            int aByte;
            try {
                aByte = stream.read();
                while (aByte != -1) {
                    result.write(aByte);
                    aByte = stream.read();
                }
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }

}
