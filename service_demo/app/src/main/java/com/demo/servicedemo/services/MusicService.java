package com.demo.servicedemo.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.demo.servicedemo.R;

public class MusicService extends Service {

    private MediaPlayer mediaPlayer;
    private Handler handler;
    private Runnable playSoundRunnable;

    public void onCreate() {
        super.onCreate();

        mediaPlayer = MediaPlayer.create(this, R.raw.beep);
        handler = new Handler();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        playSoundRunnable = new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null) {
                    mediaPlayer.start();
                    handler.postDelayed(this, 2000);
                }
            }
        };

        handler.post(playSoundRunnable);

        return START_STICKY;

    }

    public void onDestroy() {
        super.onDestroy();

        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }

        if (handler != null) {
            handler.removeCallbacks(playSoundRunnable);
        }
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
