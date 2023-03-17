package com.daniminguet.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "datos_examen", schema = "academiapolesp", catalog = "")
@IdClass(DatosExamenPK.class)
public class DatosExamen {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "fk_usuario", nullable = false)
    private int fkUsuario;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "fk_examen", nullable = false)
    private int fkExamen;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "fk_preguntas", nullable = false)
    private int fkPreguntas;
    @Basic
    @Column(name = "respuesta_alumno", nullable = true)
    private Object respuestaAlumno;

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

    public int getFkPreguntas() {
        return fkPreguntas;
    }

    public void setFkPreguntas(int fkPreguntas) {
        this.fkPreguntas = fkPreguntas;
    }

    public Object getRespuestaAlumno() {
        return respuestaAlumno;
    }

    public void setRespuestaAlumno(Object respuestaAlumno) {
        this.respuestaAlumno = respuestaAlumno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatosExamen that = (DatosExamen) o;
        return fkUsuario == that.fkUsuario && fkExamen == that.fkExamen && fkPreguntas == that.fkPreguntas && Objects.equals(respuestaAlumno, that.respuestaAlumno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fkUsuario, fkExamen, fkPreguntas, respuestaAlumno);
    }
}
