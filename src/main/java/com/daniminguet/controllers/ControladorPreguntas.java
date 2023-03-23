package com.daniminguet.controllers;

import com.daniminguet.models.Preguntas;
import com.daniminguet.repo.IPreguntasDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/preguntas")
public class ControladorPreguntas {
    @Autowired
    private IPreguntasDao repo;

    @GetMapping("/all")
    public List<Preguntas> getPreguntas() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Preguntas> getPregunta(@PathVariable("id") Integer id) {
        return repo.findById(id);
    }

    @PostMapping("/add")
    public boolean addPreguntas(@RequestBody Preguntas preguntas) {
        for (Preguntas preg : repo.findAll()) {
            if (preg.getPregunta().equals(preguntas.getPregunta())) {
                System.out.println("La pregunta ya existe");
                return false;
            }
        }

        try {
            repo.save(preguntas);
            System.out.println("Pregunta añadido");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se ha podido añadir la pregunta");
            return false;
        }
    }

    @PutMapping("/update")
    public boolean updatePreguntas(@RequestBody Preguntas preguntas) {
        for (Preguntas preg : repo.findAll()) {
            if (preg.getPregunta().equals(preguntas.getPregunta())) {
                System.out.println("La pregunta ya existe");
                return false;
            }
        }

        try {
            repo.save(preguntas);
            System.out.println("Pregunta actualizada");
            return true;
        } catch (Exception e){
            System.out.println("No se ha podido actualizar la pregunta");
            return false;
        }
    }

    @DeleteMapping(value = "/{id}")
    public boolean deletePreguntas(@PathVariable("id") Integer id) {
        try {
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
