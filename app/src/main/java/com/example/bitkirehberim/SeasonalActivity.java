package com.example.bitkirehberim;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

public class SeasonalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seasonal);

        TextView tvCurrentSeason = findViewById(R.id.tvCurrentSeason);
        TextView tvSeasonalTips = findViewById(R.id.tvSeasonalTips);
        RecyclerView recyclerViewSeasonalPlants = findViewById(R.id.recyclerViewSeasonalPlants);

        String currentSeason = getCurrentSeason();
        tvCurrentSeason.setText(currentSeason);

        // Mevsime özel ipuçlarını ayarla
        String seasonalTips = getSeasonalTips(currentSeason);
        tvSeasonalTips.setText(seasonalTips);

        // Mevsime uygun bitkileri getir
        List<Plant> seasonalPlants = getSeasonalPlants(currentSeason);

        recyclerViewSeasonalPlants.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewSeasonalPlants.setAdapter(new PlantAdapter(seasonalPlants, plant -> {
            // Bitki detayına git
            Intent detailIntent = new Intent(SeasonalActivity.this, PlantDetailActivity.class);
            detailIntent.putExtra("PLANT_NAME", plant.getName());
            detailIntent.putExtra("PLANT_GROWING_REGIONS", plant.getGrowingRegions());
            detailIntent.putExtra("PLANT_LIFESPAN", plant.getLifespan());
            detailIntent.putExtra("PLANT_WATERING_FREQUENCY", plant.getWateringFrequency());
            detailIntent.putExtra("PLANT_LIGHT_REQUIREMENT", plant.getLightRequirement());
            detailIntent.putExtra("PLANT_GROWING_ENVIRONMENT", plant.getGrowingEnvironment());
            detailIntent.putExtra("PLANT_FERTILIZING", plant.getFertilizing());
            detailIntent.putExtra("PLANT_PRUNING", plant.getPruning());
            detailIntent.putExtra("PLANT_REPOTTING", plant.getRepotting());
            detailIntent.putExtra("PLANT_GENERAL_CARE", plant.getGeneralCare());
            detailIntent.putExtra("PLANT_COMMON_DISEASES", plant.getCommonDiseases());
            detailIntent.putExtra("PLANT_PREVENTION", plant.getPrevention());
            detailIntent.putExtra("PLANT_PROPAGATION", plant.getPropagation());
            startActivity(detailIntent);
        }));

        // Geri tuşunu ekle
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

    private String getCurrentSeason() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);

        if (month >= 2 && month <= 4) return "İlkbahar";
        else if (month >= 5 && month <= 7) return "Yaz";
        else if (month >= 8 && month <= 10) return "Sonbahar";
        else return "Kış";
    }

    private String getSeasonalTips(String season) {
        switch (season) {
            case "İlkbahar":
                return "• Bahçe bitkilerinin dikimi için ideal zaman\n" +
                        "• Budama işlemleri yapılabilir\n" +
                        "• Gübreleme zamanı\n" +
                        "• Yabani otlarla mücadele edilmeli\n" +
                        "• Sulama sıklığı artırılmalı";
            case "Yaz":
                return "• Düzenli sulama çok önemli\n" +
                        "• Sabah veya akşam sulama yapın\n" +
                        "• Hastalık ve zararlılara dikkat edin\n" +
                        "• Budama işlemlerini azaltın\n" +
                        "• Gölgeleme yapın";
            case "Sonbahar":
                return "• Kış hazırlığı başlamalı\n" +
                        "• Hassas bitkiler içeri alınmalı\n" +
                        "• Soğanlı bitkiler dikilmeli\n" +
                        "• Sulama azaltılmalı\n" +
                        "• Son budamalar yapılmalı";
            case "Kış":
                return "• İç mekan bitkileri için ideal zaman\n" +
                        "• Minimum sulama yapın\n" +
                        "• Gübrelemeyi durdurun\n" +
                        "• Sıcaklık kontrolü önemli\n" +
                        "• Bitkileri dondan koruyun";
            default:
                return "";
        }
    }

    private List<Plant> getSeasonalPlants(String season) {
        List<Plant> seasonalPlants = new ArrayList<>();

        switch (season) {
            case "İlkbahar":
                seasonalPlants.add(new Plant(
                        "Lale",
                        "Tulipa",
                        "Haftada bir",
                        "Çiçekli",
                        "Güneşli",
                        "Dış mekan",
                        "Düzenli sulama",
                        "İlkbaharın müjdecisi",
                        "Ilıman bölgeler",
                        "Çok yıllık soğanlı",
                        "İlkbahar başında",
                        "Çiçek sonrası",
                        "2-3 yılda bir",
                        "Bahar aylarında aktif bakım",
                        "Soğan çürüklüğü",
                        "İyi drenaj",
                        "Soğan ile üretim"
                ));

                seasonalPlants.add(new Plant(
                        "Nergis",
                        "Narcissus",
                        "Haftada bir",
                        "Çiçekli",
                        "Güneşli",
                        "Dış mekan",
                        "Orta düzeyde sulama",
                        "Erken ilkbaharda çiçek açar",
                        "Ilıman bölgeler",
                        "Çok yıllık soğanlı",
                        "Çiçeklenme döneminde",
                        "Yapraklar sararınca",
                        "2-3 yılda bir",
                        "Sonbaharda dikim yapılır",
                        "Soğan çürüklüğü",
                        "İyi drenaj önemli",
                        "Soğan bölünmesi ile"
                ));
                break;

            case "Yaz":
                seasonalPlants.add(new Plant(
                        "Sardunya",
                        "Pelargonium",
                        "Haftada iki",
                        "Çiçekli",
                        "Güneşli",
                        "Dış/İç mekan",
                        "Düzenli sulama",
                        "Yaz boyunca çiçek açar",
                        "Sıcak ve ılıman bölgeler",
                        "Çok yıllık",
                        "Büyüme döneminde aylık",
                        "Solmuş çiçeklerin alınması",
                        "İlkbaharda",
                        "Yazın bol güneş ve su ister",
                        "Yaprak lekesi, çürüklük",
                        "İyi havalandırma",
                        "Çelik ile üretilir"
                ));

                seasonalPlants.add(new Plant(
                        "Petunya",
                        "Petunia",
                        "Haftada iki",
                        "Çiçekli",
                        "Güneşli",
                        "Dış mekan",
                        "Düzenli sulama",
                        "Renkli çiçekleriyle yaz bahçelerinin vazgeçilmezi",
                        "Ilıman bölgeler",
                        "Tek yıllık",
                        "İki haftada bir",
                        "Düzenli uç alma",
                        "Gerekli değil",
                        "Yazın bol çiçeklenme",
                        "Külleme, yaprak biti",
                        "İyi havalandırma",
                        "Tohum ile üretilir"
                ));
                break;

            case "Sonbahar":
                seasonalPlants.add(new Plant(
                        "Krizantem",
                        "Chrysanthemum",
                        "Haftada bir",
                        "Çiçekli",
                        "Yarı gölge",
                        "Dış mekan",
                        "Orta düzeyde sulama",
                        "Sonbaharın en güzel çiçeklerinden",
                        "Ilıman bölgeler",
                        "Çok yıllık",
                        "Çiçeklenme öncesi",
                        "Çiçeklenme sonrası",
                        "İlkbaharda",
                        "Sonbaharda çiçek açar",
                        "Yaprak lekesi, pas",
                        "İyi havalandırma",
                        "Kök bölünmesi ile"
                ));

                seasonalPlants.add(new Plant(
                        "Kasımpatı",
                        "Aster",
                        "Haftada bir",
                        "Çiçekli",
                        "Güneşli",
                        "Dış mekan",
                        "Düzenli sulama",
                        "Sonbahar bahçelerinin yıldızı",
                        "Ilıman bölgeler",
                        "Çok yıllık",
                        "Büyüme döneminde",
                        "Çiçeklenme sonrası",
                        "2-3 yılda bir",
                        "Sonbaharda çiçeklenir",
                        "Külleme, yaprak biti",
                        "İyi drenaj",
                        "Kök bölünmesi ile"
                ));
                break;

            case "Kış":
                seasonalPlants.add(new Plant(
                        "Yılbaşı Çiçeği",
                        "Euphorbia pulcherrima",
                        "Haftada bir",
                        "Çiçekli",
                        "Parlak ışık",
                        "İç mekan",
                        "Az sulama",
                        "Kış aylarının simgesi",
                        "Sıcak bölgeler",
                        "Çok yıllık",
                        "Çiçeklenme döneminde",
                        "İlkbaharda budama",
                        "2 yılda bir",
                        "Kışın sıcak ortam",
                        "Yaprak dökülmesi",
                        "Aşırı sulamadan kaçınma",
                        "Çelik ile üretilir"
                ));

                seasonalPlants.add(new Plant(
                        "Kaktüs",
                        "Cactaceae",
                        "Ayda bir",
                        "Sukulent",
                        "Parlak ışık",
                        "İç mekan",
                        "Minimum sulama",
                        "Kış bakımı kolay",
                        "Kurak bölgeler",
                        "Çok yıllık",
                        "Yılda 2-3 kez",
                        "Genelde gerekmez",
                        "2-3 yılda bir",
                        "Kışın minimum su",
                        "Kök çürüklüğü",
                        "Aşırı sulamadan kaçınma",
                        "Yaprak veya gövde çeliği"
                ));
                break;
        }

        return seasonalPlants;
    }
}