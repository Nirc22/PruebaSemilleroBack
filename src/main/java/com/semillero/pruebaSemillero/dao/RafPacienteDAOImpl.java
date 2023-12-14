package com.semillero.pruebaSemillero.dao;


import com.semillero.pruebaSemillero.models.RafPacientesModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class RafPacienteDAOImpl implements RafPacienteDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RafPacientesModel> getPacientes() {
        String query = "FROM RafPacientesModel";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminarPacientes(Long id) {
        RafPacientesModel rafPacientesModel = entityManager.find(RafPacientesModel.class, id);
        entityManager.remove(rafPacientesModel);
    }

    @Override
    public void registrarPaciente(RafPacientesModel rafPacientesModel) {
        entityManager.merge(rafPacientesModel);
    }

    @Override
    public void actualizarPacientes(Long id, RafPacientesModel rafPacientesModel) {
        RafPacientesModel updatePaciente = entityManager.find(RafPacientesModel.class, id);
        updatePaciente.setNmidtipoidentificacion(rafPacientesModel.getNmidtipoidentificacion());
        updatePaciente.setNmidentificacion(rafPacientesModel.getNmidentificacion());
        updatePaciente.setDsduenio(rafPacientesModel.getDsduenio());
        updatePaciente.setDsciudad(rafPacientesModel.getDsciudad());
        updatePaciente.setDsdireccion(rafPacientesModel.getDsdireccion());
        updatePaciente.setNmtelefono(rafPacientesModel.getNmtelefono());
        entityManager.merge(updatePaciente);
    }

    @Override
    public Optional<RafPacientesModel> getPacientesId(Long id) {
        RafPacientesModel rafPacientesModel = entityManager.find(RafPacientesModel.class, id);
        return Optional.of(rafPacientesModel);
    }

}
