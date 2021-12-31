package com.btforher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;



public class SpashActivity extends AppCompatActivity {
    Context context;
    private static final long SPLASH_TIME = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = SpashActivity.this;
        Window window = SpashActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(SpashActivity.this, R.color.black));
        }
        onInit();


        //specify the location of media file
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splashvid);

        //Setting MediaController and URI, then starting the videoView
        //videoView.setMediaController(mediaController);
    }
    private void onInit() {

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                startActivity(new Intent(context, WebViewActivity.class));
                finish();
            }
        }, SPLASH_TIME);
    }
    private void jump() {
        if (isFinishing())
            return;
        startActivity(new Intent(this, WebViewActivity.class));
        finish();
    }}


