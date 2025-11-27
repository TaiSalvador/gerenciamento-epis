package com.senai.gerenciamento_epis.DTO;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

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
