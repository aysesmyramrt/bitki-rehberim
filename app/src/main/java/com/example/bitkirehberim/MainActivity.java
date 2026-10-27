package com.example.bitkirehberim;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Kategori butonları
        findViewById(R.id.btnEvBitkileri).setOnClickListener(v ->
                openCategory("Ev Bitkileri")
        );

        findViewById(R.id.btnBahceBitkileri).setOnClickListener(v ->
                openCategory("Bahçe Bitkileri")
        );

        findViewById(R.id.btnTarlaBitkileri).setOnClickListener(v ->
                openCategory("Tarla Bitkileri")
        );

        // Mevsimsel öneriler butonu
        findViewById(R.id.btnSeasonal).setOnClickListener(v ->
                startActivity(new Intent(this, SeasonalActivity.class))
        );

        // Şifalı bitkiler butonu
        findViewById(R.id.btnSifaliBitkiler).setOnClickListener(v ->
                startActivity(new Intent(this, MedicinalPlantsActivity.class))
        );
    }

    private void openCategory(String categoryName) {
        Intent categoryIntent = new Intent(this, CategoryActivity.class);
        categoryIntent.putExtra("CATEGORY_NAME", categoryName);
        startActivity(categoryIntent);
    }
}
