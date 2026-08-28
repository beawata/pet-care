package com.beawata.petcare.controllers;

import com.beawata.petcare.dto.EspecieDTO;
import com.beawata.petcare.dto.PetDTO;
import com.beawata.petcare.services.EspecieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/especies")
public class EspecieController {

    @Autowired
    private EspecieService especieService;

    //Método GET para listar todas as especies
    @GetMapping
    public ResponseEntity<Page<EspecieDTO>> findAll(Pageable pageable) {
        Page<EspecieDTO> list = especieService.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<EspecieDTO> save(@Valid @RequestBody EspecieDTO dto) {
        EspecieDTO dtoSaved = especieService.save(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dtoSaved.getId()).toUri();
        return ResponseEntity.created(uri).body(dtoSaved);
    }
}
