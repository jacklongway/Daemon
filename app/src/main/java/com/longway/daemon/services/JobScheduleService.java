package com.longway.daemon.services;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.util.Log;

/**
 * Created by longway on 16/12/17. Email:longway1991117@sina.com
 */

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class JobScheduleService extends JobService {
    private static final String TAG = JobScheduleService.class.getSimpleName();

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.e(TAG, " onStartJob jobId:" + params.getJobId());
        WhiteService.startService(this);
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.e(TAG, "onStopJob jobId:" + params.getJobId());
        return false;
    }
}
