package com.daniminguet.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Preguntas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "fk_temario")
    private int temario;
    @Basic
    @Column(name = "pregunta", nullable = true, length = 500)
    private String pregunta;
    @Basic
    @Column(name = "respuesta", nullable = true)
    private Object respuesta;

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

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    public int getTemario() {
        return temario;
    }

    public void setTemario(int temario) {
        this.temario = temario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Preguntas preguntas = (Preguntas) o;
        return id == preguntas.id && temario == preguntas.temario && Objects.equals(pregunta, preguntas.pregunta) && Objects.equals(respuesta, preguntas.respuesta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, temario, pregunta, respuesta);
    }
}
