package com.senai.gerenciamento_epis.DTO;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EpiDTO {

    @NotBlank(message = "Nome do Epi não pode ser vazio")
    @Size(max = 100, message = "Nome do Epi não pode ultrapassar 100 caracteres")
    private String nome;



}

