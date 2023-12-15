package com.semillero.pruebaSemillero.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "raf_personas")
public class RafPersonasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "nmidpersona")
    private Long nmidpersona;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "nmidtipoidentificacion")
    private RafTipoDocumentoModel nmidtipoidentificacion;
    @Getter @Setter @Column(name = "nmidentificacion")
    private int nmidentificacion;
    @Getter @Setter @Column(name = "dsnombre")
    private String dsnombre;
    @Getter @Setter @Column(name = "dsapellido")
    private String dsapellido;
    @Getter @Setter @Column(name = "dsciudad")
    private String dsciudad;
    @Getter @Setter @Column(name = "dsdireccion")
    private String dsdireccion;
    @Getter @Setter @Column(name = "nmtelefono")
    private Long nmtelefono;
}
