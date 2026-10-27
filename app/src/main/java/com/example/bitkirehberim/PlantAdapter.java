package com.example.bitkirehberim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.ArrayList;

public class PlantAdapter extends RecyclerView.Adapter<PlantAdapter.PlantViewHolder> {
    private List<Plant> plants;
    private List<Plant> plantsFull;
    private OnPlantClickListener listener;

    public interface OnPlantClickListener {
        void onPlantClick(Plant plant);
    }

    public PlantAdapter(List<Plant> plants, OnPlantClickListener listener) {
        this.plants = plants;
        this.plantsFull = new ArrayList<>(plants);
        this.listener = listener;
    }

    @NonNull
    @Override
    public PlantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plant, parent, false);
        return new PlantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlantViewHolder holder, int position) {
        Plant plant = plants.get(position);
        holder.bind(plant);
    }

    @Override
    public int getItemCount() {
        return plants.size();
    }

    public void filter(String text) {
        plants.clear();
        if (text.isEmpty()) {
            plants.addAll(plantsFull);
        } else {
            text = text.toLowerCase();
            for (Plant plant : plantsFull) {
                if (plant.getName().toLowerCase().contains(text) ||
                        plant.getLatinName().toLowerCase().contains(text)) {
                    plants.add(plant);
                }
            }
        }
        notifyDataSetChanged();
    }

    class PlantViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPlantImage;
        private TextView tvPlantName;
        private TextView tvPlantLatinName;

        public PlantViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPlantImage = itemView.findViewById(R.id.ivPlantImage);
            tvPlantName = itemView.findViewById(R.id.tvPlantName);
            tvPlantLatinName = itemView.findViewById(R.id.tvPlantLatinName);
        }

        public void bind(Plant plant) {
            tvPlantName.setText(plant.getName());
            tvPlantLatinName.setText(plant.getLatinName());

            // Görseli dinamik olarak ayarlamak için eklediğimiz kod
            int imageResource = getImageResource(plant.getName());
            ivPlantImage.setImageResource(imageResource);

            itemView.setOnClickListener(v -> listener.onPlantClick(plant));
        }

        // Görsel kaynağını bitki adına göre eşle
        private int getImageResource(String plantName) {
            switch (plantName) {
                case "Afrika Menekşesi":
                    return R.drawable.afrikameneksesi;
                case "Açelya":
                    return R.drawable.acelyaa;
                case "Begonya":
                    return R.drawable.begonya;
                case "Barış Çiçeği":
                    return R.drawable.bariscicegi;
                case "Küstüm Çiçeği":
                    return R.drawable.kustumcicegi;
                case "Begonvil":
                    return R.drawable.beg;
                case "Gül":
                    return R.drawable.gul;
                case "Aloe Vera":
                    return R.drawable.aloevera;
                case "Hanımeli":
                    return R.drawable.hanimeli;
                case "Biber":
                    return R.drawable.biber;
                case "Pamuk":
                    return R.drawable.pamuk;
                case "Arpa":
                    return R.drawable.arpa;
                case "Çeltik":
                    return R.drawable.celtik;
                case "Patlıcan":
                    return R.drawable.patlican;
                case "Soğan":
                    return R.drawable.sogan;
                case "Domates":
                    return R.drawable.domates;
                case "Salatalık":
                    return R.drawable.salatalik;
                case "Ortanca":
                    return R.drawable.ortanca;
                case "Sardunya":
                    return R.drawable.sardunya;
                case "Menekşe":
                    return R.drawable.menekse;
                case "Zambak":
                    return R.drawable.zambak;
                case "Papatya":
                    return R.drawable.papatya;
                case "Şakayık":
                    return R.drawable.sakayik;
                case "Ayçiçeği":
                    return R.drawable.aycicegi;
                case "Kasımpatı":
                    return R.drawable.kasimpati;
                case "Lavanta":
                    return R.drawable.lavanta;
                case "Lale":
                    return R.drawable.lale;
                case "Sümbül":
                    return R.drawable.sumbul;
                case "Sukulent":
                    return R.drawable.sukulent;
                case "Benjamin":
                    return R.drawable.benjamin;
                case "Orkide":
                    return R.drawable.orkide;
                case "Kurdele Çiçeği":
                    return R.drawable.kurdelecicegi;
                case "Pothos":
                    return R.drawable.pothos;
                case "Buğday":
                    return R.drawable.bugday;
                case "Mısır":
                    return R.drawable.misir;
                case "Fasulye":
                    return R.drawable.fasulye;
                case "Kabak":
                    return R.drawable.kabak;
                case "Nohut":
                    return R.drawable.nohut;
                case "Mercimek":
                    return R.drawable.mercimek;
                case "Soya":
                    return R.drawable.soya;
                case "Yonca":
                    return R.drawable.yonca;
                case "Patates":
                    return R.drawable.patates;
                case "Şeker Pancarı":
                    return R.drawable.sekerpancari;
                case "Kaktüs":
                    return R.drawable.kaktus;
                default:
                    return R.drawable.acelya; //
            }
        }
    }
}
