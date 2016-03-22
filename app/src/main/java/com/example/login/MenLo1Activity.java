package com.example.login;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MenLo1Activity extends ActionBarActivity {
    // Идентификатор уведомления
    private static final int NOTIFY_ID = 101;
    public static final String NOTIFICATION_SETTING = "notificationSetting";
    public static final String NOTIFICATION_ENABLED = "notificationEnabled";
    public static final String NOTIFICATION_SOUND_ENABLED = "notificationEnabledSound";
    public static final String NOTIFICATION_VIBRATE_ENABLED = "notificationEnabledVibrate";

    private SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men_lo1);

        settings = getSharedPreferences(NOTIFICATION_SETTING, Context.MODE_PRIVATE);

    }


    public void sendBigTextStyleNotification(View view) {

        boolean notificationEnabled = settings.getBoolean(NOTIFICATION_ENABLED, true);
        if (notificationEnabled) {

            boolean soundEnabled = settings.getBoolean(NOTIFICATION_SOUND_ENABLED, true);
            boolean vibrateEnabled = settings.getBoolean(NOTIFICATION_VIBRATE_ENABLED, true);
            int notificationType = ((soundEnabled)? Notification.DEFAULT_SOUND: 0) | ((vibrateEnabled)? Notification.DEFAULT_VIBRATE: 0);

            String bigText = "Для вас пришёл новый приказ ";

            Intent intent = new Intent(this, SecondActivity.class);
            PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

            Notification.Builder builder = new Notification.Builder(this)
                    .setTicker("Пришёл приказ!")
                    .setContentTitle("Уведомление о новом приказе")
                    .setContentText(
                            "Для вас пришёл новый приказ")
                    .setSmallIcon(R.drawable.ic_menu_send)
                    .addAction(R.drawable.ic_send_24dp, "Перейти в приложение",
                            pIntent).setAutoCancel(false);

            Notification notification = new Notification.BigTextStyle(builder)
                    .bigText(bigText).build();
            notification.defaults = notificationType;
            notification.ledARGB = Color.BLUE;
            notification.ledOffMS = 0;
            notification.ledOnMS = 1;
            notification.flags = notification.flags | Notification.FLAG_SHOW_LIGHTS;
            notification.flags |= Notification.FLAG_AUTO_CANCEL;
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(1, notification);
        } else {
            Toast.makeText(getApplicationContext(), "Уведомления выключены", Toast.LENGTH_SHORT).show();
        }
    }

}


