package com.example.splashscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SplashScreen extends AppCompatActivity {
    private TextView ivScale;
    private ImageView ivRotation;
    private ObjectAnimator animatorRotation;

    public static final String LAST_LAUNCH = "GamePrefs";
    Handler handler;
    static private String TAG="hora";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences lastTime = getSharedPreferences(LAST_LAUNCH, MODE_PRIVATE);
        Date now = new Date();
        SimpleDateFormat format =
                new SimpleDateFormat ("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        Log.i(TAG, "In QuizSplashActivity");
        if (lastTime.contains("dateTime") == true) {
            String dateTime = lastTime.getString("dateTime", "Default");
            Log.i(TAG, "In QuizSplashActivity: " + dateTime);
        }
        SharedPreferences.Editor dateEditor = lastTime.edit();
        dateEditor.putString("dateTime",format.format(now));
        dateEditor.commit();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ivRotation = findViewById(R.id.imageView2);
        animatorRotation = ObjectAnimator.ofFloat(ivRotation, "rotation",0f, 360f);
        animatorRotation.setDuration(3000);
        AnimatorSet animatorSetRotator = new AnimatorSet();
        animatorSetRotator.playTogether(animatorRotation);
        animatorSetRotator.start();

        ivScale = findViewById(R.id.textView);
        Animation animationScale = AnimationUtils.loadAnimation(this, R.anim.scale);
        ivScale.startAnimation(animationScale);

        ivScale = findViewById(R.id.textView2);
        Animation animationScale2 = AnimationUtils.loadAnimation(this, R.anim.scale);
        ivScale.startAnimation(animationScale2);

                handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                },3000);

            }
        }


