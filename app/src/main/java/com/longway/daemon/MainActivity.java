package com.longway.daemon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.longway.daemon.services.BackgroundService;
import com.longway.daemon.services.GrayService;
import com.longway.daemon.services.WhiteService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initService();
    }

    private void initService() {
        BackgroundService.startService(this);
        WhiteService.startService(this);
        GrayService.startService(this);
    }
}
