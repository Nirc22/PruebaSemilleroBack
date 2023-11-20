package com.semillero.pruebaSemillero.Repository;

import com.semillero.pruebaSemillero.models.RafAdministradoresModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorRepository extends JpaRepository<RafAdministradoresModel, Integer> {
    Optional<RafAdministradoresModel> findOneByEmail(String email);
}
