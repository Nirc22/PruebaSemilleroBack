package com.semillero.pruebaSemillero.dao;

import com.semillero.pruebaSemillero.models.RafEspecieModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RafEspecieDAOImpl implements RafEspecieDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RafEspecieModel> getEspecies() {
        String query = "FROM RafEspecieModel";
        return entityManager.createQuery(query).getResultList();
    }
}
