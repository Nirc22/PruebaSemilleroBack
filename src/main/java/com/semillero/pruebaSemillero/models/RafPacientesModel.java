package com.semillero.pruebaSemillero.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "raf_pacientes")
public class RafPacientesModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "nmid")
    private Long nmid;
    @Getter @Setter @Column(name = "dsnombre")
    private String dsnombre;

    //@Getter @Setter @Column(name = "nmidespecie")
    //private int nmidespecie;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "nmidespecie")
    private RafEspecieModel nmidespecie;

    //@Getter @Setter @Column(name = "nmidraza")
    //private int nmidraza;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "nmidraza")
    private RafRazaModel nmidraza;
    @Getter @Setter @Column(name = "fenacimiento")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fenacimiento;

    //@Getter @Setter @Column(name = "nmidtipoidentificacion")
    //private int nmidtipoidentificacion;

    @Getter @Setter @Column(name = "feregistro")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date feregistro;
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "nmidpersona")
    private RafPersonasModel nmidpersona;

}
