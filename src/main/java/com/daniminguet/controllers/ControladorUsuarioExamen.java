package com.daniminguet.controllers;

import com.daniminguet.models.UsuarioHasExamen;
import com.daniminguet.repo.IUsuarioExamenDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarioExamen")
public class ControladorUsuarioExamen {
    @Autowired
    private IUsuarioExamenDao repo;

    @GetMapping("/all")
    public List<UsuarioHasExamen> getExamenesUsuario() {
        return repo.findAll();
    }

    @PostMapping("/add")
    public boolean addExamenUsuario(@RequestBody UsuarioHasExamen examenUsuario) {
        try {
            repo.save(examenUsuario);
            System.out.println("Examen del usuario añadido");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se ha podido añadir el examen del usuario");
            return false;
        }
    }
}
