package com.senai.gerenciamento_epis.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AdministradorDTO {

    private int idAdministrador;

    @NotBlank(message = "Nome do administrador não pode esta vazio")
    @Size(max= 50,message = "Administrador não pode ultrapasar 50 caracteres")
    private String nmadministrador;

}
