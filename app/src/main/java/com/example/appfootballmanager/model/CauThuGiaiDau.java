package com.example.appfootballmanager.model;

import com.google.gson.annotations.SerializedName;

public class CauThuGiaiDau {
    @SerializedName("ma_cau_thu")
    private String maCauThu;

    @SerializedName("ma_doi_bong")
    private String maDoiBong;

    @SerializedName("ma_giai_dau")
    private String maGiaiDau;

    public CauThuGiaiDau(String maCauThu, String maGiaiDau, String maDoiBong) {
        this.maCauThu = maCauThu;
        this.maGiaiDau = maGiaiDau;
        this.maDoiBong = maDoiBong;
    }

    public String getMaCauThu() {
        return maCauThu;
    }

    public void setMaCauThu(String maCauThu) {
        this.maCauThu = maCauThu;
    }

    public String getMaDoiBong() {
        return maDoiBong;
    }

    public void setMaDoiBong(String maDoiBong) {
        this.maDoiBong = maDoiBong;
    }

    public String getMaGiaiDau() {
        return maGiaiDau;
    }

    public void setMaGiaiDau(String maGiaiDau) {
        this.maGiaiDau = maGiaiDau;
    }
}
