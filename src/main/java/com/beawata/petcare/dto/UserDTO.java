package com.beawata.petcare.dto;

import com.beawata.petcare.entities.User;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class UserDTO {

    private Long id;
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Email(message = "Email invalido")
    private String email;

    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

    @PastOrPresent(message = "Data invalida")
    @NotNull
    private LocalDate dataNascimento;

    Set<RoleDTO> roles = new HashSet<>();

    public UserDTO() {}

    public UserDTO(Long id, String nome, String email, String telefone, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public UserDTO(User entity){
        id = entity.getId();
        nome = entity.getNome();
        email = entity.getEmail();
        telefone = entity.getTelefone();
        dataNascimento = entity.getDataNascimento();
        entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }

}
