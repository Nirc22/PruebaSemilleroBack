package com.semillero.pruebaSemillero.controllers;

import com.semillero.pruebaSemillero.dao.RafAuthAdministradorDAO;
import com.semillero.pruebaSemillero.models.RafAdministradoresModel;
import com.semillero.pruebaSemillero.models.RafPacientesModel;
import com.semillero.pruebaSemillero.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthAdministradorController {

    @Autowired
    private RafAuthAdministradorDAO rafAuthAdministradorDAO;

    //
    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/administradores/login", method = RequestMethod.POST)
    public String login(@RequestBody RafAdministradoresModel rafAdministradoresModel){

        RafAdministradoresModel administradorLogueado = rafAuthAdministradorDAO.getEmailPassword(rafAdministradoresModel);
        //creando el token
        if (administradorLogueado != null){
            String tokenJWT = jwtUtil.create(String.valueOf(administradorLogueado.getNmid()), administradorLogueado.getEmail());
            return tokenJWT;
        }
        return "FAIL";
    }

    private boolean validarToken(String token) {

        String administradorId = jwtUtil.getKey(token);//se extrae el id del usuario
        return administradorId != null;

    }

    @RequestMapping(value = "api/administradores/crear", method = RequestMethod.POST)
    public void registrarAdministrador(@RequestBody RafAdministradoresModel rafAdministradoresModel){

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(3, 1024, 1, rafAdministradoresModel.getPassword());
        rafAdministradoresModel.setPassword(hash);
        rafAuthAdministradorDAO.registrarAdministrador(rafAdministradoresModel);
    }

    @RequestMapping(value ="api/administradores/crearPaciente", method = RequestMethod.POST)
    public void registrarPacientes(@RequestBody RafPacientesModel rafPacientesModel){
        rafAuthAdministradorDAO.registrarPaciente(rafPacientesModel);
    }

    @RequestMapping(value = "api/administradores/get", method = RequestMethod.GET)
    public List<RafPacientesModel> getPacientes(@RequestHeader(value = "Authorization") String token){

        if(!validarToken(token)){return null;}


        return rafAuthAdministradorDAO.getPacientes();
    }

}