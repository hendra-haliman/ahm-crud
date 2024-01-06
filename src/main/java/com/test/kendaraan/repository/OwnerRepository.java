package com.test.kendaraan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.kendaraan.model.Owner;

public interface OwnerRepository extends JpaRepository<Owner, String> {

}
