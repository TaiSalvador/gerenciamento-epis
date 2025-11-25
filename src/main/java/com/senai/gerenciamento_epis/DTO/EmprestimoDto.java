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

    @NotBlank(message = "Nome do emprestimo naão pode esta vazio")
    @Size(max = 50, message = "Nome do emprestimo não pode ultrapassar 50 caracteres")
    private String nmEmpretimo;


}
