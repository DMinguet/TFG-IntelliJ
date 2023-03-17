package com.daniminguet.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "preguntas_exam", schema = "academiapolesp", catalog = "")
@IdClass(PreguntasExamPK.class)
public class PreguntasExam {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "fk_examen", nullable = false)
    private int fkExamen;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "fk_preguntas", nullable = false)
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
        PreguntasExam that = (PreguntasExam) o;
        return fkExamen == that.fkExamen && fkPreguntas == that.fkPreguntas;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fkExamen, fkPreguntas);
    }
}
