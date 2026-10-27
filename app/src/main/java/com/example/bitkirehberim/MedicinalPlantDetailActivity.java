package com.example.bitkirehberim;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MedicinalPlantDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicinal_plant_detail);

        // ActionBar'ı ayarla
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            // Gelen bitki adını başlık olarak ayarla
            String plantName = getIntent().getStringExtra("PLANT_NAME");
            getSupportActionBar().setTitle(plantName);
        }

        // TextView'ları bul
        TextView tvPlantName = findViewById(R.id.tvPlantName);
        TextView tvScientificName = findViewById(R.id.tvScientificName);
        TextView tvBenefits = findViewById(R.id.tvBenefits);
        TextView tvUsage = findViewById(R.id.tvUsage);
        TextView tvPrecautions = findViewById(R.id.tvPrecautions);
        TextView tvPreparation = findViewById(R.id.tvPreparation);
        TextView tvDosage = findViewById(R.id.tvDosage);
        TextView tvSideEffects = findViewById(R.id.tvSideEffects);
        TextView tvInteractions = findViewById(R.id.tvInteractions);
        TextView tvStorage = findViewById(R.id.tvStorage);

        // Intent'ten verileri al
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            tvPlantName.setText(extras.getString("PLANT_NAME"));
            tvScientificName.setText(extras.getString("SCIENTIFIC_NAME"));
            tvBenefits.setText(extras.getString("BENEFITS"));
            tvUsage.setText(extras.getString("USAGE"));
            tvPrecautions.setText(extras.getString("PRECAUTIONS"));
            tvPreparation.setText(extras.getString("PREPARATION"));
            tvDosage.setText(extras.getString("DOSAGE"));
            tvSideEffects.setText(extras.getString("SIDE_EFFECTS"));
            tvInteractions.setText(extras.getString("INTERACTIONS"));
            tvStorage.setText(extras.getString("STORAGE"));
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}