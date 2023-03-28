package com.daniminguet.controllers;

import com.daniminguet.models.Usuario;
import com.daniminguet.repo.IUsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class ControladorUsuario {
    @Autowired
    private IUsuarioDao repo;

    @GetMapping("/all")
    public List<Usuario> getUsers() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Usuario> getUser(@PathVariable("id") Integer id) {
        return repo.findById(id);
    }

    @PostMapping("/add")
    public boolean addUser(@RequestBody Usuario usuario) {
        for (Usuario user : repo.findAll()) {
            if (user.getNombre().equals(usuario.getNombre()) && user.getApellidos().equals(usuario.getApellidos()) || user.getNombreUsuario().equals(usuario.getNombreUsuario()) || user.getEmail().equals(usuario.getEmail())) {
                System.out.println("El usuario ya existe");
                return false;
            }
        }

        usuario.setAdmin((byte) 0);

        try {
            repo.save(usuario);
            System.out.println("Usuario añadido");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se ha podido añadir el usuario");
            return false;
        }
    }

    @PutMapping("/update")
    public boolean updateUser(@RequestBody Usuario usuario) {
        int cuentaNbreUsuario = 0;

        for (Usuario user : repo.findAll()) {
            if (user.getNombre().equals(usuario.getNombre()) && user.getApellidos().equals(usuario.getApellidos()) || user.getNombreUsuario().equals(usuario.getNombreUsuario()) || user.getEmail().equals(usuario.getEmail())) {
                cuentaNbreUsuario++;
            }
        }

        if (cuentaNbreUsuario > 1) {
            System.out.println("El usuario ya existe");
            return false;
        }

        try {
            repo.save(usuario);
            System.out.println("Usuario actualizado");
            return true;
        } catch (Exception e){
            System.out.println("No se ha podido actualizar el usuario");
            return false;
        }
    }

    @DeleteMapping(value = "/{id}")
    public boolean deleteUser(@PathVariable("id") Integer id) {
        try {
            repo.deleteById(id);
            System.out.println("Usuario eliminado correctamente");
            return true;
        } catch (Exception e){
            System.out.println("No se ha podido eliminar el usuario");
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario user) {
        System.out.println(user);
        for (Usuario usuario: getUsers()) {
            if (usuario.getNombreUsuario().equals(user.getNombreUsuario()) && usuario.getContrasenya().equals(user.getContrasenya())) {
                return usuario;
            }
        }
        return null;
    }
}
