package com.daniminguet.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Examen {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "titulo", nullable = true, length = 45)
    private String titulo;

    @OneToMany(mappedBy = "examen", cascade = CascadeType.ALL)
    private List<PreguntaHasExamen> preguntas;

    @OneToMany(mappedBy = "examen")
    private List<UsuarioHasExamen> usuarios;

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

    public List<PreguntaHasExamen> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<PreguntaHasExamen> preguntas) {
        this.preguntas = preguntas;
    }

    public List<UsuarioHasExamen> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioHasExamen> usuarios) {
        this.usuarios = usuarios;
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

    @Override
    public String toString() {
        return "Examen{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", preguntas=" + preguntas +
                ", usuarios=" + usuarios +
                '}';
    }
}
