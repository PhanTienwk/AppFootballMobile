package com.example.appfootballmanager.model;

import com.google.gson.annotations.SerializedName;

public class XepHangVongLoai {
    @SerializedName("ma_doi_bong")
    private String maDoiBong;

    @SerializedName("ma_bang_dau")
    private String maBangDau;

    @SerializedName("diem")
    private int diem;

    @SerializedName("so_tran_thang")
    private int soTranThang;

    @SerializedName("so_tran_hoa")
    private int soTranHoa;

    @SerializedName("so_tran_thua")
    private int soTranThua;

    @SerializedName("ban_thang")
    private int banThang;

    @SerializedName("ban_thua")
    private int banThua;

    public XepHangVongLoai(String maDoiBong, String maBangDau, int diem, int soTranThang, int soTranHoa, int soTranThua, int banThang, int banThua) {
        this.maDoiBong = maDoiBong;
        this.maBangDau = maBangDau;
        this.diem = diem;
        this.soTranThang = soTranThang;
        this.soTranHoa = soTranHoa;
        this.soTranThua = soTranThua;
        this.banThang = banThang;
        this.banThua = banThua;
    }

    public String getMaDoiBong() {
        return maDoiBong;
    }

    public void setMaDoiBong(String maDoiBong) {
        this.maDoiBong = maDoiBong;
    }

    public String getMaBangDau() {
        return maBangDau;
    }

    public void setMaBangDau(String maBangDau) {
        this.maBangDau = maBangDau;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public int getSoTranThang() {
        return soTranThang;
    }

    public void setSoTranThang(int soTranThang) {
        this.soTranThang = soTranThang;
    }

    public int getSoTranHoa() {
        return soTranHoa;
    }

    public void setSoTranHoa(int soTranHoa) {
        this.soTranHoa = soTranHoa;
    }

    public int getSoTranThua() {
        return soTranThua;
    }

    public void setSoTranThua(int soTranThua) {
        this.soTranThua = soTranThua;
    }

    public int getBanThang() {
        return banThang;
    }

    public void setBanThang(int banThang) {
        this.banThang = banThang;
    }

    public int getBanThua() {
        return banThua;
    }

    public void setBanThua(int banThua) {
        this.banThua = banThua;
    }
}
