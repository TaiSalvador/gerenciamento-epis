package com.senai.gerenciamento_epis.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "emprestimo")
@Getter
@Setter
public class EmprestimoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_emprestimo")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_colaborador", nullable = false)
    private ColaboradorEntity colaborador;

    @ManyToOne
    @JoinColumn(name = "id_epi", nullable = false)
    private EpiEntity epi;

    @Column(name = "data_emprestimo")
    private LocalDateTime dataEmprestimo;

    @Column(name = "data_prevista_devolucao")
    private LocalDate dataPrevistaDevolucao;

    @Column(name = "data_devolucao")
    private LocalDateTime dataDevolucao;

    @Column(nullable = false)
    private String status;

    private String observacao;
}
