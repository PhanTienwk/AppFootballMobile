package com.example.appfootballmanager.layout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfootballmanager.R;
import com.example.appfootballmanager.adapter.TranDau1Adapter;
import com.example.appfootballmanager.api.ApiService;
import com.example.appfootballmanager.model.DoiBong;
import com.example.appfootballmanager.model.DoiBongGiaiDau;
import com.example.appfootballmanager.model.Giaidau;
import com.example.appfootballmanager.model.KetQuaTranDau;
import com.example.appfootballmanager.model.News;
import com.example.appfootballmanager.model.SanVanDong;
import com.example.appfootballmanager.model.TranDau;
import com.example.appfootballmanager.model.VongDau;
import com.example.appfootballmanager.modeladapter.TranDauModelAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChiTietGiaidauActivity extends AppCompatActivity {

    private List<VongDau> listVongDau;
    private List<TranDau> listTranDau;
    private List<SanVanDong> listSanVanDong;
    private List<TranDauModelAdapter> listTranDauGiai;
    private List<DoiBong> listDoiBong;
    private List<KetQuaTranDau> listKetQuaTrauDau;
    private TranDau1Adapter tranDau1Adapter;

    private TextView tvTenGiaiDau,tvMotaGiaiDau,tvTenToChucGiaiDau,tvThoiGianBatDau,tvThoiGianKetThuc,tvGioiTinhGiaiDau;
    private RecyclerView rvTranBong,rvBangXepHang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_chi_tiet_giaidau);
        tvTenGiaiDau=findViewById(R.id.tvTenGiaiDau);
        tvMotaGiaiDau=findViewById(R.id.tvMotaGiaiDau);
        tvTenToChucGiaiDau=findViewById(R.id.tvTenToChucGiaiDau);
        tvThoiGianBatDau=findViewById(R.id.tvThoiGianBatDau);
        tvThoiGianKetThuc=findViewById(R.id.tvThoiGianKetThuc);
        tvGioiTinhGiaiDau=findViewById(R.id.tvGioiTinhGiaiDau);
        rvBangXepHang = findViewById(R.id.rvBangXepHang);
        rvTranBong=findViewById(R.id.rvTranBong);
        Intent intent =getIntent();
        Bundle bundle = intent.getBundleExtra("chitietgiaidau");
        Giaidau giaidau = (Giaidau) bundle.getSerializable("giaidau");
        setUpCard(giaidau);
        callApi();
        setuprvTrandau(giaidau);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(ChiTietGiaidauActivity.this);
        rvTranBong.setLayoutManager(linearLayoutManager1);

        DividerItemDecoration itemDecoration1 = new DividerItemDecoration(ChiTietGiaidauActivity.this,DividerItemDecoration.VERTICAL);
        rvTranBong.addItemDecoration(itemDecoration1);
        tranDau1Adapter = new TranDau1Adapter(listTranDauGiai);
        rvTranBong.setAdapter(tranDau1Adapter);
    }



    private void setUpCard(Giaidau giaidau){

        tvTenGiaiDau.setText(giaidau.getTenGiaiDau() != null ?
                giaidau.getTenGiaiDau() : "Chưa có tên giải đấu");

        tvMotaGiaiDau.setText("Mô tả :" +(giaidau.getMoTa() != null && !giaidau.getMoTa().isEmpty() ?
                giaidau.getMoTa() : "Chưa có mô tả"));

        tvTenToChucGiaiDau.setText("Tổ chức: " +
                (giaidau.getTenToChuc() != null ? giaidau.getTenToChuc() : "Chưa xác định"));

        tvGioiTinhGiaiDau.setText("Giải dành cho : " +
                (giaidau.getGioiTinh() != null ? giaidau.getGioiTinh() : "Chưa xác định"));

        String formattedStartDate = formatDate(String.valueOf(giaidau.getNgayBatdau()));
        tvThoiGianBatDau.setText("Ngày bắt đầu: " + formattedStartDate);

        String formattedEndDate = formatDate(String.valueOf(giaidau.getNgayKetThuc()));
        tvThoiGianKetThuc.setText("Ngày kết thúc: " + formattedEndDate);
    }

    private void callApi(){
        listTranDau = new ArrayList<>();
        listSanVanDong = new ArrayList<>();
        listVongDau = new ArrayList<>();
        listDoiBong = new ArrayList<>();
        listKetQuaTrauDau = new ArrayList<>();
        ApiService.apiService.getListTranDau().enqueue(new Callback<List<TranDau>>() {
            @Override
            public void onResponse(Call<List<TranDau>> call, Response<List<TranDau>> response) {
                listTranDau=response.body();
            }

            @Override
            public void onFailure(Call<List<TranDau>> call, Throwable t) {
                Log.e("ApiError", "Failed to fetch TranDau: " + t.getMessage(), t);
                Toast.makeText(ChiTietGiaidauActivity.this, "Fail api trandau: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Toast.makeText(ChiTietGiaidauActivity.this, "Fail api trandau", Toast.LENGTH_SHORT).show();
            }
        });
        ApiService.apiService.getListSanVanDong().enqueue(new Callback<List<SanVanDong>>() {
            @Override
            public void onResponse(Call<List<SanVanDong>> call, Response<List<SanVanDong>> response) {
                listSanVanDong=response.body();
            }

            @Override
            public void onFailure(Call<List<SanVanDong>> call, Throwable t) {
                Toast.makeText(ChiTietGiaidauActivity.this, "Fail api svd", Toast.LENGTH_SHORT).show();
            }
        });
        ApiService.apiService.getListVongDau().enqueue(new Callback<List<VongDau>>() {
            @Override
            public void onResponse(Call<List<VongDau>> call, Response<List<VongDau>> response) {
                listVongDau=response.body();
            }

            @Override
            public void onFailure(Call<List<VongDau>> call, Throwable t) {
                Toast.makeText(ChiTietGiaidauActivity.this, "Fail api vong dau", Toast.LENGTH_SHORT).show();
            }
        });
        ApiService.apiService.getListDoiBong().enqueue(new Callback<List<DoiBong>>() {
            @Override
            public void onResponse(Call<List<DoiBong>> call, Response<List<DoiBong>> response) {
                listDoiBong=response.body();
            }

            @Override
            public void onFailure(Call<List<DoiBong>> call, Throwable t) {
                Toast.makeText(ChiTietGiaidauActivity.this, "Fail api doibong", Toast.LENGTH_SHORT).show();
            }
        });
        ApiService.apiService.getListKetQuaTranDau().enqueue(new Callback<List<KetQuaTranDau>>() {
            @Override
            public void onResponse(Call<List<KetQuaTranDau>> call, Response<List<KetQuaTranDau>> response) {
                listKetQuaTrauDau=response.body();
            }

            @Override
            public void onFailure(Call<List<KetQuaTranDau>> call, Throwable t) {
                Toast.makeText(ChiTietGiaidauActivity.this, "Fail api ketqua", Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void setuprvTrandau(Giaidau giaidau){
        if(listTranDau==null || listTranDau.isEmpty()) return;
        List<TranDau> listtd = new ArrayList<>();
        for (TranDau tranDau:listTranDau){
            if(tranDau.getMaGiaiDau().equals(giaidau.getMaGiaidau())){
                listtd.add(tranDau);
            }
        }
        listTranDauGiai= new ArrayList<>();
        for(TranDau trandau : listtd){
            TranDauModelAdapter trandau1 = new TranDauModelAdapter();
            trandau1.setTyso("VS");
            trandau1.setGio(String.valueOf(trandau.getGioDienRa()));
            trandau1.setNgay(formatDate2(String.valueOf(trandau.getNgayDienRa())));
            for(VongDau vd:listVongDau){
                if(vd.getMaVongDau().equals(trandau.getMaVongDau())){
                    trandau1.setVongdau(vd.getTenVong());
                    break;
                }
            }
            for(SanVanDong vd:listSanVanDong){
                if(vd.getMaSan().equals(trandau.getSanVanDong())){
                    trandau1.setSanvandong(vd.getTen_san());
                    break;
                }
            }
            for(KetQuaTranDau vd:listKetQuaTrauDau){
                if(vd.getMaTranDau().equals(trandau.getMaTranDau())){
                    trandau1.setTyso(vd.getSoBanDoi1()+"-"+vd.getSoBanDoi2());
                    break;
                }
            }
            for(DoiBong db :listDoiBong){
                if(db.getMaDoiBong().equals(trandau.getMaDoi1())){
                    trandau1.setHinhAnhDoi1(db.getLogo());
                    trandau1.setTenDoi1(db.getTenDoiBong());
                }
                if(db.getMaDoiBong().equals(trandau.getMaDoi2())){
                    trandau1.setHinhAnhDoi2(db.getLogo());
                    trandau1.setTenDoi2(db.getTenDoiBong());
                }
            }
            listTranDauGiai.add(trandau1);
        }

    }

    private String formatDate(String dateString) {
        if (dateString == null || dateString.isEmpty()) {
            return "Chưa xác định";
        }
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            Date date = inputFormat.parse(dateString);

            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return dateString;
        }
    }
    private String formatDate2(String dateString) {
        if (dateString == null || dateString.isEmpty()) {
            return "Chưa xác định";
        }
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date date = inputFormat.parse(dateString);

            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return dateString;
        }
    }
}