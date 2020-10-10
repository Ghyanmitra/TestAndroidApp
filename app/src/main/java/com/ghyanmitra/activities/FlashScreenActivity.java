package com.ghyanmitra.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ghyanmitra.R;

public class FlashScreenActivity extends AppCompatActivity {


    Animation topAnimation, bottomAnimation;
    TextView textViewFlash;
    LinearLayout bottom_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        textViewFlash = findViewById(R.id.textViewFlash);
        bottom_layout = findViewById(R.id.bottom_layout);

        textViewFlash.setAnimation(topAnimation);
        bottom_layout.setAnimation(bottomAnimation);

        Handler handler = new Handler(Looper.getMainLooper());

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(textViewFlash, "top_textview");
                pairs[1] = new Pair<View, String>(bottom_layout, "bottom_layout");

                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(FlashScreenActivity.this, pairs);

                Intent intent = new Intent(FlashScreenActivity.this, TestActivity.class);
                startActivity(intent, activityOptions.toBundle());
                finish();
            }
        }, 3000);
    }
}