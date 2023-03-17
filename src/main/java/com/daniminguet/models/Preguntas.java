package com.daniminguet.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Preguntas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @ManyToOne()
    @JoinColumn(name = "fk_temario")
    private Temario temario;
    @Basic
    @Column(name = "pregunta", nullable = true, length = 500)
    private String pregunta;
    @Basic
    @Column(name = "respuesta", nullable = true)
    private Object respuesta;
    @ManyToMany(mappedBy = "preguntasExam")
    private List<Examen> examenes;
    @ManyToMany(mappedBy = "preguntasUser")
    private List<ExamenesUser> examenesUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Temario getTemario() {
        return temario;
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

    public List<Examen> getExamenes() {
        return examenes;
    }

    public List<ExamenesUser> getExamenesUser() {
        return examenesUser;
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
