package com.test.kendaraan.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.test.kendaraan.constraint.NoRegistrasiConstraint;

import lombok.Data;

@Entity
@Data
public class Kendaraan {
    @Size(min = 1, max = 10, message = "{kendaraan.noRegistrasi.minimum}")
    @NotNull(message = "{kendaraan.noRegistrasi.notNull}")
    @Id
    @NoRegistrasiConstraint
    private String noRegistrasi;

    // @Size(min = 1, max = 20, message = "${kendaraan.namaPemilik.size}")
    // private String namaPemilik;

    private String alamat;
    private String merk;
    private Integer tahunPembuatan;
    private Integer kapasitasSelinder;

    @Enumerated(EnumType.STRING)
    private WarnaKendaraan warnaKendaraan;

    private String bahanBakar;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.PERSIST })
    private Owner owner;

}
