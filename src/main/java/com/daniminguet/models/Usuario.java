package com.daniminguet.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Usuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nombre", nullable = true, length = 45)
    private String nombre;
    @Basic
    @Column(name = "apellidos", nullable = true, length = 80)
    private String apellidos;
    @Basic
    @Column(name = "nombre_usuario", nullable = true, length = 45)
    private String nombreUsuario;
    @Basic
    @Column(name = "contrasenya", nullable = true, length = 100)
    private String contrasenya;
    @Basic
    @Column(name = "email", nullable = true, length = 80)
    private String email;
    @Basic
    @Column(name = "admin", nullable = true)
    private Byte admin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Byte getAdmin() {
        return admin;
    }

    public void setAdmin(Byte admin) {
        this.admin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id && Objects.equals(nombre, usuario.nombre) && Objects.equals(apellidos, usuario.apellidos) && Objects.equals(nombreUsuario, usuario.nombreUsuario) && Objects.equals(contrasenya, usuario.contrasenya) && Objects.equals(email, usuario.email) && Objects.equals(admin, usuario.admin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellidos, nombreUsuario, contrasenya, email, admin);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", contrasenya='" + contrasenya + '\'' +
                ", email='" + email + '\'' +
                ", admin=" + admin +
                '}';
    }
}
