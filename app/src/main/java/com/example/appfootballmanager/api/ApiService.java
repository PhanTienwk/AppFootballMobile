package com.example.appfootballmanager.api;

import com.example.appfootballmanager.model.BangDau;
import com.example.appfootballmanager.model.CauThu;
import com.example.appfootballmanager.model.CauThuGiaiDau;
import com.example.appfootballmanager.model.DoiBong;
import com.example.appfootballmanager.model.DoiBongGiaiDau;
import com.example.appfootballmanager.model.Giaidau;
import com.example.appfootballmanager.model.KetQuaTranDau;
import com.example.appfootballmanager.model.SanVanDong;
import com.example.appfootballmanager.model.TranDau;
import com.example.appfootballmanager.model.TrongTai;
import com.example.appfootballmanager.model.ViTriCauThu;
import com.example.appfootballmanager.model.VongDau;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://192.168.110.219:4002/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @GET("giai_dau")
    Call<List<Giaidau>> getListGiaiDau();

    @GET("bang_dau")
    Call<List<BangDau>> getListBangDau();

    @GET("cau_thu")
    Call<List<CauThu>> getListCauThu();

    @GET("cau_thu_giai_dau")
    Call<List<CauThuGiaiDau>> getListCauThuGiaiDau();

    @GET("doi_bong")
    Call<List<DoiBong>> getListDoiBong();

    @GET("ket_qua_tran_dau")
    Call<List<KetQuaTranDau>> getListKetQuaTranDau();

    @GET("tran_dau")
    Call<List<TranDau>> getListTranDau();

    @GET("trong_tai")
    Call<List<TrongTai>> getListTrongTai();

    @GET("vi_tri_cau_thu")
    Call<List<ViTriCauThu>> getListViTriCauThu();

    @GET("doi_bong_giai_dau")
    Call<List<DoiBongGiaiDau>> getListDoiBongGiaiDau();

    @GET("san_van_dong")
    Call<List<SanVanDong>> getListSanVanDong();

    @GET("vong_dau")
    Call<List<VongDau>> getListVongDau();


}
