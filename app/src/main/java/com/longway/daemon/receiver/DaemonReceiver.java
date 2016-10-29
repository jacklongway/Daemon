package com.longway.daemon.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.longway.daemon.services.GrayService;

/**
 * Created by longway on 16/10/29. Email:longway1991117@sina.com
 */

public class DaemonReceiver extends BroadcastReceiver {
    private static final String TAG = DaemonReceiver.class.getSimpleName();
    public static final String ACTION = "com.longway.android.DAEMON_RECEIVER";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.e(TAG, "action:" + action);
        if (ACTION.equals(action)) {
            GrayService.startService(context);
        }
    }
}
