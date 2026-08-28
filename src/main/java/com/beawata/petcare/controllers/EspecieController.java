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

    //Método GET para buscar uma especie pelo id
    @GetMapping(value = "/{id}")
    public ResponseEntity<EspecieDTO> findById(@PathVariable Long id) {
        EspecieDTO dto = especieService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    //Método POST para adicionar uma especie
    @PostMapping
    public ResponseEntity<EspecieDTO> save(@Valid @RequestBody EspecieDTO dto) {
        EspecieDTO dtoSaved = especieService.save(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dtoSaved.getId()).toUri();
        return ResponseEntity.created(uri).body(dtoSaved);
    }

    //Método PUT para atualizar uma especie
    @PutMapping(value = "/{id}")
    public ResponseEntity<EspecieDTO> update(@PathVariable Long id, @Valid @RequestBody EspecieDTO dto) {
        dto.setId(id);
        EspecieDTO dtoUpdated = especieService.update(dto);
        return ResponseEntity.ok().body(dtoUpdated);
    }

    //Método DELETE para deletar uma especie
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        especieService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
