package com.daniminguet.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Examen {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "titulo", nullable = true, length = 45)
    private String titulo;
    @ManyToMany(mappedBy = "examenes")
    private List<Usuario> usuarios;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "preguntas_exam",
            joinColumns = {@JoinColumn(name = "fk_examen")},
            inverseJoinColumns = {@JoinColumn(name = "fk_preguntas")}
    )
    private List<Preguntas> preguntasExam;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Preguntas> getPreguntasExam() {
        return preguntasExam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Examen examen = (Examen) o;
        return id == examen.id && Objects.equals(titulo, examen.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo);
    }
}
