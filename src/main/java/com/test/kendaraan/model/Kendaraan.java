package com.test.kendaraan.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Kendaraan {
    @Size(min = 1, max = 10, message = "minimum 1 character and maximum 10 character")
    @NotNull
    @Id
    private String noRegistrasi;

    @Size(min = 1, max = 20, message = "minimum 1 character and maximum 20 character")
    private String namaPemilik;
    private String alamat;
    private String merk;
    private Integer tahunPembuatan;
    private Integer kapasitasSelinder;

    @Enumerated(EnumType.STRING)
    private WarnaKendaraan warnaKendaraan;

    private String bahanBakar;

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
