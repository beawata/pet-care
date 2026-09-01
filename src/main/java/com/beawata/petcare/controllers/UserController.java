package com.beawata.petcare.controllers;

import com.beawata.petcare.dto.PetDTO;
import com.beawata.petcare.dto.UserDTO;
import com.beawata.petcare.dto.UserInsertDTO;
import com.beawata.petcare.dto.UserUpdateDTO;
import com.beawata.petcare.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    //Método GET para listar todos os users
    @GetMapping
    public ResponseEntity<Page<UserDTO>> findAll(Pageable pageable) {
        Page<UserDTO> list = userService.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    //Método POST para cadastrar um user
    @PostMapping
    public ResponseEntity<UserDTO> insert(@Valid @RequestBody UserInsertDTO dto) {
        UserDTO newDto = userService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newDto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    //Método PUT para atualizar um user
    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @Valid @RequestBody UserUpdateDTO dto) {
        UserDTO dtoUpdated = userService.update(id, dto);
        return ResponseEntity.ok().body(dtoUpdated);
    }

    //Método DELETE para deletar um user
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
