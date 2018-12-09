package com.example.andinovanprastya.loginfirebase.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.example.andinovanprastya.loginfirebase.MenuActivity;
import com.example.andinovanprastya.loginfirebase.R;

public class MyNotificationManager {
    private Context mCtx;
    private static MyNotificationManager mInstance;
// builder notification
    private MyNotificationManager(Context context){
        mCtx = context;
    }

    public static synchronized MyNotificationManager getInstance(Context context){
        if(mInstance == null){
            mInstance = new MyNotificationManager(context);
        }
        return mInstance;
    }

    public void displayNotification(String title, String body){
        String CHANNEL_ID = "my_channel_01";

//        ketika user meng-clik notifikasi, maka user akan diarahkan ke halaman MAINACTIVITY
        Intent resultIntent = new Intent(mCtx, MenuActivity.class);

//        method get activity memiliki 4 parameter, requestcode digunakan untuk mendeteksi notifikasi apa yang keluar di activity
        PendingIntent pendingIntent = PendingIntent.getActivity(mCtx,0 , resultIntent, PendingIntent.FLAG_ONE_SHOT );

        //buat parsing data
//        MenuActivity.judul = title;
//        MenuActivity.isi = body;

//    masukkan pending intent ke notif builder

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mCtx, CHANNEL_ID)
                .setSmallIcon(R.drawable.mansion)
                .setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);
        NotificationManager mNotifyMgr = (NotificationManager) mCtx.getSystemService(Context.NOTIFICATION_SERVICE);

        if(mNotifyMgr != null){
            mNotifyMgr.notify(1, mBuilder.build());
        }
    }
}
