package com.semillero.pruebaSemillero.dao;

import com.semillero.pruebaSemillero.models.RafPersonasModel;

import java.util.Optional;

public interface RafPersonaDAO {

    //void registrarPersona(RafPersonasModel rafPersonasModel);

    void registrarPersona(RafPersonasModel rafPersonasModel);

    void actualizarPersona(Long id, RafPersonasModel rafPersonasModel);

    Optional<RafPersonasModel> getPersonaId(Long id);
}
