package com.senai.gerenciamento_epis.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class EmprestimoDto {

    private int idEmprestimo;

    @NotBlank(message = "")
    @Size(max = 50, message = "Colaborador não pode ultrapassar 50 caracteres")
    private String nmColaborador;


}
