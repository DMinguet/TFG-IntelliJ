package com.daniminguet.controllers;

import com.daniminguet.models.Pregunta;
import com.daniminguet.models.Temario;
import com.daniminguet.models.UsuarioHasExamen;
import com.daniminguet.repo.IPreguntaDao;
import com.daniminguet.repo.ITemarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/temario")
public class ControladorTemario {
    @Autowired
    private ITemarioDao repo;
    @Autowired
    private IPreguntaDao repoRelacion;

    @GetMapping("/all")
    public List<Temario> getTemarios() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Temario> getTemario(@PathVariable("id") Integer id) {
        return repo.findById(id);
    }

    @PostMapping("/add")
    public boolean addTemario(@RequestBody Temario temario) {
        for (Temario tema : repo.findAll()) {
            if (tema.getTema().equals(temario.getTema()) || tema.getTitulo().equals(temario.getTitulo())) {
                System.out.println("El temario ya existe");
                return false;
            }
        }

        try {
            repo.save(temario);
            System.out.println("Temario añadido");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se ha podido añadir el temario");
            return false;
        }
    }

    @PutMapping("/update")
    public boolean updateTemario(@RequestBody Temario temario) {
        int cuentaConcurrencias = 0;

        for (Temario tema : repo.findAll()) {
            if (tema.getTema().equals(temario.getTema()) || tema.getTitulo().equals(temario.getTitulo())) {
                cuentaConcurrencias++;
            }
        }

        if (cuentaConcurrencias > 1) {
            System.out.println("El temario ya existe");
            return false;
        }

        try {
            repo.save(temario);
            System.out.println("Temario actualizado");
            return true;
        } catch (Exception e){
            System.out.println("No se ha podido actualizar el temario");
            return false;
        }
    }

    @DeleteMapping(value = "/{id}")
    public boolean deleteTemario(@PathVariable("id") Integer id) {
        try {
            for (Pregunta pregunta : repoRelacion.findAll()) {
                if (pregunta.getTemario().getId() == id) {
                    pregunta.setTemario(repo.getReferenceById(1));
                    repoRelacion.save(pregunta);
                }
            }

            repo.deleteById(id);
            System.out.println("Temario eliminado correctamente");
            return true;
        } catch (Exception e){
            System.out.println("No se ha podido eliminar el temario");
            e.printStackTrace();
            return false;
        }
    }
}
