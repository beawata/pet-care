package com.beawata.petcare.controllers;

import com.beawata.petcare.dto.RotinaDTO;
import com.beawata.petcare.services.RotinaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/rotinas")
public class RotinaController {

    @Autowired
    private RotinaService rotinaService;

    //Método GET para listar todas as rotinas de um pet
    @GetMapping(value = "/pet/{petId}")
    public ResponseEntity<Page<RotinaDTO>> findByPetId(@PathVariable Long petId, Pageable pageable) {
        Page<RotinaDTO> list = rotinaService.findByPetIdPaged(petId, pageable);
        return ResponseEntity.ok().body(list);
    }

    //Método GET para listar todas as rotinas
    @GetMapping
    public ResponseEntity<Page<RotinaDTO>> findAll(Pageable pageable) {
        Page<RotinaDTO> list = rotinaService.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    //Método GET para buscar uma rotina pelo id
    @GetMapping(value = "/{id}")
    public ResponseEntity<RotinaDTO> findById(@PathVariable Long id) {
        RotinaDTO dto = rotinaService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    //Método POST para adicionar uma rotina
    @PostMapping
    public ResponseEntity<RotinaDTO> save(@Valid @RequestBody RotinaDTO dto) {
        RotinaDTO dtoSaved = rotinaService.save(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dtoSaved.getId()).toUri();
        return ResponseEntity.ok().body(dtoSaved);
    }

    //Método PUT para atualizar uma rotina
    @PutMapping(value = "/{id}")
    public ResponseEntity<RotinaDTO> update(@PathVariable Long id, @Valid @RequestBody RotinaDTO dto) {
        dto.setId(id);
        RotinaDTO dtoUpdated = rotinaService.update(dto);
        return ResponseEntity.ok().body(dtoUpdated);
    }

    //Método DELETE para deletar uma rotina
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        rotinaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
