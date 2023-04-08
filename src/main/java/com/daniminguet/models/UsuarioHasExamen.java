package com.daniminguet.models;

import jakarta.persistence.*;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Objects;

@Entity
@Table(name = "usuario_has_examen", schema = "polesp", catalog = "")
@IdClass(UsuarioHasExamenPK.class)
public class UsuarioHasExamen {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "usuario_id", nullable = false)
    private int usuarioId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "examen_id", nullable = false)
    private int examenId;
    @Basic
    @Column(name = "nota", nullable = true, precision = 0)
    private Double nota;
    @Basic
    @Column(name = "fecha", nullable = true)
    private Date fecha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getExamenId() {
        return examenId;
    }

    public void setExamenId(int examenId) {
        this.examenId = examenId;
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
        UsuarioHasExamen that = (UsuarioHasExamen) o;
        return id == that.id && usuarioId == that.usuarioId && examenId == that.examenId && Objects.equals(nota, that.nota) && Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuarioId, examenId, nota, fecha);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return "UsuarioHasExamen{" +
                "id=" + id +
                ", usuarioId=" + usuarioId +
                ", examenId=" + examenId +
                ", nota=" + nota +
                ", fecha=" + sdf.format(fecha) +
                '}';
    }
}
