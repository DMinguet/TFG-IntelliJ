package com.daniminguet.repo;

import com.daniminguet.models.PreguntasExam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPreguntaExamenDao extends JpaRepository<PreguntasExam, Integer> {
}
