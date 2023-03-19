package com.daniminguet.repo;

import com.daniminguet.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioDao extends JpaRepository<Usuario, Integer> {
}
