package com.senai.gerenciamento_epis.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "administrador")


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdministradorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_administrador")
    private int idAdiministrador;

    @Column(name ="Administrador: ")
    private String nmAdministradro;

    @Column(name ="email: ")
    private String email;

    @Column(name ="senha: ")
    private String senha;

    @Column(name ="cpf:")
    private int cpf;

    @ManyToOne
    @JoinColumn(name="id_administrador", referencedColumnName = "id_administrador")
    private AdministradorEntity departamento;


}
