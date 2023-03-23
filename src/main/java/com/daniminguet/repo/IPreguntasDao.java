package com.daniminguet.repo;

import com.daniminguet.models.Preguntas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPreguntasDao extends JpaRepository<Preguntas, Integer> {
}
