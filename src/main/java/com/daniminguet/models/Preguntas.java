package com.daniminguet.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Preguntas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "pregunta", nullable = true, length = 500)
    private String pregunta;
    @Basic
    @Column(name = "respuesta", nullable = true)
    private Object respuesta;
    @Basic
    @Column(name = "fk_temario", nullable = false)
    private int fkTemario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Object getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Object respuesta) {
        this.respuesta = respuesta;
    }

    public int getFkTemario() {
        return fkTemario;
    }

    public void setFkTemario(int fkTemario) {
        this.fkTemario = fkTemario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Preguntas preguntas = (Preguntas) o;
        return id == preguntas.id && fkTemario == preguntas.fkTemario && Objects.equals(pregunta, preguntas.pregunta) && Objects.equals(respuesta, preguntas.respuesta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pregunta, respuesta, fkTemario);
    }

    @Override
    public String toString() {
        return "Preguntas{" +
                "id=" + id +
                ", pregunta='" + pregunta + '\'' +
                ", respuesta=" + respuesta +
                ", fkTemario=" + fkTemario +
                '}';
    }
}
