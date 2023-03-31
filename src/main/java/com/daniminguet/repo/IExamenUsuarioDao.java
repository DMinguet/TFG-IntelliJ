package com.daniminguet.repo;

import com.daniminguet.models.ExamenesUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExamenUsuarioDao extends JpaRepository<ExamenesUser, Integer> {
}
