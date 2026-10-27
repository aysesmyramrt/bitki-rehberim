package com.example.bitkirehberim;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bitkirehberim.adapters.MedicinalPlantAdapter;
import com.example.bitkirehberim.models.MedicinalPlant;
import java.util.ArrayList;
import java.util.List;

public class MedicinalPlantsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<MedicinalPlant> medicinalPlants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicinal_plants);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Şifalı Bitkiler");
        }

        recyclerView = findViewById(R.id.recyclerViewMedicinalPlants);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        medicinalPlants = getMedicinalPlants();
        MedicinalPlantAdapter adapter = new MedicinalPlantAdapter(medicinalPlants, plant -> {
            // Detay sayfasına yönlendirme
            startActivity(new Intent(this, MedicinalPlantDetailActivity.class)
                    .putExtra("PLANT_NAME", plant.getName())
                    .putExtra("SCIENTIFIC_NAME", plant.getScientificName())
                    .putExtra("BENEFITS", plant.getBenefits())
                    .putExtra("USAGE", plant.getUsage())
                    .putExtra("PRECAUTIONS", plant.getPrecautions())
                    .putExtra("PREPARATION", plant.getPreparation())
                    .putExtra("DOSAGE", plant.getDosage())
                    .putExtra("SIDE_EFFECTS", plant.getSideEffects())
                    .putExtra("INTERACTIONS", plant.getInteractions())
                    .putExtra("STORAGE", plant.getStorage()));
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private List<MedicinalPlant> getMedicinalPlants() {
        List<MedicinalPlant> plants = new ArrayList<>();

        plants.add(new MedicinalPlant(
                "Zencefil",
                "Zingiber officinale",
                "Mide bulantısı, sindirim sorunları, ağrı ve iltihaplanma tedavisinde etkilidir.",
                "Çay olarak, yemeklerde baharat olarak veya tablet formunda kullanılabilir.",
                "Hamilelikte dikkatli kullanılmalıdır. Kan sulandırıcı ilaç kullananlar doktora danışmalıdır.",
                "Taze zencefil rendelenebilir veya kurutulmuş zencefil çay olarak demlenir.",
                "Günde 2-3 fincan çay veya 1-2 gram toz zencefil",
                "Yüksek dozda mide yanması yapabilir.",
                "Kan sulandırıcılar ve diyabet ilaçları ile etkileşime girebilir.",
                "Serin ve kuru yerde saklanmalıdır."
        ));

        plants.add(new MedicinalPlant(
                "Papatya",
                "Matricaria chamomilla",
                "Sakinleştirici, uyku düzenleyici ve sindirim sistemi rahatsızlıklarında etkilidir.",
                "Çay olarak içilir veya cilt bakımında harici olarak kullanılır.",
                "Aspirin alerjisi olanlar dikkatli kullanmalıdır.",
                "1 tatlı kaşığı kurutulmuş papatya çiçeği bir bardak sıcak suda 5-10 dakika demlenir.",
                "Günde 3-4 fincan çay tüketilebilir.",
                "Nadiren alerjik reaksiyonlar görülebilir.",
                "Kan sulandırıcılarla birlikte kullanımında dikkatli olunmalıdır.",
                "Işık geçirmeyen kapta, kuru ortamda saklanmalıdır."
        ));

        plants.add(new MedicinalPlant(
                "Ihlamur",
                "Tilia",
                "Soğuk algınlığı, grip ve öksürük tedavisinde etkilidir. Sakinleştirici özelliği vardır.",
                "Çay olarak tüketilir.",
                "Kalp rahatsızlığı olanlar doktora danışmalıdır.",
                "2-3 ıhlamur çiçeği bir bardak sıcak suda 5-7 dakika demlenir.",
                "Günde 2-3 fincan tüketilebilir.",
                "Fazla tüketimde uyku hali yapabilir.",
                "Sakinleştirici ilaçlarla birlikte kullanımında dikkatli olunmalıdır.",
                "Kuru ve serin ortamda saklanmalıdır."
        ));

        plants.add(new MedicinalPlant(
                "Ekinezya",
                "Echinacea purpurea",
                "Bağışıklık sistemini güçlendirir, soğuk algınlığı ve grip tedavisinde etkilidir.",
                "Çay, tablet veya damla formunda kullanılabilir.",
                "Otoimmün hastalığı olanlar kullanmamalıdır.",
                "1 tatlı kaşığı kuru ekinezya bir bardak sıcak suda 10-15 dakika demlenir.",
                "Günde 2-3 fincan çay veya doktor tavsiyesine göre tablet/damla",
                "Nadiren mide bulantısı ve baş dönmesi yapabilir.",
                "Bağışıklık sistemini etkileyen ilaçlarla etkileşime girebilir.",
                "Serin ve kuru yerde, ışıktan uzakta saklanmalıdır."
        ));

        plants.add(new MedicinalPlant(
                "Adaçayı",
                "Salvia officinalis",
                "Boğaz ağrısı, diş eti problemleri ve sindirim sorunlarında etkilidir.",
                "Çay olarak içilir veya gargara yapılır.",
                "Hamilelikte ve epilepsi hastalarında kullanılmamalıdır.",
                "1-2 tatlı kaşığı kuru adaçayı bir bardak sıcak suda 5 dakika demlenir.",
                "Günde 2-3 fincan çay tüketilebilir.",
                "Yüksek dozda baş dönmesi yapabilir.",
                "Sara ilaçları ve hormon ilaçları ile etkileşime girebilir.",
                "Hava almayan kapta, kuru ortamda saklanmalıdır."
        ));

        return plants;
    }
}