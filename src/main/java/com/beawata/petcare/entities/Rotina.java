package com.beawata.petcare.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Table(name = "tb_rotina")
@Entity
public class Rotina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private Double peso;
    private Boolean alimentacao;
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Rotina(Long id, LocalDate data, Double peso, Boolean alimentacao, String observacao, Pet pet) {
        this.id = id;
        this.data = data;
        this.peso = peso;
        this.alimentacao = alimentacao;
        this.observacao = observacao;
        this.pet = pet;
    }

    public Rotina() {
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

    public Pet getPet() {
        return pet;
    }
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rotina rotina = (Rotina) o;
        return Objects.equals(id, rotina.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
