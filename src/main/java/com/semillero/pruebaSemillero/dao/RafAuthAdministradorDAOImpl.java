package com.semillero.pruebaSemillero.dao;

import com.semillero.pruebaSemillero.models.RafAdministradoresModel;
import com.semillero.pruebaSemillero.models.RafPacientesModel;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RafAuthAdministradorDAOImpl implements RafAuthAdministradorDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public RafAdministradoresModel getEmailPassword(RafAdministradoresModel rafAdministradoresModel) {
        String query = "FROM RafAdministradoresModel WHERE email = :email";
        List<RafAdministradoresModel> lista = entityManager.createQuery(query)
                .setParameter("email", rafAdministradoresModel.getEmail())
                .getResultList();

        if(lista.isEmpty()){
            return null;
        }

        String passwordHasheh = lista.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHasheh, rafAdministradoresModel.getPassword())){
            return lista.get(0);
        }
        return null;

        //return !lista.isEmpty();//para validar si la lista es vacia

    }

    @Override
    public void registrarAdministrador(RafAdministradoresModel rafAdministradoresModel) {
        entityManager.merge(rafAdministradoresModel);
    }

    @Override
    public void registrarPaciente(RafPacientesModel rafPacientesModel) {
        entityManager.merge(rafPacientesModel);
    }

}
