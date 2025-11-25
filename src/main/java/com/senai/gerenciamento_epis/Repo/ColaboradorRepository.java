package com.senai.gerenciamento_epis.Repo;

import com.senai.gerenciamento_epis.Entity.ColaboradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ColaboradorRepository extends JpaRepository<ColaboradorEntity, Integer> {


    void deleteAllById(int id);

}
