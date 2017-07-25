package com.go.jinglesample.widget;


import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.go.jinglesample.R;
import com.go.jinglesample.model.User;
import com.go.jinglesample.utils.AndroidUtils;

public class SettingsView extends FrameLayout {

    SwitchCompat jingleToggle;
    SwitchCompat messagesToggle;
    SwitchCompat vibrateToggle;

    UserAvatarImageView userImage;

    TextView rateRow;
    TextView contactRow;
    TextView languageRow;
    TextView privacyRow;
    TextView termsRow;
    TextView signOutRow;

    TextView versionText;

    FrameLayout frameLoading;

    private User user;

    public SettingsView(Context context) {
        super(context);
        init(context);
    }

    public SettingsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SettingsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(final Context context) {
        View.inflate(context, R.layout.settings_view, this);

        userImage = (UserAvatarImageView) findViewById(R.id.iv_user_image);
        jingleToggle = (SwitchCompat) findViewById(R.id.sw_jingle);
        messagesToggle = (SwitchCompat) findViewById(R.id.sw_messages);
        vibrateToggle = (SwitchCompat) findViewById(R.id.sw_vibrate);

        rateRow = (TextView) findViewById(R.id.tv_rate);
        contactRow = (TextView) findViewById(R.id.tv_contact);
        languageRow = (TextView) findViewById(R.id.tv_language);
        privacyRow = (TextView) findViewById(R.id.tv_privacy_policy);
        termsRow = (TextView) findViewById(R.id.tv_terms);
        signOutRow = (TextView) findViewById(R.id.tv_sign_out);

        versionText = (TextView) findViewById(R.id.tv_version);

        frameLoading = (FrameLayout) findViewById(R.id.fl_loading);
    }

    public void setupViewDefaults(User user) {
        this.user = user;

        userImage.setImage(user.photos.get(1).getBitmap());
        String versionName = AndroidUtils.getVersionName(getContext());
        versionText.setText(getResources().getString(R.string.settings_version).replace("{0}", versionName));
        jingleToggle.setChecked(user.jingleNotification);
        messagesToggle.setChecked(user.chatNotification);
        vibrateToggle.setChecked(user.sound);
        jingleToggle.setOnCheckedChangeListener(toggleChangedListener);
        messagesToggle.setOnCheckedChangeListener(toggleChangedListener);
        vibrateToggle.setOnCheckedChangeListener(toggleChangedListener);
        enableToggles(true);
    }

    private void enableToggles(final boolean enabled) {
        jingleToggle.setEnabled(enabled);
        messagesToggle.setEnabled(enabled);
        vibrateToggle.setEnabled(enabled);
    }

    private final CompoundButton.OnCheckedChangeListener toggleChangedListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton toggle, boolean isChecked) {
            switch (toggle.getId()) {
                case R.id.sw_jingle:
                    user.jingleNotification = toggle.isChecked();
                    break;
                case R.id.sw_messages:
                    user.chatNotification = toggle.isChecked();
                    break;
                case R.id.sw_vibrate:
                    user.sound = toggle.isChecked();
                    break;
            }
            final ProgressDialog dialog = ProgressDialog.show(getContext(), getResources().getString(R.string.save_settings), "", true);
            dialog.setCancelable(false);
            dialog.show();

            // TODO update settings
        }
    };
}
