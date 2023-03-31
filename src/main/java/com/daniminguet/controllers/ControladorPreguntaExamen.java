package com.daniminguet.controllers;

import com.daniminguet.models.PreguntasExam;
import com.daniminguet.repo.IPreguntaExamenDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/preguntaExamen")
public class ControladorPreguntaExamen {

    @Autowired
    private IPreguntaExamenDao repo;

    @GetMapping("/all")
    public List<PreguntasExam> getPreguntasExamen() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<PreguntasExam> getPreguntaExamen(@PathVariable("id") Integer id) {
        return repo.findById(id);
    }

    @PostMapping("/add")
    public boolean addPreguntasExamen(@RequestBody PreguntasExam preguntas) {
        for (PreguntasExam preg : repo.findAll()) {
            if (preg.getFkExamen() == preguntas.getFkExamen() && preg.getFkPreguntas() == preguntas.getFkPreguntas()) {
                System.out.println("La pregunta del temario ya existe");
                return false;
            }
        }

        try {
            repo.save(preguntas);
            System.out.println("Pregunta de temario añadida");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se ha podido añadir la pregunta de temario");
            return false;
        }
    }
}
