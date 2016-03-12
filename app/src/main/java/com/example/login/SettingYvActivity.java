package com.example.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SettingYvActivity extends AppCompatActivity {
    public static final String NOTIFICATION_SETTING = "notificationSetting";
    public static final String NOTIFICATION_ENABLED = "notificationEnabled";
    public static final String NOTIFICATION_SOUND_ENABLED = "notificationEnabledSound";
    public static final String NOTIFICATION_VIBRATE_ENABLED = "notificationEnabledVibrate";

    private SharedPreferences settings;

    Switch vibrateSwitch;
    Switch soundSwitch;
    Switch notificationSwitch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_yv);

        settings = getSharedPreferences(NOTIFICATION_SETTING, Context.MODE_PRIVATE);

        vibrateSwitch = (Switch)findViewById(R.id.switchvibrate);
        soundSwitch = (Switch)findViewById(R.id.switchsound);
        notificationSwitch = (Switch)findViewById(R.id.switchnot);

        boolean notificationEnabled = settings.getBoolean(NOTIFICATION_ENABLED,true);
        boolean soundEnabled, vibrateEnabled;
        soundEnabled = vibrateEnabled = notificationEnabled;



        notificationSwitch.setChecked(notificationEnabled);
        soundSwitch.setChecked(settings.getBoolean(NOTIFICATION_SOUND_ENABLED, true));
        vibrateSwitch.setChecked(settings.getBoolean(NOTIFICATION_VIBRATE_ENABLED, true));
        soundSwitch.setEnabled(soundEnabled);
        vibrateSwitch.setEnabled(vibrateEnabled);

        notificationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean(NOTIFICATION_ENABLED, isChecked);
                editor.apply();
                if (isChecked) {
                    soundSwitch.setEnabled(settings.getBoolean(NOTIFICATION_SOUND_ENABLED, true));
                    vibrateSwitch.setEnabled(settings.getBoolean(NOTIFICATION_VIBRATE_ENABLED, true));
                } else {
                    soundSwitch.setEnabled(false);
                    vibrateSwitch.setEnabled(false);
                }
            }
        });

        soundSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean(NOTIFICATION_SOUND_ENABLED, isChecked);
                editor.apply();
            }
        });

        vibrateSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean(NOTIFICATION_VIBRATE_ENABLED, isChecked);
                editor.apply();
            }
        });

    }

}
