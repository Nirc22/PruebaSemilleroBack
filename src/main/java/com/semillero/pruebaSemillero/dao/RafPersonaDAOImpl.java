package com.semillero.pruebaSemillero.dao;

import com.semillero.pruebaSemillero.models.RafPersonasModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public class RafPersonaDAOImpl implements RafPersonaDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void registrarPersona(RafPersonasModel rafPersonasModel) {
        entityManager.merge(rafPersonasModel);

    }

    @Override
    public void actualizarPersona(Long id, RafPersonasModel rafPersonasModel) {
        RafPersonasModel updatePersona = entityManager.find(RafPersonasModel.class, id);
        updatePersona.setDsciudad(rafPersonasModel.getDsciudad());
        updatePersona.setDsdireccion(rafPersonasModel.getDsdireccion());
        updatePersona.setNmtelefono(rafPersonasModel.getNmtelefono());
        entityManager.merge(updatePersona);


    }


    @Override
    public Optional<RafPersonasModel> getPersonaId(Long id) {
        RafPersonasModel rafPersonasModel = entityManager.find(RafPersonasModel.class, id);
        return Optional.of(rafPersonasModel);
    }
}
