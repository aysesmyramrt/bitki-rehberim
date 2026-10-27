package com.example.bitkirehberim;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    private PlantAdapter adapter;
    private List<Plant> plants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        TextView tvCategoryName = findViewById(R.id.tvCategoryName);
        RecyclerView recyclerViewPlants = findViewById(R.id.recyclerViewPlants);
        SearchView searchView = findViewById(R.id.searchView);

        Intent intent = getIntent();
        String categoryName = intent.getStringExtra("CATEGORY_NAME");
        tvCategoryName.setText(categoryName);

        plants = getPlantsByCategory(categoryName);

        // RecyclerView ayarları
        recyclerViewPlants.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PlantAdapter(plants, plant -> {
            Intent detailIntent = new Intent(CategoryActivity.this, PlantDetailActivity.class);
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
        });
        recyclerViewPlants.setAdapter(adapter);

        // SearchView ayarları
        searchView.setQueryHint("Bitki ara...");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (adapter != null) {
                    adapter.filter(newText);
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private List<Plant> getPlantsByCategory(String categoryName) {
        List<Plant> plants = new ArrayList<>();
        switch (categoryName) {
            case "Ev Bitkileri":
                plants.add(new Plant(
                        "Afrika Menekşesi",
                        "Saintpaulia",
                        "Haftada bir",
                        "Çiçekli",
                        "Yarı gölge",
                        "İç mekan",
                        "Düzenli sulama ve gübreleme",
                        "Afrika Menekşesi, iç mekanlarda yetiştirilir ve parlak, dolaylı ışığı sever.",
                        "Sıcak ve nemli bölgelerde iyi yetişir",
                        "Çok yıllık bitki",
                        "Ayda bir kez çiçek açma döneminde",
                        "Solmuş çiçek ve yaprakların temizlenmesi",
                        "2-3 yılda bir veya kök sarmada",
                        "Direkt güneş ışığından koruyun, nemli ortam sağlayın",
                        "Yaprak çürümesi, külleme",
                        "İyi havalandırma, aşırı sulamadan kaçınma",
                        "Yaprak çeliği ile üretilir"
                ));

                plants.add(new Plant(

                        "Açelya",
                        "Rhododendron simsii",
                        "Haftada 2-3 kez", "Çiçekli",
                        "Parlak dolaylı ışık",
                        "İç mekan",
                        "Düzenli sulama",
                        "Renkli çiçekleri ile göz alıcı",
                        "Ilıman bölgeler",
                        "Çok yıllık", "İlkbahar-yaz",
                        "Solmuş çiçeklerin alınması",
                        "2 yılda bir",
                        "Asitli toprak sever",
                        "Yaprak dökülmesi",
                        "Düzenli nemlendirme",
                        "Çelik ile üretim"

                ));
                plants.add(new Plant(

                        "Begonya",
                        "Begonia rex",
                        "Haftada bir",
                        "Çiçekli-Yapraklı",
                        "Parlak dolaylı ışık",
                        "İç mekan",
                        "Orta düzeyde sulama",
                        "Dekoratif yaprakları ve çiçekleri var",
                        "Tropik bölgeler",
                        "Çok yıllık",
                        "Yaz boyunca",
                        "Solmuş çiçeklerin alınması",
                        "Yılda bir",
                        "Yüksek nem sever",
                        "Külleme, yaprak lekesi",
                        "İyi havalandırma",
                        "Yaprak çeliği ile"

                ));



                // 18. Barış Çiçeği

                plants.add(new Plant(

                        "Barış Çiçeği",
                        "Spathiphyllum",
                        "Haftada bir",
                        "Çiçekli",
                        "Yarı gölge",
                        "İç mekan",
                        "Düzenli sulama",
                        "Hava temizleyici özelliği var",
                        "Tropik bölgeler",
                        "Çok yıllık",
                        "İlkbahar-yaz",
                        "Solmuş çiçeklerin alınması",
                        "2-3 yılda bir",
                        "Yüksek nem sever",
                        "Yaprak yanıklığı",
                        "Düzenli nemlendirme",
                        "Kök ayırma ile"

                ));
                // 19. Küstüm Çiçeği

                plants.add(new Plant(

                        "Küstüm Çiçeği",
                        "Mimosa pudica",
                        "Haftada 2-3 kez",
                        "Yapraklı",
                        "Parlak dolaylı ışık",
                        "İç mekan",
                        "Nemli toprak",
                        "Dokunulduğunda yaprakları kapanır",
                        "Tropik bölgeler",
                        "Çok yıllık",
                        "Yaz ayları",
                        "Hafif budama",
                        "Yılda bir",
                        "Sıcak ortam sever",
                        "Yaprak dökülmesi",
                        "Düzenli nemlendirme",
                        "Tohum ile üretim"

                ));



                plants.add(new Plant(

                        "Begonvil",
                        "Bougainvillea",
                        "Haftada bir",
                        "Çiçekli-Tırmanıcı",
                        "Direkt güneş",
                        "İç-Dış mekan",
                        "Orta düzeyde sulama",
                        "Renkli çiçekleri ile gösterişli",
                        "Sıcak bölgeler",
                        "Çok yıllık",
                        "İlkbahar-sonbahar",
                        "Düzenli budama",
                        "2-3 yılda bir",
                        "Sıcağı sever",
                        "Yaprak biti",
                        "İyi drenaj",
                        "Çelik ile üretim"

                ));


                plants.add(new Plant(
                        "Aloe Vera",
                        "Aloe barbadensis",
                        "İki haftada bir",
                        "Çiçeksiz",
                        "Parlak ışık",
                        "İç mekan",
                        "Kurudukça sulama",
                        "Aloe Vera, parlak ışığı ve kurak koşulları seven bir bitkidir.",
                        "Sıcak ve kurak bölgeler",
                        "Çok yıllık sukulent",
                        "Yılda 2-3 kez",
                        "Sadece hasarlı yaprakların alınması",
                        "2-3 yılda bir",
                        "Kuraklığa dayanıklı, az bakım gerektirir",
                        "Kök çürüklüğü, yaprak lekeleri",
                        "İyi drenaj, aşırı sulamadan kaçınma",
                        "Kök sürgünleri ile"
                ));

                plants.add(new Plant(
                        "Orkide",
                        "Phalaenopsis",
                        "Haftada bir",
                        "Çiçekli",
                        "Yarı gölge",
                        "İç mekan",
                        "Düzenli sulama ve nemlendirme",
                        "Orkide, nemli ortamları seven ve düzenli nemlendirilmesi gereken bir bitkidir.",
                        "Tropik ve subtropik bölgeler",
                        "Çok yıllık epifitik bitki",
                        "Çiçeklenme döneminde 2 haftada bir",
                        "Sadece kurumuş çiçek sapları kesilir",
                        "2-3 yılda bir veya kök sarmada",
                        "Yüksek nem, özel orkide toprağı gerekli",
                        "Kök çürüklüğü, yaprak lekesi",
                        "İyi havalandırma, aşırı sulamadan kaçınma",
                        "Keiki ve bölme ile çoğaltılır"
                ));

                plants.add(new Plant(
                        "Sukulent",
                        "Sedum morganianum",
                        "İki haftada bir",
                        "Çiçeksiz",
                        "Parlak ışık",
                        "İç mekan",
                        "Kurudukça sulama",
                        "Sukulent, kurak koşulları ve parlak ışığı seven bir bitkidir.",
                        "Kurak ve yarı kurak bölgeler",
                        "Çok yıllık sukulent",
                        "Minimal gübreleme yeterli",
                        "Genellikle gerekli değil",
                        "2-3 yılda bir",
                        "Az su, iyi drene toprak gerekli",
                        "Kök ve gövde çürüklüğü",
                        "Aşırı sulamadan kaçınma",
                        "Yaprak ve gövde çeliği ile"
                ));

                plants.add(new Plant(
                        "Benjamin",
                        "Ficus benjamina",
                        "Haftada bir",
                        "Çiçeksiz",
                        "Parlak ışık",
                        "İç mekan",
                        "Kurudukça sulama",
                        "Benjamin, parlak ışığı seven ve düzenli sulanması gereken bir bitkidir.",
                        "Tropik ve subtropik bölgeler",
                        "Çok yıllık ağaç",
                        "Büyüme döneminde aylık",
                        "Şekil vermek için düzenli budama",
                        "2-3 yılda bir",
                        "Sabit sıcaklık ve nem önemli",
                        "Yaprak dökülmesi, kırmızı örümcek",
                        "Ani yer değişiminden kaçınma",
                        "Çelik ile üretilir"
                ));

                plants.add(new Plant(
                        "Kurdele Çiçeği",
                        "Chlorophytum comosum",
                        "Haftada iki",
                        "Çiçeksiz",
                        "Parlak ışık",
                        "İç mekan",
                        "Düzenli sulama ve nemlendirme",
                        "Kurdele Çiçeği, parlak ışığı ve nemli ortamları seven bir bitkidir.",
                        "Her türlü iklimde yetişebilir",
                        "Çok yıllık otsu bitki",
                        "Büyüme döneminde aylık",
                        "Kurumuş yaprakların alınması",
                        "Yılda bir kez",
                        "Kolay bakım, hava temizleme özelliği",
                        "Yaprak ucu kararması",
                        "Düzenli sulama ve nemlendirme",
                        "Stolonlarından üretilir"
                ));

                plants.add(new Plant(
                        "Pothos",
                        "Epipremnum aureum",
                        "Haftada bir",
                        "Çiçeksiz",
                        "Az ışık",
                        "İç mekan",
                        "Kurudukça sulama",
                        "Pothos, düşük ışık koşullarında bile hayatta kalabilen dayanıklı bir bitkidir.",
                        "Tropik bölgeler",
                        "Çok yıllık tırmanıcı",
                        "Büyüme döneminde aylık",
                        "Uzayan dalların budanması",
                        "2 yılda bir",
                        "Düşük ışıkta bile yaşayabilir",
                        "Yaprak sararması, kök çürüklüğü",
                        "Aşırı sulamadan kaçınma",
                        "Gövde çeliği ile"
                ));

                // Devamı gelecek...
                break;

            case "Bahçe Bitkileri":
                plants.add(new Plant(
                        "Gül",
                        "Rosa",
                        "Haftada iki",
                        "Çiçekli",
                        "Güneşli",
                        "Dış mekan",
                        "Düzenli budama ve sulama",
                        "Gül, bahçelerde yaygın olarak yetiştirilen ve güneşli yerleri seven bir bitkidir.",
                        "Ilıman iklim bölgeleri",
                        "Çok yıllık çalı",
                        "İlkbahar ve yaz aylarında aylık",
                        "Çiçeklenme sonrası ve ilkbaharda ana budama",
                        "3-4 yılda bir yer değiştirme",
                        "Kış koruması gerektirir, düzenli budama önemli",
                        "Külleme, siyah leke hastalığı",
                        "İyi havalandırma, düzenli ilaçlama",
                        "Çelik ve aşı ile üretilir"
                ));

                plants.add(new Plant(
                        "Lale",
                        "Tulipa",
                        "Haftada bir",
                        "Çiçekli",
                        "Güneşli",
                        "Dış mekan",
                        "Toprağın nemli kalmasını sağlama",
                        "Lale, bahar aylarında çiçek açan ve güneşli yerleri seven bir bitkidir.",
                        "Soğuk ve ılıman bölgeler",
                        "Çok yıllık soğanlı",
                        "Dikim öncesi ve çiçeklenme döneminde",
                        "Çiçekler solduktan sonra",
                        "Soğanlar 2-3 yılda bir bölünür",
                        "Sonbaharda dikim, yazın dinlenme",
                        "Soğan çürüklüğü, virüs hastalıkları",
                        "İyi drenaj, aşırı sulamadan kaçınma",
                        "Soğan bölünmesi ile"
                ));

                plants.add(new Plant(

                        "Hanımeli",
                        "Lonicera",
                        "Haftada 2-3 kez",
                        "Çiçekli-Tırmanıcı",
                        "Güneşli-Yarı gölge",
                        "Dış mekan",
                        "Düzenli sulama",
                        "Hoş kokulu çiçekleri var",
                        "Ilıman bölgeler",
                        "Çok yıllık",
                        "İlkbahar-yaz",
                        "Çiçeklenme sonrası",
                        "Gerekli değil",
                        "Tırmanması için destek gerekir",
                        "Yaprak biti",
                        "Düzenli ilaçlama",
                        "Çelik ile üretim"

                ));

                plants.add(new Plant(

                        "Sümbül",
                        "Hyacinthus",
                        "Haftada bir",
                        "Çiçekli",
                        "Güneşli",
                        "Dış mekan",
                        "Orta düzeyde sulama",
                        "Kokulu bahar çiçeği",
                        "Ilıman bölgeler",
                        "Soğanlı",
                        "İlkbahar başı",
                        "Çiçek sapları kesilir",
                        "Soğan bölünmesi",
                        "Sonbaharda dikim",
                        "Soğan çürüklüğü",
                        "İyi drenaj",
                        "Soğan ile üretim"

                ));


                plants.add(new Plant(

                        "Şakayık",
                        "Paeonia", "Haftada bir",
                        "Çiçekli",
                        "Güneşli-Yarı gölge",
                        "Dış mekan",
                        "Düzenli sulama",
                        "Gösterişli çiçekleri var",
                        "Ilıman bölgeler",
                        "Çok yıllık",
                        "İlkbahar sonu",
                        "Solmuş çiçeklerin alınması",
                        "3-4 yılda bir",
                        "Derin dikim ister",
                        "Botrytis", "İyi havalandırma",
                        "Kök bölünmesi ile"

                ));



                plants.add(new Plant(

                        "Ayçiçeği",
                        "Helianthus annuus",
                        "Haftada 2-3 kez",
                        "Çiçekli",
                        "Tam güneş",
                        "Dış mekan", "Bol sulama",
                        "Güneşi takip eder",
                        "Her bölge",
                        "Tek yıllık",
                        "Yaz boyu",
                        "Çiçek kuruduğunda",
                        "Gerekli değil", "Derin köklenir", "Külleme",
                        "İyi havalandırma", "Tohum ile üretim"

                ));

                plants.add(new Plant(

                        "Kasımpatı",
                        "Chrysanthemum",
                        "Haftada bir",
                        "Çiçekli",
                        "Güneşli",
                        "Dış mekan",
                        "Düzenli sulama",
                        "Sonbaharın son çiçeği",
                        "Ilıman bölgeler",
                        "Çok yıllık",
                        "Sonbahar",
                        "Solmuş çiçeklerin alınması",
                        "2-3 yılda bir",
                        "Soğuğa dayanıklı",
                        "Yaprak lekesi",
                        "İyi drenaj",
                        "Kök ayırma ile"

                ));

                plants.add(new Plant(
                        "Lavanta",
                        "Lavandula",
                        "Haftada bir",
                        "Çiçekli",
                        "Güneşli",
                        "Dış mekan",
                        "Az su ve iyi drenaj",
                        "Lavanta, güzel kokusu ve mor çiçekleriyle bilinen dayanıklı bir bitkidir.",
                        "Akdeniz iklimi bölgeleri",
                        "Çok yıllık çalı",
                        "İlkbahar başı ve sonbahar",
                        "Çiçeklenme sonrası sert budama",
                        "3-4 yılda bir bölme",
                        "Kuraklığa dayanıklı, güneşli yer sever",
                        "Kök çürüklüğü, yaprak biti",
                        "İyi drenaj, fazla sulamadan kaçınma",
                        "Çelik ve bölme ile"
                ));

                plants.add(new Plant(
                        "Papatya",
                        "Bellis perennis",
                        "Haftada iki",
                        "Çiçekli",
                        "Güneşli/Yarı gölge",
                        "Dış mekan",
                        "Düzenli sulama",
                        "Papatya, bahçelerin vazgeçilmez çiçeklerinden biridir.",
                        "Ilıman iklim bölgeleri",
                        "Çok yıllık otsu",
                        "Büyüme döneminde aylık",
                        "Solmuş çiçeklerin alınması",
                        "2-3 yılda bir bölme",
                        "Kolay bakım, dayanıklı bitki",
                        "Külleme, yaprak lekesi",
                        "İyi havalandırma",
                        "Tohum ve bölme ile"
                ));

                plants.add(new Plant(
                        "Ortanca",
                        "Hydrangea",
                        "Haftada iki",
                        "Çiçekli",
                        "Yarı gölge",
                        "Dış mekan",
                        "Bol su ve asitli toprak",
                        "Ortanca, büyük çiçek topları ile dikkat çeken bir süs bitkisidir.",
                        "Nemli ve ılıman bölgeler",
                        "Çok yıllık çalı",
                        "İlkbahar ve yaz aylarında",
                        "Şubat ayında ana budama",
                        "3-4 yılda bir",
                        "Asitli toprak ve bol su önemli",
                        "Yaprak lekesi, külleme",
                        "Düzenli sulama ve gübreleme",
                        "Çelik ve daldırma ile"
                ));

                plants.add(new Plant(
                        "Sardunya",
                        "Pelargonium",
                        "Haftada bir",
                        "Çiçekli",
                        "Güneşli",
                        "Dış mekan",
                        "Orta düzeyde sulama",
                        "Sardunya, balkon ve bahçelerde sıkça tercih edilen renkli bir bitkidir.",
                        "Akdeniz iklimi bölgeleri",
                        "Çok yıllık otsu",
                        "Büyüme döneminde 15 günde bir",
                        "Solmuş çiçeklerin alınması",
                        "İlkbaharda yıllık",
                        "Kışın iç mekana alınmalı",
                        "Yaprak lekesi, gri küf",
                        "İyi havalandırma",
                        "Çelik ile üretilir"
                ));

                plants.add(new Plant(
                        "Menekşe",
                        "Viola",
                        "Haftada iki",
                        "Çiçekli",
                        "Yarı gölge",
                        "Dış mekan",
                        "Düzenli sulama",
                        "Menekşe, küçük ve zarif çiçekleriyle bahçeleri süsleyen bir bitkidir.",
                        "Ilıman iklim bölgeleri",
                        "Tek veya çok yıllık",
                        "Çiçeklenme döneminde aylık",
                        "Solmuş çiçeklerin alınması",
                        "Yıllık yenileme",
                        "Nemli toprak sever",
                        "Külleme, yaprak biti",
                        "Düzenli sulama ve gübreleme",
                        "Tohum ve çelik ile"
                ));

                plants.add(new Plant(
                        "Zambak",
                        "Lilium",
                        "Haftada bir",
                        "Çiçekli",
                        "Güneşli",
                        "Dış mekan",
                        "Orta düzeyde sulama",
                        "Zambak, gösterişli çiçekleri ve güzel kokusuyla bilinen bir bitkidir.",
                        "Ilıman iklim bölgeleri",
                        "Çok yıllık soğanlı",
                        "Çiçeklenme öncesi ve sonrası",
                        "Çiçekler solduktan sonra",
                        "Soğanlar 2-3 yılda bir bölünür",
                        "Derin dikim, iyi drenaj önemli",
                        "Soğan çürüklüğü, virüs",
                        "İyi drenaj, aşırı sulamadan kaçınma",
                        "Soğan bölünmesi ile"
                ));

                // Devam edecek...
                break;

            case "Tarla Bitkileri":
                plants.add(new Plant(
                        "Buğday",
                        "Triticum",
                        "Yağmura bağlı",
                        "Tahıl",
                        "Güneşli",
                        "Açık alan",
                        "Düzenli gübreleme",
                        "Buğday, tarımda yaygın olarak yetiştirilen ve güneşli alanları seven bir bitkidir.",
                        "Ilıman ve soğuk iklim bölgeleri",
                        "Tek yıllık",
                        "Ekim öncesi ve sapa kalkma döneminde",
                        "Gerekli değil",
                        "Gerekli değil",
                        "Sonbaharda ekim, yazın hasat",
                        "Pas hastalığı, sürme",
                        "Dayanıklı tohum, münavebe",
                        "Tohum ile üretilir"
                ));

                plants.add(new Plant(
                        "Mısır",
                        "Zea mays",
                        "Haftada bir",
                        "Tahıl",
                        "Güneşli",
                        "Açık alan",
                        "Toprağın nemli kalmasını sağlama",
                        "Mısır, güneşli yerleri seven ve yaygın olarak yetiştirilen bir bitkidir.",
                        "Sıcak ve ılıman bölgeler",
                        "Tek yıllık",
                        "Ekim öncesi ve tepe püskülü döneminde",
                        "Gerekli değil",
                        "Gerekli değil",
                        "İlkbahar ekimi, sonbaharda hasat",
                        "Kök ve sap çürüklüğü",
                        "Münavebe, dengeli gübreleme",
                        "Tohum ile üretilir"
                ));

                plants.add(new Plant(

                        "Fasulye",
                        "Phaseolus vulgaris",
                        "2-3 günde bir",
                        "Sebze",
                        "Tam güneş",
                        "Dış mekan",
                        "Düzenli sulama",
                        "Protein açısından zengin",
                        "Her bölge",
                        "Tek yıllık",
                        "Yaz boyunca",
                        "Düzenli hasat",
                        "Her yıl yeni ekim",
                        "Sırığa sarılır",
                        "Pas hastalığı",
                        "İyi havalandırma",
                        "Tohum ile üretim"

                ));



                // 2. Kabak

                plants.add(new Plant(

                        "Kabak",
                        "Cucurbita pepo",
                        "Günlük",
                        "Sebze",
                        "Tam güneş",
                        "Dış mekan",
                        "Bol sulama",
                        "Yayılıcı gövde yapısı",
                        "Her bölge",
                        "Tek yıllık",
                        "Yaz boyunca",
                        "Düzenli hasat",
                        "Her yıl yeni ekim",
                        "Geniş alan ister",
                        "Külleme",
                        "Havadar ortam",
                        "Tohum ile üretim"

                ));


                plants.add(new Plant(

                        "Patlıcan",
                        "Solanum melongena",
                        "2 günde bir",
                        "Sebze",
                        "Tam güneş",
                        "Dış mekan",
                        "Düzenli sulama",
                        "Sıcak iklim sebzesi",
                        "Sıcak bölgeler",
                        "Tek yıllık",
                        "Yaz boyunca",
                        "Düzenli hasat",
                        "Her yıl yeni ekim",
                        "Destek gerekebilir",
                        "Yaprak biti",
                        "Düzenli ilaçlama",
                        "Fide ile üretim"

                ));

                plants.add(new Plant(

                        "Soğan",
                        "Allium cepa",
                        "Haftada bir",
                        "Sebze",
                        "Tam güneş",
                        "Dış mekan",
                        "Orta düzeyde sulama",
                        "Temel mutfak sebzesi",
                        "Her bölge",
                        "Tek yıllık",
                        "Yaz sonu hasadı",
                        "Yapraklar sararınca",
                        "Her yıl yeni ekim",
                        "Derin dikim istemez",
                        "Soğan mildiyösü",
                        "İyi drenaj",
                        "Tohum veya arpacık"

                ));

                // 5. Domates

                plants.add(new Plant(

                        "Domates",
                        "Solanum lycopersicum",
                        "Günlük",
                        "Sebze",
                        "Tam güneş",
                        "Dış mekan",
                        "Düzenli sulama",
                        "En popüler sebze",
                        "Her bölge",
                        "Tek yıllık",
                        "Yaz boyunca",
                        "Düzenli hasat",
                        "Her yıl yeni ekim",
                        "Destek gerekir",
                        "Mildiyö",
                        "İyi havalandırma",
                        "Fide ile üretim"

                ));


                // 6. Salatalık

                plants.add(new Plant(

                        "Salatalık",
                        "Cucumis sativus",
                        "Günlük",
                        "Sebze",
                        "Tam güneş",
                        "Dış mekan",
                        "Bol sulama",
                        "Serinletici sebze",
                        "Her bölge",
                        "Tek yıllık",
                        "Yaz boyunca",
                        "Düzenli hasat",
                        "Her yıl yeni ekim",
                        "Tırmanması için destek",
                        "Külleme",
                        "İyi havalandırma",
                        "Tohum ile üretim"

                ));



                // 7. Biber

                plants.add(new Plant(

                        "Biber",

                        "Capsicum annuum",

                        "2 günde bir",
                        "Sebze",
                        "Tam güneş",
                        "Dış mekan",
                        "Düzenli sulama",
                        "C vitamini deposu",
                        "Her bölge",
                        "Tek yıllık",
                        "Yaz boyunca",
                        "Düzenli hasat",
                        "Her yıl yeni ekim",
                        "Rüzgardan koruma",
                        "Yaprak biti",
                        "Düzenli ilaçlama",
                        "Fide ile üretim"

                ));
                plants.add(new Plant(
                        "Pamuk",
                        "Gossypium",
                        "Haftada iki",
                        "Endüstriyel",
                        "Güneşli",
                        "Açık alan",
                        "Düzenli sulama",
                        "Pamuk, sıcak iklimlerde yetiştirilen önemli bir endüstri bitkisidir.",
                        "Sıcak iklim bölgeleri",
                        "Tek yıllık",
                        "Ekim öncesi ve çiçeklenme dönemi",
                        "Gerekli değil",
                        "Gerekli değil",
                        "İlkbahar ekimi, sonbaharda hasat",
                        "Solgunluk, yaprak biti",
                        "Düzenli ilaçlama ve kontrol",
                        "Tohum ile üretilir"
                ));

                // Tarla Bitkileri devamı:
                plants.add(new Plant(
                        "Arpa",
                        "Hordeum vulgare",
                        "Haftada bir",
                        "Tahıl",
                        "Güneşli",
                        "Açık alan",
                        "Orta düzeyde sulama",
                        "Arpa, buğdaydan sonra en çok yetiştirilen tahıl bitkisidir.",
                        "Ilıman ve soğuk bölgeler",
                        "Tek yıllık",
                        "Ekim öncesi ve kardeşlenme dönemi",
                        "Gerekli değil",
                        "Gerekli değil",
                        "Sonbahar veya ilkbahar ekimi",
                        "Külleme, rastık",
                        "Münavebe, dengeli gübreleme",
                        "Tohum ile üretilir"
                ));

                plants.add(new Plant(
                        "Çeltik",
                        "Oryza sativa",
                        "Sürekli su",
                        "Tahıl",
                        "Güneşli",
                        "Su bazlı",
                        "Sürekli su altında tutma",
                        "Çeltik, su içinde yetiştirilen önemli bir besin kaynağıdır.",
                        "Sıcak ve nemli bölgeler",
                        "Tek yıllık",
                        "Fide döneminde ve sapa kalkma",
                        "Gerekli değil",
                        "Gerekli değil",
                        "İlkbahar ekimi, sonbahar hasadı",
                        "Piricularia, bakteriyel yanıklık",
                        "Su seviyesi kontrolü, ilaçlama",
                        "Tohum ile üretilir"
                ));

                plants.add(new Plant(
                        "Nohut",
                        "Cicer arietinum",
                        "İki haftada bir",
                        "Baklagil",
                        "Güneşli",
                        "Açık alan",
                        "Az su ihtiyacı",
                        "Nohut, kuraklığa dayanıklı önemli bir protein kaynağıdır.",
                        "Kurak ve yarı kurak bölgeler",
                        "Tek yıllık",
                        "Ekim öncesi",
                        "Gerekli değil",
                        "Gerekli değil",
                        "İlkbahar ekimi, yaz sonu hasadı",
                        "Antraknoz, kök çürüklüğü",
                        "Münavebe, hastalıklı bitkilerin uzaklaştırılması",
                        "Tohum ile üretilir"
                ));

                plants.add(new Plant(
                        "Mercimek",
                        "Lens culinaris",
                        "İki haftada bir",
                        "Baklagil",
                        "Güneşli",
                        "Açık alan",
                        "Az su ihtiyacı",
                        "Mercimek, protein açısından zengin bir baklagil bitkisidir.",
                        "Kurak ve yarı kurak bölgeler",
                        "Tek yıllık",
                        "Ekim öncesi",
                        "Gerekli değil",
                        "Gerekli değil",
                        "Sonbahar veya ilkbahar ekimi",
                        "Kök çürüklüğü, pas hastalığı",
                        "Münavebe, sağlıklı tohum kullanımı",
                        "Tohum ile üretilir"
                ));

                plants.add(new Plant(
                        "Soya",
                        "Glycine max",
                        "Haftada bir",
                        "Baklagil",
                        "Güneşli",
                        "Açık alan",
                        "Düzenli sulama",
                        "Soya, protein ve yağ bakımından zengin bir endüstri bitkisidir.",
                        "Ilıman ve sıcak bölgeler",
                        "Tek yıllık",
                        "Ekim öncesi ve çiçeklenme dönemi",
                        "Gerekli değil",
                        "Gerekli değil",
                        "İlkbahar ekimi, sonbahar hasadı",
                        "Kök çürüklüğü, bakteriyel yanıklık",
                        "Münavebe, dengeli gübreleme",
                        "Tohum ile üretilir"
                ));

                plants.add(new Plant(
                        "Yonca",
                        "Medicago sativa",
                        "Haftada bir",
                        "Yem bitkisi",
                        "Güneşli",
                        "Açık alan",
                        "Düzenli sulama",
                        "Yonca, önemli bir yem bitkisi ve toprak ıslah bitkisidir.",
                        "Ilıman ve sıcak bölgeler",
                        "Çok yıllık",
                        "İlkbahar ve yaz başında",
                        "Her biçimden sonra",
                        "Gerekli değil",
                        "4-5 yıl aynı tarlada kalabilir",
                        "Küsküt, yonca hortumlu böceği",
                        "Düzenli biçim, zararlı kontrolü",
                        "Tohum ile üretilir"
                ));

                plants.add(new Plant(
                        "Patates",
                        "Solanum tuberosum",
                        "Haftada iki",
                        "Yumru bitki",
                        "Güneşli",
                        "Açık alan",
                        "Düzenli sulama",
                        "Patates, önemli bir karbonhidrat kaynağı ve endüstri bitkisidir.",
                        "Ilıman bölgeler",
                        "Tek yıllık",
                        "Dikim öncesi ve çiçeklenme dönemi",
                        "Boğaz doldurma önemli",
                        "Gerekli değil",
                        "İlkbahar ekimi, yaz sonu hasadı",
                        "Mildiyö, patates böceği",
                        "İlaçlama, münavebe",
                        "Yumru ile üretilir"
                ));

                plants.add(new Plant(
                        "Şeker Pancarı",
                        "Beta vulgaris",
                        "Haftada iki",
                        "Endüstriyel",
                        "Güneşli",
                        "Açık alan",
                        "Düzenli sulama",
                        "Şeker pancarı, şeker üretiminde kullanılan önemli bir endüstri bitkisidir.",
                        "Ilıman bölgeler",
                        "İki yıllık",
                        "Çıkış sonrası ve kök gelişimi döneminde",
                        "Yaprak seyreltmesi",
                        "Gerekli değil",
                        "İlkbahar ekimi, sonbahar hasadı",
                        "Cercospora yaprak lekesi, kök çürüklüğü",
                        "Münavebe, dengeli gübreleme",
                        "Tohum ile üretilir"
                ));

                break;
        }
        return plants;
    }
}
