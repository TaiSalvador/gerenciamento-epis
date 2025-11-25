package com.senai.gerenciamento_epis.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class EmprestimoDto {

    private Integer idEmprestimo;

    private Integer idColaborador;

    private Integer idEpi;

    private LocalDateTime dataEmprestimo;

    private LocalDate dataPrevistaDevolucao;

    private LocalDateTime dataDevolucao;

    private String status;

    private String observacao;
}
