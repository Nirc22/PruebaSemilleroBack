package com.semillero.pruebaSemillero.dao;

import com.semillero.pruebaSemillero.models.RafTipoDocumentoModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class RafTipoDocumentoDAOImpl implements RafTipoDocumentoDAO{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<RafTipoDocumentoModel> getTiposDocumentos() {
        String query = "FROM RafTipoDocumentoModel";
        return entityManager.createQuery(query).getResultList();
    }
}
