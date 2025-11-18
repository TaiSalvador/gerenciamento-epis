package com.senai.gerenciamento_epis.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "colaborador")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ColaboradorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_colaborador")
    private int idColaborador;

    @Column(name = "nm_colaborador")
    private String nmColaborador;
}
