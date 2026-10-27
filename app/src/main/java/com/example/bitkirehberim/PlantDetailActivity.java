package com.example.bitkirehberim;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class PlantDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_detail);

        // ActionBar'ı ayarla
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            // Gelen bitki adını başlık olarak ayarla
            String plantName = getIntent().getStringExtra("PLANT_NAME");
            getSupportActionBar().setTitle(plantName);
        }

        // TextView'ları bul
        TextView tvGrowingRegions = findViewById(R.id.tvGrowingRegions);
        TextView tvLifespan = findViewById(R.id.tvLifespan);
        TextView tvWateringFrequency = findViewById(R.id.tvWateringFrequency);
        TextView tvLightRequirement = findViewById(R.id.tvLightRequirement);
        TextView tvGrowingEnvironment = findViewById(R.id.tvGrowingEnvironment);
        TextView tvFertilizing = findViewById(R.id.tvFertilizing);
        TextView tvPruning = findViewById(R.id.tvPruning);
        TextView tvRepotting = findViewById(R.id.tvRepotting);
        TextView tvGeneralCare = findViewById(R.id.tvGeneralCare);
        TextView tvCommonDiseases = findViewById(R.id.tvCommonDiseases);
        TextView tvPrevention = findViewById(R.id.tvPrevention);
        TextView tvPropagation = findViewById(R.id.tvPropagation);

        String plantName = getIntent().getStringExtra("plantName");

        // Intent'ten verileri al ve null kontrolü yap
        Intent intent = getIntent();
        if (intent != null) {
            try {
                tvGrowingRegions.setText(intent.getStringExtra("PLANT_GROWING_REGIONS"));
                tvLifespan.setText(intent.getStringExtra("PLANT_LIFESPAN"));
                tvWateringFrequency.setText(intent.getStringExtra("PLANT_WATERING_FREQUENCY"));
                tvLightRequirement.setText(intent.getStringExtra("PLANT_LIGHT_REQUIREMENT"));
                tvGrowingEnvironment.setText(intent.getStringExtra("PLANT_GROWING_ENVIRONMENT"));
                tvFertilizing.setText(intent.getStringExtra("PLANT_FERTILIZING"));
                tvPruning.setText(intent.getStringExtra("PLANT_PRUNING"));
                tvRepotting.setText(intent.getStringExtra("PLANT_REPOTTING"));
                tvGeneralCare.setText(intent.getStringExtra("PLANT_GENERAL_CARE"));
                tvCommonDiseases.setText(intent.getStringExtra("PLANT_COMMON_DISEASES"));
                tvPrevention.setText(intent.getStringExtra("PLANT_PREVENTION"));
                tvPropagation.setText(intent.getStringExtra("PLANT_PROPAGATION"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
