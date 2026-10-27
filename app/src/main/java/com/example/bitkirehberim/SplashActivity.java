package com.example.bitkirehberim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // ActionBar'ı gizle
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ImageView ivFarmer = findViewById(R.id.ivFarmer);
        TextView tvAppName = findViewById(R.id.tvAppName);
        TextView tvTapToContinue = findViewById(R.id.tvTapToContinue);

        // Animasyonları yükle
        Animation slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);

        // Çiftçi ikonu için rotate animasyonunu uygula
        ivFarmer.startAnimation(rotate);

        // Ana başlık için slide_down animasyonunu uygula
        tvAppName.startAnimation(slideDown);

        // "Devam etmek için dokun" yazısı için fade_in animasyonunu uygula
        tvTapToContinue.startAnimation(fadeIn);

        // Ekrana dokunma olayını dinle
        View rootView = findViewById(R.id.rootView);
        rootView.setOnClickListener(v -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        });
    }
}