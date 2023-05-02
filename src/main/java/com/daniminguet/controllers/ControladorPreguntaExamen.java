package com.daniminguet.controllers;

import com.daniminguet.models.PreguntaHasExamen;
import com.daniminguet.repo.IPreguntaExamenDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preguntaExamen")
public class ControladorPreguntaExamen {
    @Autowired
    private IPreguntaExamenDao repo;

    @GetMapping("/all")
    public List<PreguntaHasExamen> getPreguntasExamenes() {
        return repo.findAll();
    }

    @PostMapping("/add")
    public boolean addPreguntaExamen(@RequestBody PreguntaHasExamen preguntaExamen) {
        try {
            repo.save(preguntaExamen);
            System.out.println("Pregunta de examen añadida");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se ha podido añadir la pregunta del examen");
            return false;
        }
    }

    @DeleteMapping("/{id}")
    public boolean deletePreguntaExamen(@PathVariable("id") Integer id) {
        try {
            repo.deleteById(id);
            System.out.println("Pregunta de examen eliminada");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se ha podido eliminar la pregunta del examen");
            return false;
        }
    }
}