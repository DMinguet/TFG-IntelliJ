package com.daniminguet.models;

import jakarta.persistence.*;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Objects;

@Entity
@Table(name = "usuario_has_examen", schema = "polesp", catalog = "")
public class UsuarioHasExamen {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "examen_id")
    private Examen examen;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
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
        return id == that.id && usuario == that.usuario && examen == that.examen && Objects.equals(nota, that.nota) && Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, examen, nota, fecha);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return "UsuarioHasExamen{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", examen=" + examen +
                ", nota=" + nota +
                ", fecha=" + sdf.format(fecha) +
                '}';
    }
}
