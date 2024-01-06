package com.test.kendaraan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ownerId;

    @NotNull
    private String firstname;

    private String lastname;
    private String address;
    private String city;
    private String country;

    @Size(min = 5, max = 5, message = "Length Must be 5")
    private String postcode;

}
