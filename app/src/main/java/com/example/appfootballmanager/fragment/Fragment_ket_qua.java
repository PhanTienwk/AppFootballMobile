package com.example.appfootballmanager.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfootballmanager.R;
import com.example.appfootballmanager.adapter.MatchResultAdapter;
import com.example.appfootballmanager.api.ApiService;
import com.example.appfootballmanager.model.Giaidau;
import com.example.appfootballmanager.model.KetQuaTranDau;
import com.example.appfootballmanager.model.TranDau;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_ket_qua extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ket_qua, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getSampleMatches();
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.rv_match_results);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MatchResultAdapter(getSampleMatches()));
    }

    private List<KetQuaTranDau> getSampleMatches() {
        List<KetQuaTranDau> listdd = new ArrayList<>();
        ApiService.apiService.getListKetQuaTranDau().enqueue(new Callback<List<KetQuaTranDau>>() {
            @Override
            public void onResponse(Call<List<KetQuaTranDau>> call, Response<List<KetQuaTranDau>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<KetQuaTranDau> giaiDauList = response.body();
                    for (KetQuaTranDau giaiDau : giaiDauList) {
                        Log.d("GiaiDau", "Tournament: " + giaiDau.getSoBanDoi1() + ", Start Date: " + giaiDau.getSoBanDoi2());
                    }
                    Toast.makeText(getContext(), "Fetched " + giaiDauList.size() + " tournaments", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getActivity(), "Failed to fetch tournaments", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<KetQuaTranDau>> call, Throwable t) {
                Log.e("GiaiDau", "Error: " + t.getMessage());
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return listdd;
    }
}
