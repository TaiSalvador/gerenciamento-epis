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

}
