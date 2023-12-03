package com.test.kendaraan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.kendaraan.model.Kendaraan;

@Repository
public interface KendaraanRepository extends JpaRepository<Kendaraan, String> {
    public List<Kendaraan> findByNoRegistrasiContaining(String text);

    @Query("from Kendaraan where ((noRegistrasi like concat('%', ?1,'%')) or (namaPemilik like concat('%', ?1,'%')))")
    public List<Kendaraan> search(String searchTerm);
}
