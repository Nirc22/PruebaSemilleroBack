package com.semillero.pruebaSemillero.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "raf_administradores")
public class RafAdministradoresModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//funciona para autoincrementar el id
    @Getter @Setter @Column(name = "nmid")
    private int nmid;
    @Getter @Setter @Column(name = "dsnombre")
    private String dsnombre;

    @Getter @Setter @Column(name = "email")
    private String email;

    @Getter @Setter @Column(name = "password")
    private String password;

}
