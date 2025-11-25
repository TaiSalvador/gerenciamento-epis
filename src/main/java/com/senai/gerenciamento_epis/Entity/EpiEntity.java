package com.senai.gerenciamento_epis.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
<<<<<<< HEAD
@Table (name = "epis")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class EpiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_epis")
    private int id_epis;

    @Column (name = "nm_epis")
    private String nm_epis;
=======
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

>>>>>>> f721a461b35a1edcfb4e4776553fff6ceb7a38ed

}
