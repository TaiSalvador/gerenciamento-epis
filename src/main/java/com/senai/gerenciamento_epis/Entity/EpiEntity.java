package com.senai.gerenciamento_epis.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "epi")
@Data
public class EpiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_epi")
    private Integer id;

    @Column(name = "nome_epi")
    private String nomeEpi;

    @Column(name = "tipo_epi")
    private String tipoEpi;

    private String descricao;
    private String tamanho;
    private LocalDate validade;
    private String situacao;
}
