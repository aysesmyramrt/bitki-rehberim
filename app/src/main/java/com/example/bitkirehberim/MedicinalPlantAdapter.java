package com.example.bitkirehberim.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bitkirehberim.R;
import com.example.bitkirehberim.models.MedicinalPlant;
import java.util.List;

public class MedicinalPlantAdapter extends RecyclerView.Adapter<MedicinalPlantAdapter.ViewHolder> {
    private List<MedicinalPlant> plants;
    private OnPlantClickListener listener;

    public interface OnPlantClickListener {
        void onPlantClick(MedicinalPlant plant);
    }

    public MedicinalPlantAdapter(List<MedicinalPlant> plants, OnPlantClickListener listener) {
        this.plants = plants;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_medicinal_plant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MedicinalPlant plant = plants.get(position);
        holder.bind(plant);
    }

    @Override
    public int getItemCount() {
        return plants.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvPlantName;
        private TextView tvScientificName;
        private TextView tvBenefits;
        private Button btnDetails;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPlantName = itemView.findViewById(R.id.tvPlantName);
            tvScientificName = itemView.findViewById(R.id.tvScientificName);
            tvBenefits = itemView.findViewById(R.id.tvBenefits);
            btnDetails = itemView.findViewById(R.id.btnDetails);
        }

        public void bind(MedicinalPlant plant) {
            tvPlantName.setText(plant.getName());
            tvScientificName.setText(plant.getScientificName());
            tvBenefits.setText(plant.getBenefits());

            btnDetails.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onPlantClick(plant);
                }
            });
        }
    }
}