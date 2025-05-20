package com.example.appfootballmanager.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfootballmanager.R;
import com.example.appfootballmanager.model.KetQuaTranDau;
import com.example.appfootballmanager.model.TranDau;

import java.util.List;

public class MatchResultAdapter extends RecyclerView.Adapter<MatchResultAdapter.ViewHolder> {

    private List<KetQuaTranDau> matches;

    public MatchResultAdapter(List<KetQuaTranDau> matches) {
        this.matches = matches;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_kq_tran_dau, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Bind data to views here
        KetQuaTranDau match = matches.get(position);
        holder.team1Text.setText(match.getSoBanDoi1());
        holder.team2Text.setText(match.getSoBanDoi2());
//        holder.scoreText.setText(match.);
        holder.timeText.setText(String.valueOf(match.getMaDoiThang()));
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView team1Text, team2Text, scoreText, timeText;
        ImageView team1Image, team2Image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            team1Text = itemView.findViewById(R.id.tv_team1);
            team2Text = itemView.findViewById(R.id.tv_team2);
            scoreText = itemView.findViewById(R.id.tv_score);
            timeText = itemView.findViewById(R.id.tv_time);
            team1Image = itemView.findViewById(R.id.iv_team1);
            team2Image = itemView.findViewById(R.id.iv_team2);
        }
    }
}
