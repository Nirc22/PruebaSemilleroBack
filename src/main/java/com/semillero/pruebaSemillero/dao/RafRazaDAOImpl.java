package com.semillero.pruebaSemillero.dao;

import com.semillero.pruebaSemillero.models.RafRazaModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RafRazaDAOImpl implements RafRazaDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RafRazaModel> getRazas() {
        String query = "FROM RafRazaModel";
        return entityManager.createQuery(query).getResultList();
    }
}
