package com.senai.gerenciamento_epis.Repo;

import com.senai.gerenciamento_epis.Entity.EmprestimoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<EmprestimoEntity, Integer> {
}
