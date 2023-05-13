package com.daniminguet.controllers;

import com.daniminguet.models.Examen;
import com.daniminguet.models.PreguntaHasExamen;
import com.daniminguet.models.UsuarioHasExamen;
import com.daniminguet.repo.IExamenDao;
import com.daniminguet.repo.IPreguntaExamenDao;
import com.daniminguet.repo.IUsuarioExamenDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/examen")
public class ControladorExamen {
    @Autowired
    private IExamenDao repo;
    @Autowired
    private IUsuarioExamenDao repoUsuarioExamen;
    @Autowired
    private IPreguntaExamenDao repoPreguntaExamen;

    @GetMapping("/all")
    public List<Examen> getExamenes() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Examen> getExamen(@PathVariable("id") Integer id) {
        return repo.findById(id);
    }

    @PostMapping("/add")
    public boolean addExamen(@RequestBody Examen examen) {
        for (Examen exam : repo.findAll()) {
            if (exam.getTitulo().equals(examen.getTitulo())) {
                System.out.println("El examen ya existe");
                return false;
            }
        }

        try {
            repo.save(examen);
            System.out.println("Examen añadido");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se ha podido añadir el examen");
            return false;
        }
    }

    @PutMapping("/update")
    public boolean updateExamen(@RequestBody Examen examen) {
        for (Examen exam : repo.findAll()) {
            if (exam.getTitulo().equals(examen.getTitulo())) {
                System.out.println("El examen ya existe");
                return false;
            }
        }

        try {
            repo.save(examen);
            System.out.println("Examen actualizado");
            return true;
        } catch (Exception e){
            System.out.println("No se ha podido actualizar el examen");
            return false;
        }
    }

    @DeleteMapping(value = "/{id}")
    public boolean deleteExamen(@PathVariable("id") Integer id) {
        try {
            for (UsuarioHasExamen usuarioHasExamen : repoUsuarioExamen.findAll()) {
                if (usuarioHasExamen.getExamen().getId() == id) {
                    repoUsuarioExamen.deleteById(usuarioHasExamen.getId());
                }
            }

            for (PreguntaHasExamen preguntaHasExamen : repoPreguntaExamen.findAll()) {
                if (preguntaHasExamen.getExamen().getId() == id) {
                    repoPreguntaExamen.deleteById(preguntaHasExamen.getId());
                }
            }

            repo.deleteById(id);
            System.out.println("Examen eliminado correctamente");
            return true;
        } catch (Exception e){
            System.out.println("No se ha podido eliminar el examen");
            e.printStackTrace();
            return false;
        }
    }
}
