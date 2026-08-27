package com.beawata.petcare.controllers;

import com.beawata.petcare.dto.PetDTO;
import com.beawata.petcare.services.PetService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    //Método GET para listar todos os pets
    @GetMapping
    public ResponseEntity<List<PetDTO>> findAll() {
        List<PetDTO> list = petService.findAll();
        return ResponseEntity.ok().body(list);
    }

    //Método GET para listar um pet pelo id
    @GetMapping(value = "/{id}")
    public ResponseEntity<PetDTO> findById(@PathVariable Long id) {
        PetDTO dto = petService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    //Método POST para salvar um pet
    @PostMapping
    public ResponseEntity<PetDTO> save(@RequestBody PetDTO dto) {
        PetDTO dtoSaved = petService.save(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dtoSaved.getId()).toUri();
        return ResponseEntity.ok().body(dtoSaved);
    }

    //Método PUT para atualizar um pet
    @PutMapping(value = "/{id}")
    public ResponseEntity<PetDTO> update(@PathVariable Long id, @RequestBody PetDTO dto) {
        dto.setId(id);
        PetDTO dtoUpdated = petService.update(dto);
        return ResponseEntity.ok().body(dtoUpdated);
    }

    //Método DELETE para deletar um pet
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        petService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
