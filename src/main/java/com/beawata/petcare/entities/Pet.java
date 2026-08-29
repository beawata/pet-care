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

    @OneToMany(mappedBy = "pet")
    private List<Rotina> rotinas = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "especie_id")
    private Especie especie;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private User tutor;

    public Pet(Long id, String nome, LocalDate dataNascimento, String microchip) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.microchip = microchip;
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


    public List<Rotina> getRotinas() {
        return rotinas;
    }

    public Especie getEspecie() {
        return especie;
    }
    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public User getTutor() {
        return tutor;
    }
    public void setTutor(User tutor) {
        this.tutor = tutor;
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
