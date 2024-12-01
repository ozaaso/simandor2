package com.customs.simandor.entitiy;



import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;

import lombok.Setter;
import lombok.ToString;


// @NoArgsConstructor
// @AllArgsConstructor
@Setter
@Getter
@ToString


@Entity
@Table(name = "aset")
public class Aset {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // ID di-generate secara otomatis
    private String idAset;  // Tipe data String untuk ID

    
    private String kodeSatker;
    private String namaSatker;
    private String kodeBarang;
    private String namaBarang;
    
    private String hentiGuna;
    private String flagAtb;

    private int nup;
    private String merk;
    private String tipe;
    private String kondisi;
    private String jumlah;
    private String masaGaransi;
    
    private Date tanggalPerolehan;
    private String nilaiPerolehan;
    private int rencanaPenghapusan;

    private String tag;
    private String keterangan;
    private String foto;





}
