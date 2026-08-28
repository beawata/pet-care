package com.beawata.petcare.dto;

import com.beawata.petcare.entities.Especie;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EspecieDTO {

    private Long id;

    @Size(min = 3, max = 30, message = "Nome precisa ter entre 3 e 80 caracteres")
    @NotNull(message = "Campo obrigatório")
    private String nome;

    @Size(min = 3, max = 180, message = "Descrição precisa ter entre 3 e 80 caracteres")
    @NotNull(message = "Campo obrigatório")
    private String descricao;

    public EspecieDTO(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public EspecieDTO() {}

    public EspecieDTO(Especie entity) {
        id = entity.getId();
        nome = entity.getNome();
        descricao = entity.getDescricao();
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
