package com.daniminguet.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Pregunta {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "pregunta", nullable = true, length = 500)
    private String pregunta;
    @Basic
    @Column(name = "respuesta", nullable = true, length = 1)
    private String respuesta;
    @Basic
    @Column(name = "temario_id", nullable = false)
    private int temarioId;
    @Basic
    @Column(name = "examen_id", nullable = false)
    private int examenId;

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

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getTemarioId() {
        return temarioId;
    }

    public void setTemarioId(int temarioId) {
        this.temarioId = temarioId;
    }

    public int getExamenId() {
        return examenId;
    }

    public void setExamenId(int examenId) {
        this.examenId = examenId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pregunta pregunta1 = (Pregunta) o;
        return id == pregunta1.id && temarioId == pregunta1.temarioId && examenId == pregunta1.examenId && Objects.equals(pregunta, pregunta1.pregunta) && Objects.equals(respuesta, pregunta1.respuesta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pregunta, respuesta, temarioId, examenId);
    }
}
