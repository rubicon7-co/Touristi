package com.lightning.touristi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.lightning.touristi.ui.login.LoginActivity;

import java.util.Random;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

//        ImageView logo = findViewById(R.id.logo);

        final TextView tw = findViewById(R.id.logo);
        final String text = "rubicon";
        final int[] index = {0};
        tw.setText("");
        int splashTimeOut = 2000;
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (index[0] < text.length()){
                    tw.setText(text.substring(0, ++index[0]));
                    final int random = new Random().nextInt(250) + 50;
                    tw.playSoundEffect(SoundEffectConstants.CLICK); // generates click sound
                    handler.postDelayed(this, random);
                } else {
                    handler.removeCallbacks(this);
                    Intent i = new Intent(LauncherActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        handler.postDelayed(runnable, 150);

//        int splashTimeOut = 2000;
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent i = new Intent(LauncherActivity.this, LoginActivity.class);
//                startActivity(i);
//                finish();
//            }
//        }, splashTimeOut);

//        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mysplashanimation);
//        logo.startAnimation(myanim);
    }
}
