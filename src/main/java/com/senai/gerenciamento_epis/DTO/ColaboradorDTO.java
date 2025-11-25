package com.senai.gerenciamento_epis.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ColaboradorDTO {

    private int idColaborador;

    @NotBlank(message = "Nome do colaborador não pode ser vazio")
    @Size(max = 50, message = "Colaborador não pode ultrapassar 50 caracteres")
    private String nmColaborador;

    @NotBlank(message = "CPF não pode ser vazio")
    @Size(min = 11, max = 11, message = "O CPF deve conter exatamente 11 dígitos")
    private String cpf;

    @Size(max = 80, message = "O cargo não pode ultrapassar 80 caracteres")
    private String cargo;

    @Size(max = 80, message = "O setor não pode ultrapassar 80 caracteres")
    private String setor;

    private String dataAdmissao;

    private boolean statusAtivo;
}
