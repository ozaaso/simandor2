package com.customs.simandor.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customs.simandor.entitiy.Aset;


@Repository
public interface AsetRepo extends JpaRepository<Aset, String> {


}
