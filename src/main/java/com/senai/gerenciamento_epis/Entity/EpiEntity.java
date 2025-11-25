package com.senai.gerenciamento_epis.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Epi")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EpiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Epi")
    private int idEpi;

    @Column(name = "nm_Emprestimo")
    private String nmEpi;


}
