package com.daniminguet.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class PreguntasExamPK implements Serializable {
    @Column(name = "fk_examen", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fkExamen;
    @Column(name = "fk_preguntas", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fkPreguntas;

    public int getFkExamen() {
        return fkExamen;
    }

    public void setFkExamen(int fkExamen) {
        this.fkExamen = fkExamen;
    }

    public int getFkPreguntas() {
        return fkPreguntas;
    }

    public void setFkPreguntas(int fkPreguntas) {
        this.fkPreguntas = fkPreguntas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PreguntasExamPK that = (PreguntasExamPK) o;
        return fkExamen == that.fkExamen && fkPreguntas == that.fkPreguntas;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fkExamen, fkPreguntas);
    }
}
