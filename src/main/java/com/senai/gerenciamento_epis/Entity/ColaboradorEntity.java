package com.senai.gerenciamento_epis.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "colaborador")
@Data


public class ColaboradorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_colaborador")
    private Integer id;

    private String nome;

    @Column(length = 11, nullable = false)
    private String cpf;

    private String cargo;
    private String setor;

    @Column(name = "data_admissao")
    private LocalDate dataAdmissao;

    @Column(name = "status_ativo")
    private Boolean statusAtivo;
}
