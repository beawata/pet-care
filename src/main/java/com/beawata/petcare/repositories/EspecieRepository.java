package com.beawata.petcare.repositories;

import com.beawata.petcare.entities.Especie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecieRepository extends JpaRepository<Especie, Long> {


}
