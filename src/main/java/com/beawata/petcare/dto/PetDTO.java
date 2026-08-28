package com.beawata.petcare.dto;

import com.beawata.petcare.entities.Pet;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class PetDTO {

    private Long id;
    @Size(min = 3, max = 80, message = "Nome precisa ter entre 3 e 80 caracteres")
    @NotNull(message = "Campo obrigatório")
    private String nome;
    @Size(min = 3, max = 80, message = "Microchip precisa ter entre 3 e 80 caracteres")
    @NotNull(message = "Campo obrigatório")
    private String microchip;

    @NotNull(message = "Campo obrigatório")
    private Long especieId;

    private String especieNome;

    @PastOrPresent(message = "Data de nascimento precisa ser do passado ou igual a data atual")
    @NotNull(message = "Campo obrigatório")
    private LocalDate dataNascimento;

    public PetDTO() {
    }

    public PetDTO(Long id, String nome, String microchip, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.microchip = microchip;
        this.dataNascimento = dataNascimento;
    }

    public PetDTO(Pet entity){
        id = entity.getId();
        nome = entity.getNome();
        microchip = entity.getMicrochip();
        dataNascimento = entity.getDataNascimento();

        //Proteção e Mapeamento da Espécie
        if (entity.getEspecie() != null) {
            especieId = entity.getEspecie().getId();
            especieNome = entity.getEspecie().getNome();
        }
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getEspecieId() {
        return especieId;
    }
    public void setEspecieId(Long especieId) {
        this.especieId = especieId;
    }
    public String getEspecieNome() {
        return especieNome;
    }
    public void setEspecieNome(String especieNome) {}

}
