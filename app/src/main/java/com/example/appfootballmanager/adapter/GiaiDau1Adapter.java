package com.example.appfootballmanager.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appfootballmanager.R;
import com.example.appfootballmanager.model.Giaidau;

import java.util.List;

public class GiaiDau1Adapter extends RecyclerView.Adapter<GiaiDau1Adapter.GiaiDau1ViewAdapter> {

    private List<Giaidau> listGiaidau;
    private OnItemClickListener onItemClickListener; // Use custom interface
    private int selectedPosition = -1;

    public interface OnItemClickListener {
        void onItemClick(Giaidau giaidau);
    }

    public GiaiDau1Adapter(List<Giaidau> listGiaidau) {
        this.listGiaidau = listGiaidau;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public GiaiDau1ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_giai_dau, parent, false);
        return new GiaiDau1ViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GiaiDau1ViewAdapter holder, int position) {
        Giaidau giaidau = listGiaidau.get(position);
        if (giaidau == null) {
            return;
        }
        Glide.with(holder.itemView.getContext())
                .load(giaidau.getHinhAnh())
                .placeholder(R.drawable.logopp)
                .error(R.drawable.logopp)
                .into(holder.logoGiaiDau);
        holder.tenGiaiDau.setText(giaidau.getTenGiaiDau());

        if (position == selectedPosition) {
            holder.itemView.setBackgroundResource(R.drawable.selected_item_background);
        } else {
            holder.itemView.setBackgroundResource(R.drawable.normal_item_background);
        }

        holder.itemView.setOnClickListener(v -> {
            int oldPosition = selectedPosition;
            selectedPosition = holder.getAdapterPosition();
            if (oldPosition != -1) {
                notifyItemChanged(oldPosition);
            }
            notifyItemChanged(selectedPosition);

            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(giaidau);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (listGiaidau != null) {
            return listGiaidau.size();
        }
        return 0;
    }

    public class GiaiDau1ViewAdapter extends RecyclerView.ViewHolder {
        private TextView tenGiaiDau;
        private ImageView logoGiaiDau;

        public GiaiDau1ViewAdapter(@NonNull View itemView) {
            super(itemView);
            tenGiaiDau = itemView.findViewById(R.id.tenGiaiDau);
            logoGiaiDau = itemView.findViewById(R.id.logoGiaiDau);
        }
    }
}