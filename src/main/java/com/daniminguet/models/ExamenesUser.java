package com.daniminguet.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "examenes_user", schema = "academiapolesp", catalog = "")
@IdClass(ExamenesUserPK.class)
public class ExamenesUser {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "fk_usuario", nullable = false)
    private int fkUsuario;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "fk_examen", nullable = false)
    private int fkExamen;
    @Basic
    @Column(name = "nota", nullable = true, precision = 0)
    private Double nota;
    @Basic
    @Column(name = "fecha", nullable = true)
    private Date fecha;

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

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamenesUser that = (ExamenesUser) o;
        return fkUsuario == that.fkUsuario && fkExamen == that.fkExamen && Objects.equals(nota, that.nota) && Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fkUsuario, fkExamen, nota, fecha);
    }
}
