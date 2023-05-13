package com.daniminguet.controllers;

import com.daniminguet.models.Pregunta;
import com.daniminguet.models.PreguntaHasExamen;
import com.daniminguet.repo.IPreguntaDao;
import com.daniminguet.repo.IPreguntaExamenDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pregunta")
public class ControladorPregunta {
    @Autowired
    private IPreguntaDao repo;
    @Autowired
    private IPreguntaExamenDao repoRelacion;

    @GetMapping("/all")
    public List<Pregunta> getPreguntas() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Pregunta> getPregunta(@PathVariable("id") Integer id) {
        return repo.findById(id);
    }

    @PostMapping("/add")
    public boolean addPregunta(@RequestBody Pregunta pregunta) {
        for (Pregunta preg : repo.findAll()) {
            if (preg.getPregunta().equals(pregunta.getPregunta())) {
                System.out.println("La pregunta ya existe");
                return false;
            }
        }

        try {
            repo.save(pregunta);
            System.out.println("Pregunta añadida");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se ha podido añadir la pregunta");
            return false;
        }
    }

    @PutMapping("/update")
    public boolean updatePregunta(@RequestBody Pregunta pregunta) {
        int cuentaConcurrencias = 0;
        for (Pregunta preg : repo.findAll()) {
            if (preg.getPregunta().equals(pregunta.getPregunta())) {
                cuentaConcurrencias++;
            }
        }

        if (cuentaConcurrencias > 1) {
            System.out.println("La pregunta ya existe");
            return false;
        }

        try {
            repo.save(pregunta);
            System.out.println("Pregunta actualizada");
            return true;
        } catch (Exception e){
            System.out.println("No se ha podido actualizar la pregunta");
            return false;
        }
    }

    @DeleteMapping(value = "/{id}")
    public boolean deletePregunta(@PathVariable("id") Integer id) {
        try {
            for (PreguntaHasExamen preguntaHasExamen : repoRelacion.findAll()) {
                if (preguntaHasExamen.getPregunta().getId() == id) {
                    repoRelacion.deleteById(preguntaHasExamen.getId());
                }
            }

            repo.deleteById(id);
            System.out.println("Pregunta eliminada correctamente");
            return true;
        } catch (Exception e){
            System.out.println("No se ha podido eliminar la pregunta");
            e.printStackTrace();
            return false;
        }
    }
}
