package com.daniminguet.repo;

import com.daniminguet.models.Temario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITemarioDao extends JpaRepository<Temario, Integer> {
}
