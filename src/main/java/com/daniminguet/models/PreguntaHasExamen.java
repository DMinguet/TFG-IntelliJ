package com.daniminguet.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "pregunta_has_examen", schema = "polesp", catalog = "")
public class PreguntaHasExamen {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @ManyToOne
    @JoinColumn(name = "pregunta_id")
    private Pregunta pregunta;
    @ManyToOne
    @JoinColumn(name = "examen_id")
    private Examen examen;

    public int getId() {
        return id;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PreguntaHasExamen that = (PreguntaHasExamen) o;
        return pregunta == that.pregunta && examen == that.examen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pregunta, examen);
    }
}
