package com.beawata.petcare.repositories;

import com.beawata.petcare.entities.Rotina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RotinaRepository extends JpaRepository<Rotina, Long> {

    List<Rotina> findByPetId(Long id);
}
