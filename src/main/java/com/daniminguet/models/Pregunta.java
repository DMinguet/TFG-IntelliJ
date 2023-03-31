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
    @Column(name = "respuesta", nullable = true)
    private String respuesta;
    @ManyToOne
    @JoinColumn(name = "temario_id")
    private Temario temario;
    @ManyToOne
    @JoinColumn(name = "examen_id")
    private Examen examen;

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

    public Temario getTemario() {
        return temario;
    }

    public void setTemario(Temario temario) {
        this.temario = temario;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pregunta pregunta1 = (Pregunta) o;
        return id == pregunta1.id && temario == pregunta1.temario && examen == pregunta1.examen && Objects.equals(pregunta, pregunta1.pregunta) && Objects.equals(respuesta, pregunta1.respuesta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pregunta, respuesta, temario, examen);
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "id=" + id +
                ", pregunta='" + pregunta + '\'' +
                ", respuesta=" + respuesta +
                ", temario=" + temario +
                ", examen=" + examen +
                '}';
    }
}
