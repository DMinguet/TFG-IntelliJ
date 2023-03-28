package com.daniminguet.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Temario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "tema", nullable = true)
    private Integer tema;
    @Basic
    @Column(name = "titulo", nullable = true, length = 45)
    private String titulo;
    @Basic
    @Column(name = "pdf", nullable = true, length = 100)
    private String pdf;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getTema() {
        return tema;
    }

    public void setTema(Integer tema) {
        this.tema = tema;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Temario temario = (Temario) o;
        return id == temario.id && Objects.equals(tema, temario.tema) && Objects.equals(titulo, temario.titulo) && Objects.equals(pdf, temario.pdf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tema, titulo, pdf);
    }
}
