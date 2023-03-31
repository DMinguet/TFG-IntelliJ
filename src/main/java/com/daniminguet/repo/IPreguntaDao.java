package com.daniminguet.repo;

import com.daniminguet.models.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPreguntaDao extends JpaRepository<Pregunta, Integer> {
}
