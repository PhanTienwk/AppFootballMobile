package com.example.appfootballmanager.api;

import com.example.appfootballmanager.model.BangDau;
import com.example.appfootballmanager.model.CauThu;
import com.example.appfootballmanager.model.CauThuGiaiDau;
import com.example.appfootballmanager.model.DoiBong;
import com.example.appfootballmanager.model.Giaidau;
import com.example.appfootballmanager.model.KetQuaTranDau;
import com.example.appfootballmanager.model.TranDau;
import com.example.appfootballmanager.model.TrongTai;
import com.example.appfootballmanager.model.ViTriCauThu;
import com.example.appfootballmanager.model.XepHangVongLoai;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiService {

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://192.168.1.20:4002/api/")
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
    Call<List<DoiBong>> getListCauThuDoiBong();

    @GET("ket_qua_tran_dau")
    Call<List<KetQuaTranDau>> getListKetQuaTranDau();

    @GET("trau_dau")
    Call<List<TranDau>> getListTranDau();

    @GET("trong_tai")
    Call<List<TrongTai>> getListTrongTai();

    @GET("vi_tri_cau_thu")
    Call<List<ViTriCauThu>> getListViTriCauThu();

    @GET("xep_hang_vong_loai")
    Call<List<XepHangVongLoai>> getListXepHangVongLoai();
}
