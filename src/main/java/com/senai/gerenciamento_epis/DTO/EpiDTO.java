package com.senai.gerenciamento_epis.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EpiDTO {

    private int idEpi;

    @NotBlank(message = "Nome do EPI não pode ser vazio")
    @Size(max = 120, message = "O nome do EPI não pode ultrapassar 120 caracteres")
    private String nmEpi;

    @NotBlank(message = "Tipo do EPI não pode ser vazio")
    @Size(max = 80, message = "O tipo do EPI não pode ultrapassar 80 caracteres")
    private String tipoEpi;

    @Size(max = 255, message = "A descrição não pode ultrapassar 255 caracteres")
    private String descricao;

    @Size(max = 20, message = "O tamanho não pode ultrapassar 20 caracteres")
    private String tamanho;

    private String validade;

    @NotBlank(message = "Situação do EPI é obrigatória")
    private String situacao;
}
