package com.example.andinovanprastya.loginfirebase.notification;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "FCM_GUE";
// messaging service
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        // menampilkan code
        Log.d(TAG, "Pengirim: " + remoteMessage.getFrom());


        // pemilihan data apabila kita memiliki data maka yang akan ditampilkann adalah
        // data yang berada pada "body" yang telah kita inputkan di postman maupun fcm
        if(remoteMessage.getData().size() > 0){
            Log.d(TAG,"Pesennya bang: " + remoteMessage.getData().get("body"));
        }

        // method untuk menampilkan notifikasi dari data
        MyNotificationManager.getInstance(this).displayNotification(
                remoteMessage.getData().get("body"),
                remoteMessage.getData().get("title")
        );
    }
}
