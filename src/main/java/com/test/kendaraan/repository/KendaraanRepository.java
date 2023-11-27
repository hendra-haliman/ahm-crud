package com.test.kendaraan.repository;

import com.test.kendaraan.model.Kendaraan;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KendaraanRepository extends JpaRepository<Kendaraan, String>{
    public List<Kendaraan> findByNoRegistrasiContaining(String text);
}
