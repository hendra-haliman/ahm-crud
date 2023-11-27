package com.test.kendaraan.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Kendaraan {
    @Size(min = 1, max = 10, message = "Minimum 1 character and maximum 10 character")
    @NotNull(message = "Cannot be empty")
    @Id
    private String noRegistrasi;

    @Size(min = 1, max = 20, message = "Minimum 1 character and maximum 20 character")
    private String namaPemilik;

    private String alamat;
    private String merk;
    private Integer tahunPembuatan;
    private Integer kapasitasSelinder;

    @Enumerated(EnumType.STRING)
    private WarnaKendaraan warnaKendaraan;

    private String bahanBakar;

}
