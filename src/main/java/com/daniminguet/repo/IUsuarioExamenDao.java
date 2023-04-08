package com.daniminguet.repo;

import com.daniminguet.models.UsuarioHasExamen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioExamenDao extends JpaRepository<UsuarioHasExamen, Integer> {
}
