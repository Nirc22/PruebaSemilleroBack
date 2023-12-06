package com.semillero.pruebaSemillero.models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "raf_especie")
public class RafEspecieModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "nmidespecie")
    private Long nmid;

    @Getter @Setter @Column(name = "dsnombre")
    private String dsnombre;

    @OneToMany(mappedBy = "nmidespecie")
    private List<RafRazaModel> rafRazaModels;
}
