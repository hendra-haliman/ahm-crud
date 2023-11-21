package com.test.kendaraan.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Kendaraan {
    @Id
    private String          noRegistrasi;

    private String          namaPemilik;
    private String          alamat;
    private String          merk;
    private Integer         tahunPembuatan;
    private Integer         kapasitasSelinder;
    
    @Enumerated(EnumType.STRING)
    private WarnaKendaraan  warnaKendaraan;
    
    private String          bahanBakar;

    public String getBahanBakar() {
        return bahanBakar;
    }

    public void setBahanBakar(String bahanBakar) {
        this.bahanBakar = bahanBakar;
    }

    public String getNoRegistrasi() {
        return noRegistrasi;
    }

    public void setNoRegistrasi(String noRegistrasi) {
        this.noRegistrasi = noRegistrasi;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public Integer getTahunPembuatan() {
        return tahunPembuatan;
    }

    public void setTahunPembuatan(Integer tahunPembuatan) {
        this.tahunPembuatan = tahunPembuatan;
    }

    public Integer getKapasitasSelinder() {
        return kapasitasSelinder;
    }

    public void setKapasitasSelinder(Integer kapasitasSelinder) {
        this.kapasitasSelinder = kapasitasSelinder;
    }

    public WarnaKendaraan getWarnaKendaraan() {
        return warnaKendaraan;
    }

    public void setWarnaKendaraan(WarnaKendaraan warnaKendaraan) {
        this.warnaKendaraan = warnaKendaraan;
    }    
}
