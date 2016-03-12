package com.example.login;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MenLo1Activity extends ActionBarActivity {
    // Идентификатор уведомления
    private static final int NOTIFY_ID = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men_lo1);
    }

    public void sendActionNotification(View view) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Намерение для запуска второй активности
        Intent intent = new Intent(this, MenLo1Activity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        // Строим уведомление
        Notification builder = new Notification.Builder(this)
                .setTicker("Пришёл приказ!")
                .setContentTitle("Приказ")
                .setContentText(
                        "Для вас пришёл новый приказ")
                .setSmallIcon(R.drawable.ic_menu_send).setContentIntent(pIntent)
                .addAction(R.drawable.ic_menu_send, "Открыть", pIntent)
                .addAction(R.drawable.ic_menu_send, "Отказаться", pIntent)
                .build();

        // убираем уведомление, когда его выбрали
        builder.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(0, builder);
    }
    public void sendBigTextStyleNotification(View view) {
        String bigText = "Для вас пришёл новый приказ ";

        Intent intent = new Intent(this, SecondActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Notification.Builder builder = new Notification.Builder(this)
                .setTicker("Пришёл приказ!")
                .setContentTitle("Уведомление о новом приказе")
                .setContentText(
                        "Для вас пришёл новый приказ")
                .setSmallIcon(R.drawable.ic_menu_send)
                .addAction(R.drawable.ic_send_24dp, "Запустить активность",
                        pIntent).setAutoCancel(true);

        Notification notification = new Notification.BigTextStyle(builder)
                .bigText(bigText).build();
        notification.defaults = Notification.DEFAULT_SOUND |
                Notification.DEFAULT_VIBRATE;
        notification.ledARGB = Color.BLUE;
        notification.ledOffMS = 0;
        notification.ledOnMS = 1;
        notification.flags = notification.flags | Notification.FLAG_SHOW_LIGHTS;

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }
    public void sendBigPictureStyleNotification(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("Большой приказ")
                .setTicker("Пришёл приказ!")
                .setContentText("Уведомление с большой картинкой")
                .setSmallIcon(R.drawable.ic_menu_send)
                .addAction(R.drawable.ic_menu_send, "Запустить активность",
                        pIntent);

        // Подготовим большую картинку
        Notification notification = new Notification.BigPictureStyle(builder)
                .bigPicture(
                        BitmapFactory.decodeResource(getResources(),
                                R.drawable.ic_menu_send)).build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(2, notification);
    }
    public void sendInboxStyleNotification(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
        Notification.Builder builder = new Notification.Builder(this)
                .setTicker("Пришёл приказ!!")
                .setContentTitle("Уведомление в стиле Inbox")
                .setContentText("Inbox Style notification!!")
                .setSmallIcon(R.drawable.ic_menu_send)
                .addAction(R.drawable.ic_menu_send, "Запустить активность", pIntent);

        Notification notification = new Notification.InboxStyle(builder)
                .addLine("Первое сообщение").addLine("Второе сообщение")
                .addLine("Третье сообщение").addLine("Четвертое сообщение")
                .setSummaryText("+2 more").build();

        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(3, notification);
    }
}


