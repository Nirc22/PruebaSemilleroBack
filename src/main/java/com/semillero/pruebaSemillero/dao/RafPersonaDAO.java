package com.semillero.pruebaSemillero.dao;

import com.semillero.pruebaSemillero.models.RafPersonasModel;

import java.util.List;
import java.util.Optional;

public interface RafPersonaDAO {

    List<RafPersonasModel> getPersonas();

    void registrarPersona(RafPersonasModel rafPersonasModel);

    void actualizarPersona(Long id, RafPersonasModel rafPersonasModel);

    Optional<RafPersonasModel> getPersonaId(Long id);
}
