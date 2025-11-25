package com.senai.gerenciamento_epis.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "epis")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class EpiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_epis")
    private int id_epis;

    @Column (name = "nm_epis")
    private String nm_epis;

}
