package com.semillero.pruebaSemillero.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "raf_tipoidentificacion")
public class RafTipoDocumentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "nmidtipoidentificacion")
    private Long nmidtipoidentificacion;

    @Getter @Setter @Column(name = "dsnombre")
    private String dsnombre;
}
