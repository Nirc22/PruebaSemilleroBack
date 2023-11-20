package com.semillero.pruebaSemillero.security;


import com.semillero.pruebaSemillero.Repository.AdministradorRepository;
import com.semillero.pruebaSemillero.models.RafAdministradoresModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServieImpl implements UserDetailsService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        RafAdministradoresModel rafAdministradoresModel = administradorRepository
                 .findOneByEmail(email)
                 .orElseThrow(() -> new UsernameNotFoundException("El usuario con email " + email + " no existe."));

        return new UserDetailsImpl(rafAdministradoresModel);
    }
}
