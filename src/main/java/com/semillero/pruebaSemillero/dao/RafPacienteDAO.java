package com.semillero.pruebaSemillero.dao;

import com.semillero.pruebaSemillero.models.RafPacientesModel;

import java.util.List;
import java.util.Optional;

public interface RafPacienteDAO {

    List<RafPacientesModel> getPacientes();

    void eliminarPacientes(Long id);

    void registrarPaciente(RafPacientesModel rafPacientesModel);

    void actualizarPacientes(Long id, RafPacientesModel rafPacientesModel);

    Optional<RafPacientesModel> getPacientesId(Long id);
}
