package com.test.kendaraan.model;

public enum WarnaKendaraan {
    Merah("Merah"), Hitam("Hitam"), Biru("Biru"), AbuAbu("Abu Abu");

    private String displayName;

    WarnaKendaraan(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
