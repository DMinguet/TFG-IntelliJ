package com.daniminguet.repo;

import com.daniminguet.models.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExamenDao extends JpaRepository<Examen, Integer> {
}
