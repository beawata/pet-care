package com.beawata.petcare.repositories;

import com.beawata.petcare.entities.Rotina;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RotinaRepository extends JpaRepository<Rotina, Long> {

    Page<Rotina> findByPetId(Long id, Pageable pageable);
}
