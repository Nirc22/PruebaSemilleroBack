package com.semillero.pruebaSemillero.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "raf_raza")
public class RafRazaModel {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "nmidraza")
    private Long nmid;

    @Getter @Setter @Column(name = "dsnombre")
    private String dsnombre;

    //@Getter @Setter @Column(name = "nmidespecie")
    //private Long nmidespecie;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "nmidespecie")
    private RafEspecieModel nmidespecie;


}
