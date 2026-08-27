package com.beawata.petcare.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table(name = "tb_pet")
@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDate dataNascimento;
    private String microchip;
    private Tipo tipo;

    @OneToMany(mappedBy = "pet")
    private List<Rotina> rotinas = new ArrayList<>();

    public Pet(Long id, String nome, LocalDate dataNascimento, String microchip, Tipo tipo) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.microchip = microchip;
        this.tipo = tipo;
    }

    public Pet() {
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public List<Rotina> getRotinas() {
        return rotinas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(id, pet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
