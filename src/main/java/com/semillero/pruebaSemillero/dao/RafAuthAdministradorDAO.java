package com.semillero.pruebaSemillero.dao;

import com.semillero.pruebaSemillero.models.RafAdministradoresModel;
import com.semillero.pruebaSemillero.models.RafPacientesModel;

import java.util.List;


public interface RafAuthAdministradorDAO {
    RafAdministradoresModel getEmailPassword(RafAdministradoresModel rafAdministradoresModel);

    void registrarAdministrador(RafAdministradoresModel rafAdministradoresModel);

    void registrarPaciente(RafPacientesModel rafPacientesModel);

}
