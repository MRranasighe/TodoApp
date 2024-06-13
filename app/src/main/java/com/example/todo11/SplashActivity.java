package com.example.todo11;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private ImageView logo;
    private TextView textWorkouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        logo = findViewById(R.id.logo);
        textWorkouts = findViewById(R.id.textWorkouts);

        // Load animations
        Animation moveUp = AnimationUtils.loadAnimation(this, R.anim.move_up);
        Animation moveDown = AnimationUtils.loadAnimation(this, R.anim.move_down);
        Animation moveLeft = AnimationUtils.loadAnimation(this, R.anim.move_left);
        Animation moveRight = AnimationUtils.loadAnimation(this, R.anim.move_right);
        Animation moveBackCenter = AnimationUtils.loadAnimation(this, R.anim.move_back_center);
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        // Start move up animation
        logo.startAnimation(moveUp);

        // Set animation listeners to chain animations
        moveUp.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                logo.startAnimation(moveDown);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        moveDown.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                logo.startAnimation(moveLeft);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        moveLeft.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                logo.startAnimation(moveRight);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        moveRight.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                logo.startAnimation(moveBackCenter);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        moveBackCenter.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                textWorkouts.setVisibility(View.VISIBLE);
                textWorkouts.startAnimation(fadeIn);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                        finish();
                    }
                }, 2000); // Wait for 2 seconds before starting LoginActivity
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
    }
}
