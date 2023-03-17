package com.daniminguet.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class ExamenesUserPK implements Serializable {
    @Column(name = "fk_usuario", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fkUsuario;
    @Column(name = "fk_examen", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fkExamen;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamenesUserPK that = (ExamenesUserPK) o;
        return fkUsuario == that.fkUsuario && fkExamen == that.fkExamen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fkUsuario, fkExamen);
    }
}
