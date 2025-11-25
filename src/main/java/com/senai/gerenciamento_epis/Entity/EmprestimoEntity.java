package com.senai.gerenciamento_epis.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Emprestimo")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmprestimoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Empretimo")
    private int idEmprestimo;

    @Column(name = "nm_Emprestimo")
    private String nmEmprestimo;

}
