package com.semillero.pruebaSemillero.dao;

import com.semillero.pruebaSemillero.models.RafAdministradoresModel;

import java.util.List;


public interface RafAuthAdministradorDAO {
    RafAdministradoresModel getEmailPassword(RafAdministradoresModel rafAdministradoresModel);

    void registrarAdministrador(RafAdministradoresModel rafAdministradoresModel);
}
