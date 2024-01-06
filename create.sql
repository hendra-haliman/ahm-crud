
    create table kendaraan (
       no_registrasi varchar(10) not null,
        alamat varchar(255),
        bahan_bakar varchar(255),
        kapasitas_selinder integer,
        merk varchar(255),
        tahun_pembuatan integer,
        warna_kendaraan varchar(255),
        owner_owner_id bigint,
        primary key (no_registrasi)
    ) engine=InnoDB;

    create table owner (
       owner_id bigint not null auto_increment,
        address varchar(255),
        city varchar(255),
        country varchar(255),
        firstname varchar(255) not null,
        lastname varchar(255),
        postcode varchar(5),
        primary key (owner_id)
    ) engine=InnoDB;

    alter table kendaraan 
       add constraint FKl5u0iajp90l4mddpu3ad5q0gj 
       foreign key (owner_owner_id) 
       references owner (owner_id);
insert into owner(firstname, lastname, address, city, country, postcode)     values ('Hendra', 'Haliman', 'Kluster Latania C12', 'Bogor', 'Indoenesia', '16134');
insert into owner(firstname, lastname, address, city, country, postcode)     values ('Okvie', 'Oktaviana', 'Kluster Latania C12', 'Bogor', 'Indoenesia', '16134');
insert into owner(firstname, lastname, address, city, country, postcode)     values ('Jane', 'Doe', 'Kluster Latania C12', 'Bogor', 'Indoenesia', '16134');
insert into owner(firstname, lastname, address, city, country, postcode)     values ('Sandra', 'Bullock', 'Kluster Latania C12', 'Bogor', 'Indoenesia', '16134');
insert into owner(firstname, lastname, address, city, country, postcode)     values ('Tony', 'S.', 'Kluster Latania C12', 'Bogor', 'Indoenesia', '16134');
insert into owner(firstname, lastname, address, city, country, postcode)     values ('Ray', 'Sebastian', 'Kluster Latania C12', 'Bogor', 'Indoenesia', '16134');
insert into owner(firstname, lastname, address, city, country, postcode)     values ('Roy', 'Suryo', 'Kluster Latania C12', 'Bogor', 'Indoenesia', '16134');
insert into owner(firstname, lastname, address, city, country, postcode)     values ('Tamara', 'Bell', 'Kluster Latania C12', 'Bogor', 'Indoenesia', '16134');
insert into owner(firstname, lastname, address, city, country, postcode)     values ('John', 'Hopkins', 'Kluster Latania C12', 'Bogor', 'Indoenesia', '16134');
insert into kendaraan(no_registrasi, merk, tahun_pembuatan, kapasitas_selinder, warna_kendaraan, bahan_bakar)      values('B123', 'Toyota', 2017, 1500, 'Merah','Bensin');
insert into kendaraan(no_registrasi, merk, tahun_pembuatan, kapasitas_selinder, warna_kendaraan, bahan_bakar)      values('B8889', 'Honda', 2022, 2200, 'Hitam','Bensin');
insert into kendaraan(no_registrasi, merk, tahun_pembuatan, kapasitas_selinder, warna_kendaraan, bahan_bakar)      values('B3484 KL', 'Mazda', 1994, 1350, 'Biru','Bensin');
insert into kendaraan(no_registrasi, merk, tahun_pembuatan, kapasitas_selinder, warna_kendaraan, bahan_bakar)      values('B3290', 'Toyota', 1999, 1800, 'Merah','Solar');
insert into kendaraan(no_registrasi, merk, tahun_pembuatan, kapasitas_selinder, warna_kendaraan, bahan_bakar)      values('B224', 'Toyota', 2018, 1500, 'Biru','Pertamax');
insert into kendaraan(no_registrasi, merk, tahun_pembuatan, kapasitas_selinder, warna_kendaraan, bahan_bakar)      values('B99012', 'Mazda', 2017, 2200, 'Merah','Bensin');
insert into kendaraan(no_registrasi, merk, tahun_pembuatan, kapasitas_selinder, warna_kendaraan, bahan_bakar)      values('B9034', 'Toyota', 2017, 1500, 'Hitam','Bensin');
insert into kendaraan(no_registrasi, merk, tahun_pembuatan, kapasitas_selinder, warna_kendaraan, bahan_bakar)      values('A8830', 'Toyota', 2018, 1200, 'Hitam','Solar');
insert into kendaraan(no_registrasi, merk, tahun_pembuatan, kapasitas_selinder, warna_kendaraan, bahan_bakar)      values('B3410', 'Toyota', 2017, 1500, 'Biru','Bensin');
insert into kendaraan(no_registrasi, merk, tahun_pembuatan, kapasitas_selinder, warna_kendaraan, bahan_bakar)      values('B3700', 'Toyota', 2017, 1500, 'Merah','Bensin');
