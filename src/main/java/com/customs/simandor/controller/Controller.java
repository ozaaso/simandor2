package com.customs.simandor.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.customs.simandor.entitiy.Aset;
import com.customs.simandor.repository.AsetRepo;

@RestController
@RequestMapping("/simandor")
public class Controller {
    

    @Autowired 
    AsetRepo asetRepo;

    @GetMapping(value="test")
    public String getHeader() {
    
        return "uji coba berhasil";


    }


    // Contoh endpoint POST untuk menerima data
    @PostMapping(value = "/aset")
    public String postHeader(@RequestBody Aset data) {
        // Misalnya data yang dikirimkan dalam request body

        asetRepo.save(data);
        return "Data berhasil dikirim";
    }

    @GetMapping(value="aset")
    public List<Aset> getAllAset() {

    List<Aset> listAset = asetRepo.findAll();
    return listAset;
        

    }

        @GetMapping(value = "/aset/{id}")
        public ResponseEntity<?> getAsetById(@PathVariable String id) {
            // Validasi jika id kosong
            if (id == null || id.trim().isEmpty()) {
                return ResponseEntity.badRequest().body("ID tidak boleh kosong.");
            }

            // Cari aset berdasarkan ID
            Optional<Aset> aset = asetRepo.findById(id);

            // Jika aset tidak ditemukan
            if (aset.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aset dengan ID " + id + " tidak ditemukan.");
            }

            // Jika aset ditemukan, kembalikan data aset
            return ResponseEntity.ok(aset.get());
        }



        @DeleteMapping(value = "/aset/{id}")
        public String deleteAset(@PathVariable String id) {
            // Cari Aset berdasarkan ID
            Aset existingAset = asetRepo.findById(id).orElse(null);

            if (existingAset == null) {
                return "Aset tidak ditemukan";
            }

            // Hapus Aset
            asetRepo.delete(existingAset);

            return "Aset berhasil dihapus";
        }


                @PutMapping(value = "/aset/{id}")
        public String updateAset(@PathVariable String id, @RequestBody Aset newData) {
            // Cari Aset berdasarkan ID
            Aset existingAset = asetRepo.findById(id).orElse(null);

            if (existingAset == null) {
                return "Aset tidak ditemukan";
            }
            // Simpan perubahan
            // 
            System.out.println(newData.getIdAset());
            newData.setIdAset(id);
            System.out.println(newData.getIdAset());
            asetRepo.save(newData);
            return "Data Aset berhasil diperbarui";
        }







}
