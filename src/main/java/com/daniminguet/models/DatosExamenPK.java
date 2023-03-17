package com.daniminguet.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class DatosExamenPK implements Serializable {
    @Column(name = "fk_usuario", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fkUsuario;
    @Column(name = "fk_examen", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fkExamen;
    @Column(name = "fk_preguntas", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fkPreguntas;

    public int getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(int fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

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
        DatosExamenPK that = (DatosExamenPK) o;
        return fkUsuario == that.fkUsuario && fkExamen == that.fkExamen && fkPreguntas == that.fkPreguntas;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fkUsuario, fkExamen, fkPreguntas);
    }
}
