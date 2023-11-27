package com.test.kendaraan.service;

import com.test.kendaraan.model.Kendaraan;
import com.test.kendaraan.repository.KendaraanRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class KendaraanService {
    @Autowired
    KendaraanRepository kendaraanRepository;
    
    public List<Kendaraan> listKendaraan() {
        return kendaraanRepository.findAll();
    }

    public Page<Kendaraan> listKendaraan(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.kendaraanRepository.findAll(pageable);
    }
    
    public Kendaraan addKendaraan(Kendaraan kendaraan) {
        return kendaraanRepository.save(kendaraan);
    }
    
    public void deleteKendaraan(Kendaraan kendaraan) {
        kendaraanRepository.delete(kendaraan);
    }
    
    public void deleteKendaraanById(String id) {
        kendaraanRepository.deleteById(id);
    }
    
    public Kendaraan findById(String id) {
         return kendaraanRepository.findById(id).orElseThrow(() -> new RuntimeException("Kendaraan not found"));
    }
    
    public Kendaraan updateKendaraan(Kendaraan kendaraan) {
        return kendaraanRepository.save(kendaraan);
    }
    
    public List<Kendaraan> search(String noRegistrasi) {
        return kendaraanRepository.findByNoRegistrasiContaining(noRegistrasi);
    }
    
}
