package com.beawata.petcare.dto;

import com.beawata.petcare.entities.Rotina;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class RotinaDTO {

    private Long id;

    @FutureOrPresent(message = "A data deve ser presente ou futura")
    @NotNull(message ="Campo obrigatório")
    private LocalDate data;
    @NotNull(message ="Campo obrigatório")
    @PositiveOrZero(message = "O peso deve ser positivo")
    @NotNull(message ="Campo obrigatório")
    private Double peso;
    @NotNull(message ="Campo obrigatório")
    private Boolean alimentacao;
    @Size(min = 8, max = 150, message = "Campo obrigatório")
    @NotNull(message ="Campo obrigatório")
    private String observacao;
    @NotNull(message ="Campo obrigatório")
    private Long petId;

    public RotinaDTO() {
    }

    public RotinaDTO(Long id, LocalDate data, Double peso, Boolean alimentacao, String observacao, Long petId) {
        this.id = id;
        this.data = data;
        this.peso = peso;
        this.alimentacao = alimentacao;
        this.observacao = observacao;
        this.petId = petId;
    }

    public RotinaDTO(Rotina entity){
        id = entity.getId();
        data = entity.getData();
        peso = entity.getPeso();
        alimentacao = entity.getAlimentacao();
        observacao = entity.getObservacao();

        if(entity.getPet() != null) {
            petId = entity.getPet().getId();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Boolean getAlimentacao() {
        return alimentacao;
    }

    public void setAlimentacao(Boolean alimentacao) {
        this.alimentacao = alimentacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }
}
