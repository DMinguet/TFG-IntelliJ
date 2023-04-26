package com.daniminguet.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "pregunta_has_examen", schema = "polesp", catalog = "")
public class PreguntaHasExamen {
    @ManyToOne
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @JoinColumn(name = "pregunta_id", nullable = false)
    private Pregunta pregunta;
    @ManyToOne
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @JoinColumn(name = "examen_id", nullable = false)
    private Examen examen;

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
