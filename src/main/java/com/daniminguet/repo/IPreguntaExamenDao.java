package com.daniminguet.repo;

import com.daniminguet.models.PreguntaHasExamen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPreguntaExamenDao extends JpaRepository<PreguntaHasExamen, Integer> {
}
