package com.longway.daemon.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.longway.daemon.R;

/**
 * Created by longway on 16/10/29. Email:longway1991117@sina.com
 */

public class WhiteService extends Service {
    private static final String TAG = WhiteService.class.getSimpleName();
    public static final int WHITE_SERVICE_NOTIFICATION_ID = 100;

    public static void startService(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, WhiteService.class);
        intent.setPackage(context.getPackageName());
        context.startService(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.e(TAG, "onStart");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.mContentTitle = "WhiteService";
        builder.mContentText = "WhiteService";
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.mLargeIcon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        startForeground(WHITE_SERVICE_NOTIFICATION_ID, builder.build());
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
