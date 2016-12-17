package com.longway.daemon;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.longway.daemon.services.BackgroundService;
import com.longway.daemon.services.GrayService;
import com.longway.daemon.services.JobScheduleService;
import com.longway.daemon.services.WhiteService;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity {
    private static final int JOB_ID = 100;
    private JobScheduler mJobScheduler;

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
        mJobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        JobInfo jobInfo = new JobInfo.Builder(JOB_ID, new ComponentName(getPackageName(), JobScheduleService.class.getName())).setPeriodic(1000).build();
        mJobScheduler.schedule(jobInfo);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mJobScheduler.cancel(JOB_ID);
    }
}
