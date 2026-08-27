package com.beawata.petcare.dto;

import com.beawata.petcare.entities.Pet;
import com.beawata.petcare.entities.Tipo;

import java.time.LocalDate;

public class PetDTO {

    private Long id;
    private String nome;
    private String microchip;
    private Tipo tipo;
    private LocalDate dataNascimento;

    public PetDTO() {
    }

    public PetDTO(Long id, String nome, String microchip, Tipo tipo, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.microchip = microchip;
        this.tipo = tipo;
        this.dataNascimento = dataNascimento;
    }

    public PetDTO(Pet entity){
        id = entity.getId();
        nome = entity.getNome();
        microchip = entity.getMicrochip();
        tipo = entity.getTipo();
        dataNascimento = entity.getDataNascimento();
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

    public String getMicrochip() {
        return microchip;
    }

    public void setMicrochip(String microchip) {
        this.microchip = microchip;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
