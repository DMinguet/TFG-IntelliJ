package com.daniminguet.models;

import jakarta.persistence.*;

import java.util.List;
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
    @OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL)
    private List<PreguntaHasExamen> examenes;

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

    public List<PreguntaHasExamen> getExamenes() {
        return examenes;
    }

    public void setExamenes(List<PreguntaHasExamen> examenes) {
        this.examenes = examenes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pregunta pregunta1 = (Pregunta) o;
        return id == pregunta1.id && temario == pregunta1.temario && Objects.equals(pregunta, pregunta1.pregunta) && Objects.equals(respuesta, pregunta1.respuesta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pregunta, respuesta, temario);
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "id=" + id +
                ", pregunta='" + pregunta + '\'' +
                ", respuesta=" + respuesta +
                ", temario=" + temario +
                ", examenes=" + examenes +
                '}';
    }
}
